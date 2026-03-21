class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length- 1; j++){
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j + 1);
            }
        }
    }
}
public class Main{
    public static void main(String[] args) {
        Integer[] numbers = {5, 1, 3, 2};
        String[] words = {"Java", "C++", "Python"};

        ArrayUtils.sort(numbers);
        ArrayUtils.sort(words);

        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        System.out.println();
        for (int i = 0; i < words.length; i++)
            System.out.print(words[i] + " ");
    }
}