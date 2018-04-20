/** Lab 3 (Arrays, ArrayLists, Iterators, and 2048 Helper)
 Nicholas Romano (No partners)
 **/
import java.util.ArrayList;

public class Lab3Task1 {
    public static void main(String[] args) {
        int[][] arr2D = {{10,15,30,40},{15,5,8,2},{20,2,4,2},{1,4,5,0}};
        System.out.println("Printing a 2D Array: ");
        print2DArray(arr2D);

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
        System.out.println("Printing a 2D Array List: ");
        print2DList(arrayList2D);
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
}
