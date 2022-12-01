package Project2;
import java.util.ArrayList;

public class selection {
    // Make sure to place results in a CSV file for easy data analysis?

    public void mergeSort(ArrayList<Integer> givenList, int k){
        // selectKthSmallest();
    }



    public void iterativeQuickSortSelect(ArrayList<Integer> givenList, int k){
        /*
         * pick a pivot (first, last, or middle elem)
         *      if val > pivot
         *          val -> list of larger values
         *      if val <= pivot 
         *          val -> list of smaller values
         *  repeat until sublist lengths = 1
         *  merge all sublists today
        */
        
        // selectKthSmallest(); k-1
    }



    public void recurQuickSortSelect(ArrayList<Integer> givenList, int k){
        ArrayList<Integer> orderedList = recursiveQuickSort(givenList);
        printList(orderedList, "Recursive quick sorted list: ");
        selectKthSmallest(orderedList, k-1);
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



    public void medianOfMedians(ArrayList<Integer> givenList, int k){
        // selectKthSmallest();
    }



    public void selectKthSmallest(ArrayList<Integer> orderedList, int k){
        int kth_smallest = orderedList.get(k);
        System.out.println("Kth (" + (k+1) + "th) smallest element: "+ kth_smallest);
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
