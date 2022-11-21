import java.util.*;

public class bestFit{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs");
        int j = sc.nextInt();
        System.out.println("Enter the number of blocks");
        int b = sc.nextInt();

        int job_size[] = new int[j];
        int block_size[] = new int[b];
        int allocation[] = new int[j];

        for(int i=0; i<j; i++){
            System.out.println("Enter the job size of process "+(i+1));
            job_size[i] = sc.nextInt();
        }

        for(int i=0; i<b; i++){
            System.out.println("Enter the block size of process "+(i+1));
            block_size[i] = sc.nextInt();
        }

        for(int i=0; i<j; i++){
            allocation[i] = -1;
        }

        int mindiff = 9999;
        int minIndex = 0;
        for(int i=0; i<j; i++){

            for(int k=0; k<b; k++){

                if(job_size[i]<=block_size[k] && (block_size[k]-job_size[i])>0 && ((block_size[k]-job_size[i])<mindiff)){
                    mindiff = (block_size[k]-job_size[i]);
                    minIndex = k;
                }
            }

            block_size[minIndex] -= job_size[i];
            allocation[i] = minIndex;
            mindiff = 9999;

        }

        
        for(int i=0; i<b; i++){
            System.out.print(block_size[i]+" ");
            
        }

        for(int i=0; i<j; i++){
            System.out.print(allocation[i]+" ");
        }
    }
}