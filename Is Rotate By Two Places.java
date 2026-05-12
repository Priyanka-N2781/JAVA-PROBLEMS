import java.util.*;

class Main {
    public static boolean isRotatedByTwo(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() < 2) return s1.equals(s2);

        String anticlockwise = s1.substring(2) + s1.substring(0, 2);

        String clockwise = s1.substring(s1.length() - 2) + s1.substring(0, s1.length() - 2);

        return s2.equals(anticlockwise) || s2.equals(clockwise);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();

        System.out.println(isRotatedByTwo(s1, s2));
    }
}
