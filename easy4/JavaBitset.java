package Easy;

import java.io.*;
import java.util.*;

public class JavaBitset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            BitSet target = (x == 1) ? b1 : b2;
            BitSet other  = (x == 1) ? b2 : b1;

            switch (op) {
                case "AND":
                    target.and(other);
                    break;
                case "OR":
                    target.or(other);
                    break;
                case "XOR":
                    target.xor(other);
                    break;
                case "FLIP":
                    target.flip(y);
                    break;
                case "SET":
                    target.set(y);
                    break;
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }

        sc.close();
    }
}
