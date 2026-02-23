// Code is stored as 13template.java
//Idowu Popoola
//4546626
//2026/02/23

import java.lang.Math.*;   import java.io.*;   import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class timeMethods{
    public static int N = 0;
    public static void main(String args[]) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("ulysses.numbered"));
        String line;
        while ((line = br.readLine()) != null){
        String[] parts = line.split("\\s" ,2);
        int k =Integer.parseInt(parts[0]);
        list.add(k);

        }
        br.close();
        int[] arr = list.stream().mapToInt(i -> i).toArray(); // had to look how stream() is worked
        Arrays.sort(arr);
        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;
        Random rand = new Random();

        runTime = 0;
        for(repetition = 0; repetition < repetitions; repetition++) {

            int key = rand.nextInt(32654) + 1;
            start = System.currentTimeMillis();
            linearsearch(key,arr);
            finish = System.currentTimeMillis();
            time = finish - start;
            runTime+= time;


            start = System.currentTimeMillis();
            binarysearch (key,arr);
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
        System.out.println(); }

    public static int linearsearch(int n, int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == n) {
                return i;
            }

        }
        return -1;
    }

    public static int binarysearch(int n, int[] arr){
         int left = 0;
         int right = arr.length - 1;
         int mid = (left + right) / 2;
         while (left <= right){
             if (arr[mid] == n) {
                 return arr[mid];
             }
             else if(arr[mid] < n){
                 left =mid + 1;
                 }
             else{
                 right = mid-1;
             }
         }
         return -1;
    }
}
// The declarations and body of your method / s
// The final statement of this code.} }
