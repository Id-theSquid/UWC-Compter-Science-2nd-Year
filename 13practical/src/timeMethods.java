// Code is stored as 13template.java
import java.lang.Math.*;   import java.io.*;   import java.text.*;

static class Node {
    int key;
    String data;
    Node(int k,String d) {key = k;data = d;}
}

public class timeMethods{
    public static int N = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ulysses.numbered"));
        String line;
        while ((line = br.readLine()) != null){
        

        }
        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;
        for(repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();
            linearsearch ();
            finish = System.currentTimeMillis();
            time = finish - start;
            runTime+= time;


            start = System.currentTimeMillis();
            binarysearch ();
            finish = System.currentTimeMillis();
            time = finish - start;
            runTime2 += time;
            // Figure out how to alter this guideline here,

            finish = System.currentTimeMillis();

            time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time); }

        double aveRuntime = runTime/repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + n);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000)
                + '\u00B5' + "s. ");

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println(); }	}

public static void linearsearch(int n,int[] arr){
    for (int i = 0; i < arr.length ; i++) {
        if (arr[i] == n){
            System.out.println("Found it ");
        }
    }
}

public static void binarysearch(int n,int[] arr){

}
// The declarations and body of your method / s
// The final statement of this code.} }
