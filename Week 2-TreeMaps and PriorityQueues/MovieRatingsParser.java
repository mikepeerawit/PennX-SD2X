/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();
		
		if (allUsersRatings == null || allUsersRatings.isEmpty()) 
			return map;
		
		for (UserMovieRating rating : allUsersRatings) {
			if (!(rating == null || 
				  rating.getMovie() == null || rating.getMovie().isEmpty() ||
				  rating.getUserRating() < 0)) {
				String title = rating.getMovie().toLowerCase();
				if (!map.containsKey(title)) { 
					PriorityQueue<Integer> ratings = new PriorityQueue<>();
					ratings.add(rating.getUserRating());
					map.put(title, ratings);
				} else {
					map.get(title).add(rating.getUserRating());
				}
			}
		}		
		
		return map;
	}

}
