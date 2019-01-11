package scrabble;

import scrabble.data.SimpleWordList;
import scrabble.data.WordList;

public class Main {
    private static WordList swl;

    public static void main(String[] args){
        if (args.length < 2) System.out.println("Please enter valid input");
        else init(args);
        lookUpStuff(args);

    }

    private static void init(String[] args) {
        String file = args[0].equals("default") ? "../wordlists/sowpods.txt" : args[0];
        swl = new SimpleWordList().initFromFile(file);
    }

    private static void lookUpStuff(String[] args) {
        for(int i = 1; i < args.length; i++) {
            System.out.println("Valid words using all tiles of \"" + args[i] + "\" :");
            System.out.println(swl.validWordsUsingAllTiles(args[i]));
        }
    }
}
