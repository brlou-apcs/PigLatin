import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines1[] = loadStrings("words.txt");
	for (int i = 0 ; i < lines1.length; i++) {
	  System.out.println(pigLatin(lines1[i]));
	}
}

public boolean beginsWithQu(String word) {
	if(word.substring(0,2).equals("qu")) return true;
	return false;
}

public boolean beginsWithVowel(String word) {
	if(word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u') return true;
	return false;
}

public boolean isVowel(String letter) {
	if(letter.charAt(0) == 'a' || letter.charAt(0) == 'e' || letter.charAt(0) == 'i' || letter.charAt(0) == 'o' || letter.charAt(0) == 'u') return true;
	return false;
}

public String pigLatin(String word) {
	if(beginsWithQu(word)) {
		return word.substring(2,word.length()) + "quay";
	} else if (beginsWithVowel(word)) {
		return word + "way";
	} else {
		for(int i = 0; i < word.length(); i++) {
			if(isVowel(word.substring(i,i+1))) {
				return word.substring(i,word.length()) + word.substring(0,i) + "ay";
			}
		}
		return word + "ay";
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
