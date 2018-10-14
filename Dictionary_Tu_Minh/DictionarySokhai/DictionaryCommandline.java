package minh.tu;

public class DictionaryCommandline extends Dictionary {
	public void showAllWords(Dictionary dictionary) {
		System.out.println("No\t" + "| English" +     "\t| Vietnamese ");
		final int SIZE_LOOP = dictionary.getListOfWord().length;
		for (int i = 0; i < SIZE_LOOP; i++) {
			System.out.println(i + 1 + "\t| " + dictionary.getListOfWord()[i].getTarget()
					+ "\t\t| " + dictionary.getListOfWord()[i].getExplain());
		}
	}

	public void dictionaryBasic(DictionaryManagement dictionaryManagement) {
		
		Dictionary dictionary = new Dictionary();
		// nhap vao tu dien
		dictionaryManagement.insertFromCommandline(dictionary);
		
		// Hien thi tu dien
		showAllWords(dictionary);
	}

	public static void main(String[] args) {
		
		DictionaryManagement dictionaryManagement = new DictionaryManagement();
		new DictionaryCommandline().dictionaryBasic(dictionaryManagement);

	}

}
