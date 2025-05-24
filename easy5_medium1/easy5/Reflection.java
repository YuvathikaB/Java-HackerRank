package Easy;
import java.lang.reflect.*;
import java.util.*;
public class Reflection {

    public static void main(String[] args){
        Class student = Student.class; // Get the class object
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName()); // Add method names to list
        }

        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}
