package arraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

public class Answers {
	
	//1.5 Write a method to replace all spaces in a string with "%20"
	public String replaceSpaces(String input) {
		for(int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if(temp == ' '){
				String first = input.substring(0,i);
				String middle = "%20";
				String end = input.substring(i+1, input.length());
				input = first+middle+end;
			}
		}
		return input;
	}
	
	//1.4 Write a method to decide if two strings are anagrams or not
	public boolean StringsAreAnagrams(String input1, String input2) {
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for(int i = 0; i < input1.length(); i++) {
			char temp = input1.charAt(i);
			if(map1.containsKey(temp)) {
				map1.put(temp, map1.get(temp)+1);
			}else {
				map1.put(temp, 1);
			}
		}
		
		for(int i = 0; i < input2.length(); i++) {
			char temp = input2.charAt(i);
			if(map2.containsKey(temp)) {
				map2.put(temp, map2.get(temp)+1);
			}else {
				map2.put(temp, 1);
			}
		}
		
		for(Character c : map1.keySet()) {
			if(!map2.containsKey(c)) return false;
			if(map2.get(c) != map1.get(c)) return false;
		}
		
		return true;
	}
	
	//1.3 Design an algorithm and write code to remove duplicate characters in a string without using any additional buffer.
	//One or two additional variables are fine. An extra copy of the array is not.
	public String removeDuplicateCharacters(String input) {
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(i != j && input.charAt(i) == input.charAt(j)) {
					String first = input.substring(0,i);
					String middle = input.substring(i,j);
					String last = input.substring(j+1);
					input = first+middle+last;
					j--;
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
		String anagram1 = "murder";
		String anagram2 = "redrum";
		
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
		//System.out.println(answers.removeDuplicateCharacters(hasDuplicates));
		
		//1.4 tests
		//System.out.println(answers.StringsAreAnagrams(anagram1, anagram2)); //true
		//System.out.println(answers.StringsAreAnagrams(anagram1, noDuplicates)); //false
		
		//1.5 tests
		System.out.println(answers.replaceSpaces(cStyle));
		
	}
	
}
