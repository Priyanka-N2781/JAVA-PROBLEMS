import java.util.*;
public class SieveOfSundaram {
    public static List<Integer> sundaram(int n) {
        boolean[] marked = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; (i + j + 2 * i * j) <= n; j++) {
                marked[i + j + 2 * i * j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        if (n > 0) {
            primes.add(2);
        }
        for (int i = 1; i <= n; i++) {
            if (!marked[i]) {
                primes.add(2 * i + 1);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit (n): ");
        int n = sc.nextInt();
        List<Integer> result = sundaram(n);
        System.out.println("Prime numbers: " + result);
        sc.close();
    }
}
