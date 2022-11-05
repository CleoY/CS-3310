package Project1;
public class Main{
    public static void main(String args[]){
        matrixMultiplication multi = new matrixMultiplication();

        //set size=n; 1 n size at a time for the sake of avoiding
        // overworking comp + ease of finding data
        // consider saving findings to a csv file for easy graphical analysis
        /**
         * for 1000
         *      generate new random matrices x2
         *      for 20
         *          pass matrix into classic method
         *          pass matrix into divide-and-conquer method
         *          pass matrix into Strassen method
         *          * from each method, calculate completion time
         *          ** also print each output matrix? or store in another Matrix class?
         *      pass matrix
         */

        for(int i=0; i<1000; i++){
            matrix matrixA = new matrix(128);
            matrix matrixB = new matrix(128);
            for (int j=0; j<20; j++){
                //matrixA.printMatrix();
                //matrixB.printMatrix();
                multi.classicMultiplication(matrixA, matrixB);
            }
            //System.out.println("Classic method average time for 20 runs: "+multi.getClassicAvg()+ " ms");
            // ^ Does NOT find avg for ONE dataset; finds CURRENT avg given prev datasets 
        }
        System.out.println("Classic method average time for 1000*20 runs: "+multi.getClassicAvg()+ " ms"); 
    }
}