import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;

                // Visit all connected cities
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1)
                        visited[j] = true;
                }
            }
        }

        System.out.println(provinces);
    }
}
