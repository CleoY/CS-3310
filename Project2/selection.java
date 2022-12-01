package Project2;
import java.util.ArrayList;

public class selection {
    //int k;

    // Make sure to place results in a CSV file for easy data analysis?

    // public void setK(int given){
    //     k = given;
    // }

    public int mergeSort(randomList givenList){
        return 0;
    }

    public int iterativeQuickSort(randomList givenList){
        return 0;
    }



    public void mergeSortSelect(ArrayList<Integer> givenList, int k){
        ArrayList<Integer> orderedList = recursiveQuickSort(givenList);
        printList(orderedList, "Merge sorted list: ");
        selectKthSmallest(orderedList, k);
    }

    public ArrayList<Integer> recursiveQuickSort(ArrayList<Integer> givenList){
        int pivot;
        ArrayList<Integer> orderedList = new ArrayList<>(givenList.size());
        ArrayList<Integer> smallerValues = new ArrayList<>(givenList.size()/2+1);
        ArrayList<Integer> largerValues = new ArrayList<>(givenList.size()/2+1);
       
        /*
         * pick a pivot (first, last, or middle elem)
         *      if val > pivot
         *          val -> list of larger values
         *      if val <= pivot 
         *          val -> list of smaller values
         *  repeat until sublist lengths = 1
         *  merge all sublists today
        */

        // Split list
        // Base case
        if(givenList.size() == 1){
            orderedList.add(givenList.get(0));
            return orderedList;
        } else if(givenList.size() > 1){
            // Sort elements into 2 sublists
            pivot = givenList.get(0);
            for(int i=1; i<givenList.size(); i++){
                if(givenList.get(i) > pivot){
                    largerValues.add(givenList.get(i));
                } else{
                    smallerValues.add(givenList.get(i));
                }
            }
            // Recursive calls; funnel sublists to recursive calls AND merge returned sublists
            orderedList.addAll(recursiveQuickSort(smallerValues));
            orderedList.add(pivot);
            orderedList.addAll(recursiveQuickSort(largerValues));
        }
        return orderedList;
    }

    public int medianOfMedians(randomList givenList){
        return 0;
    }

    public void selectKthSmallest(ArrayList<Integer> orderedList, int k){
        int kth_smallest = orderedList.get(k);
        System.out.println("Kth (" + k + "th) smallest element: "+ kth_smallest);
        //return kth_smallest; //////// Can change return type to void
    }

    public void printList(ArrayList<Integer> given, String msg){
        System.out.println(msg);
        for(int i=0; i<given.size(); i++){
            System.out.print(given.get(i)+" ");
        }
        System.out.println();
    }
}
