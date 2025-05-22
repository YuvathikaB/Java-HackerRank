package Easy;
import java.util.*;


class JavaMap{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        Map<String, String> phoneBook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            String phone = in.nextLine();
            phoneBook.put(name, phone);
        }

        while (in.hasNextLine()) {
            String query = in.nextLine();
            if (query.isEmpty()) continue;
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}




