import java.io.File;

public class Application
{
    public static void main(String[] args)
    {
        // creates the file variables
        File inputFile = new File("problem2.txt");
        File outputFile = new File("unique_word_counts.txt");

        // creates the DuplicateCounter object
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        try
        {
            duplicateCounter.count(inputFile); // counts the strings in inputFile
            duplicateCounter.write(outputFile); // prints the strings and the frequencies to outputFile
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
