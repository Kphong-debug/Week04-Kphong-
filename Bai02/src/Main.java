interface CanFly{
    public void fly();
}

interface CanSwim{
    public void swim();
}
interface CanFight{
    public void fight();
}

class ActionCharacter{
    public void fight() {
        System.out.println("Boxing ");
    }
}
class Hero extends ActionCharacter implements CanFight, CanSwim{
    @Override
    public void swim() {
        System.out.println("Hero is swimming");
    }
} 
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.swim();
        hero.fight();
    }
}
