import java.util.ArrayList;

/**
 * The <code>Laptop<code> class is a class simulating functions of a computer.
 * SIDENOTE: I don't think I need to document this class because most of it aligns with SmartPhone.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
public class Laptop implements Computer {
    private ArrayList<String> videogames = new ArrayList<>();
    private int gameNumber = 0;
    private State state;
    private int ScreenSize;
    private int RAM;
    private int processorSpeeed;
    private String brand;
    private String hostname;

    Laptop(State state, int ScreenSize, int RAM, int processorSpeeed, String brand, String owner) {
        this.state = state;
        this.ScreenSize = ScreenSize;
        this.RAM = RAM;
        this.processorSpeeed = processorSpeeed;
        this.brand = brand;
        this.hostname = (owner + "'s " + brand + " laptop.");
    }

    public int getScreenSize(){
        return ScreenSize;
    }
    public int getRAM() {
        return RAM;
    }
    public int getProcessorSpeeed(){
        return processorSpeeed;
    }
    public State getState() {
        return this.state;
    }

    public void setState(String to){
        to = to.toUpperCase();
        if(to.equals(State.OFF.toString())) {
            this.state = State.OFF;
            System.out.println(this.hostname + "'s Laptop has been turned off.");
        } else if(to.equals(State.ON.toString())) {
            this.state = State.ON;
            System.out.println(this.hostname + "'s Laptop has been turned off.");
        }
        else {
            throw new java.lang.IllegalArgumentException("ERROR 216: Your laptop is broken. Contact customer support.");
        }
    }

    public void installGame(String gameName){
        if (this.getState().equals(State.OFF)) {
            // Debugging purposes System.out.println(this.getOwner() + "'s phone is off!");
            return;
        }
        if (!this.hasGame(gameName) && gameNumber != 4) {
            this.gameNumber++;
            videogames.add(gameName);
            System.out.println("Installing " + gameName + " on " +  hostname + ".");
        } else if (gameNumber == 4)
            System.out.println("Cannot install " + gameName + ". There is no space on " + hostname + "!");
        else
            System.out.println("Cannot install " + gameName + ". It has already been installed on " + hostname + ".");
    }

    public boolean hasGame(String gameName){
        for (int i = 0; i < this.gameNumber; i++) {
            if (videogames.get(i).equals(gameName))
                return true;
        }
        return false;
    }

    String getBrand() {
        return brand;
    }

    public void playGame(String gameName){
        if (this.getState().equals(State.OFF)) {
            // Debugging purposes System.out.println(hostname + " is off!");
            return;
        }
        for (int i = 0; i < this.gameNumber; i++) {
            if (videogames.get(i).equals(gameName)) {
                System.out.println(hostname + " is now playing " + gameName + ".");
                return;
            }
        }
        System.out.println("Cannot play " + gameName + " on " + hostname + ". Install it first.");
    }
}
