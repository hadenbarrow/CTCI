package arraysAndStrings;

import java.util.HashSet;

public class Answers {
	
	//1.1
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
	
	public static void main(String[] args) {
		Answers answers = new Answers();
		
		//1.1 tests
		String noDuplicates = "no dupes";
		String hasDuplicates = "has dupess";
		
		System.out.println(answers.hasDupeChars(noDuplicates));
		System.out.println(answers.hasDupeChars(hasDuplicates));
		
	}
	
}
