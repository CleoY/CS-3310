package Project1;
import java.util.concurrent.TimeUnit;

public class matrixMultiplication {

    // calc time needed to complete each method within each method
    // classic matrix multi
    public void classicMultiplication(int[][] matrixA, int[][]matrixB){
        long start = System.nanoTime();








        long finish = System.nanoTime();
        long duration = start-finish;
        duration = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        System.out.printf("Duration of %f for %d by %d matrix%n", duration, matrixA.length, matrixA.length);
    }

    // divide and conquer multi
    public void divideAndConquer(int[][] matrixA, int[][]matrixB){
        
    }

    //strassen multi
    public void Strassen(int[][] matrixA, int[][]matrixB){
        
    }   
}
