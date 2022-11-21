// import java.util.*;
// class A{
//     boolean search_in_memory(int arr[], int a){
//         for(int i=0; i<arr.length; i++){
//             if(arr[i] == a) return true;
//         }

//         return false;
//     }
// }

// class B{
//     int leastrecent=9999;
//     int search_least_recent(int mainarr[], int sequencearr[], int i){
//         int t=i;
//         for(int j=mainarr.length-1; j>=0; j--){
            
//             for(int k=t-1; k>=0; k--){
//                 if(sequencearr[k] == mainarr[j]){
//                     if(k<leastrecent){
//                         leastrecent = k;
//                         break;
//                     }
//                 }
//             }
//         }

//         return leastrecent;
//     }
// }

// Java implementation of above algorithm

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class lru{

    static int pageFaults(int pages[], int n, int capacity){

        HashSet<Integer> s = new HashSet<>(capacity);

        HashMap<Integer, Integer> indexes = new HashMap<>();

        int page_faults=0;
        for(int i=0; i<n; i++){

            if(s.size() < capacity){

                if(!s.contains(pages[i])){

                    s.add(pages[i]);

                    page_faults++;
                }

                indexes.put(pages[i], i);
            }
            else{

                if(!s.contains(pages[i])){

                    int lru = Integer.MAX_VALUE;
                    int val = Integer.MIN_VALUE;

                    Iterator<Integer> itr = s.iterator();

                    while(itr.hasNext()){

                        int temp = itr.next();
                        if(indexes.get(temp) < lru){
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }

                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);

                    page_faults++;
                }

                indexes.put(pages[i], i);
            }
        }

        return page_faults;
    }

    public static void main(String args[]){

        int pages[] = {0, 2, 1, 6, 4, 0, 1, 0, 3, 1, 2, 1};

        int capacity = 3;

        System.out.println(pageFaults(pages, pages.length, capacity));
    }
}






























// public class lru{

//     public static void main(String args[]){

//         A a = new A();
//         B b = new B();

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of pages");
//         int pages = sc.nextInt();
//         System.out.println("Enter the number of frames in memoery");
//         int frames = sc.nextInt();

//         int mainmemory[] = new int[frames];
//         int sequence[] = new int[pages];
//         int pagefaults=0;

//         for(int i=0; i<pages; i++){
//             System.out.println("Enter the "+(i+1)+"th page");
//             sequence[i] = sc.nextInt();
//         }

//         for(int i=0; i<frames; i++){
//             mainmemory[i] = -1;
//         }

//         int pos=0;

//         for(int i=0; i<pages; i++){

//             if(mainmemory[pos] == -1 && !a.search_in_memory(mainmemory, sequence[i])){
//                 mainmemory[pos] = sequence[i];
//                 pos=(pos+1)%frames;
//                 pagefaults++;
//                 for(int k=0; k<frames; k++){
//                    System.out.print(mainmemory[k]+" ");
//                 } 

//                 System.out.println();
//             }else{
//                 if(!a.search_in_memory(mainmemory, sequence[i])){
//                     pos = b.search_least_recent(mainmemory, sequence, i);
//                     mainmemory[pos] = sequence[i];
//                     pos=(pos+1)%frames;
//                     pagefaults++;
//                 for(int k=0; k<frames; k++){
//                    System.out.print(mainmemory[k]+" ");
//                 } 

//                 System.out.println();                }

//             }
//         }

//         System.out.println("No of pagefaults:");
//         System.out.println(pagefaults);
//     }
// }