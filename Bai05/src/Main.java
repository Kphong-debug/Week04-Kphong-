import java.security.Key;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value){
        this.value = value;
    }

   @Override
   public String toString() {
       return this.key + " - " + this.value;
   }
}
public class Main {
   public static void main(String[] args) {
    Pair<String, Integer> info1 = new Pair<>("Age", 20);
    Pair<String, String> info2 = new Pair<>("MSV", "SV001");
    Pair<Integer, Double> info3 = new Pair<>(105, 21.5);

    System.out.println(info1);
    System.out.println(info2);
    System.out.println(info3);
   } 
}
