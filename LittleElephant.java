import java.util.*;

public class Main {

    // precomputed powers of 10 up to 18
    static long[] pow10 = new long[19];

    static {
        pow10[0] = 1;
        for (int i = 1; i < 19; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
    }

    // count valid numbers from 1 → x
    static long count(long x) {
        if (x <= 0) return 0;

        String s = Long.toString(x);
        int n = s.length();
        long ans = 0;

        // lengths smaller than n
        for (int len = 1; len < n; len++) {
            if (len == 1) ans += 9;
            else ans += 9 * pow10[len - 2];
        }

        int firstDigit = s.charAt(0) - '0';

        // same length, smaller first digit
        for (int d = 1; d < firstDigit; d++) {
            if (n == 1) ans++;
            else ans += pow10[n - 2];
        }

        // if single digit
        if (n == 1) return ans + 1;

        // middle part (only if length > 2)
        long middle = 0;
        if (n > 2) {
            middle = Long.parseLong(s.substring(1, n - 1));
        }

        ans += middle;

        // check last digit
        int lastDigit = s.charAt(n - 1) - '0';
        if (lastDigit >= firstDigit) ans++;

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        System.out.println(count(r) - count(l - 1));
    }
}
