import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.util.*;
public class PuzzleJava {
	public static void main(String[] args) {
		Number (1);
		int [] myArray = {3,5,1,2,7,9,8,13,25,32};
		int sum = 0;
		ArrayList<Integer> greaterThanTen = new ArrayList<Integer>();
		for(int i = 0; i < myArray.length; i++){
			sum = sum + myArray[i];
			if(myArray[i]>10){
				greaterThanTen.add(myArray[i]);
			}
		}
		System.out.println(sum);
		System.out.println(greaterThanTen);

		Number (2);
		String [] myArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		ArrayList<String> allNames = new ArrayList<String>();
		for (int i = 0; i<myArray.length;i++){
			// allNames.add(myArray[i]);
			if (myArray[i].length() > 5) {
				allNames.add(myArray[i]);
			}
		}
		Collections.shuffle(allNames);
		System.out.println(allNames);

		Number (3);
		String [] myArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String [] vowels = {"a","e","i","o","u"};
		ArrayList<String> allLetters = new ArrayList<String>();
		ArrayList<String> allVowels = new ArrayList<String>();
		for (int i = 0;i < myArray.length;i++){
				allLetters.add(myArray[i]);
		}
		for (int i = 0; i < vowels.length;i++){
			allVowels.add(vowels[i]);
		}
		Collections.shuffle(allLetters);
		System.out.println(allLetters.get(allLetters.size()-1));
		if (allVowels.contains(allLetters.get(0))){
			System.out.println("This is a vowel");
		}

		Number (4);
		int [] myArray;
		myArray = new int [10];
		ArrayList<Integer> randomNumber = new ArrayList<Integer>();
		for (int i = 0; i<myArray.length;i++){
			Random r= new Random();
			int high = 100;
			int low = 55;
			myArray[i] = r.nextInt(high-low)+low;
			randomNumber.add(myArray[i]);
		}
		Collections.sort(randomNumber);
		System.out.println(randomNumber);
		System.out.println("Maximum number is " + (int)(randomNumber.get(randomNumber.size()-1)));
		System.out.println("Minimum number is " + (int)(randomNumber.get(0)));

		Number (5);
		int leftLimit = 97; // letter 'a'
    	int rightLimit = 122; // letter 'z'
    	int targetStringLength = 5;
  	  	Random random = new Random();
  	  	ArrayList<String> randomStrings = new ArrayList<String>();
    	String generatedString = random.ints(leftLimit, rightLimit + 1)
      	.limit(targetStringLength)
      	.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      	.toString();
      	int limit = 10;
      	for (int i = 0; i<limit;i++){
      		randomStrings.add(generatedString);
      	}
    	System.out.println(randomStrings);
}
	}
