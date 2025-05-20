package Easy;
import java.util.*;
public class Output {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        int num1 = scanner.nextInt();
        String str2 = scanner.next();
        int num2 = scanner.nextInt();
        String str3 = scanner.next();
        int num3 = scanner.nextInt();
        scanner.close();
        System.out.println("================================");
        System.out.printf("%-15s%03d%n", str1, num1);
        System.out.printf("%-15s%03d%n", str2, num2);
        System.out.printf("%-15s%03d%n", str3, num3);
        System.out.println("================================");
}
}
