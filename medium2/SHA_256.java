package Medium;

import java.util.*;
import java.security.*;

public class SHA_256 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not found");
        }

        sc.close();
    }
}
