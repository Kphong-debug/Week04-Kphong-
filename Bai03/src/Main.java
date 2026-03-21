import java.util.Scanner;

interface IWorkable{
    public void work();
}

abstract class Employee implements IWorkable{
    private String id, name;
    private double baseSalary;

    public Employee(String id, String name, double baseSalary){
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public double getbaseSalary(){
        return this.baseSalary;
    }

     public String getName(){
        return this.name;
    }
    public abstract double calculatePay();
}

class OfficeWorker extends Employee{
    public OfficeWorker(String id, String name, double baseSalary){
        super(id, name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return this.getbaseSalary();
    }

    @Override
    public void work() {
        System.out.println("Text editing");
    }
}

class Technician extends Employee{
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours){
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
         return this.getbaseSalary() + this.overtimeHours * 20000;
    }

    @Override
    public void work() {
        System.out.println("equipment installation");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        Employee[] employees = new Employee[n + 1];
        for (int i = 1; i <= n; i++){
            String type = inp.next();
            String id = inp.next();
            String name = inp.next();
            double baseSalary = inp.nextDouble();
            if (type.equals("O"))
                employees[i] = new OfficeWorker(id, name, baseSalary);
            else{
                int overtimeHours = inp.nextInt();
                employees[i] = new Technician(id, name, baseSalary, overtimeHours);
            }

            inp.nextLine();
        }

        for (int i = 1; i <= n; i++){
            System.out.println('\n'+ employees[i].getName() + " - Pay: " + employees[i].calculatePay());
            employees[i].work();

        }
        inp.close();
    }
}
