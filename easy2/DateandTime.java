package Easy;
import java.util.Calendar;
import java.util.Scanner;
public class DateandTime {
    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] days = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return days[dayOfWeek - 1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dateInput = scanner.nextLine().split(" ");
        int month = Integer.parseInt(dateInput[0]);
        int day = Integer.parseInt(dateInput[1]);
        int year = Integer.parseInt(dateInput[2]);
        System.out.println(findDay(month, day, year));
        scanner.close();
    }
}
