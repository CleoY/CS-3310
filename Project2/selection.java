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



    public void recursiveQuickSortSelect(ArrayList<Integer> givenList, int k){
        int pivot;
        int pivotIndex;
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
            pivotIndex = smallerValues.size() + 1;
            if(pivotIndex == k){
                System.out.println("Kth smallest element: " + pivot);
            } else if(k>smallerValues.size()){ // k is in list of larger values
                System.out.println("K-size-1: "+(k-smallerValues.size()-1));
                System.out.println("Focus on larger values");
                recursiveQuickSortSelect(largerValues, k-smallerValues.size()-1);
                // scale k to a position relative to larger value list
            } else{ // k is in list of smaller values
                System.out.println("Focus on larger values");
                recursiveQuickSortSelect(smallerValues, k);
            }
        }
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
