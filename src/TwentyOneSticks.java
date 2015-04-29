import java.util.Scanner;

/**
 * This is a fun, simple and known game made in a simple console version.
 * 
 * @author lmadeuf
 *
 */
public class TwentyOneSticks {

	final static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Where all the fun starts !
	 * @param args : the arguments passed, although we don't need them here.
	 */
	public static void main(final String[] args){
		System.out.println("TWENTY ONE STICKS GAME !");
		System.out.println("Welcome to the twenty-one sticks game in JAVA.");
		
		if(isPlayerFirst()){
			System.out.println("OK, you will play first.");
			
		}else{
			System.out.println("OK, the computer will play first.");
		}
	}

	private static boolean isPlayerFirst() {
		System.out.println("Do you wish to start first ? (y/n)");
		String userInput = scanner.nextLine();
		while(!"y".equalsIgnoreCase(userInput) && !"n".equalsIgnoreCase(userInput)){
			System.out.println("Wrong input. Expecting one of these : y Y n N");
			System.out.println("Do you wish to start first ? (y/n)");
			userInput = scanner.nextLine();
		}
		return "y".equalsIgnoreCase(userInput);
	}
}
