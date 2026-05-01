import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n <= 1) {
            System.out.println(0);
        } else {
            int near = 0;
            int far = 0;
            int jump = 0;
            while (far < n - 1) {
                int farthestInThisRange = 0;
                for (int i = near; i <= far; i++) {
                    farthestInThisRange = Math.max(farthestInThisRange, i + arr[i]);
                }
                if (farthestInThisRange <= far) {
                    jump = -1;
                    break;
                }
                near = far + 1;
                far = farthestInThisRange;
                jump++;
            }
            System.out.println(jump);
        }
        sc.close();
    }
}
