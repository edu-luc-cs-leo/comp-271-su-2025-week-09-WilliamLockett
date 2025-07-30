
/*
 * MY PLAN for findMax:
 * I plan on using what we learned in class about merge sorting arrays,
 * (taking the left and the right side and finding the middle),
 * I can use this for the findMax by finding the max on both sides
 * by spliting the array in half using the mid((Left + Right)/ 2)
 * 
 */
import java.util.Arrays;

public class RecursiveExercises {
    public static int findMax(int[] arr, int left, int right) {
        int result;
        // if statement for if left = right, meaning only one element is in the array
        if (left == right) {
            result = arr[left];
            // if not then find the max on each side by splitting the array in half
            // then find the maax on the left & then on the right
        } else {
            int mid = (left + right) / 2;
            // max on left side of mid
            int maxLeft = findMax(arr, left, mid);
            // max on right side of mid
            int maxRight = findMax(arr, mid + 1, right);

            // next find the larger of the two values
            result = Math.max(maxLeft, maxRight);

        }
        return result;
    } // method findMax
    /*
     * Recursively reverse elements in the array between left & right.
     */

    public static void reverseArray(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // swap the left into temp, then ut the right into where the left was
        // then put the left that was in temp into right.
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArray(arr, left + 1, right - 1);

    } // method reverseArray

    public static int countOccurrences(int[] arr, int target, int index) {
        int result;
        // if there is nothing in the array,
        // result = 0
        if (index >= arr.length) {
            result = 0;
        } else {
            // starts the count off to 0
            int count = 0;
            // if the element in the array = the target
            // then count will be = to 1
            if (arr[index] == target) {
                count = 1;
            }
            // process rest of the array
            result = count + countOccurrences(arr, target, index + 1);
        }
        return result;
    } // method countOccurrences

    public static int binarySearch(int[] arr, int target, int left, int right) {
        int result;
        // if left > than right, then the target is not found
        if (left > right){
            result = -1;
        } else {
            // find the middle
            int mid = (left + right) / 2;
            // if middle is the target
            if (arr[mid] == target){
                result = mid;
                
            } else if (arr[mid] > target){
            // if the middle is > than the target (left side)
            // mid - 1 to get the left side without inclucling the middle
                result = binarySearch(arr, target, left, mid -1);
            
            }else{
            // if the middle is < than the target ( right side)
            result = binarySearch(arr, target, mid +1, right);
            }
        }
        return result;
    } // method binarySearch

    public static void main(String[] args) {
        // Test findMax
        int[] array1 = { 5, 9, 1, 3, 7 };
        System.out.println("Max value: " + findMax(array1, 0, array1.length - 1));

        // Test reverseArray
        int[] array2 = { 1, 2, 3, 4, 5 };
        reverseArray(array2, 0, array2.length - 1);
        System.out.println("Reversed: " + Arrays.toString(array2));

        // Test countOccurrences
        int[] array3 = { 3, 5, 3, 3, 2, 5 };
        System.out.println("Occurrences of 3: " + countOccurrences(array3, 3, 0));

        // Test binarySearch
        int[] sortedArray = { 1, 3, 5, 7, 9, 11 };
        System.out.println("Index of 7: " + binarySearch(sortedArray, 7, 0, sortedArray.length - 1));
        System.out.println("Index of 4 (not found): " + binarySearch(sortedArray, 4, 0, sortedArray.length - 1));
    }
}