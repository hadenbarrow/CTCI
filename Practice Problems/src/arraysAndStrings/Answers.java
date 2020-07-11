package arraysAndStrings;

import java.util.HashSet;

public class Answers {
	
	//1.3 Design an algorithm and write code to remove duplicate characters in a string without using any additional buffer.
	//One or two additional variables are fine. An extra copy of the array is not.
	
	public String removeDuplicateCharacters(String input) {
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(i != j && input.charAt(i) == input.charAt(j)) {
					input = input.substring(i, j) + input.substring(j+1);
				}
			}
		}
		return input;
	}
	
	//1.2 - Write code to reverse a C-style String.
	public String reverseString(String input) {
		StringBuilder sb = new StringBuilder();
		for(int i = input.length()-2; i >= 0; i--) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	
	//1.1 a - Implement an algorithm to determine if a string has all unique characters.
	public boolean hasDupeChars(String input) {
		HashSet<Character> seen = new HashSet<Character>();
		for(int i = 0; i < input.length(); i++) {
			if(seen.contains(input.charAt(i))) {
				return true;
			}
			seen.add(input.charAt(i));
			
		}
		return false;
	}
	
	//1.1 b - What if you can't use an additional data structure?
	public boolean hasDupeChars2(String input) {
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(i) == input.charAt(j) && i != j) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Answers answers = new Answers();
		
		
		String noDuplicates = "no dupes"; //false
		String hasDuplicates = "has dupess"; //true
		String edgeCase1 = ""; //false
		String edgeCase2 = "1"; //false
		String edgeCase3 = "1122"; //true
		String cStyle = "This is a normal string&";
		
		/*
		 * //1.1a tests System.out.println("---1.1a tests---");
		 * System.out.println(answers.hasDupeChars(noDuplicates));
		 * System.out.println(answers.hasDupeChars(hasDuplicates));
		 * System.out.println(answers.hasDupeChars(edgeCase1));
		 * System.out.println(answers.hasDupeChars(edgeCase2));
		 * System.out.println(answers.hasDupeChars(edgeCase3));
		 * 
		 * //1.1b tests System.out.println("---1.1b tests---");
		 * System.out.println(answers.hasDupeChars2(noDuplicates));
		 * System.out.println(answers.hasDupeChars2(hasDuplicates));
		 * System.out.println(answers.hasDupeChars2(edgeCase1));
		 * System.out.println(answers.hasDupeChars2(edgeCase2));
		 * System.out.println(answers.hasDupeChars2(edgeCase3));
		 */
		
		//1.2 tests
		//System.out.println(answers.reverseString(cStyle));
		
		//1.3 tests
		System.out.println(answers.removeDuplicateCharacters(hasDuplicates));
		
	}
	
}
