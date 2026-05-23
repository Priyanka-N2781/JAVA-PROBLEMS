import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[][] dp = new int[k+1][n];
        for(int i=1;i<=k;i++){
            int minDiff =- arr[0];
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i][j-1],arr[j]+minDiff);
                minDiff = Math.max(minDiff,dp[i-1][j]-arr[j]);
            }
        }
        System.out.println(dp[k][n-1]);
    }
}
