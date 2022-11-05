package Project1;
import java.util.concurrent.TimeUnit;

public class matrixMultiplication {
    double classicAvg = 0;
    int classicUseCount = 0;
    double classicTotalTime = 0;

    double DandC_Avg = 0;
    int DandC_UseCount = 0;
    double DandC_TotalTime = 0;

    double strassenAvg = 0;
    int strassenUseCount = 0;
    double strassenTotalTime = 0;
    // calc time needed to complete each method within each method
    // classic matrix multi

    //int[][] matrixA, int[][]matrixB
    public void classicMultiplication(matrix matrixA, matrix matrixB){
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length];
        classicUseCount++;

        double start = System.nanoTime();
        //System.out.println("Start :"+start);
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

        double finish = System.nanoTime();
        //System.out.println("Finish :"+finish);
        double duration = finish-start;
        duration /= 1000; //time in nanoseconds since
        //System.out.println("Duration of "+duration+"ms for "+matrixA.getMatrix().length+" by "+matrixA.getMatrix().length+" matrix\n");
        //System.out.printf("Duration of %f for %d by %d matrix%n", duration, matrixA.length, matrixB.length);
        //printMatrix(matrixC);
        classicTotalTime += duration;
        classicAvg = classicTotalTime/classicUseCount;
        //System.out.println("Current classic method average: "+classicAvg+" ms\n");
    }

    public double getClassicAvg(){
        return classicAvg;
    }


    // divide and conquer multi
    // recursive
    public void divideAndConquer(matrix matrixA, matrix matrixB){
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length];
        DandC_UseCount++;


    }

    public double get_DandC_Avg(){
        return DandC_Avg;
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
