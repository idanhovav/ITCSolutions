import java.lang.ArrayIndexOutOfBoundsException;
import java.util.HashSet;
import java.util.Set;

public class Question1 {
	public static void main(String[] args) {
		if (args.length < 2) {
			printUsageInfo();
			System.exit(0);
		}
		printArgs(args);
		String str = "";
		String set = "";

		try {
			str = args[0];
			set = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			handleIndexError(e);
		}

		int firstIndex = getFirstIndex(str, set);
		printIndex(firstIndex);
	}

	// time complexity of O(m + n)
	public static int getFirstIndex(String str, String set) {
		Set<Character> setSet = stringToSet(set); // time complexity O(n)
		for (int index = 0; index < str.length(); index++) {
			if (setSet.contains(str.charAt(index))) { // contains on HashSet & charAt on String are O(1)
				return index;
			}
		} // loop's overall time complexity is O(m * 1) = O(m)
		return 0; // if index not found or empty String.
	}

	private static HashSet<Character> stringToSet(String str) {
		HashSet<Character> set = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			set.add(c);
		}
		return set;
	}

	private static void printUsageInfo() {
		System.out.println("Hello! An input or two seem to be missing.");
		System.out.println("Please input the 'str' string and 'set' string as inputs to the program in that order.");
	}
	private static void printArgs(String[] args) {
		try {
			System.out.format("For 'str', the input is %s\n", args[0]);
			System.out.format("For 'set', the input is %s\n", args[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			handleIndexError(e);
		}
		
	}
	private static void handleIndexError(ArrayIndexOutOfBoundsException e) {
		System.out.println("There seems to be an input missing. Please try again.");
		System.exit(0);
	}

	private static void printIndex(int index) {
		System.out.format("The index found is %d\n", index);
	}
}