import java.util.*;

public class Main {
    public static int findCelebrity(int[][] mat, int n) {
        int candidate = 0;

        // Find potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println(findCelebrity(mat, n));
    }
}
