import java.util.*;

class InPlaceShuffle {
    public static void rearrange(int[] nums, int[] pos) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // While element is not in the correct position
            while (pos[i] != i) {
                int target = pos[i];

                // Swap nums[i] with nums[target]
                int tempNum = nums[i];
                nums[i] = nums[target];
                nums[target] = tempNum;

                // Swap pos[i] with pos[target] to keep track
                int tempPos = pos[i];
                pos[i] = pos[target];
                pos[target] = tempPos;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] pos = new int[n];

        // Input nums[]
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input pos[]
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }

        // Rearrange in-place
        rearrange(nums, pos);

        // Print result
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}
