import java.util.*;

public class Main {
    public static int dfs(int node, List<Integer>[] graph, int[] quiet, int[] ans) {
        if (ans[node] != -1) {
            return ans[node];
        }

        ans[node] = node;

        for (int richerPerson : graph[node]) {
            int candidate = dfs(richerPerson, graph, quiet, ans);

            if (quiet[candidate] < quiet[ans[node]]) {
                ans[node] = candidate;
            }
        }

        return ans[node];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[b].add(a);   // a is richer than b
        }

        int[] quiet = new int[n];
        for (int i = 0; i < n; i++) {
            quiet[i] = sc.nextInt();
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, ans);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}
