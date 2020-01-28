/* SELF ASSESSMENT
1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5: 5
       Comment: I used easy-to-understand meaningful variable names formatted properly.
2. Did I indent the code appropriately?
       Mark out of 5: 5
       Comment: I indented the code appropriately.
3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20: 20
      Comment: I wrote the createCipher function correctly (parameters, return type and function body) and invoked it correctly.
4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20: 20
      Comment: I wrote the encrypt function correctly (parameters, return type and function body) and invoked it correctly.
5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20: 20
      Comment: I wrote the decrypt function correctly (parameters, return type and function body) and invoked it correctly.
6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
      Mark out of 25: 25
      Comment: I wrote the main function body correctly.
7. How well did I complete this self-assessment?
       Mark out of 5: 5
      Comment: I completed this self-assessment to the best of my ability.
Total Mark out of 100 (Add all the previous marks): 100
*/ 
import java.util.Random;
import java.util.Scanner;
public class Cipher {
	public static void main(String[] args)
	{
		boolean finished = false;
		Scanner scanner = new Scanner(System.in);
		while (finished == false)
		{
			System.out.print("Enter the plain text phrase you want to encrypt (or type 'exit' to exit):");
			if (scanner.hasNext("exit") || scanner.hasNext("'exit'"))
			{
				finished = true;
				System.out.print("Goodbye.");
			}
			else
			{
				String input = scanner.nextLine();
				String userInput = input.toLowerCase();
				char[] cipherPhrase = userInput.toCharArray();
				char[] cipherAlphabet = new char[27];
				char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
						'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };
				createCipher(cipherAlphabet, alphabet);
				encrypt(cipherPhrase, cipherAlphabet, alphabet);
				String encryptedString = new String(cipherPhrase);
				System.out.print("The encrypted phrase is: " + encryptedString);
				decrypt(cipherPhrase, cipherAlphabet, alphabet);
				String decryptedString = new String(cipherPhrase);
				System.out.println("\nThe decrypted phrase is: " + decryptedString);
			}
		}
		scanner.close();
	}
	public static void createCipher(char[] cipherAlphabet, char[] alphabet)
	{
		for (int count = 0; count < cipherAlphabet.length; count++)
		{
			Random generator = new Random();
			int number = generator.nextInt(27);
			cipherAlphabet[count]=alphabet[number];
			for (int index = 0; index < count; index++)
			{
				if (cipherAlphabet[count] == cipherAlphabet[index])
				{
					count--;
					index = count;
				}
			}
		}
	}
	public static void encrypt(char[] cipherPhrase, char[] cipherAlphabet, char[] alphabet)
	{
		for (int count = 0; count < cipherPhrase.length; count++)
		{
			boolean finished = false;
			for (int index = 0; index < alphabet.length && finished==false; index++)
			{
				if(cipherPhrase[count] == alphabet[index])
				{
					cipherPhrase[count] = cipherAlphabet[index];
					finished = true;
				}
			}
		}
	}
	public static void decrypt(char[] cipherPhrase, char[] createdCipher, char[] alphabet)
	{
		for (int count = 0; count < cipherPhrase.length; count++)
		{
			boolean finished = false;
			for (int index = 0; index < createdCipher.length && finished == false; index++)
			{
				if (cipherPhrase[count] == createdCipher[index])
				{
					cipherPhrase[count] = alphabet[index];
					finished = true;
				}
			}
		}
	}
}