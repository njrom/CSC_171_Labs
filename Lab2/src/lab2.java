/** Lab 2 (Java Generics)
Nicholas Romano (No partners)
**/
import java.util.function.Function;
public class lab2 {
    public static void main(String[] args) {
        Integer [] intArry = {1, 2, 3, 4, 5};
        Double [] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character [] charArry = {'H', 'E', 'L', 'L', 'O'};
        String[] strArry = {"once", "upon", "a", "time"};

        Function<Character [], Character> findMax = (Character [] arr) -> {
            Character maxElement = arr[0];
            for(int i = 0; i < arr.length; i++){
                if(arr[i].compareTo(maxElement) > 0) maxElement = arr[i];
            }
            return maxElement;
        };

        printArray(intArry);
        printArray(doubArry);
        printArray(charArry);
        printArray(strArry);
        System.out.println("The Maximum Integer is: "+ getMax(intArry));
        System.out.println("The Maximum Double is: "+ getMax(doubArry));
        System.out.println("The Maximum Character is: "+ getMax(charArry));
        System.out.println("The Maximum String is: "+ getMax(strArry));
        System.out.println("The Maximum Character is: "+ findMax.apply(charArry));
    }
/**
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ",arr[i]);
        }
        System.out.println();
    }
**/
/**
    public static void printArray (Integer [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }

    public static void printArray (Double [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }

    public static void printArray (Character [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }

    public static void printArray (String[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }
**/

    public static <T> void printArray(T[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s ",arr[i]);
        }
        System.out.println();
    }
/**
    public static Comparable getMax(Comparable [] arr){
        Comparable maxElement = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(maxElement) > 0) maxElement = arr[i];
        }
        return(maxElement);
    }
 **/
    public static <T extends Comparable<T>> T getMax(T [] arr) {
        T maxElement = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(maxElement) > 0) maxElement = arr[i];
        }
        return(maxElement);
    }

}
