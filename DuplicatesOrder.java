import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean[] seen = new boolean[256];
        int[] last = new int[10];

        for (int i = 0; i < 10; i++)
            last[i] = -1;

        // Store last occurrence of digits
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                last[s.charAt(i) - '0'] = i;

        // Print result
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (!seen[ch]) {
                    System.out.print(ch);
                    seen[ch] = true;
                }
            } else if (last[ch - '0'] == i) {
                System.out.print(ch);
            }
        }
    }
}
