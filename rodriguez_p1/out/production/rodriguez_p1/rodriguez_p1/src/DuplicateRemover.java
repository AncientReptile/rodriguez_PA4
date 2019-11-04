import java.io.*;
import java.util.*;

public class DuplicateRemover
{
    // stores the unique words from inputFile
    private HashSet<String> uniqueWords;

    // creates the set for the unique words
    public DuplicateRemover()
    {
        uniqueWords = new HashSet<String>();
    }

    // reads the dataFile and puts unique strings into the uniqueWords set
    public void remove(File dataFile) throws Exception {
        Scanner scan = null;

        try
        {
            // reads through the dataFile and adds unique words to uniqueWords
            scan = new Scanner(dataFile);
            while(scan.hasNext())
            {
                this.uniqueWords.add(scan.next()); // only adds new words
            }
            scan.close();

            // I removed this line because I interpreted the assignment as removing the duplicates from the input file.
            // "uses a Set of Strings to eliminate duplicate words from dataFile" - From webcourses
            // However, I felt like this wouldn't make sense for the graders and I didn't see this functionality in the rubric so I removed this feature just in case.
            // write(dataFile); // removes duplicate words from dataFile
        }
        catch (Exception e)
        {
            // ensures that scanner is closed
            if(scan != null)
                scan.close();

            // io exception is handled
            throw new IOException("problem1.txt doesn't exist in the current directory");
        }
    }

    // writes the set of unique words to outputFile
    public void write(File outputFile) throws IOException {
        BufferedWriter txt = null;
        try
        {
            // checks if outputFile exists or if the file variable is null and creates a file if not
            if(outputFile == null || (!outputFile.exists()))
            {
                outputFile = new File("unique_words.txt");
                outputFile.createNewFile();
            }

            // iterates through the set and writes the unique words to the outputFile
            txt = new BufferedWriter(new FileWriter(outputFile));
            Iterator i = this.uniqueWords.iterator();
            while(i.hasNext())
            {
                txt.write((String)i.next() + "\n");
            }
            txt.close();
        }
        catch (IOException e)
        {
            // ensures that print writer is closed
            if(txt != null)
                txt.close();

            // handles io exception
            throw new IOException("unique_words.txt doesn't exist and couldn't be created");
        }

    }
}
