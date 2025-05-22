package Easy;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
public class twoDArr {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        JavaList<JavaList<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int top = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j) + arr.get(i - 1).get(j + 1);
                int middle = arr.get(i).get(j);
                int bottom = arr.get(i + 1).get(j - 1) + arr.get(i + 1).get(j) + arr.get(i + 1).get(j + 1);
                int hourglassSum = top + middle + bottom;
                if (hourglassSum > maxSum) {
                    maxSum = hourglassSum;
                }
            }
        }
        System.out.println(maxSum);
    }
}
