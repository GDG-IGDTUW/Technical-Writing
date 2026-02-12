import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long[] a = Arrays.stream(br.readLine().split(" "))
                             .mapToLong(Long::parseLong)
                             .toArray();

            long[] b = Arrays.stream(br.readLine().split(" "))
                             .mapToLong(Long::parseLong)
                             .toArray();

            // Pair dishes and sort by courier time
            long[][] dishes = new long[n][2];
            for (int i = 0; i < n; i++) {
                dishes[i][0] = a[i]; // courier time
                dishes[i][1] = b[i]; // pickup time
            }

            Arrays.sort(dishes, Comparator.comparingLong(d -> d[0]));

            // Suffix sum of pickup times
            long[] suffix = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + dishes[i][1];
            }

            // Case: pick all yourself
            long answer = suffix[0];

            // Try delivering first i dishes
            for (int i = 0; i < n; i++) {
                long courierTime = dishes[i][0];
                long pickupTime = suffix[i + 1];
                answer = Math.min(answer, Math.max(courierTime, pickupTime));
            }

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}
