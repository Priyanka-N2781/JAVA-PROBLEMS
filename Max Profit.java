import java.util.*;

public class Main {
    static class Task {
        long diff;
        long a;
        long b;

        Task(long diff, long a, long b) {
            this.diff = diff;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(Math.abs(a[i] - b[i]), a[i], b[i]);
        }

        Arrays.sort(tasks, (t1, t2) -> Long.compare(t2.diff, t1.diff));

        long profit = 0;

        for (Task task : tasks) {
            if ((task.a >= task.b && x > 0) || y == 0) {
                profit += task.a;
                x--;
            } else {
                profit += task.b;
                y--;
            }
        }

        System.out.println(profit);
    }
}
