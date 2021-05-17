/**
 * The <code>OldLandline<code> class is a phone that can only make or receive a phone call.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
public class OldLandline implements Phone {
    private String owner;
    private PhoneNumber ownerNumber;
    private Phone whoOwnerIsCalling = null;

    OldLandline(String owner, long ownerNumber) {
        this.owner = owner;
        this.ownerNumber = new PhoneNumber(ownerNumber);
    }
    OldLandline(String owner, String ownerNumber) {
        this.owner = owner;
        this.ownerNumber = new PhoneNumber(ownerNumber);
    }

    /**
     * These are getters and setters to see who the owner is calling.
     */
    Phone getWhoOwnerIsCalling() {
        return whoOwnerIsCalling;
    }
    void setWhoOwnerIsCalling(Phone whoOwnerIsCalling) {
        this.whoOwnerIsCalling = whoOwnerIsCalling;
    }

    /**
     * Returns the owner of the old landline.
     * @return The owner of the old landline.
     */
    public String getOwner(){
        return owner;
    }

    /**
     * Calls someone on the phone. More than one simultaneous call cannot be made from an old landline.
     * @param phone
     * The phone that this old landline is calling.
     */
    public void call(Phone phone) {
        if (!this.isBusy() && phone.isBusy()) {
            System.out.println(this.getOwner() + " is unable to call " + phone.getOwner() + ". " + phone.getOwner() + " cannot receive the call.");
            phone.receive(this);
        }
        else if (!this.isBusy() && !phone.isBusy()) {
            this.setWhoOwnerIsCalling(phone);
            phone.receive(this);
        }
    }

    /**
     * Ends the call.
     * Checks if the person ending the call is busy or not. If the person is not busy, then they aren't in a call.
     * If the person ending the call is busy, then it ends the conversation between the two participants.
     */
    public void end(){
        if(!this.isBusy()) {
            System.out.println(this.getOwner() + " is not in a call.");
        }
        else {
            this.getWhoOwnerIsCalling().receiveEndSignal(this);
            this.setWhoOwnerIsCalling(null);
        }
    }

    /**
     * Allows the person to receive the call, and sets their boolean value to true.
     * @param from
     * The person that is calling.
     */
    public void receive(Phone from){
        if (!this.isBusy()) {
            this.setWhoOwnerIsCalling(from);
            System.out.println(from.getOwner() + " is on the phone with " + this.getOwner() + ".");
        }

    }

    /**
     * Tells you whether or not the phone line is busy.
     * @return Whether or not hte phone line is busy.
     */
    public boolean isBusy() {
        return whoOwnerIsCalling != null;
    }

    /**
     * Receives the end signal for the phone to end the call.
     * @param from
     * Where the signal is coming from.
     */
    public void receiveEndSignal(Phone from){
        System.out.println(from.getOwner() + " has ended the call to " + this.getOwner() + ".");
        this.setWhoOwnerIsCalling(null);
    }

    /**
     * Returns the phone number of the old landline.
     * @return the phone number of the old landline.
     */
    public PhoneNumber number(){
        return ownerNumber;
    }
}
