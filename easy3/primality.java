package Easy;
import java.io.*;
import java.math.*;
public class primality {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        bufferedReader.close();
        BigInteger number = new BigInteger(n);
        if (number.isProbablePrime(100)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
