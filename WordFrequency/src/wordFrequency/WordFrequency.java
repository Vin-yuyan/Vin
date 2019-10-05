package wordFrequency;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class WordFrequency {
	Vector<String> allWord,noSameWord;
	File file = new File("d:/hello.txt");
	Scanner sc=null;
	String regex;
	WordFrequency(){
		allWord = new Vector<String>();
		noSameWord = new Vector<String>();
		regex = "[\\s\\d\\p{Punct}]+";
		try{
			sc = new Scanner(file);
			sc.useDelimiter(regex);
		}
		catch(IOException exp){
			System.out.println(exp.toString());
		}
	}
	void setFileName(String name) {
		file = new File(name);
		try{
			sc = new Scanner(file);
			sc.useDelimiter(regex);
		}
		catch(IOException exp){
			System.out.println(exp.toString());
		}
	}
	public void wordFrequency(){
		try{
			while(sc.hasNext()){
				String word = sc.next();
				allWord.add(word);
				if(!noSameWord.contains(word))
					noSameWord.add(word);
			}
		}
		catch(Exception e){}
	}
	public Vector<String> getAllWord(){
		return allWord;
	}
	public Vector<String> getNoSameWord(){
		return noSameWord;
	}
}