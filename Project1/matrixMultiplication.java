package Project1;
import java.util.concurrent.TimeUnit;

public class matrixMultiplication {
    
    // Classic matrix multiplication
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
        //printMatrix(matrixC, "Classic multiplication result: ");
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


            // C quadrants
            // C[1,1] = A[1,1]*B[1,2] + A[1,2]*B[1,2]
            //        = A[TL]*B[TL] + A[TR]*B[BL]
            int[][] C_TL = addOrSubMatrices(divideAndConquer(A_TL, B_TL), divideAndConquer(A_TR, B_BL), 1);
            
            // C[1,2] = A[1,1]*B[1,2] + A[1,2]*B[2,1]
            //        = A[TL]*B[TR] + A[TR]*B[BR]
            int[][] C_TR = addOrSubMatrices(divideAndConquer(A_TL, B_TR), divideAndConquer(A_TR, B_BR), 1);

            // C[2,1] = A[2,1]*B[1,1] + A[2,2]*B[2,1]
            //        = A[BL]*B[TL] + A[BR]*B[BL]
            int[][] C_BL = addOrSubMatrices(divideAndConquer(A_BL, B_TL), divideAndConquer(A_BR, B_BL), 1);

            // C[2,2] = A[2,1]*B[1,2] + A[2,2]*B[2,2]
            //        = A[BL]*B[TR] + A[BR]*B[BR]
            int[][] C_BR = addOrSubMatrices(divideAndConquer(A_BL, B_TR), divideAndConquer(A_BR, B_BR), 1);


            // Converge C quadrants into large matrixC output
            k=0;
            l=0;
            for(int i=0; i<size/2; i++){
                for(int j=0; j<size/2; j++){
                    matrixC[i][j] = C_TL[k][l];
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
                    matrixC[i][j] = C_TR[k][l];
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
                    matrixC[i][j] = C_BL[k][l];
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
                    matrixC[i][j] = C_BR[k][l];
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
        return matrixC;
    }

    // option = 1 -> add matrices
    // option = 2 -> subtract matrices
    public int[][] addOrSubMatrices(int[][] matrixA, int[][] matrixB, int option){
        int[][] intermediate = new int [matrixA.length][matrixA.length];
        int size = matrixA.length;
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(option == 1){
                    intermediate[i][j] = matrixA[i][j] + matrixB[i][j];
                } else{
                    intermediate[i][j] = matrixA[i][j] - matrixB[i][j];
                }
            }
        }
        return intermediate;
    }



    // Strassen multiplication
    public int[][] strassen(int[][] matrixA, int[][] matrixB){
        int size = matrixA.length;
        int[][] matrixC = new int [size][size];
        if(size==2){
            matrixC[0][0] = matrixA[0][0] * matrixB[0][0] + matrixA[0][1] * matrixB[1][0];
            matrixC[0][1] = matrixA[0][0] * matrixB[0][1] + matrixA[0][1] * matrixB[1][1];
            matrixC[1][0] = matrixA[1][0] * matrixB[0][0] + matrixA[1][1] * matrixB[1][0];
            matrixC[1][1] = matrixA[1][0] * matrixB[0][1] + matrixA[1][1] * matrixB[1][1];
        } else{
            // Create submatrices for matrixA and matrixB
            int[][] A_TL = new int [size/2][size/2];
            int[][] A_TR = new int [size/2][size/2];
            int[][] A_BL = new int [size/2][size/2];
            int[][] A_BR = new int [size/2][size/2];
            int[][] B_TL = new int [size/2][size/2];
            int[][] B_TR = new int [size/2][size/2];
            int[][] B_BL = new int [size/2][size/2];
            int[][] B_BR = new int [size/2][size/2];

            // Split matrixA and matrixB into submatrices
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

            // P = (A[1,1] + A[2,2]) * (B[1,1] + B[2,2])
            int[][] P = strassen(addOrSubMatrices(A_TL, A_BR, 1), addOrSubMatrices(B_TL, B_BR, 1));
            
            // Q = (A[2,1] + A[2,2]) * B[1,1]
            int[][] Q = strassen(addOrSubMatrices(A_BL, A_BR, 1), B_TL);

            // R = A[1,1] * (B[1,2] - B[2,2])
            int[][] R = strassen(A_TL, addOrSubMatrices(B_TR, B_BR, 2));

            // S = A[2,2] * (B[2,1] - B[1,1])
            int[][] S = strassen(A_BR, addOrSubMatrices(B_BL, B_TL, 2));

            // T = (A[1,1] + A[1,2]) * B[2,2]
            int[][] T = strassen(addOrSubMatrices(A_TL, A_TR, 1), B_BR);

            // U = (A[2,1] - A[1,1]) * (B[1,1] + B[1,2])
            int[][] U = strassen(addOrSubMatrices(A_BL, A_TL, 2), addOrSubMatrices(B_TL, B_TR, 1));

            // V = (A[1,2] - A[2,2]) * (B[2,1] + B[2,2])
            int[][] V = strassen(addOrSubMatrices(A_TR, A_BR, 2), addOrSubMatrices(B_BL, B_BR, 1));
        
            // C[1,1] = P + S - T + V
            int[][] C_TL = addOrSubMatrices(addOrSubMatrices(addOrSubMatrices(P, S, 1), T, 2), V, 1);

            // C[1,2] = R + T
            int[][] C_TR = addOrSubMatrices(R, T, 1);

            // C[2,1] = Q + S
            int[][] C_BL = addOrSubMatrices(Q, S, 1);

            // C[2,2] = P + R - Q + U
            int[][] C_BR = addOrSubMatrices(addOrSubMatrices(addOrSubMatrices(P, R, 1), Q, 2), U, 1);


            // Converge C quadrants
            k=0;
            l=0;
            for(int i=0; i<size/2; i++){
                for(int j=0; j<size/2; j++){
                    matrixC[i][j] = C_TL[k][l];
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
                    matrixC[i][j] = C_TR[k][l];
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
                    matrixC[i][j] = C_BL[k][l];
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
                    matrixC[i][j] = C_BR[k][l];
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

        return matrixC;
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
