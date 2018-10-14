package minh.tu;

import java.util.ArrayList;
import java.util.Scanner;


public class DictionaryCommandline {
public void showAllWords(String target,String explain,int i) {
		
		System.out.println( i + "\t| " + target	+ "\t\t | " + explain);
	}
	public void dictionaryAdvanced(DictionnaryManagement dictionnaryManagement, String target,int i)  {
		String explain = dictionnaryManagement.dictionaryLookup(target);
		showAllWords(target, explain, i);
	}
	public static void main(String[] args) {
		
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập số từ cần tra ");
		n =sc.nextInt();
		ArrayList<String> target = new ArrayList<String>();
		sc.nextLine();
		
		for(int i = 0;i < n;i++) {
			target.add(sc.nextLine());
		}
		System.out.println("No\t| English\t | Vietnamese");
		for(int i = 0;i < n;i++) {
			DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
			DictionnaryManagement dictionnaryManagement = new DictionnaryManagement();
			dictionaryCommandline.dictionaryAdvanced(dictionnaryManagement , target.get(i), i);
		}
		sc.close();
		
	}
}
