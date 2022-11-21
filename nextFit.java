import java.util.*;

public class nextFit{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs");
        int j = sc.nextInt();
        System.out.println("Enter the number of blocks");
        int b = sc.nextInt();

        int job_size[] = new int[j];
        int block_size[] = new int[b];
        int allocation[] = new int[j];
        int processID[] = new int[j];

        for(int i=0; i<j; i++){
            System.out.println("Enter the size of job "+(i+1));
            processID[i] = i+1;
            job_size[i] = sc.nextInt();
        }

        for(int i=0; i<b; i++){
            System.out.println("Enter the size of block "+(i+1));
            block_size[i] = sc.nextInt();
        }

        int currIndex = 0;
        for(int i=0; i<j; i++){
            for(int k=currIndex; k<b; k++){
                if(job_size[i]<block_size[k]){
                    block_size[k] -= job_size[i];
                    currIndex = k;
                    break;
                }
            }
        }

        for(int i=0; i<b; i++){
            System.out.print(block_size[i]+" ");
        }
    }

    

}