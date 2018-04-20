/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.io.PrintWriter;

public class Sorting {
    //TODO: Need To Copy MergeSort and QuickSort from the slides
    //TODO: Need To Run each sorting algorithm on all of the files that take less than 10 mins to run
    //TODO: Make a table out of the runtimes for the relative sizes
    //TODO: Generate 4 plots log x Comment on the findins of the groth (how this shows the big Oh notation)
    // save to a pdf and submit zip with source code and my pdf with the results


 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  { 
        In in = new In(args[0]);
        
		  // Storing file input in an array
        int[] a = in.readAllInts();
        int[] b = a.clone();
        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        Arrays.sort(b);
        // c contains all integers stored in reverse order
        int[] c = new int[b.length];
        for(int i = 0; i < b.length; i++) c[(b.length - 1) - i] = b[i];
        // (you can have your own O(n) solution to get c from b
        // d contains almost sorted array
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.
        int[] d = new int[b.length];
        for(int i = 0; i < 0.1 * d.length; i++){ // Performs n swaps
            int random1 = ThreadLocalRandom.current().nextInt(0, d.length); // Picks random element to swap
            int random2 = ThreadLocalRandom.current().nextInt(0, d.length); // Picks random element to be swapped
            int temp = d[random1];
            d[random1] = b[random2];
            d[random2] = temp;
        }

        //TODO:
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort
        //  * 3 = Insertion Sort
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those.
        // For runtime and priting, you can use the same code from Lab 4 as follows:
        int n = Integer.parseInt(args[1]);
        // TODO: For each array, a, b, c, d:
        // TODO: Perform Sorting and store the result in an  array
        switch(n) {
            case 0:
                sort_JavaDefault(a, "a", args);
                sort_JavaDefault(b, "b", args);
                sort_JavaDefault(c, "c", args);
                sort_JavaDefault(d, "d", args);
                break;
            case 1:
                sort_Bubble(a,"a", args);
                sort_Bubble(b,"b", args);
                sort_Bubble(c,"c", args);
                sort_Bubble(d,"d", args);
                break;
            case 2:
                sort_Selection(a, "a", args);
                sort_Selection(b, "b", args);
                sort_Selection(c, "c", args);
                sort_Selection(d, "d", args);
                break;
            case 3:
                sort_Insertion(a, "a", args);
                sort_Insertion(b, "b", args);
                sort_Insertion(c, "c", args);
                sort_Insertion(d, "d", args);
                break;
            case 4:
                sort_Merge(a, "a", args);
                sort_Merge(b, "b", args);
                sort_Merge(c, "c", args);
                sort_Merge(d, "d", args);
                break;
            case 5:
                sort_Quick(a, "a", args);
                sort_Quick(b, "b", args);
                sort_Quick(c, "c", args);
                sort_Quick(d, "d", args);
                break;
            default:
                System.out.println("Invalid Sorting Choice");
        }
  }
  public static void sort_JavaDefault(int[] array, String arrayUsed, String[] args){
        Stopwatch timer = new Stopwatch();
        String algorithmUsed = "Arrays.sort() (Java Default)";
        Arrays.sort(array);
        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "nromano2";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]); // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        try {
            PrintWriter pr = new PrintWriter(arrayUsed);
            for (int i=0; i<array.length ; i++) {
                pr.print(array[i]+" ");
            }
            pr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
  }
    public static void sort_Bubble(int[] array, String arrayUsed, String[] args){
        Stopwatch timer = new Stopwatch();
        String algorithmUsed = "Bubble Sort";
        //TODO: Write Sorting algorithm
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "nromano2";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]); // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        try {
            PrintWriter pr = new PrintWriter(arrayUsed);
            for (int i=0; i<array.length ; i++) {
                pr.print(array[i]+" ");
            }
            pr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
    public static void sort_Selection(int[] array, String arrayUsed, String[] args){
        Stopwatch timer = new Stopwatch();
        String algorithmUsed = "Selection Sort";
        //TODO: Write Sorting algorithm
        for(int i = 0; i < array.length-1; i++){
            int minIndex = i;
            for(int j = i; j < array.length; j++){
                if(array[j]< array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "nromano2";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]); // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        try {
            PrintWriter pr = new PrintWriter(arrayUsed);
            for (int i=0; i<array.length ; i++) {
                pr.print(array[i]+" ");
            }
            pr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
    public static void sort_Insertion(int[] array, String arrayUsed, String[] args){
        Stopwatch timer = new Stopwatch();
        String algorithmUsed = "Insertion Sort";
        //TODO: Write Sorting algorithm
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }

        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "nromano2";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]); // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        try {
            PrintWriter pr = new PrintWriter(arrayUsed);
            for (int i=0; i<array.length ; i++) {
                pr.print(array[i]+" ");
            }
            pr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
    public static void sort_Merge(int[] array, String arrayUsed, String[] args){
        Stopwatch timer = new Stopwatch();
        String algorithmUsed = "Mergesort";
        //TODO: Write Sorting algorithm
        MergeSort(array);

        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "nromano2";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]); // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        try {
            PrintWriter pr = new PrintWriter(arrayUsed);
            for (int i=0; i<array.length ; i++) {
                pr.print(array[i]+" ");
            }
            pr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
    // Merge sort algorithm copied from the lecture slides
    public static void MergeSort(int[] arr){
        if(arr.length <= 1) return;
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length - arr.length/2];
        System.arraycopy(arr, 0, left, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, right, 0, arr.length - arr.length/2);
        MergeSort(left);
        MergeSort(right);
        merge(arr, left, right);
    }
    public static void merge(int[] target, int[] left, int[] right){
        int i = 0, j = 0, k=0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j])
                target[k++] = left[i++];
            else
                target[k++] = right[j++];
        }
        while(i < left.length) target[k++] = left[i++];
        while(j < right.length) target[k++] = right[j++];
    }
    public static void sort_Quick(int[] array, String arrayUsed, String[] args){
        Stopwatch timer = new Stopwatch();
        String algorithmUsed = "Quicksort";
        //TODO: Write Sorting algorithm
        quickSort(array,0,array.length-1);
        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "nromano2";
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]); // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        try {
            PrintWriter pr = new PrintWriter(arrayUsed);
            for (int i=0; i<array.length ; i++) {
                pr.print(array[i]+" ");
            }
            pr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
} 


