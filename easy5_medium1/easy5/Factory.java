package Easy;

import java.util.*;

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        } else {
            return null;
        }
    }
}

public class Factory {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FoodFactory foodFactory = new FoodFactory();

        String order = sc.nextLine();
        Food food = foodFactory.getFood(order);

        if (food == null) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        }

        sc.close();
    }
}
