/*
 * Class Name:    WordMatchLexicon
 *
 * Author:        Luis Herrera
 * Creation Date: Sunday, March 29 2015, 20:27
 * Last Modified: Sunday, March 29 2015, 19:58
 *
 * Class Description: WordMatch Lexicon Helper Class.
 */

import java.util.*;
import java.io.*;

public class WordMatchLexicon {
    private TreeSet<String> lexicon;

    public WordMatchLexicon() {
        lexicon = new TreeSet<String>();
    }

    public void setLexicon(String word) {
        lexicon.add(word);
    }
    
    public TreeSet<String> getLexicon() {
        return lexicon;
    }
}
