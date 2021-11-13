package medium;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SaddleMatrixTest {

    @Test
    public void testCanIdentifySingleSaddlePoint() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
            Arrays.asList(9, 8, 7),
            Arrays.asList(5, 3, 2),
            Arrays.asList(6, 6, 7)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.singleton(new MatrixCoordinate(2, 1));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyThatEmptyMatrixHasNoSaddlePoints() {
        SaddleMatrix matrix = new SaddleMatrix(new ArrayList<>());

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.emptySet();

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyLackOfSaddlePointsWhenThereAreNone() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(3, 1, 2),
            Arrays.asList(2, 3, 1)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.emptySet();

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyMultipleSaddlePointsInAColumn() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
            Arrays.asList(4, 5, 4),
            Arrays.asList(3, 5, 5),
            Arrays.asList(1, 5, 4)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(1, 2),
            new MatrixCoordinate(2, 2),
            new MatrixCoordinate(3, 2)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyMultipleSaddlePointsInARow() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
                Arrays.asList(6, 7, 8),
                Arrays.asList(5, 5, 5),
                Arrays.asList(7, 5, 6)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
                new MatrixCoordinate(2, 1),
                new MatrixCoordinate(2, 2),
                new MatrixCoordinate(2, 3)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifySaddlePointInBottomRightCorner() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
            Arrays.asList(8, 7, 9),
            Arrays.asList(6, 7, 6),
            Arrays.asList(3, 2, 5)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.singleton(new MatrixCoordinate(3, 3));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifySaddlePointsInANonSquareMatrix() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
                Arrays.asList(3, 1, 3),
                Arrays.asList(3, 2, 4)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
                new MatrixCoordinate(1, 3),
                new MatrixCoordinate(1, 1)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyThatSaddlePointsInASingleColumnMatrixAreThoseWithMinimumValue() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
                Collections.singletonList(2),
                Collections.singletonList(1),
                Collections.singletonList(4),
                Collections.singletonList(1)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
                new MatrixCoordinate(2, 1),
                new MatrixCoordinate(4, 1)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyThatSaddlePointsInASingleRowMatrixAreThoseWithMaximumValue() {
        SaddleMatrix matrix = new SaddleMatrix(Arrays.asList(
                Arrays.asList(2, 5, 3, 5)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
                new MatrixCoordinate(1, 2),
                new MatrixCoordinate(1, 4)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

}
