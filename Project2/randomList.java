package Project2;

public class randomList {
    private double[] list;

    // Generate random numbers for list
    public randomList(int size){
        list = new double[size];
        for(int i=0; i<size; i++){
            list[i] = (Math.random()*(10-1)); // can change to dif range later, after testing
        }
    }

    public double[] getList(){
        return list;
    }

    public void printList(){
        System.out.println("Randomly generated list of size "+list.length+": ");
        for(int i=0; i<list.length; i++){
            System.out.println(list[i]+" ");
        }
        System.out.println();
    }

}
