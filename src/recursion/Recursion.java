package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

	public static void main(String[] args) {
		List<Integer> randomMultiSet = randomIntegerGenerator(new ArrayList<Integer>(), 5);

		// DONE: Print the list above using your printList method
        printList(randomMultiSet);
		System.out.println();
		
		// DONE: Print the results of running your isSubsetSum method on the above list
		System.out.println(isSubsetSum(randomMultiSet));

		/*(List<Integer> testMultiSet = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, -4));
		printList(testMultiSet);
		System.out.println();
		System.out.println(isSubsetSum(testMultiSet));*/
	}

	public static List<Integer> randomIntegerGenerator(List<Integer> generate, int length) {
		if (length == 0) {
			return generate;
		}
		boolean isNegative = Math.random() < 0.5;
		generate.add(((int) (Math.random() * 49) + 1) * (isNegative ? -1 : 1));
		return randomIntegerGenerator(generate, length - 1);
	}

	// Done: Write a static method printList which takes List<Integer> and integer position as
	// parameters and recursively prints all elements on a line separated by space

    public static void printList(List<Integer> list, int i){
	    if(i == 0){
	        System.out.print("{");
        }else if(i == list.size()){
            System.out.print("}");
        }else{
            System.out.print(", ");
        }
	    if(i < list.size()) {
            System.out.print(list.get(i));
            printList(list, i + 1);
        }
    }
    public static void printList(List<Integer> list){
	    printList(list, 0);
    }

	// Done: Write a static method isSubsetSum which checks a list to see if there is a
	// non-empty multiset(set with repeats allowed so basically a list) which sums
	// to zero and returns a boolean without any loops
	public static boolean isSubsetSum(List<Integer> list){
		return isSubsetSum(list, list.size() - 1, 0, true);
	}

	private static boolean isSubsetSum(List<Integer> list, int index, int sum, boolean empty){
		if(index == -1){
			return !empty && sum == 0;
		}else{
			boolean with = isSubsetSum(list, index-1, sum + list.get(index), false);
			boolean without = isSubsetSum(list, index-1, sum, empty);
			/*if(with){
				System.out.print("[" + list.get(index) + " " + sum + " " + (sum + list.get(index)) + "]");
			}*/
			return  with || without;
		}
	}
}
