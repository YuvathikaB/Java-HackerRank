package Easy;
import java.util.Scanner;
public class intString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        if (n == Integer.parseInt(str)) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer");
        }
        sc.close();
    }
}
