class Darts {

    private int score = 0;

    Darts(double x, double y) {
        double radius = Math.pow(x, 2) + Math.pow(y, 2);

        if (radius <= Math.pow(1, 2))  score = 10;
        else if (radius <= Math.pow(5, 2)) score = 5;
        else if (radius <= Math.pow(10, 2)) score = 1;
    }

    int score() {
        return score;
    }

}
