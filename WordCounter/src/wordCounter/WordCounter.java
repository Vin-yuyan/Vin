package wordCounter;

import java.util.Scanner;

public class WordCounter {
	
	static int welcome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("HI!You can input a string and you can import from your file!And we will give you some message that you want konw!");
		
		System.out.println("Please input your choice !");
		System.out.println("1、input a string \n2、import from file");
		int choice=scanner.nextInt();
		return choice;	
	}
	
	private static String getUserString(int choice) {
		String s = null ;
		if (choice==1) {
			//input string
			System.out.println("Please input your string!");
			Scanner scanner=new Scanner(System.in);
			s = scanner.nextLine();
		}else if (choice==2) {
			//get string from file
			
		}else {
			welcome();
		}
		
		return s;
		
	}
	/**
	 * get number\character\black\other
	 * @param s
	 */
	private static void getMessageOne (String s) {
		
		char[] myChar = s.toCharArray();
		for (int i = 0; i < myChar.length; i++) {
			char temp = myChar[i];
			if (temp >= '0' && temp <= '9') {
				num[0]++;
			} else if (temp >= 'a' && temp <= 'z' || temp >= 'A' && temp <= 'Z') {
				num[1]++;
			} else if (temp == ' ') {
				num[2]++;
			} else {
				num[3]++;
			}
		}
	}
	
	private static void showMessage() {
		System.out.println("**************************");
		System.out.println("Your counter at here:");
		System.out.println("number:"+num[0]);
		System.out.println("character:"+num[1]);
		System.out.println("blank:"+num[2]);
		System.out.println("other:"+num[3]);
		System.out.println("words:"+num[4]);
		System.out.println("**************************");
		System.out.println("Thank you for your using!");
	}
	static int num[] = { 0, 0, 0, 0 ,0};// 数字、字母、空格、其他、单词
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		String s=getUserString(welcome());
		
		
		System.out.println("Now,we doing some work!Please wait!");
		//System sleep!
		//Thread.currentThread().sleep(5000);
		
		getMessageOne(s);
		getMessageTwo(s);
		showMessage();
		

	}

	private static void getMessageTwo(String s) {
		// TODO Auto-generated method stub
		System.out.println("There are the word!");
		 String s1[] = s.split(" ");
         for(int i=0;i<s1.length;i++) {
             // System.out.println(s1[i]);
              num[4]++;//计数变量
         } 
		
		
	}
	

}
