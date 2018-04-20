/** Lab 3 (Arrays, ArrayLists, Iterators, and 2048 Helper)
 Nicholas Romano (No partners)
 **/
import java.util.ArrayList;
import java.util.Iterator;

public class Lab3Task3 {
    public static void main(String[] args) {
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
        printArrayListBasicLoop(row);
        printArrayEnhancedLoop(row);
        printArrayListForLoopListIterator(row);
        printArrayListWhileLoopListIterator(row);
        printArrayListLambda(row);

    }
    public static void printArrayListBasicLoop(ArrayList<Integer> al){
        for(int i = 0; i < al.size(); i++){
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }

    public static void printArrayEnhancedLoop(ArrayList<Integer> al){
        for(int i : al){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void printArrayListForLoopListIterator(ArrayList<Integer> al){
        for(Iterator iterator = al.listIterator(); iterator.hasNext(); ){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }

    public static void printArrayListWhileLoopListIterator(ArrayList<Integer> al){
        Iterator iterator = al.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();

    }

    public static void printArrayListLambda(ArrayList<Integer> al){
        al.forEach((Integer value) -> System.out.print(value + " "));
    }
}
