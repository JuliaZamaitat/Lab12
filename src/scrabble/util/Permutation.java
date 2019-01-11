package scrabble.util;


import java.util.Arrays;

public class Permutation {
	private String word;

	public Permutation(String word) {
		this.word = word;
	}

	@Override
	public int hashCode() {
		// TBD: implement this method
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Permutation) {
			return getNormalized().equals(((Permutation) obj).getNormalized());
		}
		return false;
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}

	//sorts the char array in alphabetical order
	public String getNormalized() {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public String getWord() {
		return word;
	}

	public int length() {
		return word.length();
	}

}
