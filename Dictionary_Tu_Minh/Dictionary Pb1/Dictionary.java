package minh.tu;

public class Dictionary {
	private Word listOfWord[];

	public Word[] getListOfWord() {
		return listOfWord;
	}

	public void setListOfWord(Word[] listOfWord) {
		this.listOfWord = listOfWord;
	}

	public Dictionary(Word[] listOfWord) {
		this.listOfWord = listOfWord;
	}

	public Dictionary() {
	}
	
	public Dictionary(final int SIZE) {
		listOfWord = new Word[SIZE];
	}
}
