import java.util.List;
import java.util.ArrayList;
import java.util.Scanner; 

class Student{
    private String id, name;
    private double gpa;

    public Student(String id, String name, double gpa){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public double getGpa(){
        return this.gpa;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.id  + " " + this.name + " " + this.gpa;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String id  = inp.next();
            String name = inp.next();
            double gpa = inp.nextDouble();

            students.add(new Student(id, name, gpa));
        }
        
        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0: ");
        for (Student student : students){
            System.out.println(student.toString());
        }
        System.out.println();

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("After sorting by name: ");
        for (Student student : students){
            System.out.println(student.toString());
        }
        inp.close();
    }   
}
