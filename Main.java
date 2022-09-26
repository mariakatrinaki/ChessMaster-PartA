import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		

		 printInput();
		 
		 
		 
		 
	}

	public static void printInput() {
		int input = 0;
		String word = null;
		Scanner sc = new Scanner(System.in);
		System.out.format("%50s", "CHESSMASTER");
		do {
		System.out.println();
		System.out.println();
		System.out.format("%50s","Choose Menu");
		System.out.println("\nPress 1 ChessMaster 2D from Up to Down: ");
		System.out.println("Press 2 ChessMaster 2D shuffle: ");
		System.out.println("Press 3 ChessMaster with no array, shuffle: ");
		System.out.println("Press 4 ChessMaster with no array, from Down to Up: ");
		System.out.println("Press 5 type a word: ");
		System.out.println("Press 6 EXIT");
		 while (!sc.hasNextInt() ) {
		      System.out.println("Input is not a number.Type again");
		      sc.nextLine();
		    }
		input = sc.nextInt();
		 if(input>6 ) {
			 while(input>6) {
			 System.out.println("Not valid. Press a number from the menu");
			 input= sc.nextInt();
			 }
		 }
		
		switch (input) {
		case 1:

			chessMaster2dUpToDown("CHESSMASTER");
			break;
		case 2:

			chessMaster2dShuffle("CHESSMASTER");
			break;

		case 3:
			
			chessMasterShuffle("CHESSMASTER");
			break;
			
		case 4:
			
			chessMasterDownToUp("CHESSMASTER");
			break;
			
		case 5:
			
			do {

				System.out.println("Give a word");
				word = sc.next();
				if ((!word.matches("[A-Za-z]+")) || (word.length() <= 4)) {
					System.out.println("Not valid");
				}
			} while ((!word.matches("[A-Za-z]+")) || (word.length() <= 4));
            System.out.println("Choose from chessMaster what you want to do ");
            System.out.println("Press 1 ChessMaster 2D from Up to Down ");
    		System.out.println("Press 2 ChessMaster 2D shuffle");
    		System.out.println("Press 3 ChessMaster with no array, shuffle ");
    		System.out.println("Press 4 ChessMaster with no array, from Down to Up");
    		System.out.println("Press 5 EXIT");
    		Scanner scanner = new Scanner(System.in);
    		while (!scanner.hasNextInt()) {
  		      System.out.println("Input is not a number.Type again");
  		      scanner.nextLine();
  		    }
             input=scanner.nextInt();
             if(input>5 ) {
    			 while(input>5) {
    			 System.out.println("Not valid. Press a number from the menu");
    			 input= sc.nextInt();
    			 }
    		 }
             switch(input) {
		case 1:
			chessMaster2dUpToDown(word);
			break;
		case 2:    
			chessMaster2dShuffle(word);
			break;
		case 3:	
			chessMasterShuffle(word);
			break;
		case 4:	
			chessMasterDownToUp(word);
			break;
		case 5:
			break;
             }
			
		  break;
		  
		case 6:
			
			break;
		  
		}}while(input!=6 && input!=5);
        
	}

	public static void chessMasterDownToUp(String word) {
		int numberCounter = word.length();
		int counterLine = 0;
		int counter = 0;
		char character = ' ';
		int position = 0;
		Random r = new Random();
		int a = word.length() - 1;

		System.out.println();
		for (int i = 0; i < word.length(); i++) {
			System.out.print(numberCounter + "\t" + "| ");
			counterLine = r.nextInt(word.length());
			counter++;
			for (int j = 0; j < word.length(); j++) {
				do {
					counterLine = r.nextInt(word.length());
				} while (counterLine == i && counterLine > j);

				if (i == j) {

					System.out.print("X");

				} else if (i != j && counter > 0 && counterLine <= j) {
					character = word.charAt(a);
					System.out.print(String.valueOf(word.charAt(a)));
					position = j;
					counter = 0;
					a--;
				} else {

					System.out.print(" ");
				}

				System.out.print("  |  ");
			}
			char characterPosition=  printCharacter(word,  position);
			System.out.print(character + ": " + "( " + characterPosition + " , " + numberCounter + " )");
			System.out.println();
			numberCounter -= 1;
			printLine(word);
			System.out.println();

		}
		System.out.println();
		printCharacter(word);

	}

	public static void chessMasterShuffle(String word) {

		char a = 'X';
		int counter = 0;
		int numberCounter = word.length();
		int position = 0;
		Random r = new Random();
		int counterLine = 0;
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		char character = ' ';
		int index = 0;

		System.out.println();
		for (int i = 0; i < word.length(); i++) {

			System.out.print(numberCounter + "\t" + "| ");
			counterLine = r.nextInt(word.length());

			index = r.nextInt(word.length());

			if (arraylist.contains(index)) {
				while (arraylist.contains(index)) {
					index = r.nextInt(word.length());
				}
				if (!arraylist.contains(index)) {
					arraylist.add(index);
				}
			} else if (!arraylist.contains(index)) {
				arraylist.add(index);
			}

			counter++;
			for (int j = 0; j < word.length(); j++) {
				do {
					counterLine = r.nextInt(word.length());
				} while (counterLine > j && counterLine == i);

				if (i == j) {

					System.out.print(a);

				} else if (i != j && counter > 0 && counterLine <= j) {
					position = j;
					character = word.charAt(arraylist.get(i));
					System.out.print(String.valueOf(word.charAt(arraylist.get(i))));
					counter = 0;

				} else {
					System.out.print(" ");
				}

				System.out.print("  |  ");
			}
			char characterPosition=  printCharacter(word,  position);
			System.out.print(character + ": " + "( " + characterPosition + " , " + numberCounter + " )");
			System.out.println();
			numberCounter -= 1;
			printLine(word);
			System.out.println();

		}
		System.out.println();
		printCharacter(word);

	}

	public static void chessMaster2dUpToDown(String word) {
		String[][] array = new String[word.length()][word.length()];
		int count = array.length;
		Random rand = new Random();
		int randInt = 0;

		System.out.println();
		for (int i = 0; i < array.length; i++) {
			System.out.print(count + "\t" + "| ");

			randInt = rand.nextInt(array.length);

			for (int j = 0; j < array[i].length; j++) {
				if (i == j) {

					array[i][j] = "X";

				} else if (i != j) {
					if (array[i][j] == null) {
						array[i][j] = " ";

						if (i != randInt) {
							array[i][randInt] = String.valueOf(word.charAt(i));

						} else if (i == randInt) {
							do {
								randInt = rand.nextInt(array.length);
								array[i][randInt] = String.valueOf(word.charAt(i));

							} while (i == randInt);

						}

					}

				}

				System.out.print(array[i][j] + "  |  ");

			}
			char character=  printCharacter(word,  randInt);
			System.out.print(word.charAt(i) + ": " + "( " + character + " , " + count + " )");
			count -= 1;
			System.out.println();

			printLine(word);
			System.out.println();

		}
		System.out.println();
		printCharacter(word);
	}

	public static void chessMaster2dShuffle(String word) {
		String[][] array = new String[word.length()][word.length()];
		int count = word.length();
		Random r = new Random();
		int position = 0;

		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		System.out.println();
		for (int i = 0; i < array.length; i++) {
			System.out.print(count + "\t" + "| ");
			position = r.nextInt(word.length());
			// positionLetter = r.nextInt(word.length());
			if (arraylist.contains(position)) {
				while (arraylist.contains(position)) {
					position = r.nextInt(word.length());
				}

				arraylist.add(position);
			} else {
				arraylist.add(position);
			}

			for (int j = 0; j < array[i].length; j++) {
				if (i == j) {
					array[i][j] = "X";

				} else {
					array[i][j] = " ";
					if (i != position) {

						array[i][position] = String.valueOf(word.charAt(arraylist.get(i)));

					} else if (i == position) {
						do {
							position = r.nextInt(word.length());
						} while (i == position);

						array[i][position] = String.valueOf(word.charAt(arraylist.get(i)));
					}

				}

				System.out.print(array[i][j] + "  |  ");
			}
			char character=  printCharacter(word,  position);
			System.out.print(array[i][position] + ": " + "( " + character + " , " + count + " )");
			count -= 1;
			System.out.println();

			printLine(word);
			System.out.println();
		}
		System.out.println();
		printCharacter(word);

	}

	public static void printLine(String word) {

		System.out.print("\t");
		for (int i = 0; i < (word.length() * 6); i++) {

			System.out.print("-");
		}

	}
	
	public static char printCharacter(String word, int position) {
		char arrayChar[] = new char[word.length()];
		char character = 'A';
		char returnCharacter =' ';
	//	System.out.print("\t  ");
		for (int i = 0; i < arrayChar.length; i++) {

			arrayChar[i] = character;
			character++;
	//		System.out.print(arrayChar[i] + "     ");

		}
		return arrayChar[position];
	}

	public static void printCharacter(String word) {
		char arrayChar[] = new char[word.length()];
		char character = 'A';
		System.out.print("\t  ");
		for (int i = 0; i < arrayChar.length; i++) {

			arrayChar[i] = character;
			character++;
			System.out.print(arrayChar[i] + "     ");

		}
        
	}

}
