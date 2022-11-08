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
        printMatrix(matrixC, "Classic multiplication result: ");
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
            // Split matrixA
            int k=0;
            int l=0;
            for(int i=0; i<size/2; i++){
                for(int j=0; j<size/2; j++){
                    A_TL[k][l] = matrixA[i][j];
                    B_TL[k][l] = matrixB[i][j];
                    l++;
                    if(l==size/2){
                        k++;
                        l=0;
                    }
                    if(k==size/2){
                        k=0;
                    }
                }
            }

            for(int i=0; i<size/2; i++){
                for(int j=size/2; j<size; j++){
                    A_TR[k][l] = matrixA[i][j];
                    B_TR[k][l] = matrixB[i][j];
                    l++;
                    if(l==size/2){
                        k++;
                        l=0;
                    }
                    if(k==size/2){
                        k=0;
                    }
                }
            }
            
            for(int i=size/2; i<size; i++){
                for(int j=0; j<size/2; j++){
                    A_BL[k][l] = matrixA[i][j];
                    B_BL[k][l] = matrixB[i][j];
                    l++;
                    if(l==size/2){
                        k++;
                        l=0;
                    }
                    if(k==size/2){
                        k=0;
                    }
                }
            }

            for(int i=size/2; i<size; i++){
                for(int j=size/2; j<size; j++){
                    A_BR[k][l] = matrixA[i][j];
                    B_BR[k][l] = matrixB[i][j];
                    l++;
                    if(l==size/2){
                        k++;
                        l=0;
                    }
                    if(k==size/2){
                        k=0;
                    }
                }
            }
            
            
            // int k = 0;
            // int l = 0;
            // for(int i=0; i<size; i++){ ///
            //     for(int j=0; j<size; j++){ ///
            //         //System.out.println("k = "+k+", l = "+l);
            //         if(i<size/2 && j<size/2){
            //             A_TL[k][l] = matrixA[i][j];
            //             B_TL[k][l] = matrixB[i][j];
            //         } else if(i<size/2 && j>=size/2){
            //             A_TR[k][l] = matrixA[i][j];
            //             B_TR[k][l] = matrixB[i][j];
            //         } else if(i>=size/2 && j<size/2){
            //             A_BL[k][l] = matrixA[i][j];
            //             B_BL[k][l] = matrixB[i][j];
            //         } else{
            //             A_BR[k][l] = matrixA[i][j];
            //             B_BR[k][l] = matrixB[i][j];
            //         }
            //         l++;
            //         if(l==size/2){
            //             k++;
            //             l=0;
            //         }
            //         if(k==size/2){
            //             k=0;
            //         }
            //     }
            // }
            System.out.println("A submatrices");
            printMatrix(A_TL,"");
            printMatrix(A_TR,"");
            printMatrix(A_BL,"");
            printMatrix(A_BR,"");
    
            System.out.println("B submatrices");
            printMatrix(B_TL,"");
            printMatrix(B_TR,"");
            printMatrix(B_BL,"");
            printMatrix(B_BR,"");




            // C quadrants
            // C[1,1] = A[1,1]*B[1,2] + A[1,2]*B[1,2]
            //        = A[TL]*B[TL] + A[TR]*B[BL]
            int[][] C_TL = addMatrices(divideAndConquer(A_TL, B_TL), divideAndConquer(A_TR, B_BL));
            
            // C[1,2] = A[1,1]*B[1,2] + A[1,2]*B[2,1]
            //        = A[TL]*B[TR] + A[TR]*B[BR]
            int[][] C_TR = addMatrices(divideAndConquer(A_TL, B_TR), divideAndConquer(A_TR, B_BR));

            // C[2,1] = A[2,1]*B[1,1] + A[2,2]*B[2,1]
            //        = A[BL]*B[TL] + A[BR]*B[BL]
            int[][] C_BL = addMatrices(divideAndConquer(A_BL, B_TL), divideAndConquer(A_BR, B_BL));

            // C[2,2] = A[2,1]*B[1,2] + A[2,2]*B[2,2]
            //        = A[BL]*B[TR] + A[BR]*B[BR]
            int[][] C_BR = addMatrices(divideAndConquer(A_BL, B_TR), divideAndConquer(A_BR, B_BR));


            // Converge C quadrants into large matrixC output
            k=0;
            l=0;
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(i<size/2 && j<size/2){
                        matrixC[i][j] = C_TL[k][l];
                    } else if(i<size/2 && j>=size/2){
                        matrixC[i][j] = C_TR[k][l];
                    } else if(i>=size/2 && j<size/2){
                        matrixC[i][j] = C_BL[k][l];
                    } else{
                        matrixC[i][j] = C_BR[k][l];
                    }
                    l++;
                    if(l==size/2){
                        k++;
                        l=0;
                    }
                    if(k==size/2){
                        k=0;
                    }
                }
            }

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

        // Declare C quadrants
            // int[][] C_TL = new int [size/2][size/2];
            // int[][] C_TR = new int [size/2][size/2];
            // int[][] C_BL = new int [size/2][size/2];
            // int[][] C_BR = new int [size/2][size/2];
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

    public void printMatrix(int [][] output, String msg){
        System.out.println(msg);
        for(int i=0; i<output.length; i++){
            for(int j=0; j<output[i].length; j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

}
