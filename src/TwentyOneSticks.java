import java.util.Scanner;

/**
 * This is a fun, simple and known game made in a simple console version.
 * 
 * @author lmadeuf
 *
 */
public class TwentyOneSticks {

	private static final String STICK = " |";
	private static final String COMPUTER_FIRST = "OK, the computer will play first.";
	private static final String PLAYER_FIRST = "OK, you will play first.";
	private static final String PLAYER_WON = "The computer removed the last stick. You won ! :)";
	private static final String PLAYER_LOST = "You removed the last stick. You lost ! :(";
	private static final String THE_COMPUTER_REMOVED_X_STICKS = "The computer removed %s stick(s).";
	private static final String YOU_REMOVED_X_STICKS = "You removed %s stick(s).";
	private static final String WRONG_INPUT_EXPECTING_1_2_OR_3 = "Wrong input. Expecting 1, 2 or 3.";
	private static final String ASK_ONE_TWO_OR_THREE_STICKS = "Do you want to remove one, two or three sticks ? (1/2/3)";
	private static final String THERE_ARE_X_STICKS_LEFT = "There are %s sticks left :";
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
			System.out.println(PLAYER_FIRST);
			runGameTurns(true);
		}else{
			System.out.println(COMPUTER_FIRST);
			runGameTurns(false);
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
		String userInput = scanner.nextLine().trim();
		while(!"y".equalsIgnoreCase(userInput) && !"n".equalsIgnoreCase(userInput)){
			System.out.println(WRONG_INPUT_Y_N);
			System.out.println(START_QUESTION_Y_N);
			userInput = scanner.nextLine();
		}
		return "y".equalsIgnoreCase(userInput);
	}
	
	/**
	 * Runs the game turns until the end. When there are 0 sticks or less, the game ends.
	 */
	private static void runGameTurns(final boolean isPlayerFirst) {
		boolean isPlayersTurn = isPlayerFirst;
		boolean hasGameEnded = false;
		while(!hasGameEnded){
			drawSticks();
			removeSticks(isPlayersTurn);
			hasGameEnded = hasGameEnded(isPlayersTurn);
			isPlayersTurn = !isPlayersTurn;
		}
	}

	/**
	 * Determines if the game has ended. If it has, it outputs the results.
	 */
	private static boolean hasGameEnded(final boolean isPlayersTurn) {
		boolean hasGameEnded = false;
		if(stickCount <= 0){
			hasGameEnded = true;
			if(isPlayersTurn){
				System.out.println(PLAYER_LOST);
			}else{
				System.out.println(PLAYER_WON);
			}
		}
		return hasGameEnded;
	}

	/**
	 * Removes a number of sticks equal to sticksToRemove and tells who removed them.
	 * @param sticksToRemove : the number of sticks to remove.
	 * @param isPlayersTurn : determines the author of the removal.
	 */
	private static void removeSticks(boolean isPlayersTurn) {
		int sticksToRemove;
		if(isPlayersTurn){
			sticksToRemove = askForSticksToRemove();
			stickCount -= sticksToRemove;
			System.out.println(String.format(YOU_REMOVED_X_STICKS, sticksToRemove));
		}else{
			sticksToRemove = determineNumberOfSticksToRemove();
			stickCount -= sticksToRemove;
			System.out.println(String.format(THE_COMPUTER_REMOVED_X_STICKS, sticksToRemove));
		}
	}

	/**
	 * Determines the number of sticks the computer should remove.
	 * @return int the number of sticks the computer will remove.
	 */
	private static int determineNumberOfSticksToRemove() {
		int sticksToRemove;
		System.out.println();
		int mod5Result = stickCount % 5;
		if(mod5Result==1 || mod5Result==2 || mod5Result==3){
			sticksToRemove = mod5Result;
		}else{
			sticksToRemove = 1;
		}
		return sticksToRemove;
	}

	/**
	 * Asks the player to enter a valid number of sticks : 1, 2 or 3.
	 * @return int returns the first correctly entered number.
	 */
	private static int askForSticksToRemove() {
		System.out.println();
		System.out.println(ASK_ONE_TWO_OR_THREE_STICKS);
		String userInput = scanner.nextLine().trim();
		while(!"1".equals(userInput) && !"2".equals(userInput) && !"3".equals(userInput)){
			System.out.println(WRONG_INPUT_EXPECTING_1_2_OR_3);
			System.out.println(ASK_ONE_TWO_OR_THREE_STICKS);
			userInput = scanner.nextLine().trim();
		}
		int sticksToRemove = Integer.parseInt(userInput);
		if(sticksToRemove > stickCount){
			sticksToRemove = stickCount;
		}
		return sticksToRemove;
	}

	/**
	 * Draws the remaning sticks in the standard output.
	 */
	private static void drawSticks() {
		System.out.println();
		System.out.println(String.format(THERE_ARE_X_STICKS_LEFT, stickCount));
		for(int i=1; i<=stickCount; i++){
			System.out.print(STICK);
		}
	}
	
}
