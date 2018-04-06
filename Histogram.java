/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */


import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Histogram extends ConsoleProgram {
	String file = "scores";
	String filepath = file+".txt";
	public void run() {
	int[] buckets = new int[11];
	ArrayList<String> scoresAsString=makeListArray(filepath);
	for(int i=0; i<scoresAsString.size();i++) {
		int j = Integer.parseInt(scoresAsString.get(i))/10;
		buckets[j]++;
		}		
	println("00-09 : "+numStars(buckets[0]));
	println("10-19 : "+numStars(buckets[1]));
	println("20-29 : "+numStars(buckets[2]));
	println("30-39 : "+numStars(buckets[3]));
	println("40-49 : "+numStars(buckets[4]));
	println("50-59 : "+numStars(buckets[5]));
	println("60-69 : "+numStars(buckets[6]));
	println("70-79 : "+numStars(buckets[7]));
	println("80-89 : "+numStars(buckets[8]));
	println("90-99 : "+numStars(buckets[9]));
	println("100 : "+numStars(buckets[2]));
	} 
	private String numStars(int i) {
		String stars ="";
		for (int j=0; j<i; j++){
			stars= stars+"*";
		}

		return stars;
	}
	private ArrayList<String> makeListArray(String fileName) {
		ArrayList<String> lex = new ArrayList<String>();
		String line="";
		try{
			BufferedReader rd =new BufferedReader(new FileReader(filepath));
			while (true) {
			line=rd.readLine();
			if(line==null) {
				break;
			}
			lex.add(line);
		}
		rd.close();
		}catch(IOException ex) {
			lex.add("YOUTHREWANEXEPTION");
		}
	return lex;
	}
	private int getArrayCount(String filename) {
		ArrayList<String> bigList = makeListArray(filepath);
		return bigList.size();
	}
}
