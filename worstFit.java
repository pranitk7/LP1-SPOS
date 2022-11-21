import java.util.*;

public class worstFit{

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

        for(int i=0; i<j; i++){
            allocation[i] = -1;
        }

        int maxSize = -9999;
        int maxIndex = 0;
        for(int i=0; i<j; i++){

            for(int k=0; k<b; k++){
                if(block_size[k]>=maxSize){
                    maxSize = block_size[k];
                    maxIndex = k;
                }
            }

            if(block_size[maxIndex]>job_size[i]){
                block_size[maxIndex] -= job_size[i];
                maxSize = block_size[0];
                allocation[i] = maxIndex;
            }
        }

        for(int i=0; i<b; i++){
            System.out.print(block_size[i]+" ");
        }

        for(int i=0; i<j; i++){
            System.out.print(allocation[i]+" ");
        }


    }

}