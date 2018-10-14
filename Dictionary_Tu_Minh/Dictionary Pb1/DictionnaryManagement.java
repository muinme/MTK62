package minh.tu;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DictionnaryManagement {
	/*
	public int insertFromCommandline(Dictionary dictionary) {
		Scanner inputSting = new Scanner(System.in);
		System.out.print("Nhap so luong tu ");
		final int SIZE = inputSting.nextInt();
		inputSting.nextLine();
		
		dictionary.setListOfWord(new Word[SIZE]);
		Word word = null;
		for (int i = 0; i < SIZE; i++) {
			word = new Word();
			System.out.print("Nhap tu tieng anh");
			word.setTarget(inputSting.nextLine());
			System.out.print("Nhap nghia");
			word.setExplain(inputSting.nextLine());
			
			dictionary.getListOfWord()[i] = word;
		}
		
		inputSting.close();
		return SIZE;
		
	
	}
	*/
	public ArrayList<String> insertFromFile(String path) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line != null) {
				if(line.length() > 0) {
					String [] arr = line.split("\t");
					data.add(arr[0]);
					data.add(arr[1]);
					line = br.readLine();
				}
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String dictionaryLookup(String target) {
		ArrayList<String> list = insertFromFile("D:/dictionaries.txt");
		String explain = null;
		String x = target.toLowerCase();
		for(int i = 0;i < list.size();i+=2) {
			if(x.equals(list.get(i))) {
				explain = list.get(i+1);
			}
		}
		return explain;
	}

}
