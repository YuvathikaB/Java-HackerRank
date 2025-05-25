package Medium;
import java.io.*;

public class CanAccess {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine().trim());
            Object o;

            var inner = new CanAccess.Inner();

            Class<?> privateClass = Class.forName("Medium.CanAccess$Inner$Private");
            var constructor = privateClass.getDeclaredConstructor(CanAccess.Inner.class);
            constructor.setAccessible(true);
            o = constructor.newInstance(inner);

            var method = privateClass.getDeclaredMethod("powerof2", int.class);
            method.setAccessible(true);

            String result = (String) method.invoke(o, num);

            System.out.println(num + " is " + result);
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        }
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & (num - 1)) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}
