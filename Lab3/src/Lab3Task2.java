/** Lab 3 (Arrays, ArrayLists, Iterators, and 2048 Helper)
 Nicholas Romano (No partners)
 **/
import java.util.ArrayList;

public class Lab3Task2 {
    public static void main(String[] args) {
        int[][] arr2D = {{10,15,30,40},{15,5,8,2},{20,2,4,2},{1,4,5,0}};
        int[][] sumArray;
        sumArray = runningSum2DArray(arr2D);
        System.out.println("Summing a 2D Array: ");
        print2DArray(sumArray);

        ArrayList<Integer> row = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        ArrayList<ArrayList<Integer>> arrayList2D = new ArrayList<ArrayList<Integer>>(){{
            for(int i = 0; i <4; i++)
                add(new ArrayList<>(row));
        }};
        ArrayList<ArrayList<Integer>> sumList2D;
        System.out.println("Summing a 2D Array List: ");
        sumList2D = runningSum2DList(arrayList2D);
        print2DList(sumList2D);
    }

    public static void print2DArray(int[][] arr2D) {
        for(int[] row: arr2D){
            for(int n: row){
                System.out.print(n+"\t");
            }
            System.out.println();
        }
    }

    public static void print2DList(ArrayList<ArrayList<Integer>> arrayL2D){
        for(ArrayList<Integer> row: arrayL2D){
            for(Integer n : row){
                System.out.print(n+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] runningSum2DArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            int lastCell = 0;
            for(int j = 0; j < array[i].length; j++){
                array[i][j] += lastCell;
                lastCell = array[i][j];
            }
        }
        return array;
    }

    public static ArrayList<ArrayList<Integer>> runningSum2DList(ArrayList<ArrayList<Integer>> arrayL2D){
        for(int i =0; i < arrayL2D.size(); i++){
            int lastCell = 0;
            for(int j = 0; j < arrayL2D.get(i).size(); j++){
                arrayL2D.get(i).set(j, arrayL2D.get(i).get(j) + lastCell);
                lastCell = arrayL2D.get(i).get(j);
            }
        }
        return arrayL2D;
    }

}
