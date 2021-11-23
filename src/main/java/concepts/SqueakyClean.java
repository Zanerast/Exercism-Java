package concepts;

import java.util.Arrays;
import java.util.stream.Collectors;

class SqueakyClean {
    static String clean(String identifier) {

        StringBuilder builder = new StringBuilder();
        char[] chars = identifier.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            char character = chars[i];
            if (character == ' ') builder.append('_');
            else if (character == '\0') builder.append("CTRL");
            else if (character == '-') {
                i++;
                builder.append(Character.toUpperCase(chars[i]));
            }
            else if (Character.UnicodeBlock.of(character) == Character.UnicodeBlock.GREEK && Character.isLowerCase(character)) continue;
            else if (Character.isAlphabetic(character)) builder.append(character);
        }

        return builder.toString();
    }
}
