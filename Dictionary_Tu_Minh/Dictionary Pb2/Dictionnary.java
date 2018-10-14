package minh.tu;

public class Dictionnary {
	private Word listOfWord[];

	public Word[] getListOfWord() {
		return listOfWord;
	}

	public void setListOfWord(Word[] listOfWord) {
		this.listOfWord = listOfWord;
	}

	public Dictionnary(Word[] listOfWord) {
		this.listOfWord = listOfWord;
	}

	public Dictionnary() {
	}
	
	public Dictionnary(final int SIZE) {
		listOfWord = new Word[SIZE];
	}
}
