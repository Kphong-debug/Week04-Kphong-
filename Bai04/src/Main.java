interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
// Cố tình KHÔNG ghi public
public void show() { 
    System.out.println("Show Data");
}
}

public class Main {
   public static void main(String[] args) {
    DataManager dataManager = new DataManager();
    dataManager.show();
   }
}
