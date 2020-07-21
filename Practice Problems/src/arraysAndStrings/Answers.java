package arraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

public class Answers {
		
	//1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
	public int[][] zero(int[][] input){
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> columns = new HashSet<Integer>();
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				if(input[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}
			}
		}
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				if(rows.contains(i) || columns.contains(j)) {
					input[i][j] = 0;
				}
			}
		}
		
		return input;
	}
	
	//1.6 Rotate and NxN matrix 90 degrees
	public int[][] rotate(int[][] matrix){
		int N = matrix.length;
		for(int layer = 0; layer < N/2; layer++) {
			int first = layer;
			int last = N - 1 - layer;
			for(int i = first; i < last; i++) {
				//how far away we are from first
				int offset = i - first;
				
				//save the top left corner
				int save = matrix[layer][i];
				
				//bottom left corner -> top left corner
				matrix[layer][i] = matrix[last-offset][first];
				
				//bottom right corner -> bottom left corner
				matrix[last-offset][first] = matrix[last][last-offset];
				
				//top right corner -> bottom right corner
				matrix[last][last-offset] = matrix[i][last];
				
				//saved value -> top right corner
				matrix[i][last] = save;
				
			}
		}
		return matrix;
	}
	
	public void printMatrix(int[][] input) {
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input.length; j++) {
				System.out.print(input[i][j] + "");
			}
			System.out.println();
		}
	}
	
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
		//System.out.println(answers.replaceSpaces(cStyle));
		
		//1.6 tests
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}}; int[][] arr2 = {{1,2,3,4},
		{5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; answers.printMatrix(arr);
		System.out.println(); answers.printMatrix(answers.rotate(arr));
		  
		answers.printMatrix(arr2); System.out.println();
		answers.printMatrix(answers.rotate(arr2));
		 
		
		//1.7 tests
//		int[][] arr = {{0,1,2}, {3,4,5}, {6,7,8}};
//		answers.printMatrix(arr);
//		System.out.println();
//		answers.printMatrix(answers.zero(arr));
	}
	
}
