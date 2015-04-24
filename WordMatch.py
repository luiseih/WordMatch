#!/usr/pkg/bin/python
# -*- coding: utf-8 -*-

# WordMatch
__author__ = "Luis Herrera (lherrera@sdf.org)"
__version__ = "$Revision: 1.0 $"
__date__ = "$Date: 2015/03/31 18:42:00 $"

'''
This work is licensed under the Creative Commons Attribution-
ShareAlike 4.0 International License. To view a copy of this
license, visit http://creativecommons.org/licenses/by-sa/4.0/.
'''

lexicon = []

def main_menu():
    ''' ***** Main Menu ***** '''
    print "------------------------------------------------------"
    print "Word Match System - Main Menu"
    print "------------------------------------------------------"
    print "R. Read in a text file and add the words in it to the lexicon."
    print "S. Search for a word."
    print "W. Write the lexicon to a new file."
    print "Q. Quit."
    print "------------------------------------------------------"

    main_option = raw_input("Enter your option ( R, S, W, or Q ): ").lower()

    if main_option == "r":
        read_text_file()

    elif main_option == "s":
        search_word()

    elif main_option == "w":
        write_lexicon()

    elif main_option == "q":
        print
        print "Thank you for using the WordMatch system."
        print "Have a nice day."
        print

    else:
        print
        print "Enter a valid value. Try again."
        print
        main_menu()

def alpha_filter(word):
    ''' ** Word filter to remove non alpha characters and
    to lower case word. ** '''
    filtered_word = []
    word = word.lower()
    for letter in word:

        if letter.isalpha():
            filtered_word.append(letter)
        
        else:
            continue
    
    return "".join(filtered_word)

def read_text_file():
    ''' ***** R. Read in a text file and add the words
    in it to the lexicon. ***** '''
    try:
        word_file = raw_input("Please enter the name of the file to read: ")
        with open(word_file, 'r') as f:
            for line in f:
                for word in line.split():
                    word = alpha_filter(word)
                    
                    if lexicon.count(word) == 0 and word != "":
                        lexicon.append(word)
                    
                    else:
                        continue

        lexicon.sort()
        f.close()
        print
        print "Words added to the lexicon."
        print
        main_menu()

    except IOError:
        print
        print "File does not exist. Please try again..."
        print
        main_menu()

def search_word():
    ''' ***** S. Search for a word ***** '''
    search_word = raw_input("Enter the word to search for: ").lower()

    print
    print "Retrieving words..."
    print

    for word in lexicon:
        
        if len(word) == len(search_word):
            for i in range(len(word)):
                
                if word[i] != search_word[i] and search_word[i] != "?":
                    break
                
                elif i == len(word) - 1:
                    print word
                
                else:
                    continue
        
        else:
            continue

    main_menu()

def write_lexicon():
    ''' ***** W. Write the lexicon to a new file ***** '''
    try:
        filename = raw_input("Enter the name of the new lexicon file: ")
        target = open(filename, 'w')
        target.truncate()
        for word in lexicon:
            target.write(word)
            target.write("\n")
        target.close()

        print
        print "File has been saved."
        print
        main_menu()
    
    except IOError:
        print
        print "There was an error writing the file to disk."
        print "Please try again."
        print
        main_menu()

main_menu()
