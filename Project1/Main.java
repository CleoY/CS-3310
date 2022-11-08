package Project1;

import java.time.Duration;

public class Main{
    public static void main(String args[]){
        double start = System.nanoTime();

        matrixMultiplication multi = new matrixMultiplication();

        double classicAvg = 0;
        int classicUseCount = 0;
        double classicTotalTime = 0;
        double classicStart = 0;
        double classicFinish = 0;
        double classicDuration = 0;

        double DandC_Avg = 0;
        int DandC_UseCount = 0;
        double DandC_TotalTime = 0;
        double DandC_Start = 0;
        double DandC_Finish = 0;
        double DandC_Duration = 0;

        double strassenAvg = 0;
        int strassenUseCount = 0;
        double strassenTotalTime = 0;

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

        for(int i=0; i<1; i++){
            matrix matrixA = new matrix(4);
            matrix matrixB = new matrix(4);
            for (int j=0; j<1; j++){
                matrixA.printMatrix();
                matrixB.printMatrix();
                
                classicUseCount++;
                classicStart = System.nanoTime();
                multi.classicMultiplication(matrixA, matrixB);
                classicFinish = System.nanoTime();
                classicDuration = classicFinish - classicStart;
                classicDuration /= 1000000;
                classicTotalTime += classicDuration;
                classicAvg = classicTotalTime/classicUseCount;
                
                DandC_UseCount++;
                DandC_Start = System.nanoTime();
                multi.printMatrix(multi.divideAndConquer(matrixA.getMatrix(), matrixB.getMatrix()), "D&C result: ");
                DandC_Finish = System.nanoTime();
                DandC_Duration = DandC_Finish - DandC_Start;
                DandC_Duration /= 1000000; //CHECK CONVERSION
                DandC_TotalTime += DandC_Duration;
                DandC_Avg = DandC_TotalTime/DandC_UseCount;
            }
            //System.out.println("Classic method average time for 20 runs: "+multi.getClassicAvg()+ " ms");
            // ^ Does NOT find avg for ONE dataset; finds CURRENT avg given prev datasets 
        }
        System.out.println("Classic method average time for 1000*20 runs: " + classicAvg + " ms"); 
        System.out.println("D&C method average time for 1000*20 runs: " + DandC_Avg + " ms");
        
        double finish = System.nanoTime();
        double duration = finish - start;
        duration /= 1000000;
        System.out.println("Duration: "+duration+" ms");
    }
}