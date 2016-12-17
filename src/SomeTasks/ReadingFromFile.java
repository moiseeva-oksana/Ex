package SomeTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Оксана on 17.12.2016.
 */
public class ReadingFromFile {
    public static void main(String[] args) {
        readOnlyLinesWithWord("C:\\Users\\Оксана\\IdeaProjects\\Ex\\myFile.txt", "myword").forEach(System.out::println);
    }
    public static List<String> readOnlyLinesWithWord(String path, String word){
        List<String> lines = new ArrayList<>();
        String line;
        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            while ((line=bf.readLine())!=null){
                if(line.contains(word)) lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
