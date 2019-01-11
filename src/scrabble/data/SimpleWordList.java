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
	//private ArrayList<String> simpleWordList = new ArrayList<>();
	private Map<String, HashSet<String>> simpleWordList = new HashMap<>();

	/**
	 * @return a Set of all the Words that are permutations of a given tile rack
	 */
	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		//Set<String> words = new HashSet<>();
		Permutation perm = new Permutation(tileRackPart);
		//	Permutation w = new Permutation(word);
			//if (w.equals(perm)) words.add(word);
		//}
		//return words;
		Set<String> wlst = simpleWordList.get(perm.getNormalized()) == null ? new HashSet<>() : simpleWordList.get(perm.getNormalized());
		return wlst;
	}


	@Override
	public Set<String> allValidWords(String tileRack) {
		return null;
	}

	@Override
	public boolean add(String word) {
		//return simpleWordList.add(word);
		Permutation perm = new Permutation(word);
		String normWord = perm.getNormalized();
		if(simpleWordList.containsKey(normWord)) {
			if(simpleWordList.get(normWord).contains(word)) return false;
			else simpleWordList.get(normWord).add(word); return true;
		} else {
			HashSet<String> words = new HashSet<>();
			words.add(word);
			simpleWordList.put(normWord, words);
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<String> words) {
		//return simpleWordList.addAll(words);
		int prevSize = simpleWordList.size();
		for (String word: words) {
			add(word);
		}
		return simpleWordList.size()-prevSize == words.size();
	}

	@Override
	public int size() {
		//return simpleWordList.size();
		Set<String> keys = simpleWordList.keySet();
		if (keys.size()> 0){
			int size = 0;
			for (String key : keys) size += simpleWordList.get(key).size();
			return size	;
		} else return 0;
	}

	@Override
	public WordList initFromFile(String fileName) {
			Charset charset = Charset.forName("UTF-8");
			try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), charset)) {
				String line;
				while ((line = reader.readLine()) != null) {
					add(line);
				}
			} catch (IOException x) {
				System.err.println("An Error occurred while reading the file or it did not exist.");
				System.err.format("IOException: %s%n",  x);
			}
			return this; //returns the instance of my SimpleWordList which is backed by a WordList
	}

}
