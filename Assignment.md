** Assignment Objectives **

	* To understand various data structures and searching and sorting
	techniques;

	* To analyse these techniques in relation to a particular problem;

	* To implement these techniques within a Java program.

** Problem Description **

In many situations, we may need to find a word based on one or more letters in
it. For example, when making or completing a crossword you may want to find a
word that has 4 letters, starts with J and ends with A. In this assignment, the
program you will write will create a lexicon of words from various sources (that
is, from various text files) and will allow the user to search for words that
fit particular patterns.

** Assignment Requirements **

Write a Java program called <WordMatch.java>. This program provides a menu with
the following options:

	r)	Read in a text file and add the words in it to the lexicon
	
	s)	Search for a word
	
	w)	Write the lexicon to a new file
	
	q)	Quit

The menus must accept the letters 'r', 's', 'w', or 'q' and be case insensitive.

** Option r - Building the Lexicon

When the program starts the lexicon is empty. When the user selects option 'r'
from the menu, the program should prompt them for the name of a text file to
open. If there is any error in reading the file, the program must warn the user
and return to the menu. Otherwise, each word of the file is read and added to
the lexicon. Words will be treated in a case-insensitive manner and punctuation
must be removed.

	* While the word "and" occurs twice in the file, it is only stored once in
	the lexicon.

	* While the word "you" also occurs as "YOU", only one version is stored.

	* Punctuation such as commas, quotes, full stops and question marks are
	removed.

	* If the word "don't" or the word "second-hand" had appeared, they would be
	stored without punctuation - "dont" and "secondhand" respectively.

	* The word "1" (one) will be ignored as it contains numeric characters.

By selecting this option, the user can choose to read from one or more files and
all their words are added to the lexicon.

** Option r - Finding Matching Words

When the user selects option 's', the program will ask for a pattern to be
entered from the keyboard and display on the screen the list of words that match
the pattern - one word on each line and in sorted order.

A pattern consists of a sequence of letters, with no spaces within the sequence.
In addition, a pattern can contain zero or more occurences of the wild-card
character '?', which can match with an occurence of any letter.

For each pattern, the pattern and the words that match the pattern are to be
displayed on the screen - one matching word on each line and in sorted order.

For example, the pattern:

	ma?

may result in the words below being displayed to the screen (depending on the
lexicon at hand)

	man

	may

The pattern:

	?o?

may result in the following words being displayed

	for

	not

	you

Note the words are displayed in lexicographic order.

Any pattern that has no matches will result in the message "No words in the
lexicon matched your input" output to the screen.

** Option w - Saving the Lexicon

When the user selects option 'w', the program will ask for the name of the
output file to be entered from the keyboard, and write the words in the lexicon
to that file, one word on each line in sorted order.

** Correctness and Efficiency Consideration

The correctness and efficiency with the program performs various operations are
the major concerns.

The files read in can be quite long and the lexicon of words can grow to be
quite lengthy. Time to insert the words will be critical here and you will need
to carefully consider which algorithms and data structures you use.

You can use any text files for input to this program. A good source of long text
files is at the Gutenberg project (www.gutenberg.com) which is a project aimed
to put into electronic form older literary works that are in the public domain.

You should choose files of lengths suitable for providing good information about
the efficiency of your program. In other words, make sure that you test your
program on large text files and report the result as part of Task 2.

** It is critical to note that for each particular search, only words of a
certain length can match the pattern. Failure to exploit the fact will result in
a substantial reduction of your mark. **

** Other Concerns **

Though correctness is the major considerations, code style, modularity and
documentation are also important. Choose your identifies (variable names, etc.)
carefully. Include appropriate comments to explain your programs. This program
will be marked on correctness, style, and the match patterns included for the
testing.

[Back to README](README.md) 
