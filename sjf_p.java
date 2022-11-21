import java.util.*;

public class sjf_p{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sc.nextInt();

        // Arrays
        int processID[] = new int[n];                 // Takes process IDs
        int arrivalT[] = new int[n];                   // Takes arrival time
        int burstT[] = new int[n];                       // Takes burst time
        int completionT[] = new int[n];             // Stores completion time
        int turnaroundT[] = new int[n];             // Stores turn around time
        int waitingT[] = new int[n];                   // Stores waiting time
        int burstcopy[] = new int[n];                 // Copy of burst array;
        int flag[] = new int[n];                           // It indicates whether a process is finished

        //Variables
        int currTime = 0;                                 // Holds the current time value
        float avgWt = 0;                                  // Average waiting time
        float avgTat = 0;                                 // Average turn around time
        int total = 0;                                    // Total no of processes finished for the current time


        for(int i=0; i<n; i++){
            processID[i] = i+1;
            System.out.println("Enter arrival time for process"+(i+1));
            arrivalT[i] = sc.nextInt();
            System.out.println("Enter burst time for process"+(i+1));
            burstT[i] = sc.nextInt();

            burstcopy[i] = burstT[i];
            flag[i] = 0;
        }

        while(true){
            int minburstTime = 9999;
            int minIndex = n;

            if(total == n) break;

            // For finding the job with min burst time
            for(int i=0; i<n; i++){

                if(arrivalT[i]<=currTime && flag[i]==0 && burstT[i]<minburstTime){
                    minburstTime = burstT[i];
                    minIndex = i;
                }
            }

            if(minIndex == n){
                currTime++;
            }
            else{
                burstT[minIndex]--;
                currTime++;

                if(burstT[minIndex] == 0){             // Indicates that the job is finished
                flag[minIndex] = 1;
                completionT[minIndex] = currTime;
                total++;
                }
            }

            
        }

        for(int i=0; i<n; i++){
            turnaroundT[i] = completionT[i] - arrivalT[i];
            waitingT[i] = turnaroundT[i] - burstcopy[i];
            avgTat += turnaroundT[i];
            avgWt += waitingT[i];
        }
        
        System.out.println("pid  arrival  burst  complete turn waiting");
        for(int i=0; i<n; i++){
            System.out.println(processID[i] +"\t"+ arrivalT[i]+"\t"+ burstcopy[i] +"\t"+ completionT[i] +"\t"+ turnaroundT[i] +"\t"+ waitingT[i]);
        }

        System.out.println("\naverage tat is "+ (float)(avgTat/n));
    System.out.println("average wt is "+ (float)(avgWt/n));
    sc.close();
    }
}