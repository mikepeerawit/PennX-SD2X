import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> myStack = new Stack<>();
		
		for (HtmlTag tag : tags) {
			if (tag.isOpenTag()) {
				myStack.push(tag);
			}else {
				if (!tag.isSelfClosing()) {
					if (myStack.isEmpty()) {
						return null;
					}
					
					if (tag.matches(myStack.peek())) {
						myStack.pop();
					}else {
						return myStack;
					}
				}
			}
			
		}
		return myStack;
		
	}
	

}

