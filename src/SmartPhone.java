import java.util.ArrayList;

/**
 * The <code>SmartPhone<code> class is a class adding more functionality than a landline, implementing a computer.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
public class SmartPhone extends Landline implements Computer {
    private ArrayList<String> videogames = new ArrayList<>();
    private int gameNumber = 0;
    private State state;
    private int ScreenSize;
    private int RAM;
    private int processorSpeeed;

    /**
     * This is a basic constructor for the SmartPhone class.
     */
    SmartPhone(String owner, long ownerNumber, State state, int ScreenSize, int RAM, int processorSpeeed) {
        super(owner, ownerNumber);
        this.state = state;
        this.ScreenSize = ScreenSize;
        this.RAM = RAM;
        this.processorSpeeed = processorSpeeed;
    }

    /**
     * This is a constructor for the SmartPhone class taking a string instead of a long for the phone number.
     */
    SmartPhone(String owner, String ownerNumber, State state, int ScreenSize, int RAM, int processorSpeeed) {
        super(owner, ownerNumber);
        this.state = state;
        this.ScreenSize = ScreenSize;
        this.RAM = RAM;
        this.processorSpeeed = processorSpeeed;
    }

    /**
     * This getter and the others below are getters for basic instance variables.
     */
    public int getScreenSize() {
        return ScreenSize;
    }
    public int getRAM() {
        return RAM;
    }
    public int getProcessorSpeeed() {
        return processorSpeeed;
    }
    public State getState() {
        return state;
    }

    /**
     * This sets the phone to on or off, depending on what you want the phone to be.
     * @param to
     * The state to which the phone is on or off.
     */
    public void setState(String to) {
        to = to.toUpperCase();
        if (to.equals(State.OFF.toString())) {
            this.state = State.OFF;
            System.out.println(this.getOwner() + "'s phone has been turned off.");
        } else if (to.equals(State.ON.toString())) {
            this.state = State.ON;
            System.out.println(this.getOwner() + "'s phone has been turned on.");
        } else {
            throw new java.lang.IllegalArgumentException("ERROR 216: Your SmartPhone is broken. Contact customer support.");
        }
    }

    /**
     * Installs a game into the SmartPhone. Handles basic exceptions, like when the phone is off, when the game is already installed, and if there is no space on the phone.
     * @param gameName
     * The name of the game to be installed.
     */
    public void installGame(String gameName) {
        if (this.getState().equals(State.OFF)) {
            // Debugging purposes System.out.println(this.getOwner() + "'s phone is off!");
            return;
        }
        if (!this.hasGame(gameName) && gameNumber != 5) {
            this.gameNumber++;
            videogames.add(gameName);
            System.out.println("Installing " + gameName + " on " + this.getOwner() + "'s phone.");
        } else if (gameNumber == 4)
            System.out.println("Cannot install " + gameName + ". There is no space on " + this.getOwner() + "'s phone!");
        else
            System.out.println("Cannot install " + gameName + ". It has already been installed on " + this.getOwner() + "'s phone!");
    }

    /**
     * This method tells you whether or not a game is installed on the phone.
     * @param gameName
     * The name of the game.
     * @return
     * Returns true if a game exists, false otherwise.
     */
    public boolean hasGame(String gameName) {
        for (int i = 0; i < this.gameNumber; i++) {
            if (videogames.get(i).equals(gameName))
                return true;
        }
        return false;
    }

    /**
     * Allows someone to play a game.
     * @param gameName
     * The name of the game that they are playing.
     */
    public void playGame(String gameName) {
        if (this.getState().equals(State.OFF)) {
            // Debugging purposes System.out.println(this.getOwner() + "'s phone is off!");
            return;
        }
        for (int i = 0; i < this.gameNumber; i++) {
            if (videogames.get(i).equals(gameName)) {
                System.out.println(this.getOwner() + " is now playing " + gameName + ".");
                return;
            }
        }
        System.out.println("Cannot play " + gameName + " on " + this.getOwner() + "'s phone. Install it first.");
    }

    /**
     * An override for whether or not the phone is busy. Adds the STATE of the phone into account.
     * @return Whether or not the phone is busy or not.
     */
    @Override
    public boolean isBusy() {
        if(this.getState().equals(State.OFF)) {
            return true;
        }
        else
            return this.getWhoOwnerIsCalling() != null;
    }

}


