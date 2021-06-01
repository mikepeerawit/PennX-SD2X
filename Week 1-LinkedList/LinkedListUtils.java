import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		
		if (list != null) {
			int index;
			for (index = 0; index < list.size(); index++) {
				if (list.get(index) >= value) break;
			}
			list.add(index, value);
		}

	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		
		if (list != null && !list.isEmpty() && N >= 0) {
			if (list.size() <= N) {
				list.removeAll(list);
				return;
			}
			for (int i = 0; i < N; i++) {
				LinkedList<String> sortedList = new LinkedList<>(list);
				Collections.sort(sortedList, Collections.reverseOrder());
				list.removeAll(Arrays.asList(sortedList.get(0)));
			}

		}

	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		if (one == null || two == null || one.isEmpty() || two.isEmpty()) return false;
		int start = one.indexOf(two.getFirst());
		if (start < 0) return false;
		for (int i = 0; i < two.size(); i++) {
			if (start + i >= one.size()) return false;
			if (!(one.get(start + i).equals(two.get(i)))) {
				return false;
			}
		}
		return true;
	}
}
