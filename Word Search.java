import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        int k = sc.nextInt();
        String[] words = new String[k];
        for (int i = 0; i < k; i++) {
            words[i] = sc.next();
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (exists(board, word)) {
                result.add(word);
            }
        }

        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            Collections.sort(result);
            for (String w : result) {
                System.out.print(w + " ");
            }
        }
    }

    static boolean exists(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1);

        board[i][j] = temp;

        return found;
    }
}
