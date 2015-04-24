/*
 * Class Name:    WordMatch
 *
 * Author:        Luis Herrera
 * Creation Date: Sunday, March 29 2015, 09:52
 * Last Modified: Sunday, March 29 2015, 20:24
 *
 * Class Description: Word Match System.
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License.
 * For more information, visit http://creativecommons.org/
 *
 */

import java.util.*;
import java.io.*;

public class WordMatch {
    public static void main(String [] args) throws IOException {
        WordMatchLexicon wml = new WordMatchLexicon();

        mainMenu(wml);
    }

    // ***** Main Menu *****
    public static void mainMenu(WordMatchLexicon wml) {
        System.out.println("------------------------------------------------------");
        System.out.println("Word Match System - Main Menu");
        System.out.println("------------------------------------------------------");
        System.out.println("R. Read in a text file and add the words in it to the lexicon.");
        System.out.println("S. Search for a word.");
        System.out.println("W. Write the lexicon to a new file.");
        System.out.println("Q. Quit.");
        System.out.println("------------------------------------------------------");
        System.out.print("Enter your option ( R, S, W, or Q ): ");

        Scanner keyboard = new Scanner(System.in);
        String mainOption = keyboard.next().toLowerCase();
        keyboard.nextLine();

        switch (mainOption) {
        case "r":
            readTextFile(wml);
            break;
        case "s":
            searchWord(wml);
            break;
        case "w":
            writeLexiconToFile(wml);
            break;
        case "q":
            System.out.println("Thank you for using the WordMatch system.");
            System.out.println("Have a nice day.");
            break;
        default:
            System.out.println("Enter a valid value. Try again.");
            mainMenu(wml);
            break;
        }
    }

    // ***** R. Read in a text file and add the words in it to the lexicon. *****
	public static void readTextFile(WordMatchLexicon wml) {
	    System.out.println("Please enter the name of the file to read: ");
   		try {
			Scanner keyboard = new Scanner(System.in);
			String wordFile = keyboard.nextLine();
           	Scanner in = new Scanner(new File(wordFile));
           	
           	System.out.println("Retrieving words...");
           	while (in.hasNext()) {

               	String word = in.next();
               	word = word.toLowerCase();
                word = getStringOfLettersOnly(word);
                if (word.length() > 0 )
                {
               	    wml.setLexicon(word);
               	}
            }
            
           	in.close();
           	System.out.println();
           	System.out.println("Words added to the lexicon.");
            System.out.println();
        }
        catch (IOException e) {
            System.out.println();
            System.out.println("File does not exist. Please try again.");
            System.out.println();
        }
        mainMenu(wml);
	}

    // ***** S. Search for a word *****
    public static void searchWord(WordMatchLexicon wml) {
        System.out.print("Enter the word to search for: ");

		Scanner keyboard = new Scanner(System.in);
		String searchWord = keyboard.nextLine();
		searchWord = searchWord.toLowerCase();

        System.out.println();
       	System.out.println("Retrieving words...");
        System.out.println();

       	Iterator<String> iterator = wml.getLexicon().iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            
            if (word.length() == searchWord.length()) {
                for(int i = 0; i < searchWord.length(); i++) {
                    if ((word.charAt(i) != searchWord.charAt(i)) &&
                        (searchWord.charAt(i) != '?')) {
                        break;
                    } else if (i == (searchWord.length()-1)) {
                            System.out.println(word);
                    }
                }
            }
        }
        System.out.println();
        mainMenu(wml);
    }

    // ***** W. Write the lexicon to a new file Menu *****
    public static void writeLexiconToFile(WordMatchLexicon wml) {
        System.out.println("Enter the name of the new lexicon file: ");
        try {
			Scanner keyboard = new Scanner(System.in);
			String fileName = keyboard.nextLine();
			
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			
			Iterator<String> iterator = wml.getLexicon().iterator();
            while (iterator.hasNext()) {
                String setElement = iterator.next();
                pw.println(setElement);
            }
			pw.close();
			System.out.println();
			System.out.println("File has been saved.");
			System.out.println();
       	}
       	catch (IOException e) {
       	    System.out.println();
       		System.out.println("There was an error writing the file to disk. Please try again.");
       	    System.out.println();
       	}
        mainMenu(wml);
    }
    
    // To alpha helper
    public static String getStringOfLettersOnly(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
