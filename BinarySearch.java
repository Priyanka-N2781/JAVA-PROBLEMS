public class BinarySearchRecursive {

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // If the element is at the middle
            if (array[mid] == target) {
                return mid;
            }

            // If element is smaller than mid, it can only be in left subarray
            if (array[mid] > target) {
                return binarySearch(array, target, low, mid - 1);
            }

            // Else the element can only be in right subarray
            return binarySearch(array, target, mid + 1, high);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 16;
        
        int resultIndex = binarySearch(sortedArray, target, 0, sortedArray.length - 1);
        
        if (resultIndex == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + resultIndex);
        }
    }
}
