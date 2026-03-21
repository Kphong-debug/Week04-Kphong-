import java.util.Scanner;

interface SetupWifi {
    public void setupWifi();
}

abstract class Device{
    private String id, name;
    private boolean state;

    public Device(String id, String name){
        this.name = name;
        this.id = id;
        this.state = true;
    }

    public String getName(){
        return this.name;
    }

    public void setState(){
        if (this.state) this.state = false;
        else this.state = true;
    }
    public boolean getState(){
        return this.state;
    }

    public abstract String turningState();
}

class Light extends Device{
    public Light(String id, String name){
        super(id, name);
    }

    @Override
    public String turningState() {
        if (this.getState()){
            this.setState();
            return "turn off";
        }
        else{
            this.setState();
            return "turn on";
        }
    }
}

class AC extends Device implements SetupWifi{
    public AC(String id, String name){
        super(id, name);
    }

    @Override
    public String turningState() {
        if (this.getState()){
            this.setState();
            return "turn off";
        }
        else{
            this.setState();
            return "turn on";
        }
    }

    @Override
    public void setupWifi() {
        System.out.println(this.getName() + "connected to wifi");
    }
}

class Curtain extends Device{
    public Curtain(String id, String name){
        super(id, name);
    }

    @Override
    public String turningState() {
        if (this.getState()){
            this.setState();
            return "turn off";
        }
        else{
            this.setState();
            return "turn on";
        }
    }
}

class Speaker extends Device implements SetupWifi{
    public Speaker(String id, String name){
        super(id, name);
    }

    @Override
    public String turningState() {
        if (this.getState()){
            this.setState();
            return "turn off";
        }
        else{
            this.setState();
            return "turn on";
        }
    }

    @Override
    public void setupWifi() {
        System.out.println(this.getName() + "connected to wifi");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        Device[]  devices = new Device[n];
        for (int i = 0; i < n; i++){
            String type = inp.next();
            String id = inp.next();
            String name = inp.next();
            
            if (type.equals("L"))
                devices[i] = new Light(id, name);
            else if (type.equals("AC"))
                devices[i] = new AC(id, name);
            else if (type.equals("S"))
                devices[i] = new Speaker(id, name);
            else
                devices[i] = new Curtain(id, name);
        }

        System.out.println('\n' + "Turn Off All Devices:");
        for (Device device : devices)
            System.out.println(device.getName() + device.turningState());

        System.out.println('\n' + "Setup Wifi: ");
        for (Device device : devices){
            if (device instanceof SetupWifi)
                ((SetupWifi)device).setupWifi();
        }
        inp.close();

    }    
}
