package Easy;
import java.util.*;

public class JavaHashset{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Set<String> pairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String a = parts[0];
            String b = parts[1];

            String pair = a + " " + b;
            String reversePair = b + " " + a;

            if (!pairs.contains(pair) && !pairs.contains(reversePair)) {
                pairs.add(pair);
            }

            System.out.println(pairs.size());
        }

        sc.close();
    }
}

