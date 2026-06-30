import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int num = Integer.parseInt(s.substring(i - 2, i));

            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        System.out.println(dp[n]);
    }
}
