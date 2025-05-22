package Easy;
import java.util.*;
public class JavaList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int q=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<q;i++){
            String query=sc.nextLine();
            if(query.equals("Insert")){
                String[] param =sc.nextLine().split(" ");
                int x=Integer.parseInt(param[0]);
                int y = Integer.parseInt(param[1]);
                list.add(x, y);
            } else if (query.equals("Delete")) {
                int x = Integer.parseInt(sc.nextLine());
                list.remove(x);
            }
        }
        sc.close();
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
