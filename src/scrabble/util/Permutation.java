package scrabble.util;


import java.util.Arrays;

public class Permutation {
	private String word;

	public Permutation(String word) {
		this.word = word;
	}

	//Hash Calculation based on Java String HashCode()
	@Override
	public int hashCode() {
		int hash = 0;
		char[] chars = getNormalized().toCharArray();
		for(int i = 0; i < chars.length; i++) {
			for(int l = chars.length; l > 0; l--) {
				hash += Math.pow(chars[i] * 31, l-1);
			}
		}
		return hash;
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
