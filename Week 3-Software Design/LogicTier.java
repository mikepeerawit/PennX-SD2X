import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	public Set<String> findBookTitlesByAuthor(String author) {
		
		List<Book> books = dataTier.getAllBooks();
		Set<String> titles = new HashSet<>();
		
		for (Book element : books) {
			if (element.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				titles.add(element.getTitle());
			}
		}
		
		
		return titles;
	}
	
	public int findNumberOfBooksInYear(int year) {
		
		List<Book> books = dataTier.getAllBooks();
		int number = 0;
		
		for (Book element : books) {
			if (element.getPublicationYear() == year) {
				number++;
			}
		}
		
		return number;
	}

}
