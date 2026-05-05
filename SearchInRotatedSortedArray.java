import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int low = 0, high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==target){
                System.out.println(mid);
                return;
            }

            if(nums[low] <= nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(target>nums[mid] && target<=nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        System.out.println(-1);
    }
}
