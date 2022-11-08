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
    // recursive
    public int[][] divideAndConquer(int[][] matrixA, int[][] matrixB){
        int size = matrixA.length;
        int[][] matrixC = new int [size][size];

        if(size == 1){
            matrixC[0][0] = matrixA[0][0] * matrixB[0][0];
        } else{
            // Submatrices
            // A_TL = top left quadrant of matrixA     
            // A_TR = top right quadrant of matrixA
            // etc...   
            int[][] A_TL = new int [size/2][size/2];
            int[][] A_TR = new int [size/2][size/2];
            int[][] A_BL = new int [size/2][size/2];
            int[][] A_BR = new int [size/2][size/2];
            int[][] B_TL = new int [size/2][size/2];
            int[][] B_TR = new int [size/2][size/2];
            int[][] B_BL = new int [size/2][size/2];
            int[][] B_BR = new int [size/2][size/2];

            // Split matrixA and matrixB into submatrices



            // Declare C quadrants
            // int[][] C_TL = new int [size/2][size/2];
            // int[][] C_TR = new int [size/2][size/2];
            // int[][] C_BL = new int [size/2][size/2];
            // int[][] C_BR = new int [size/2][size/2];


        }

        /*
         * Base case: matrix size = 1
         *      c[0][0] = a[0][0]*b[0][0] (only size 1x1 each)
         * Else:
         *      Split matrices:
         *          Copy quadrants of each matrix to their respective submatrices
         *      C[1,1] = A[1,1]*B[1,2] + A[1,2]*B[1,2]
         *             = A[TL]*B[TL] + A[TR]*B[BL]
         * 
         *      C[1,2] = A[1,1]*B[1,2] + A[1,2]*B[2,1]
         *             = A[TL]*B[TR] + A[TR]*B[BR]
         * 
         *      C[2,1] = A[2,1]*B[1,1] + A[2,2]*B[2,1]
         *             = A[BL]*B[TL] + A[BR]*B[BL]
         * 
         *      C[2,2] = A[2,1]*B[1,2] + A[2,2]*B[2,2]
         *             = A[BL]*B[TR] + A[BR]*B[BR]
         * 
         *      Converge all C quadrants into large output matrixC
         * 
         * Passing each quadrant into their appropriate D&C calls
         *   -> splitting each passed matrix into further submatrices
         *      until matrices' sizes = all 1x1
         */

        return matrixC;
    }

    public int[][] addMatrices(int[][] matrixA, int[][] matrixB){
        int[][] intermediate = new int [matrixA.length][matrixA.length];
        int size = matrixA.length;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                intermediate[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return intermediate;
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
