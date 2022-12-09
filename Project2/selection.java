package Project2;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class selection {
    // Make sure to place results in a CSV file for easy data analysis?

    public void mergeSortSelect(ArrayList<Integer> givenList, int k){
        //mergeSort(givenList, 0, givenList.size()-1); // may need to 
        // Make copy of givenList so temp list can be changed
        ArrayList<Integer> temp = new ArrayList<Integer>(givenList.size());
        for(int i=0; i<givenList.size(); i++){
            temp.add(givenList.get(i));
        }
        //temp = mergeSort(temp, 0, givenList.size()-1);
        mergeSort(temp, 0, givenList.size()-1);
        printList(temp,"");
        selectKthSmallest(temp, k); 
    }

    public void mergeSort(ArrayList<Integer> givenList, int start, int end){
        if(start<end){ //0<givenList.size()
            int mid = (start+end)/2;
            mergeSort(givenList, start, mid); // inf loop because givenList/givenList size does not change
            mergeSort(givenList, mid+1, end);
            //givenList = merge(givenList, start, mid, end);
            merge(givenList, start, mid, end);
        }
    }

    public void merge(ArrayList<Integer> givenList, int start, int mid, int end){
        // int i = start;
        // int j = mid + 1;
        // int k = start;

        int i = start;
        int j = mid;
        int k = start;

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for(int l=0; l<mid-start+1; l++){
            left.add(givenList.get(start+l));
        }
        for(int r=0; r<end-mid; r++){
            right.add(givenList.get(mid+1+r));
        }

        while(i<mid && j<end){
            if(left.get(i) < right.get(j)){
                givenList.set(k, left.get(i));
                i++;
            } else{
                givenList.set(k, right.get(j));
                j++;
            }
            k++;
        }

        if(i>mid){
            for(;j<=end; j++){
                givenList.set(k, right.get(j));
                k++;
            }
        } else{
            for(;i<=mid; i++){
                givenList.set(k, left.get(i));
                k++;
            }
        }



    //     while(i<=mid && j<=end){
    //         if (givenList.get(i) < givenList.get(j)){
    //             temp.add(givenList.get(i));
    //             i++;
    //         } else{
    //             temp.add(givenList.get(j));
    //             j++;
    //         }
    //         k++;
    //     }
    //     if(i>mid){
    //         for(;j<=end; j++){
    //             temp.add(givenList.get(j));
    //         }
    //     } else{
    //         for(;i<=mid; i++){
    //             temp.add(givenList.get(i));
    //         }
    //     }
    //     //printList(temp, "i is "+i);
    //     // for(int l=0; l<givenList.size(); l++){
    //     //     givenList.set(l, temp.get(l));
    //     // }
    //     givenList = temp;
    //     //return temp;
    }



    public void iterativeQuickSortSelect(ArrayList<Integer> givenList, int k){
        int pivot;
        int pivotIndex;
        ArrayList<Integer> smallerValues;
        ArrayList<Integer> largerValues;

        boolean k_found = false; 
        // ^Not completely necessary since break statement already breaks out of while loop

        while(!k_found){
            // pivot = first element (which changes if the next sublist to focus on is full of smaller or larger values)
            pivot = givenList.get(0);
            if (k==1 && givenList.size() == 1){
                System.out.println("Kth smallest element: " + pivot);
                k_found = true;
                break;
            }

            smallerValues = new ArrayList<>();
            largerValues = new ArrayList<>();

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
            //printList(smallerValues, "Smaller value list: ");
            //printList(largerValues, "Larger value list: ");
            //System.out.println("K: "+k);
            pivotIndex = smallerValues.size() + 1;
            
            if(pivotIndex == k){
                System.out.println("Kth smallest element: " + pivot);
                k_found = true;
                break;
            } else if(k>smallerValues.size()){ // k is in list of larger values
                //System.out.println("K-size-1: "+(k-smallerValues.size()-1));
                //System.out.println("Focus on larger values");
                k = k-smallerValues.size()-1;
                givenList = largerValues;
                // scale k to a position relative to larger value list
            } else{ // k is in list of smaller values
                //System.out.println("Focus on larger values");
                // k does not change
                givenList = smallerValues;
            }
        }

        
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



    public int recursiveQuickSortSelect(ArrayList<Integer> givenList, int k, int p){
        int pivot;
        int pivotIndex;
        ArrayList<Integer> smallerValues = new ArrayList<>(givenList.size()/2+1);
        ArrayList<Integer> largerValues = new ArrayList<>(givenList.size()/2+1);
        
        // pivot = first element = kth smallest at the base case
        if(k==1 && givenList.size()==1){
            System.out.println("Kth smallest element: " + givenList.get(0) + "\n");
            return givenList.get(0);
        } else{
            int avoid;
            if(p>-1){
                //System.out.println("NOT -1");
                pivot = givenList.get(p);
                avoid = p;
            } else{
                //pivot = givenList.get(medianOfMedians(givenList));
                //pivot = medianOfMedians(givenList);
                avoid = medianOfMedians(givenList);
                pivot = givenList.get(avoid);
                System.out.println("MM pivot: "+pivot);
            }
            //pivot = givenList.get(0); // pivot = first element
            // sort values into list of smaller values and list of larger values
            
            for(int i=0; i<givenList.size(); i++){
                if(i!=avoid){
                    if(givenList.get(i) > pivot){
                        largerValues.add(givenList.get(i));
                    } else{
                        smallerValues.add(givenList.get(i));
                    }
                }
            }
            smallerValues.trimToSize();
            largerValues.trimToSize();
            //printList(smallerValues, "Smaller value list: ");
            //printList(largerValues, "Larger value list: ");
            //System.out.println("K: "+k);
            pivotIndex = smallerValues.size() + 1;
            if(pivotIndex == k){
                System.out.println("Kth smallest element: " + pivot + "\n");
                return pivot;
            } else if(k>smallerValues.size()){ // k is in list of larger values
                //System.out.println("K-size-1: "+(k-smallerValues.size()-1));
                //System.out.println("Focus on larger values");
                recursiveQuickSortSelect(largerValues, k-smallerValues.size()-1, 0);
                // scale k to a position relative to larger value list
            } else{ // k is in list of smaller values
                //System.out.println("Focus on larger values");
                recursiveQuickSortSelect(smallerValues, k, 0);
            }
        }
        return -1;
    }

    public void mmSelect(ArrayList<Integer> givenList, int k){
        recursiveQuickSortSelect(givenList, k, -1);
        //medianOfMedians(givenList);
        // selectKthSmallest();
    }

    public int medianOfMedians(ArrayList<Integer> givenList){
        int n = givenList.size();
        int subSize = (int) Math.sqrt(n);
        System.out.println("subsize: "+subSize);
        ArrayList <Integer> subList;
        int subListMidIndex;
        ArrayList <Integer> medians = new ArrayList<Integer>(subSize);
        
        for(int i=0; i<subSize; i++){
            //System.out.println("Sublist i: "+i);
            subList = new ArrayList<Integer>(subSize);
            for(int j=i*subSize; j<i*subSize+subSize; j++){
                //System.out.println("J: "+j);
                //System.out.println("J+subsize: "+(i*subSize+subSize));
                subList.add(givenList.get(j));
            }

            // In case there is excess in givenList, just add to last subList
            if(i == subSize-1 && i*subSize+subSize<givenList.size()){
                for(int j=i*subSize+subSize; j<givenList.size(); j++){
                    //System.out.println("Extra index: "+j);
                    subList.add(givenList.get(j));
                }
            }

            printList(subList,"Sublist "+i);
            subListMidIndex = (subList.size()+1)/2;
            //System.out.println("Sublist median");
            medians.add(findMedian(subList, subListMidIndex));
        }
        int mediansMidIndex = medians.size()/2;
        printList(medians, "BIG medians");
        int temp = findMedian(medians, mediansMidIndex); //actual mm but not INDEX of mm in givenList
        System.out.println("Find BIG median return: "+temp);
        int w=0;
        for(; w<givenList.size(); w++){
            if(givenList.get(w)==temp){
                break;
            }
        }
        return w;
        //return -2;
        //return findMedian(medians, mediansMidIndex);
    }

    public int findMedian(ArrayList<Integer> subList, int k){
        int temp = recursiveQuickSortSelect(subList, k, 0);
        System.out.println("SUBLIST median: "+temp);
        return temp;
        //return recursiveQuickSortSelect(subList, k, 0);
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
