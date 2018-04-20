import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import java.util.Scanner;

public class Lab1 {
    static Scanner scan = new Scanner(System.in);

    public static boolean isAnagram(String name, String nameAn) {
        if(name.length() != nameAn.length()){ // nameAn can't be an anagram if it has more or less letters
            return false;
        }
        char[]  characterArray = nameAn.toCharArray();
        for(char c : characterArray){
            if (nameAn.indexOf(c) == -1){
                return false; // indexOf -1 means name has a letter in it not contained in nameAn so not an anagram
            }
        }
        return true; // If all the char in characterArray are found in nameAn and it is the same length it must be true
    }

    public static boolean isRotation(String original, String rotation) {
        if(original.length() != rotation.length()){ //Rotating a word wouldn't make it shorter or longer
            return false;
        }
        String rotationStack = rotation+rotation;
        if(rotationStack.indexOf(original) == -1) return false;
        return true; // No matter how you rotate putting two rotations together will contain the original

    }

    public static void main(String[] args) {
        System.out.println("Please input a name");
        String name = scan.nextLine();
        System.out.println("Please input an anagram to this name");
        String anagram = scan.nextLine();
        System.out.println("This anagram is "+isAnagram(name, anagram));
        System.out.println("Please input a word");
        String word = scan.nextLine();
        System.out.println("Please input a rotation");
        String rotation = scan.nextLine();
        System.out.println("This rotation is "+isRotation(word, rotation));
    }


}
