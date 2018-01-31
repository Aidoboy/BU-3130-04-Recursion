package recursion;

import java.util.ArrayList;
import java.util.List;

public class Recurssion {

	public static void main(String[] args) {
		List<Integer> randomMultiSet = randomIntegerGenerator(new ArrayList<Integer>(), 5);

		// TODO: Print the list above using your printList method
		
		// TODO: Print the results of running your isSubsetSum method on the above list

	}

	public static List<Integer> randomIntegerGenerator(List<Integer> generate, int length) {
		if (length == 0) {
			return generate;
		}
		boolean isNegative = Math.random() < 0.5;
		generate.add(((int) (Math.random() * 49) + 1) * (isNegative ? -1 : 1));
		return randomIntegerGenerator(generate, length - 1);
	}

	// TODO: Write a static method printList which takes List<Integer> and integer position as
	// parameters and recursively prints all elements on a line separated by space

	// TODO: Write a static method isSubsetSum which checks a list to see if there is a
	// non-empty multiset(set with repeats allowed so basically a list) which sums
	// to zero and returns a boolean without any loops

}
