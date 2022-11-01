package Project1;
import java.util.concurrent.TimeUnit;

public class matrixMultiplication {

    // calc time needed to complete each method within each method
    // classic matrix multi

    //int[][] matrixA, int[][]matrixB
    public void classicMultiplication(matrix matrixA, matrix matrixB){
        long start = System.nanoTime();
        System.out.println("Start :"+start);
        // 3 for loops
        /*
         * for # of rows in matrixA (i)
         *      for # of cols in matrixB (will be = to row/col of both matrices) (j)
         *          for each cell in the row in matrixA (k)
         *              multiply a(i,k) * b(j, k)
         */





        long finish = System.nanoTime();
        System.out.println("Finish :"+finish);
        long duration = finish-start;
        duration /= 1000; //time in nanoseconds since
        System.out.println("Duration of "+duration+"ms for "+matrixA.getMatrix().length+" by "+matrixA.getMatrix().length+" matrix\n");
        //System.out.printf("Duration of %f for %d by %d matrix%n", duration, matrixA.length, matrixB.length);
        
    }

    // divide and conquer multi
    // recursive
    public void divideAndConquer(int[][] matrixA, int[][]matrixB){
        
    }

    //strassen multi
    public void Strassen(int[][] matrixA, int[][]matrixB){
        
    }   
}
