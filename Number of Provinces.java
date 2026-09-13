import java.util.*;

public class Main {

    static void dfs(int city, int[][] a, boolean[] visited) {
        visited[city] = true;

        for (int i = 0; i < a.length; i++) {
            if (a[city][i] == 1 && !visited[i]) {
                dfs(i, a, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];

        // Read matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, a, visited);
            }
        }

        System.out.println(provinces);
    }
}
