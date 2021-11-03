package medium;

import java.util.function.BiFunction;

class RotationalCipher {

    private static final String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int rot;

    RotationalCipher(int shiftKey) {
        rot = shiftKey;
    }

    String rotate(String data) {
        StringBuilder builder = new StringBuilder();
        for (char c : data.toCharArray()) {
            builder.append(transform(c));
        }
        return builder.toString();
    }

    private Character transform(Character character){
        if (!Character.isAlphabetic(character)) return character;

        BiFunction<Character, String, Character> transformChar = (ch, alphabet) ->
                alphabet.charAt((alphabet.indexOf(ch) + rot) % 26);

        return transformChar.apply(character, (Character.isUpperCase(character)) ? alphabetUpperCase : alphabetLowerCase);
    }
}
