import java.util.*;

public class sjf_np{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of processes");
        int n = sc.nextInt();

        int processID[] = new int[n];
        int arrivalT[] = new int[n];
        int burstT[] = new int[n];
        int completionT[] = new int[n];
        int turnaroundT[] = new int[n];
        int waitingT[] = new int[n];
        int flag[] = new int[n];
        int temp=0;
        float avgTat=0;
        float avgWt=0;

        HashMap<Integer, Integer> indexes = new HashMap<>();

        for(int i=0; i<n; i++){

            processID[i] = i+1;
            System.out.println("Enter the arrival time of process "+(i+1));
            arrivalT[i] = sc.nextInt();
            
            System.out.println("Enter the burst time of process "+(i+1));
            burstT[i] = sc.nextInt();
            indexes.put(burstT[i], i);
            flag[i] = 0;

        }




        for(int i=0; i<n; i++){

            for(int j=0; j<n-(i+1); j++){

                if(arrivalT[j] > arrivalT[j+1]){

                    
                    temp = arrivalT[j];
                    arrivalT[j] = arrivalT[j+1];
                    arrivalT[j+1] = temp;

                    temp = burstT[j];
                    burstT[j] = burstT[j+1];
                    burstT[j+1] = temp;

                    temp = processID[j];
                    processID[j] = processID[j+1];
                    processID[j+1] = temp;

                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currTime = 0;
        

        while(true){

            for(int i=0; i<n; i++){

                if(arrivalT[i]<=currTime && flag[i]==0){
                    pq.add(burstT[i]);
                    flag[i] = 1;
                }
            }

            if(pq.isEmpty()){
                break;
            }
            
            int t = pq.poll();
            currTime += t;
            int index = indexes.get(t);

            completionT[index] = currTime;

            turnaroundT[index] = completionT[index]-arrivalT[index];
            waitingT[index] = turnaroundT[index]-burstT[index];
            avgTat += turnaroundT[index];
            avgWt += waitingT[index];
            
        }




        System.out.println("\npid at bt ct tat wt");

        for(int i=0; i<n; i++){
            System.out.println(processID[i]+"\t"+arrivalT[i]+"\t"+burstT[i]+"\t"+completionT[i]+"\t"+turnaroundT[i]+"\t"+waitingT[i]);
        }

        System.out.println("Average waiting time: "+(avgWt/n));
        System.out.println("Average turnaround time: "+(avgTat/n));

        
    }
}