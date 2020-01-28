/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:]5
- Comment: I do have the correct method definition.
- My method reads the words from the "words.txt" file. [Mark out of 5:]5
- Comment: My method does read the words from the "words.txt" file.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:]5
- Comment: Yes, it returns the contents from "words.txt" in a String array or an ArrayList.

2. readWordList
- I have the correct method definition [Mark out of 5:]5
- Comment: I do have the correct method definition.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:]5
- Comment: My method does read the words provided

3. isUniqueList
- I have the correct method definition [Mark out of 5:]5
- Comment: I do have the correct method definition.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:]5
- Comment: My method does compare each word in the array with the rest of the words in the list.
- Exits the loop when a non-unique word is found. [Mark out of 5:]5
- Comment: It does exit the loop when a non-unique word is found.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:]5
- Comment: It does return true is all the words are unique and false otherwise.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:]5
- Comment: I do have the correct method definition.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:]3
- Comment: My method does use the binarySearch method in Arrays library class.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:]2
- Comment: It does return true if the binarySearch method return a value >= 0, otherwise false is returned.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:]5
- Comment: I do have the correct method definition.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:]10
- Comment: My method does loop through the length of a words comparing characters at the same position in both words searching for one difference.

6. isWordChain
- I have the correct method definition [Mark out of 5:]5
- Comment: I do have the correct method definition.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:]10
- Comment: My method does call isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:]10
- Comment: It does read all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures.
- Asks the user for input and calls isWordChain [Mark out of 5:]5
- Comment: It does ask the user for input and calls isWordChain.

 Total Mark out of 100 (Add all the previous marks):100
*/
import java.util.*;
import java.io.*;
public class WorldLinks {
	public static final int NUMBER_OF_WORDS = 658964;
	public static void main(String[] args) {
		String[] dictionary = readDictionary();
		System.out.print("Enter a comma separated list of words (or an empty list to quit):");
		String[] wordList = readWordList();
		isWordChain (wordList, dictionary);
	}
	public static String [] readDictionary () {
		String[] dictionary = new String[NUMBER_OF_WORDS];
		try {
			BufferedReader bout = new BufferedReader (new FileReader("words.txt"));
			for(int line=1; line<dictionary.length; line++) {
				String newWord = bout.readLine();
				dictionary[line-1] = newWord;
			}
			bout.close();
		}catch (IOException e){
			e.printStackTrace();	
		}
		return dictionary;
	}
	public static String[] readWordList () {
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		String[] wordList = userInput.split(", ");
		input.close();
		return wordList;
	}
	public static boolean isUniqueList (String[] wordList) {
		for (int count = 0; count < wordList.length; count++) {
			for (int index = 0; index < wordList.length; index++) {
				if (wordList[count].equalsIgnoreCase(wordList[index]) && count != index) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isEnglishWord (String[] wordList, String[] dictionary) {
		for (int count=0; count<wordList.length; count++) {
			int index = java.util.Arrays.binarySearch(dictionary, wordList[count]);
			if (index < 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isDifferentByOne (String[] wordList) {
		int check=0;
		for(int count=0; count<wordList.length-1; count++) {
			if (wordList[count].length() == wordList[count+1].length()) {
				int differentLetters = 0;
				for (int index = 0; index < wordList[count].length(); index++) {
					if (wordList[count].charAt(index) != wordList[count+1].charAt(index)) {
						differentLetters++;
					}

				}
				if (differentLetters == 1) {
					check++;
				}
			}
		}
		if (check == wordList.length-1) {
			return true;
		}
		return false;
	}
	public static void isWordChain (String[] wordList, String[] dictionary) {
		if (isUniqueList(wordList) && isDifferentByOne(wordList) && isEnglishWord(dictionary, wordList)) {
				System.out.print("Valid chain of words from Lewis Carroll's word-links game.");
			}else {
					System.out.print("Not a valid chain of words from Lewis Carroll's word-links game.");
			}
	}
}