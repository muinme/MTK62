package minh.tu;

import java.util.Scanner;

public class DictionaryManagement {
	public int insertFromCommandline(Dictionary dictionary) {
		
		Scanner inputSting = new Scanner(System.in);
		System.out.print("Nhap so luong tu ");
		final int SIZE = inputSting.nextInt();
		inputSting.nextLine();
		
		dictionary.setListOfWord(new Word[SIZE]);
		Word word = null;
		for (int i = 0; i < SIZE; i++) {
			word = new Word();
			System.out.print("Nhap tu tieng anh ");
			word.setTarget(inputSting.nextLine());
			System.out.print("Nhap nghia ");
			word.setExplain(inputSting.nextLine());
			
			dictionary.getListOfWord()[i] = word;
		}
		
		inputSting.close();
		return SIZE;
	}
}
