import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args){
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        File inputFile = new File("problem1.txt");
        File outputFile = new File("unique_words.txt");
        try
        {
            duplicateRemover.remove(inputFile);
            duplicateRemover.write(outputFile);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
