package medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;

class WordCount {

    Map<String, Integer> phrase(String phrase){
        phrase = phrase.replaceAll("\n|\\s'|'\\s|'$", " ")
                .toLowerCase();

        return Arrays.stream(phrase.split("[^a-zA-Z0-9']+"))
                .filter(Predicate.not(String::isBlank))
                .collect(groupingBy(identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }
}
