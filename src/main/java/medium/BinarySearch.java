package medium;

import java.util.List;

class BinarySearch{
    private final List<Integer> list;
    private double indexToSearch;
    private boolean indexIsZero = false;
    private int lowestIndexBound, highestIndexBound;

    BinarySearch(List<Integer> list){
        this.list = list;
        indexToSearch = (double) list.size() / 2;
        System.out.println(System.nanoTime());
    }

    int indexOf(int number) throws ValueNotFoundException{
        if (list.size() == 0) throw new ValueNotFoundException("Value not in array");

        // See if indexToSearch is not a whole number
        if (indexToSearch % 2 != 0 && indexToSearch > 2 || indexToSearch == 0){
            // Get results related to floor and ceiling of indexToSearch
            int resultOne = list.get((int) Math.floor(indexToSearch));
            int resultTwo = list.get((int) Math.ceil(indexToSearch));

            // If either match, return result
            if (number == resultOne) {
                System.out.println(System.nanoTime());
                return (int) Math.floor(indexToSearch);
            }
            if (number == resultTwo) {
                System.out.println(System.nanoTime());
                return (int) Math.ceil(indexToSearch);
            }

            // Set new search criteria
            if (number > resultTwo){
                lowestIndexBound = (int) indexToSearch;
                indexToSearch *= 1.5;
            } else {
                highestIndexBound = (int) indexToSearch;
                indexToSearch /= 2;
            }

            // Validate new search criteria
            if (highestIndexBound - lowestIndexBound == 1 || indexToSearch > list.size()) throw new ValueNotFoundException("Value not in array");
            return indexOf(number);
        } else {
            int result = list.get((int) Math.floor(indexToSearch));

            if (number == result) {
                System.out.println(System.nanoTime());
                return (int) Math.floor(indexToSearch);
            }

            // Set new search criteria
            if (number > result){
                lowestIndexBound = (int) indexToSearch;
                indexToSearch *= 1.5;
            } else {
                highestIndexBound = (int) indexToSearch;
                indexToSearch /= 2;
            }

            // Validate new search criteria
            if (indexIsZero || indexToSearch > list.size()) throw new ValueNotFoundException("Value not in array");
            if ((int) indexToSearch == 0) indexIsZero = true;

            return indexOf(number);
        }
    }
}

class ValueNotFoundException extends Exception {

    ValueNotFoundException(String message) {
        super(message);
    }
}
