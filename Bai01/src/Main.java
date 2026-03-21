abstract class Shape{
    protected int x, y;
    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
    public abstract void erase();

    public void moveTo(int newX, int newY){
        this.erase();
        this.x = newX;
        this.y = newY;
        this.draw();
    }
}

class Circle extends Shape{
    public Circle(int x, int y){
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle at point: " + this.x +  " "  + this.y);
    }

    @Override
    public void erase() {
        System.out.println("Erasing circle at point: "  + this.x + " " + this.y);
    }
}

class Square extends Shape{
    public Square(int x, int y){
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing square at point: " + this.x +  " "  + this.y);
    }

    @Override
    public void erase() {
        System.out.println("Erasing square at point: "  + this.x + " " + this.y);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10);
        circle.moveTo(20, 20);
    }
}
