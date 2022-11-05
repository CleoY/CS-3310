package Project1;
import java.util.concurrent.TimeUnit;

public class matrixMultiplication {
    long classicAvg = 0;
    int classicUseCount = 0;
    long classicTotalTime = 0;

    long DandC_Avg = 0;
    int DandC_UseCount = 0;
    long DandC_TotalTime = 0;

    long strassenAvg = 0;
    int strassenUseCount = 0;
    long strassenTotalTime = 0;
    // calc time needed to complete each method within each method
    // classic matrix multi

    //int[][] matrixA, int[][]matrixB
    public void classicMultiplication(matrix matrixA, matrix matrixB){
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length];
        classicUseCount++;

        long start = System.nanoTime();
        System.out.println("Start :"+start);
        // 3 for loops
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

        long finish = System.nanoTime();
        System.out.println("Finish :"+finish);
        long duration = finish-start;
        duration /= 1000; //time in nanoseconds since
        System.out.println("Duration of "+duration+"ms for "+matrixA.getMatrix().length+" by "+matrixA.getMatrix().length+" matrix\n");
        //System.out.printf("Duration of %f for %d by %d matrix%n", duration, matrixA.length, matrixB.length);
        printMatrix(matrixC);
        classicTotalTime += duration;
        classicAvg = classicTotalTime/classicUseCount;
        System.out.println("Current classic method average: "+classicAvg+" ms\n");
    }

    // divide and conquer multi
    // recursive
    public void divideAndConquer(int[][] matrixA, int[][]matrixB){
        
    }

    //strassen multi
    public void Strassen(int[][] matrixA, int[][]matrixB){
        
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
