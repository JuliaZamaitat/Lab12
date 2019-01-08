package scrabble.data;

import java.util.Collection;
import java.util.Set;

public class SimpleWordList implements WordList {

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		// TODO Auto-generated method stub
		return null;
		//newComment
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WordList initFromFile(String fileName) {
		return new SimpleWordList();
		// TODO Auto-generated method stub
	}

}
