import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter Author's name");
		String name = kb.nextLine();
		showBookTitlesByAuthor(name);
		
		System.out.println("Enter the publishing year");
		int year = kb.nextInt();
		showNumberOfBooksInYear(year);
		
		kb.close();
		
	}
	
	public void showBookTitlesByAuthor(String name) {
		System.out.println(logicTier.findBookTitlesByAuthor(name));
	}
	
	public void showNumberOfBooksInYear(int year) {
		System.out.println(logicTier.findNumberOfBooksInYear(year));
	}

}
