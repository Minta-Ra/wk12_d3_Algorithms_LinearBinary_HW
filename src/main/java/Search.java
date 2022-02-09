import java.util.ArrayList;

public class Search {

    public boolean linearSearch(ArrayList<Integer> array, int searchNumber) {
        for(int number : array)
        if(number == searchNumber){
            return true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public static Boolean binarySearch(ArrayList<Integer> array, int searchNumber) {

        // Checking if array is not empty
        if(array.size() == 0){
            return false;
        }

        // Find midpoint
        int midIndex = 0;
        if(array.size() > 1){
            // ceil() returns the double value that is greater than or equal to the argument.
            // ceil() method rounds the specified double value upward and returns it. The rounded value will be equal to the mathematical integer
            midIndex = (int) Math.ceil((double) array.size() / 2);
        }

        int midPoint = array.get(midIndex);

        // If number we are looking for is midpoint
        if(searchNumber == midPoint){
            return true;
        }

        ArrayList<Integer> newSearchArea;

        if(searchNumber < midPoint){
            // subList(0, midIndex) - starts at 0, finishing at midIndex
            newSearchArea = new ArrayList<Integer>(array.subList(0, midIndex));
        } else {
            // subList(midIndex +1, array.size()) - starts at midIndex+1 finishing at the end
            newSearchArea = new ArrayList<Integer>(array.subList(midIndex +1, array.size()));
        }
        return binarySearch(newSearchArea, searchNumber);
    }

}
