import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product{
    private String id, name;
    
    public Product(String id, String name){
        this.id = id;
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }

    public abstract String getDetails();
}

class Food extends Product{
    private String ExpiryDate;

    public Food(String id, String name, String ExpiryDate){
        super(id, name);
        this.ExpiryDate = ExpiryDate;
    }

    @Override
    public String getDetails() {
        return this.getName() + " - " + this.ExpiryDate;
    }
}

class Electronic extends Product{
    private int warantineMonths;

    public Electronic(String id, String name, int warantineMonths){
        super(id, name);
        this.warantineMonths = warantineMonths;
    }

    @Override
    public String getDetails() {
        return this.getName() + " - " + this.warantineMonths;
    }
}

class WareHouse <T extends Product>{
    private List<T> items = new ArrayList<>();

    public void importItems(T item){
        items.add(item);
        System.out.println(item.getName() + " added !");
        System.out.println();
    }

    public void exportItems(T item){
        if (items.remove(item))
            System.out.println(item.getName() + " exported");
        else System.out.println("Item not founded");
        System.out.println();
    }

    public void checkingItem(){
        if (items.isEmpty()){
            System.out.println("List is empty");
        }
        else{
            for (T item: items)
                System.out.println(item.getDetails());
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        WareHouse <Food> foodWareHouse = new WareHouse<>();
        WareHouse <Electronic> electronicWareHouse = new WareHouse<>();

        int n = inp.nextInt();
        inp.nextLine();

        for (int  i = 0; i < n; i++){
            String type = inp.next();
            String id = inp.next();
            String name = inp.next();

            if (type.equals("F")){
                String expiryDate = inp.next();
                Food food = new Food(id, name, expiryDate);
                foodWareHouse.importItems(food);
            }
            else{
                int warantineMonths = inp.nextInt();
                inp.nextLine();
                Electronic electronic = new Electronic(id, name, warantineMonths);
                electronicWareHouse.importItems(electronic);
            }
        }

        System.out.println("Food's list: ");
        foodWareHouse.checkingItem();

        System.out.println("Electronic's list: " );
        electronicWareHouse.checkingItem();
        inp.close();
    }
}
