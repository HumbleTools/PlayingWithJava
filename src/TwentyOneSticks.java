import java.util.Scanner;

/**
 * This is a fun, simple and known game made in a simple console version.
 * 
 * @author lmadeuf
 *
 */
public class TwentyOneSticks {

	private static final String RULE_3 = "Rule 3 : If you take the last stick, you loose !";
	private static final String RULE_2 = "Rule 2 : You can take one, two or three sticks at each turn.";
	private static final String RULE_1 = "Rule 1 : There are 21 sticks.";
	private static final String WELCOME_PHRASE = "Welcome to the twenty-one sticks game in JAVA.";
	private static final String GAME_TITLE = "TWENTY ONE STICKS GAME !";
	private static final String WRONG_INPUT_Y_N = "Wrong input. Expecting one of these : y Y n N";
	private static final String START_QUESTION_Y_N = "Do you wish to start first ? (y/n)";
	
	final static Scanner scanner = new Scanner(System.in);
	static int stickCount = 21;
	
	/**
	 * Where all the fun starts !
	 * @param args : the arguments passed, although we don't need them here.
	 */
	public static void main(final String[] args){
		System.out.println(GAME_TITLE);
		System.out.println(WELCOME_PHRASE);
		printRules();
		if(isPlayerFirst()){
			System.out.println("OK, you will play first.");
			System.out.println();
			runGame(true);
		}else{
			System.out.println("OK, the computer will play first.");
			System.out.println();
			runGame(false);
		}
	}

	/**
	 * Prints the rules of the games.
	 */
	private static void printRules() {
		System.out.println(RULE_1);
		System.out.println(RULE_2);
		System.out.println(RULE_3);
		System.out.println();
	}

	/**
	 * Asks the player if he wants to start. It will continue to ask the question if 
	 * the response is different from one of these : y Y n N.
	 * @return boolean true id the player will start the game, false otherwise.
	 */
	private static boolean isPlayerFirst() {
		System.out.println(START_QUESTION_Y_N);
		String userInput = scanner.nextLine();
		while(!"y".equalsIgnoreCase(userInput) && !"n".equalsIgnoreCase(userInput)){
			System.out.println(WRONG_INPUT_Y_N);
			System.out.println(START_QUESTION_Y_N);
			userInput = scanner.nextLine();
		}
		return "y".equalsIgnoreCase(userInput);
	}
	
	/**
	 * Runs the game until the end. When there are 0 sticks or less, the game ends.
	 */
	private static void runGame(final boolean isPlayerFirst) {
		while(stickCount>0){
			if(isPlayerFirst){
				
			}else{
				
			}
		}
	}
	
}
