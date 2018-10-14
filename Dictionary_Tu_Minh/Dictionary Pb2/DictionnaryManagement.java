package minh.tu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	public ArrayList<String> insertFromFile(String path) {		/* trả về danh sách từ điển*/
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
	public String dictionaryLookup(String target) {  					/* tra từ bằng dòng lệnh */
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
	public void themtu(String target, String explain, String path) { /* thêm 1 từ vào file từ điển */
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter br = new BufferedWriter(osw);
			br.write(target);
			br.write("\t");
			br.write(explain);
			br.newLine();
			br.close();
			osw.close();
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		System.out.println("đã thêm từ thành công ");
	}
	public void xoatu(String target, String path) {   /* xóa 1 từ khỏi file từ điển */
		ArrayList<String> LIST = insertFromFile(path);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter br = new BufferedWriter(osw);
			for(int i = 0;i < LIST.size() - 1;i+= 2) {
				if(target.equals(LIST.get(i))) {} else {
					br.write(LIST.get(i));
					br.write("\t");
					br.write(LIST.get(i + 1));
					br.newLine();
				}
			}
			br.close();
			osw.close();
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		System.out.println("Đã xóa từ thành công");
	}
	public void suatu(String target1, String target2, String explain, String path) {   /* sửa 1 từ của file từ điển */
		ArrayList<String> LIST = insertFromFile(path);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter br = new BufferedWriter(osw);
			for(int i = 0;i < LIST.size() - 1;i+= 2) {
				if(target1.equals(LIST.get(i))) {} else {
					br.write(LIST.get(i));
					br.write("\t");
					br.write(LIST.get(i + 1));
					br.newLine();
				}
			}
			br.write(target2);
			br.write("\t");
			br.write(explain);
			br.close();
			osw.close();
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		System.out.println("đã sửa từ thành công");
		
	}
	public void dictionaryExportToFile(String path) {     /* xuất dữ liệu từ điển ra 1 file có đường dẫn là path */
		ArrayList<String> data = insertFromFile("D:/dictionaries.txt");
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter br = new BufferedWriter(osw);
			for(int i = 0;i < data.size() - 1;i+= 2) {
				br.write(data.get(i));
				br.write("\t");
				br.write(data.get(i + 1));
				br.newLine();
			}
			br.close();
			osw.close();
			fos.close();
		}	catch (Exception ex) {
		ex.printStackTrace();
		
		}
	}

}
