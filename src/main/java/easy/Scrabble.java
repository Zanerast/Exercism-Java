package easy;

import java.util.stream.IntStream;

class Scrabble {

    private final char[] characters;

    Scrabble(String word) {
        characters = word.toCharArray();
    }

    int getScore() {
        return (int) IntStream.range(0, characters.length).mapToLong(c -> switch (Character.toUpperCase(characters[c])) {
            case 'Q', 'Z' -> 10;
            case 'J', 'X' -> 8;
            case 'K' -> 5;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'D', 'G' -> 2;
            default -> 1;
        }).sum();
    }

}
