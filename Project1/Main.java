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
        double strassenStart = 0;
        double strassenFinish = 0;
        double strassenDuration = 0;


        // Change "size" in matrixA and matrixB calls each time you want to test a matrix of a different size
        for(int i=0; i<1000; i++){
            matrix matrixA = new matrix(2);
            matrix matrixB = new matrix(2);
            for (int j=0; j<20; j++){
                //matrixA.printMatrix();
                //matrixB.printMatrix();
                
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
                multi.divideAndConquer(matrixA.getMatrix(), matrixB.getMatrix());
                DandC_Finish = System.nanoTime();
                DandC_Duration = DandC_Finish - DandC_Start;
                DandC_Duration /= 1000000;
                DandC_TotalTime += DandC_Duration;
                DandC_Avg = DandC_TotalTime/DandC_UseCount;

                strassenUseCount++;
                strassenStart = System.nanoTime();
                multi.strassen(matrixA.getMatrix(), matrixB.getMatrix());
                strassenFinish = System.nanoTime();
                strassenDuration = strassenFinish - strassenStart;
                strassenDuration /= 1000000;
                strassenTotalTime += strassenDuration;
                strassenAvg = strassenTotalTime/strassenUseCount;
                
            }
        }
        System.out.println("Classic method average time for 1000*20 runs: " + classicAvg + " ms"); 
        System.out.println("D&C method average time for 1000*20 runs: " + DandC_Avg + " ms");
        System.out.println("Strassen method average time for 1000*20 runs: " + strassenAvg + " ms");
        
        double finish = System.nanoTime();
        double duration = finish - start;
        duration /= 1000000;
        System.out.println("Duration: "+duration+" ms");
    }
}