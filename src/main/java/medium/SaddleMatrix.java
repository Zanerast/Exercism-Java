package medium;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

class SaddleMatrix {

    List<Integer> columnMins;
    List<Integer> rowMaxs = new ArrayList<>();
    List<List<Integer>> values;

    SaddleMatrix(List<List<Integer>> values) {
        this.values = values;

        columnMins = range(0, values.size() > 0 ? values.get(0).size() : 0)
                .map(col -> values.stream().mapToInt(value -> value.get(col))
                        .min().orElseThrow()).boxed().toList();

        for (List<Integer> row : values) {
            rowMaxs.add(Collections.max(row));
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return range(0, values.size()).boxed()
                .flatMap(rowIndex -> range(0, values.get(0).size())
                        .filter(colIndex -> Objects.equals(rowMaxs.get(rowIndex), columnMins.get(colIndex)))
                        .mapToObj(columnIndex -> new MatrixCoordinate(rowIndex + 1, columnIndex + 1)))
                .collect(Collectors.toSet());
    }

}

class MatrixCoordinate implements Comparable<MatrixCoordinate> {
    private final int row;
    private final int col;

    MatrixCoordinate(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Row: " + row + ", Column: " + col;
    }

    // Generated equals and hashcode.

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MatrixCoordinate that = (MatrixCoordinate) o;

        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public int compareTo(MatrixCoordinate o) {
        int rowComparison = Integer.compare(row, o.row);
        return (rowComparison == 0) ? Integer.compare(col, o.col) : rowComparison;
    }
}

