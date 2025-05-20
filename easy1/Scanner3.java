package Easy;
import java.util.Scanner;
public class Scanner3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        double n2 = scanner.nextDouble();
        scanner.nextLine();
        String n3 = scanner.nextLine();
        scanner.close();
        System.out.println("String: "+n3);
        System.out.println("Double: "+n2);
        System.out.println("Int: "+n1);
    }
}
