package Project2;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class selection {
    // Make sure to place results in a CSV file for easy data analysis?

    public void mergeSort(ArrayList<Integer> givenList, int k){
        // selectKthSmallest();
    }



    public void iterativeQuickSortSelect(ArrayList<Integer> givenList, int k){
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
         * Change first, last, pivot(?) and k indices
         *      for loop to repeat until base cases reached
         * 
        */

        
        // selectKthSmallest(); k-1
    }



    // public void recurQuickSortSelect(ArrayList<Integer> givenList, int k){
    //     ArrayList<Integer> orderedList = recursiveQuickSort(givenList);
    //     printList(orderedList, "Recursive quick sorted list: ");
    //     selectKthSmallest(orderedList, k-1);
    // }

    public void recursiveQuickSortSelect(ArrayList<Integer> givenList, int k){
        int pivot;
        ArrayList<Integer> smallerValues = new ArrayList<>(givenList.size()/2+1);
        ArrayList<Integer> largerValues = new ArrayList<>(givenList.size()/2+1);
        
        // pivot = first element = kth smallest at the base case
        if(k==1 && givenList.size()==1){
            System.out.println("Kth smallest element: " + givenList.get(0));
        } else{
            pivot = givenList.get(0); // pivot = first element
            // sort values into list of smaller values and list of larger values
            for(int i=1; i<givenList.size(); i++){
                if(givenList.get(i) > pivot){
                    largerValues.add(givenList.get(i));
                } else{
                    smallerValues.add(givenList.get(i));
                }
            }
            smallerValues.trimToSize();
            largerValues.trimToSize();
            printList(smallerValues, "Smaller value list: ");
            printList(largerValues, "Larger value list: ");
            System.out.println("K: "+k);
            if(k==1 && smallerValues.size()==0){ // k is the first elem = pivot
                System.out.println("Kth smallest element: " + pivot);
            } 
            // need to consider when k = n and the largest list is 0 so pivot = "last" elem in smaller value sublist
            else if(k==givenList.size() && largerValues.size()==0){
                System.out.println("Kth smallest element: " + pivot);
            }
            else if(k>smallerValues.size()){ // k is in list of larger values
                System.out.println("K-size-1: "+(k-smallerValues.size()-1));
                System.out.println("Focus on larger values");
                recursiveQuickSortSelect(largerValues, k-smallerValues.size()-1);
                // scale k to a position relative to larger value list
            } else{ // k is in list of smaller values
                System.out.println("Focus on larger values");
                recursiveQuickSortSelect(smallerValues, k);
            }
        }

        /*
            * Choose pivot (first, last, or middle elem)
            * Split array into 2 parts
            *      if val > pivot
            *          val -> list of larger values
            *      if val <= pivot 
            *          val -> list of smaller values
            * NEED TO RECONSIDER SHIFTING OF K SINCE PIVOT MIGHT = K
            *   AND CURR IMPL IGNORES K AS PIVOT EXCEPT WHEN (K=1=pivot or K=n=pivot)
            * if k=n/2, then the size of smallerValues (n/2 OR n/2 - 1) = largerValues(n/2 OR n/2 - 1)
            *       if n = odd, sizes will be equal
            *       if n = even, one list will be +1 longer than the other
            *   
            * if k=1, then k=pivot, smallerValues size = 0 and largervalues = n-1
            * if k=n, then k=pivot, smallerValues size = n-1 and largerValues = 0
            * if k=n/4, then smallerValues size = n/4 (n/4-1?) and largerValues size = 3n/4 (or 3n/4-1?)
            *
            *

            * need to find size of smaller value list and size of large value list
            * if k > smaller value size -> focus on larger value list
            *      k - size -1 (k is base 1 so 4th position can = size of 4)
            * else -> focus on smaller value list
            *      k does not change
            * selected list and k -> recursive call
            * base case: k=1 and size = 1
            *      print kth smallest value or return it
            * 
            */
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
