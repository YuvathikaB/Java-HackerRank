package Medium;

import java.util.*;
import java.security.*;

public class MD5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception: " + e);
        }

        sc.close();
    }
}
