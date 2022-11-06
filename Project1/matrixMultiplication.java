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
    public int divideAndConquer(matrix matrixA, matrix matrixB){
        // inefficient use of space??
        int[][] matrixC = new int [matrixA.getMatrix().length][matrixA.getMatrix().length]; // change dimensions?
        int[][] subA_top = new int [matrixA.getMatrix().length/2][matrixA.getMatrix()[1].length];
        int[][] subA_bottom = new int [matrixA.getMatrix().length/2][matrixA.getMatrix()[1].length];
        int[][] subB_left = new int [matrixB.getMatrix().length][matrixB.getMatrix()[1].length/2];
        int[][] subB_right = new int [matrixB.getMatrix().length][matrixB.getMatrix()[1].length/2];

        if(matrixA.getMatrix().length == 1){
            return matrixA.getMatrix()[1][1] * matrixB.getMatrix()[1][1];
        } else{
            // top half of matrixA and left half of matrixB
            for(int i=0; i<matrixA.getMatrix().length/2; i++){
                for(int j=0; j<matrixA.getMatrix()[i].length; j++){
                    subA_top[i][j] = matrixA.getMatrix()[i][j];
                    subB_left[j][i] = matrixB.getMatrix()[j][i];
                }
            }

            // bottom half matrixA and right half of matrixB
            for(int i=matrixA.getMatrix().length/2; i<matrixA.getMatrix().length; i++){
                for(int j=0; j<matrixA.getMatrix()[i].length; j++){
                    subA_bottom[i][j] = matrixA.getMatrix()[i][j];
                    subB_right[j][i] = matrixB.getMatrix()[j][i];
                }
            }

            // what indices for C??
            matrixC[][] = divideAndConquer(subA_top, subB_left) + divideAndConquer(subA_bottom, subB_right);

            //matrixC[1][1] = divideAndConquer(matrixA, matrixB) + divideAndConquer(matrixA, matrixB);
            // C indices = something related to curr matA length?
            // split matrices in half and give to each D&C call

        }

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
         *  split matA rows in half until only 1 row remains
         *      AND split matB cols in half until only 1 col remains
         *  THEN split single matA row in half until only 1 cell remains
         *      AND split single matB col in half until only 1 cell remains
         *  sub C = a[1]*b[1]
         *  C = total of sub C's for a row
         */

         /*
          * C = D&C(matA row, matB col) + D&C(matA row, matB col)
          */
        return 0;
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
