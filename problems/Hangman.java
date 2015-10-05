package problems;

import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Hangman {
	public static void main(String[] args) throws Exception {
		ArrayList<String> wordList = new ArrayList<String>();
		JFileChooser jFileChooser = new JFileChooser();
		if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			java.io.File file = jFileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
			
			while(input.hasNext()) {
				String word = input.next();
				wordList.add(word);
			}
			
			input.close();
			
			String[] wordArray = wordList.toArray(new String[wordList.size()]);
			
			boolean continueGame = true;
			
			while(continueGame) {
				int index = (int)(Math.random()*wordArray.length);
				String actualWord = wordArray[index];
				Scanner guess = new Scanner(System.in);
				StringBuilder word = new StringBuilder();
				for(int i = 0; i < actualWord.length(); i++) {
					word.append('*');
				}
				int leftToGuess = word.length();
				int missesCount = 0;
				
				while(leftToGuess > 0) {
					boolean guessed = false;
					boolean alreadyInWord = false;
					System.out.printf("(Guess) Enter a letter in word %s > ", word);
					String guessChar = guess.next();
					char convertedChar = guessChar.charAt(0);
					for(int i = 0; i < actualWord.length(); i++) {
						if(convertedChar == actualWord.charAt(i)) {
							if(word.charAt(i) == actualWord.charAt(i)) {
								System.out.printf("%c is already in the word\n", convertedChar);
								alreadyInWord = true;
							}
							else{
								word.setCharAt(i, convertedChar);
								guessed = true;
								leftToGuess--;
							}
							
						}
						
					}
					if(!guessed && !alreadyInWord) {
						System.out.println("Boo! You missed!");
						missesCount++;
					}
					
				}
				if(missesCount == 0) {
					System.out.printf("The word is %s. You rock!\n", actualWord);
				}
				else{
					System.out.printf("The word is %s. You missed %d times.\n", actualWord, missesCount);
				}
				
				System.out.print("Do you want to guess for another word? Enter"
						+ " Y or N> ");
				String answer = guess.next();
				if(answer.equals(new String("N"))) {
					continueGame = false;
				}
				
			}
			
			
			
			
		}
		else{
			System.out.println("No file selected");
		}
	}
	
}
  
