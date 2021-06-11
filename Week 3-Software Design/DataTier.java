import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks() {
		List<Book> book = new ArrayList<>();
		List<String> lines = null;
		
		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String line : lines) {
			String[] elements = line.split("\t");
			book.add(new Book(elements[0], elements[1], Integer.parseInt(elements[2])));	
		}
		
		return book;
	}

}
