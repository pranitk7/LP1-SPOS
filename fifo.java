import java.util.*;




// class A{
//     boolean search_in_memory(int[] arr, int a){
//         for (int i = 0; i < arr.length; i++) {
//             if(arr[i]==a)return true;
//         }
//         return false;
//     }
// }
// public class fifo {

//     public static void main(String[] args) {
//         int pages_sequence;
//         A a=new A();
//             int hit = 0;
//             int page_fault = 0;
//             Scanner sc = new Scanner(System.in);
//             System.out.println("Enter number of page_sequence");
//             pages_sequence = sc.nextInt();
//             System.out.println("Enter memory size");
//             int memory = sc.nextInt();


//             int[] arrsequence = new int[pages_sequence];
//             int[] arrmemory = new int[memory];
//             System.out.println("Enter page_sequence");
//             for (int i = 0; i < pages_sequence; i++) {
//                 System.out.println("Enter "+(i+1)+"th page required");
//                 arrsequence[i] = sc.nextInt();
//             }
//             for (int i = 0; i < memory; i++) {
//                 arrmemory[i] = -1;
//             }

//         int free=0;
//         for (int i = 0; i < pages_sequence; i++) {
//                if(arrmemory[free]==-1 && !a.search_in_memory(arrmemory, arrsequence[i])){
//                    arrmemory[free]=arrsequence[i];
//                    free=(free+1)%memory;
//                    page_fault++;
//                }else if( arrmemory[free]==-1 && a.search_in_memory(arrmemory, arrsequence[i]) ){
//                    hit++;
//                }
//                else if( !a.search_in_memory(arrmemory, arrsequence[i]) ){
//                    arrmemory[free]=arrsequence[i];
//                    free=(free+1)%memory;
//                    page_fault++;
//                }else{
//                    hit++;
//                }

//         }
//         System.out.println("tottal hits are "+hit);
//         System.out.println("tottal pagefaults are "+page_fault);


//     }
// }

class A{
    boolean search_in_memory(int arr[], int a){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == a) return true;
        }

        return false;
    }
}

public class fifo{

    public static void main(String args[]){

        A a = new A();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pages");
        int pages = sc.nextInt();
        System.out.println("Enter the number of frames in memoery");
        int frames = sc.nextInt();

        int mainmemory[] = new int[frames];
        int sequence[] = new int[pages];
        int pagefaults=0;

        for(int i=0; i<pages; i++){
            System.out.println("Enter the "+(i+1)+"th page");
            sequence[i] = sc.nextInt();
        }

        for(int i=0; i<frames; i++){
            mainmemory[i] = -1;
        }

        int pos=0;

        for(int i=0; i<pages; i++){

            if(mainmemory[pos] == -1 && !a.search_in_memory(mainmemory, sequence[i])){
                mainmemory[pos] = sequence[i];
                pos=(pos+1)%frames;
                pagefaults++;
                
            }else{
                if(!a.search_in_memory(mainmemory, sequence[i])){
                    mainmemory[pos] = sequence[i];
                    pos=(pos+1)%frames;
                    pagefaults++;
                }
                
            }
        }

        System.out.println("No of pagefaults:");
        System.out.println(pagefaults);
    }
}