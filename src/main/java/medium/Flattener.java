package medium;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {

    public List<Object> flatten(List<Object> list) {
        return list.stream()
                .flatMap(this::flatten)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Stream<Object> flatten(Object object) {
        return object instanceof List ? ((List<?>) object).stream().flatMap(this::flatten) : Stream.of(object);
    }

}
