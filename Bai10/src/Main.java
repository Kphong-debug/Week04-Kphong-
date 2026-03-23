import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem{
    private String id, name , author;

    public MediaItem(String id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return this.author;
    }

    public abstract String getDetails();
}

class Book extends MediaItem{
    private int pages;
    public Book(String id, String name, String author, int pages){
        super(id, name, author);
        this.pages = pages;
    }

    @Override
    public String getDetails() {
        return this.getName() + " - " + this.getAuthor() + " - " + this.pages;
    }
}

class DVD extends MediaItem{
    private int length;

     public DVD(String id, String name, String author, int length){
        super(id, name, author);
        this.length = length;
    }

    @Override
    public String getDetails() {
        return this.getName() + " - " + this.getAuthor() + " - " + this.length;
    }
}

class Library<T extends MediaItem>{
    private List<T> mediaList = new ArrayList<>();

    public void addingMediaItem(T item){
        mediaList.add(item);
    }

    public void removeMediaItem(T item){
        mediaList.remove(item);
    }

    public void getList(){
        if (mediaList.isEmpty()) System.out.println("List is empty");
        else{
            for (T item : mediaList)
                System.out.println(item.getDetails());
        }
        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();
        
        Library<Book> BookSection = new Library<>();
        Library<DVD> DVDSection = new Library<>();

        for (int i = 1; i <= n; i++){
            String type = inp.next();
            String id = inp.next();
            String name = inp.next();
            String author = inp.next();
            int length = inp.nextInt();

            if (type.equals("B")){
                Book book = new Book(id, name, author, length);
                BookSection.addingMediaItem(book);
            }
            else{
                DVD dvd = new DVD(id, name, author, length);
                DVDSection.addingMediaItem(dvd);
            }
        }

        System.out.println('\n' + "Book's list: ");
        BookSection.getList();

        System.out.println("DVD's list: ");
        DVDSection.getList();

    }
}
