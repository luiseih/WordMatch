/*
 * REPORT
 *
 * Author:        Luis Herrera
 * Creation Date: Tuesday, March 24 2015, 22:52
 * Last Modified: Sunday, March 29 2015, 23:24
 *
 * Algorithms and Data Structures.
 *
 */

DESCRIPTION

The program is composed of two classes:

* WordMatch: Class that does most of the processes and,

* WordMatchLexicon: Class that contains the getter and the setter for the
* treeset that composes the lexicon. I decided to use the TreeSet as data
* structure since, by its very nature, it is designed to be kept itself in a
* lexicological order and with only one copy of the elements (no duplicates),
* therefore reducing times required for further processing and sorting when
* executing any other steps related with the program.

* This class is subject to further expansion such as a filteredLexicon and
* alternate Lexicons, in case it were later decided to save a lexicon, either
* with backup purposes, or with only certain specific words that fulfill the
* final user requirements, for example.

About the Chosen Data Structure

A few sorting algorithms were evaluated for efficiency, ease of use and
maintenance and I decided that the most optimal data structure for the purposes
of this program was the Java TreeSet Data Structure, which has the following
characteristics:

1. No duplicates. The nature of a Java Set is such that it does not allow for
any duplicates and implements into its algorithm the rejection of any.
This was one of the major considerations for choosing it above a classical
List approach, such as ArrayList or LinkedList. 

2. Element sorting. Even though a HashSet is technically faster than a TreeSet
when adding or removing elements, the data is stored in no particular order
and therefore requiring more steps just to have an ordered set.
On the other hand, a TreeSet keeps the data sorted in lexicographic order
naturally since it applies a Red-Black Tree Algorithm, updating the tree
with every change done to it. As a reference, its add and remove methods
have a time complexity of O(log n).

The program works by creating an instance of WordMatchLexicon upon WordMatch
invocation (java WordMatch) and proceeding to execute the mainMenu method, which
is the platform for user interaction. It is important to mention that it is at
this stage (main method) that Java exception handling is implemented.

Besides main method and mainMenu method, there are some additional methods in
the WordMatch class in order to keep modularity of the processes that are
executed by the program. I have also tried to assign self-explanatory names to
variables and the methods themselves so as to keep the program as clear as
possible.

These additional methods are:
a) readTextFile()
	This method is in charge of asking the user for the name of the file to be
	read to populate the lexicon. If the user wants to add additional files to
	the lexicon, s/he can do so by applying this method multiple times. Due to
	the nature of the Red-Black Tree, the Set is updated, sorted
	lexicographically and kept free of duplicates in real time.

b) searchWord()
	As the name implies, this method is in charge of asking the user for a word
	to look for, this method accepts the <?> symbol as a wild-card character.

c) WriteLexiconToFile()
	This method asks the user for a file name to write the current lexicon in
	memory. Even though there are faster methods to just output the data in
	binary. For the purposes of this exercise, we want to be able to see the
	information even when the program is not running and so, the output file is
	written in a plain-text format.

d) getStringOfLettersOnly()
	This is a helper method and it is used to clear every word written to the
	lexicon from any characters that are NOT alphabetic.


TESTS APPLIED

Use Case 1:
Request to add to the lexicon a non-existent file.

Provided a non-existent file name. Program succesfully handled the exception
and fell back to the mainMenu.

Use Case 2:
Request to add to the lexicon a file with words and characters not alphabetical.

Program succesfully filtered numbers, special characters, tabs, newline
characters and any other character that is *not* alphabetical.

Use Case 3:
Request to add to the lexicon a file with duplicated words.

Program succesfully pruned duplicates.

Use Case 4:
Request to add to the lexicon a file with capital letters at random positions in
the words.

Program succesfully replaced upper case letters to lower case letters and
inserted them into the lexicon.

Use Case 5:
Request to search for a word in upper case letters.

Program changed user input to lowercase and succesfully proceeded with a search.

Use Case 6:
Request to search for a word using the special character <?>.

Program successfully detected the symbol and proceeded to search for words that
satisfied the search conditions requested.

Use Case 7:
Request to save lexicon to another file.

Program asked user for name of new file and saved it succesfully in a plain text
file. One word per line.

Use Case 8:
Request to add multiple files to lexicon.

Program succesfully added the files, pruned the lexicon for any duplicate files,
and corrected the input words for any special or upper-case letters.

[Back to README.md](README.md)
