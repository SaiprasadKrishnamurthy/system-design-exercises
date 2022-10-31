import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scrabble {

    public static void main(String[] args) {

        String word = "cabbage";

        Scrabble scrabble = new Scrabble();
        System.out.println("'" + word + "' is worth " + scrabble.getWordScore(word) + " points");
    }

    private List<LetterSet> letterSets;

    public Scrabble() {
        letterSets = Arrays.asList(
                new LetterSet(0, "*"),
                new LetterSet(1, "aeioulnrst"),
                new LetterSet(2, "dg"),
                new LetterSet(3, "bcmp"),
                new LetterSet(4, "fhvwy"),
                new LetterSet(5, "k"),
                new LetterSet(8, "jx"),
                new LetterSet(10, "qz")
        );
    }

    public int getWordScore(String word) {

        int finalScore = 0;
        for (char letter : word.toCharArray()) {
            finalScore += getLetterScore(letter);
        }
        return finalScore;
    }

    public int getLetterScore(char letter) {
        for (LetterSet letterSet : letterSets) {
            if (letterSet.containsLetter(letter)) {
                return letterSet.getScore();
            }
        }

        throw new IllegalArgumentException("'" + letter + "' is not a valid scrabble letter");
    }


    //-------------------------------------------------------------------------

    public static final class LetterSet {

        private int score;
        private List<Character> letters;

        public LetterSet(int score, String letters) {
            this.score = score;
            this.letters = new ArrayList<Character>(letters.length());
            for (char letter : letters.toCharArray()) {
                this.letters.add(letter);
            }
        }

        public int getScore() {
            return score;
        }

        public boolean containsLetter(Character letter) {
            return letters.contains(letter);
        }
    }
}