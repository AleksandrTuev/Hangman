import java.util.Random;
import java.util.TreeSet;

public class RandomWord {
    private String randomWord;
    private final TreeSet<Character> letters = new TreeSet<>();

    RandomWord(){
        generateWord();
    }

    void generateWord(){
        String[] list = new String[]{"молоко","машина","погода","лыжник", "корова","сундук"};
        Random random = new Random();
        randomWord = list[random.nextInt(list.length)];

        for (int i = 0; i < randomWord.length(); i++) {
            char symbol = randomWord.charAt(i);
            letters.add(symbol);
        }
    }

    public String getRandomWord(){
        return randomWord;
    }

    public TreeSet<Character> getListOfCorrectLetters(){
        return letters;
    }
}
