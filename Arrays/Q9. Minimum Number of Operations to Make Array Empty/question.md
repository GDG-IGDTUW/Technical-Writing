import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToEmptyArray {

    public static int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int operations = 0;

        for (int count : freq.values()) {
            if (count == 1) {
                return -1;
            }

            if (count % 3 == 0) {
                operations += count / 3;
            } else if (count % 3 == 1) {
                operations += (count - 4) / 3 + 2;
            } else {
                operations += count / 3 + 1;
            }
        }

        return operations;
    }
}
