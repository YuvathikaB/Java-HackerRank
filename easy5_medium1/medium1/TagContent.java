package Medium;

import java.util.*;
import java.util.regex.*;

public class TagContent {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            //Write your code here
            String pattern = "<(.+?)>([^<]+)</\\1>";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);

            boolean found = false;
            while (m.find()) {
                System.out.println(m.group(2));
                found = true;
            }
            if (!found) {
                System.out.println("None");
            }
            testCases--;
        }
    }
}




