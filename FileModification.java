import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

public class FileModification {
    private LinkedList<String> textWords;
    private LinkedList<String> textLines;
    private Vector<String> wordVec =  new Vector<String>();
    private Vector<String> lineVec = new Vector<String>();


    public FileModification(LinkedList<String> words, LinkedList<String> lines){
        textWords = words;
        erasePunctuation(textWords);
        convertingUpperCaseToLowerCase(textWords);
        removingDuplicate(textWords);
        Collections.sort(textWords); //sorting words alphabetically

        textLines = lines;
        erasePunctuation(textLines);
        convertingUpperCaseToLowerCase(textLines);

        wordInFollowingLines(textWords, textLines);
    }


    /*Removes punctuation from given list
     *@param list is a linked list
     */
    private void erasePunctuation(LinkedList<String> list) {
        String temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                temp = list.get(i).replaceAll("\\p{Punct}","");
                list.set(i, temp);
            }
        }
    }

    /*Replaces uppercase letters with lowercase letters
     *@param list is a linked list
     */
    private void convertingUpperCaseToLowerCase(LinkedList<String> list){
        for(int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toLowerCase());
        }
    }

    /*Removes duplicate elements of the given list
     *@param list is a linked list
     */
    private void removingDuplicate(LinkedList<String> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    /*Finds for each word in which rows/lines it appears
     *@param word is a linked list that contains words
     *@param line is a linked list of the lines to search for words in it
     */
    private void wordInFollowingLines(LinkedList<String> word, LinkedList<String> line){
        System.out.println("word:" + "found in lines:");
        for (int i = 0; i < word.size(); i++){

            System.out.print(word.get(i) + " : ");
            for (int j = 0; j < line.size(); j++){
                boolean found = line.get(j).contains(" " + word.get(i) + " ");
                if (found == true){
                    System.out.print(j+1 + " ");
                }

            }

            System.out.println();
        }

    }




}
