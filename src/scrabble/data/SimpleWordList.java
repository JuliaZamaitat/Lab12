package scrabble.data;

import scrabble.util.Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SimpleWordList implements WordList {
	private ArrayList<String> simpleWordList = new ArrayList<>();
	//private Map<String, HashSet<String>> simpleWordList = new HashMap<>();

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		// TODO Auto-generated method stub
		return null;
		//newComment
	}

	/**
	 * @return a Set of all the Words that are permutations of a given tile rack
	 */
	@Override
	public Set<String> allValidWords(String tileRack) {
		Set<String> words = new HashSet<>();
		Permutation perm = new Permutation(tileRack);
		for(String word : simpleWordList) {
			Permutation w = new Permutation(word);
			if (w.equals(perm)) words.add(word);
		}
		return words;
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
			Charset charset = Charset.forName("UTF-8");
			try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), charset)) {
				String line;
				while ((line = reader.readLine()) != null) {
					simpleWordList.add(line);
				}
			} catch (IOException x) {
				System.err.println("An Error occurred while reading the file or it did not exist.");
				System.err.format("IOException: %s%n",  x);
			}
			return this; //returns the instance of my SimpleWordList which is backed by a WordList
	}

}
