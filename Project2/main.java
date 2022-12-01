package Project2;
import java.util.ArrayList;

public class main {
    public static void main(String args[]){
        double start = System.nanoTime();
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        selection select = new selection();
        randomList list1 = new randomList(10);
        list1.printList();
        select.recurQuickSortSelect(list1.getList(), 1);

        //select.mergeSort(list1,3);

        /*
        double mergeAvg = 0.0;
        int mergeUseCount = 0;
        double mergeTotalTime = 0.0;
        double mergeStart = 0.0;
        double mergeFinish = 0.0;
        double mergeDuration = 0.0;

        double iterQuickAvg = 0.0;
        int iterQuickUseCount = 0;
        double iterQuickTotalTime = 0.0;
        double iterQuickStart = 0.0;
        double iterQuickFinish = 0.0;
        double iterQuickDuration = 0.0;

        double recurQuickAvg = 0.0;
        int recurQuickUseCount = 0;
        double recurQuickTotalTime = 0.0;
        double recurQuickStart = 0.0;
        double recurQuickFinish = 0.0;
        double recurQuickDuration = 0.0;

        double mmAvg = 0.0;
        int mmUseCount = 0;
        double mmTotalTime = 0.0;
        double mmStart = 0.0;
        double mmFinish = 0.0;
        double mmDuration = 0.0;

        // k = 1, n/4, n/2, 3n/4, n
        // Can try enumerating k or something so I do not need to manually change k and run it many times? //////////
        int k = 1;
        int kth_smallest;

        // Create 1000 different lists of size n = 10, 50, 100, 500, 100,...
        // Test each list 20 times with the 4 different methods
        for(int i=0; i<1000; i++){
            //randomList list1 = new randomList(10);
            for(int j=0; j<20; j++){
                // Run merge sort algorithm
                mergeUseCount++;
                mergeStart = System.nanoTime();
                select.mergeSort(list1, k);
                // kth_smallest = select.mergeSort(list1, k); // for printing
                mergeFinish = System.nanoTime();
                mergeDuration = (mergeFinish - mergeStart) / 1000000;;
                mergeTotalTime += mergeDuration;
                mergeAvg = mergeTotalTime / mergeUseCount;

                // Run iterative quick sort algorithm
                iterQuickUseCount++;
                iterQuickStart = System.nanoTime();
                select.iterativeQuickSort(list1, k);
                // kth_smallest = select.iterQuickSort(list1, k); // for printing
                iterQuickFinish = System.nanoTime();
                iterQuickDuration = (iterQuickFinish - iterQuickStart) / 1000000;;
                iterQuickTotalTime += iterQuickDuration;
                iterQuickAvg = iterQuickTotalTime / iterQuickUseCount;

                // Run recursive quick sort algorithm
                recurQuickUseCount++;
                recurQuickStart = System.nanoTime();
                select.recursiveQuickSort(list1, k);
                // kth_smallest = select.recurQuickSort(list1, k); // for printing
                recurQuickFinish = System.nanoTime();
                recurQuickDuration = (recurQuickFinish - recurQuickStart) / 1000000;;
                recurQuickTotalTime += recurQuickDuration;
                recurQuickAvg = recurQuickTotalTime / recurQuickUseCount;

                // Run recursive quick sort algorithm
                mmUseCount++;
                mmStart = System.nanoTime();
                select.medianOfMedians(list1, k);
                // kth_smallest = select.mmSort(list1, k); // for printing
                mmFinish = System.nanoTime();
                mmDuration = (mmFinish - mmStart) / 1000000;;
                mmTotalTime += mmDuration;
                mmAvg = mmTotalTime / mmUseCount;
            }
        }
        System.out.println("Merge sort average time for 1000*20 runs: " + mergeAvg + " ms"); 
        System.out.println("Iterative quick sort method average time for 1000*20 runs: " + iterQuickAvg + " ms");
        System.out.println("Recursive quick sort method average time for 1000*20 runs: " + recurQuickAvg + " ms");
        System.out.println("Median of medians method average time for 1000*20 runs: " + mmAvg + " ms");
        
        double finish = System.nanoTime();
        double duration = finish - start;
        duration /= 1000000;
        System.out.println("Duration: "+duration+" ms");
        */
    }
}