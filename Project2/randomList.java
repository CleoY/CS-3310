package Project2;
import java.util.ArrayList;

public class randomList {
    private ArrayList<Integer> list;

    // Generate random numbers for list
    public randomList(int size){
        list = new ArrayList(size);
        for(int i=0; i<size; i++){
            list.add((int)(Math.random()*(20-1))); // can change to dif range later, after testing
        }
    }

    public ArrayList<Integer> getList(){
        return list;
    }

    public void printList(){
        System.out.println("Randomly generated list of size "+list.size()+": ");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
