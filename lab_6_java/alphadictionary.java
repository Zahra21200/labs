import java.util.*;

public class alphadictionary {
    private Map<Character, List<String>> wordsMap;

    public alphadictionary() {
        wordsMap = new TreeMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            wordsMap.put(c, new ArrayList<>());
        }
    }

    public void addWord(String word) {
        
        char firstChar = Character.toUpperCase(word.charAt(0));
        if (wordsMap.containsKey(firstChar)) {
            List<String> wordsList = wordsMap.get(firstChar);
            wordsList.add(word);
        }
    }

    public void printAllLettersAndWords() {
        wordsMap.forEach((letter, words) -> {
            System.out.println(letter + ": " + String.join(", ", words));
        });
       
    }

    public void printWordsOfGivenLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (wordsMap.containsKey(letter)) {
            List<String> wordsList = wordsMap.get(letter);
            System.out.println(letter + ": " + String.join(", ", wordsList));
        } else {
            System.out.println("No words for the letter " + letter);
        }
    }

    public static void main(String[] args) {
        alphadictionary alphabetMap = new alphadictionary();

        // Example usage
        alphabetMap.addWord("apple");
        alphabetMap.addWord("banana");
        alphabetMap.addWord("ant");
        alphabetMap.addWord("zebra");
        alphabetMap.addWord("xylophone");

        System.out.println("All Letters and Words:");
        alphabetMap.printAllLettersAndWords();

        System.out.println("\nWords for the letter 'a':");
        alphabetMap.printWordsOfGivenLetter('a');
    }
}
