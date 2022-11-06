package Project1;
import java.util.concurrent.TimeUnit;

public class matrixMultiplication {
    double strassenAvg = 0;
    int strassenUseCount = 0;
    double strassenTotalTime = 0;
    // calc time needed to complete each method within each method
    // classic matrix multi

    //int[][] matrixA, int[][]matrixB
    public void classicMultiplication(matrix matrixA, matrix matrixB){
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length];

        /*
         * for # of rows in matrixA (i)
         *      for # of cols in matrixB (will be = to row/col of both matrices) (j)
         *          for each cell in the row in matrixA (k)
         *              c(i,j) += a(i,k) * b(j, k)
         */

        for(int i=0; i<matrixA.getMatrix().length; i++){
            for(int j=0; j<matrixB.getMatrix().length; j++){
                for(int k=0; k<matrixA.getMatrix()[i].length; k++){
                    matrixC[i][j] += matrixA.getMatrix()[i][k] * matrixB.getMatrix()[k][j];
                }
            }
        }
        //printMatrix(matrixC);
    }


    // Divide & conquer multiplication
    // Recursive
    public void divideAndConquer(matrix matrixA, matrix matrixB){
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length];
        

        /*
         * split into rows until length of matrixA = reached
         * +split into columns until matrixB[i].length = reached
         *  ** matrixA and matrixB are squares of equal size
         * take the first row of matA and column of matB, feed the rest into the recursive call
         * stop when mat length = 1
         * C = each row * each column
         * 
         */

        /*
         * if matrixA length = 1
         *      return C = 
         */

    }

    //strassen multi
    public void Strassen(matrix matrixA, matrix matrixB){
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length];
        strassenUseCount++;




    }   

    public double getStrassenAvg(){
        return strassenAvg;
    }

    public void printMatrix(int [][] output){
        System.out.println("Output matrix C: ");
        for(int i=0; i<output.length; i++){
            for(int j=0; j<output[i].length; j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

}
