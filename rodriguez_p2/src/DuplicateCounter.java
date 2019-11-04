import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter
{
    // Contains the strings read from input and frequency
    private HashMap<String, Integer> wordCounter;

    // creates the wordCounter variable
    public DuplicateCounter()
    {
        wordCounter = new HashMap<String, Integer>();
    }

    // Takes dataFile and counts how many times the strings in dataFile are repeated
    public void count(File dataFile) throws Exception
    {
        Scanner scan = null;

        try
        {

            scan = new Scanner(dataFile);
            String word;
            while(scan.hasNext())
            {
                word = scan.next();
                if(wordCounter.containsKey(word))
                    wordCounter.put(word, wordCounter.get(word) + 1); // Adds one to the string that is already in the map
                else
                    wordCounter.put(word, 1); // Adds a string to map that wasn't there and starts it at 1
            }
            scan.close();

        }
        catch (Exception e)
        {
            // Ensures that scanner was closed before leaving the method
            if(scan != null)
                scan.close();

            throw new IOException("problem1.txt doesn't exist in the current directory");
        }
    }

    // writes the contents of wordCounter to an outputFile called unique_word_counts.txt
    public void write(File outputFile) throws Exception
    {
        BufferedWriter txt = null;
        try
        {
            // creates the outputFile if it hasn't been made yet
            if(outputFile == null || (!outputFile.exists()))
            {
                outputFile = new File("unique_word_counts.txt");
                outputFile.createNewFile();
            }
            txt = new BufferedWriter(new FileWriter(outputFile));

            // goes through each entry in wordCounter and writes the string and frequency in the outputFile
            for(Map.Entry entry: wordCounter.entrySet())
            {
                txt.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            txt.close();
        }
        catch (IOException e)
        {
            // Ensures that the buffered writer was closed before leaving the method
            if(txt != null)
                txt.close();

            throw new IOException("unique_words.txt doesn't exist and couldn't be created");
        }
    }
}
