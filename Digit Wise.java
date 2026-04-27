class Solution {
    public int digitWiseAdd(int a, int b) {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        int i = s1.length() - 1;
        int j = s2.length() - 1;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int d1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

            result.append(d1 + d2);

            i--;
            j--;
        }

        result.reverse();

        return Integer.parseInt(result.toString());
    }
}
