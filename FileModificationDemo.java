import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileModificationDemo {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LinkedList<String> words = new LinkedList<>();
        LinkedList<String> lines = new LinkedList<>();

        try {

            Scanner text = new Scanner(new File("document.txt"));
            Scanner myText = new Scanner(new File("document.txt"));

            while (text.hasNext()) {
                words.add(text.next());
            }

            while (myText.hasNextLine()) {
                lines.add(" " + myText.nextLine() + " ");
            }

            FileModification file1 = new FileModification(words, lines); //creating an object of FileModification class

        } catch (IOException e) {

            System.out.println("Error accessing input file!");

        }

    }




}
