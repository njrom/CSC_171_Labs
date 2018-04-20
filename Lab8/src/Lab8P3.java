import java.util.HashMap;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Lab8P3 {
    private HashMap<String,Integer> makeFrequencyTable(String[] elementArray){
        HashMap<String, Integer> frequencyTable = new HashMap<>();
        for(String element: elementArray){
            frequencyTable.merge(element, 1, Integer::sum);
        }
        return frequencyTable;
    }

    private void word_count(String inputFile, String outputFile) throws IOException{
        String content = new String(Files.readAllBytes(Paths.get(inputFile)));
        String[] words = content.split("\\s+");
        HashMap<String, Integer> frequency = makeFrequencyTable(words);
        PrintWriter out = new PrintWriter(new File(outputFile));
        for (HashMap.Entry<String,Integer> entry : frequency.entrySet()) {
            out.println(entry.getKey() + ":" + entry.getValue());
        }
        out.close();
    }
    public static void main(String[] args) throws IOException{
        Lab8P3 counter = new Lab8P3();
        counter.word_count("alice30.txt","frequencyOfAlice30.txt");

    }

}
