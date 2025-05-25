package Medium;

import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        return a -> {
            if (a < 2) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            String str = String.valueOf(a);
            return str.equals(new StringBuilder(str).reverse().toString());
        };
    }
}
public class Lambda {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SHA_256. */
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        PerformOperation op;
        boolean ret;
        String ans = null;

        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            switch (ch) {
                case 1:
                    op = ob.isOdd();
                    ret = MyMath.checker(op, num);
                    ans = (ret) ? "ODD" : "EVEN";
                    break;
                case 2:
                    op = ob.isPrime();
                    ret = MyMath.checker(op, num);
                    ans = (ret) ? "PRIME" : "COMPOSITE";
                    break;
                case 3:
                    op = ob.isPalindrome();
                    ret = MyMath.checker(op, num);
                    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
                    break;
            }
            System.out.println(ans);
        }
    }
}
