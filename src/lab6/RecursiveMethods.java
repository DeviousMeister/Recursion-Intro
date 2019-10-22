package lab6;

public class RecursiveMethods {

    /**
     * Recursively computes string representations of dragon curves
     * @param n the desired degree of the dragon curve
     * @return the nth dragon curve
     */
    public static String dragon(int n) {
        //FIXME Recursively compute dragon curves
        if(n==0){
            return ("F-H");
        }
        else{
            return dragon(n-1).replaceAll("F", "f-h").replaceAll("H", "f+h").replaceAll("f", "F").replaceAll("h", "H");
        }
    }

    /**
     * Recursively computes base ^ exponent
     * @param base the base - can be positive or negative
     * @param exp the exponent - can be positive or negative
     * @return base ^ exponent
     */

    public static double exponent(int base, int exp) {
        //FIXME Recursively compute base^exp
        if(base==0){
            return 0;
        }
       /* if(exp==2){
            return base*base;
        }
        if(exp==1){
            return base;
        }*/
        if(exp==0) {
            return 1;
        }
        /*else if(base<0 && (0==exp%2) && exp<0){
            return -1/(exponent(base, exp-1));
        }
        else if(base<0 && (0!=exp%2) && exp<0){
           return -1/(exponent(base, (exp-1)*-1));
        }*/
        else if(exp<0){
            return 1/(double)base*(exponent(base, (exp+1)));
        }
        else{
           return (double)base * exponent(base, exp-1);
        }
    }
    /**
     * Recursively compute the sum of elements in an array
     * @param array an array of integers
     * @return the sum of the elements in values
     */
    public static int sumHelper(int index, int[] array){
        if(index<0){
            return 0;
        }
        else{
            return array[index] + sumHelper(index-1, array);
        }
    }
    public static int arraySum(int[] array) {
        // FIXME: Recursively compute the sum of the values in an array
        int index=array.length-1;
        return sumHelper(index, array);
    }

    /**
     * Finds the length of the longest path in the given array
     * @param paths an array containing paths
     * @return the length of the longest path that was found
     */
    public static int maxHelper(int[][] paths, int row, int column){

        if(row<0 || column<0 || row>paths.length-1 || column>paths[0].length-1 || paths[row][column] != 1){
            return 0;
        }
        else{
            paths[row][column]=0;
        }
            int north = 1+maxHelper(paths, row-1, column);
            int south = 1+maxHelper(paths, row+1, column);
            int east = 1+maxHelper(paths, row, column+1);
            int west = 1+maxHelper(paths, row, column-1);
            int max1 = Math.max(north, south);
            int max2 = Math.max(east, west);
            int max3 = Math.max(max1, max2);
            return max3;
    }
    public static int maxPathLength(int[][] paths) {
        //FIXME Find and return the length of the longest path in the array
        return maxHelper(paths, 0, 0);
    }
}
