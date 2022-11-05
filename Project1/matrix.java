package Project1;
public class matrix {
    private int[][] nSizeMatrix;

    // generate random matrix given size n in constructor
    public matrix(int size){
        nSizeMatrix = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                nSizeMatrix[i][j] =(int) (Math.random()*(10-1)); // can change to dif range later, after testing
            }
        }
        //saveMatrix();
    }

    public int[][] getMatrix(){
        return nSizeMatrix;
    }

    public void printMatrix(){
        System.out.println("Randomly generated matrix of size "+nSizeMatrix.length+": ");
        for(int i=0; i<nSizeMatrix.length; i++){
            for(int j=0; j<nSizeMatrix.length; j++){
                System.out.print(nSizeMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    // save matrix to csv?
    public void saveMatrix(){

    }
    



}