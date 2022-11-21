import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class roundRobin{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sc.nextInt();
        System.out.println("Enter time quanta");
        int timeQuanta = sc.nextInt();

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
        int prevProcessID;


        Queue<Integer> readyQueue = new LinkedList<>();

        for(int i=0; i<n; i++){
            processID[i] = i+1;
            System.out.println("Enter arrival time for process"+(i+1));
            arrivalT[i] = sc.nextInt();
            System.out.println("Enter burst time for process"+(i+1));
            burstT[i] = sc.nextInt();

            burstcopy[i] = burstT[i];
            flag[i] = 0;
        }

        int currIndex = -1;
        while(true){

            for(int i=0; i<n; i++){

                
                if(arrivalT[i]<=currTime && flag[i]==0 && i!=currIndex && !readyQueue.contains(i)){
                    readyQueue.add(processID[i]-1);
                }

            }

            if(readyQueue.isEmpty()){
                break;
            }

            if(currIndex!=-1 && burstT[currIndex]<burstcopy[currIndex]){
                readyQueue.add(currIndex);
            }

            int currprocess = readyQueue.remove();
            burstT[currprocess] -= timeQuanta;//2
            currTime += timeQuanta;
            currIndex = currprocess;

            if(burstT[currprocess]<=0){
                flag[currprocess]=1;
                currIndex=-1;
                if(burstT[currprocess]<0){
                    completionT[currprocess] = currTime-((-1)*burstT[currprocess]);
                    currTime -= (-1)*burstT[currprocess];
                }else{
                    completionT[currprocess] = currTime;
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

    }
    
}