package medium;

import java.util.Arrays;

class Matrix {

    private final int[][] rows;

    Matrix(String matrixAsString) {
        rows = Arrays.stream(matrixAsString.split("\\n"))
                .map(row -> Arrays.stream(row.split(" ")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }

    int[] getRow(int rowNumber) {
        return rows[--rowNumber];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(rows).mapToInt(it -> it[columnNumber - 1]).toArray();
    }
}
