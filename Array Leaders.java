import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> leaders = new ArrayList<>();

        int max = arr[n - 1];
        leaders.add(max);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(leaders);

        for (int x : leaders) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
