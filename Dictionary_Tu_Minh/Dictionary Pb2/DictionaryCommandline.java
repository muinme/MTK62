package minh.tu;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
	public void dictionarySearcher(String target, DictionnaryManagement dictionnaryManagement) {
		
		ArrayList<String> LIST = dictionnaryManagement.insertFromFile("D:/dictionaries.txt");
		target = target.toLowerCase();
		int leng_target = target.length();
		for(int i = 0;i < LIST.size();i+= 2) {
			String target1 = LIST.get(i);											/* tìm kiếm các từ bắt đầu bằng target bằng dòng lệnh*/
			int num = 1;
			if(target1.length() >= leng_target) {
				String phu = target1.substring(0,leng_target); 
				if(target.equals(phu)) {
						showAllWords(target1, LIST.get(i + 1), num );
						num++;
				}
			}
		}
	}
	public void showAllWords(String target,String explain,int i) {      /* xuất dữ liệu ra ngoài màn hình*/
		
		System.out.println( i + "\t| " + target	+ "\t\t | " + explain);
	}
	public void dictionaryAdvanced(DictionnaryManagement dictionnaryManagement, String target,int i)  {  /* hàm gọi các hàm insertFromFile(), showAllWords() và dictionaryLookup()*/
		String explain = dictionnaryManagement.dictionaryLookup(target);
		showAllWords(target, explain, i);
	}
	public static void main(String[] args) {
		DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
		DictionnaryManagement dictionnaryManagement = new DictionnaryManagement();
		System.out.println("các thao tác với từ điển: "); 
		System.out.println("1. tra từ gõ : tra");
		System.out.println("2. thêm từ gõ : thêm");
		System.out.println("3. sửa từ gõ : sửa");
		System.out.println("4. xóa từ gõ : xóa");
		System.out.println("5. dừng chương trình gõ : 0");
		System.out.println("6. tra các từ : 1");
		System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		while (true) {
			switch (key) {
			case "tra":
				int n;
				System.out.println("nhập số từ cần tra ");
				n =sc.nextInt();
				ArrayList<String> target = new ArrayList<String>();
				sc.nextLine();
				
				for(int i = 0;i < n;i++) {
					target.add(sc.nextLine());
				}
				System.out.println("No\t| English\t | Vietnamese");
				for(int i = 0;i < n;i++) {
					
					
					dictionaryCommandline.dictionaryAdvanced(dictionnaryManagement , target.get(i), i);
				}
				System.out.println("các thao tác với từ điển: "); 
				System.out.println("1. tra từ gõ : tra");
				System.out.println("2. thêm từ gõ : thêm");
				System.out.println("3. sửa từ gõ : sửa");
				System.out.println("4. xóa từ gõ : xóa");
				System.out.println("5. dừng chương trình gõ : 0");
				System.out.println("6. tra các từ : 1");
				System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
				key = sc.nextLine();
				break;
			case "thêm" : 
				System.out.println("nhập từ cần thêm");
				System.out.println("nhập từ tiếng anh : ");
				String target1 = sc.nextLine();
				target1 = target1.toLowerCase();
				System.out.println("nhập nghĩa của từ : ");
				String explain1 = sc.nextLine();
				dictionnaryManagement.themtu(target1, explain1, "D:/dictionaries.txt");
				System.out.println("các thao tác với từ điển: "); 
				System.out.println("1. tra từ gõ : tra");
				System.out.println("2. thêm từ gõ : thêm");
				System.out.println("3. sửa từ gõ : sửa");
				System.out.println("4. xóa từ gõ : xóa");
				System.out.println("5. dừng chương trình gõ : 0");
				System.out.println("6. tra các từ : 1");
				System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
				key = sc.nextLine();
				break;
			case "xóa" :
				System.out.println("nhập từ cần xóa : ");
				String target2 = sc.nextLine();
				target2 = target2.toLowerCase();
				dictionnaryManagement.xoatu(target2, "D:/dictionaries.txt");
				System.out.println("các thao tác với từ điển: "); 
				System.out.println("1. tra từ gõ : tra");
				System.out.println("2. thêm từ gõ : thêm");
				System.out.println("3. sửa từ gõ : sửa");
				System.out.println("4. xóa từ gõ : xóa");
				System.out.println("5. dừng chương trình gõ : 0");
				System.out.println("6. tra các từ : 1");
				System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
				key = sc.nextLine();
				break;
			case "sửa" : 
				System.out.println("nhập từ cần sửa : ");
				String target3 = sc.nextLine();
				target3 = target3.toLowerCase();
				System.out.println("nhập từ sau khi sửa : ");
				String target4 = sc.nextLine();
				target4 = target4.toLowerCase();
				System.out.println("nhập nnghĩa của từ sau khi sửa : ");
				String explain2 = sc.nextLine();
				dictionnaryManagement.suatu(target3, target4, explain2, "D:/dictionaries.txt");
				System.out.println("các thao tác với từ điển: "); 
				System.out.println("1. tra từ gõ : tra");
				System.out.println("2. thêm từ gõ : thêm");
				System.out.println("3. sửa từ gõ : sửa");
				System.out.println("4. xóa từ gõ : xóa");
				System.out.println("5. dừng chương trình gõ : 0");
				System.out.println("6. tra các từ : 1");
				System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
				key = sc.nextLine();
				break;
			case "1":
				System.out.println("nhập từ cần tra : ");
				String target5 = sc.nextLine();
				dictionaryCommandline.dictionarySearcher(target5, dictionnaryManagement);
				System.out.println("các thao tác với từ điển: "); 
				System.out.println("1. tra từ gõ : tra");
				System.out.println("2. thêm từ gõ : thêm");
				System.out.println("3. sửa từ gõ : sửa");
				System.out.println("4. xóa từ gõ : xóa");
				System.out.println("5. dừng chương trình gõ : 0");
				System.out.println("6. tra các từ : 1");
				System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
				key = sc.nextLine();
				break;
			case "xuất":
				System.out.println("nhập đường dẫn file :");
				String path = sc.nextLine();
				dictionnaryManagement.dictionaryExportToFile(path);
				System.out.println("các thao tác với từ điển: "); 
				System.out.println("1. tra từ gõ : tra");
				System.out.println("2. thêm từ gõ : thêm");
				System.out.println("3. sửa từ gõ : sửa");
				System.out.println("4. xóa từ gõ : xóa");
				System.out.println("5. dừng chương trình gõ : 0");
				System.out.println("6. tra các từ : 1");
				System.out.println("7. xuất dữ liệu từ điển ra file gõ : xuất ");
				key = sc.nextLine();
			default :
				System.exit(0);
				break;
			}
		}
	}
}
