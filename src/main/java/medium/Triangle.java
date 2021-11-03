package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Triangle {

    List<Double> sidesList;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        sidesList = Arrays.asList(side1, side2, side3);
        Collections.sort(sidesList);
        if (sidesList.contains(0.0) || sidesList.get(0) + sidesList.get(1) < sidesList.get(2)) throw new TriangleException();
    }

    boolean isEquilateral() {
        return sidesList.stream().distinct().count() == 1;
    }

    boolean isIsosceles() {
        return isEquilateral() || sidesList.stream().distinct().count() == 2;
    }

    boolean isScalene() {
        return sidesList.stream().distinct().count() == 3;
    }
}

class TriangleException extends Exception {}
