import java.util.ArrayList;
import java.util.Scanner;
/**
 * The <code>Landline<code> class is a phone that can leave a message if the recipient is busy on another call.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
public class Landline extends OldLandline {
    // "Has a" data type to store messages (the array lists are the data type).
    private ArrayList<String> messages = new ArrayList<>();
    private ArrayList<MSG_STATUS> enums = new ArrayList<>();

    enum MSG_STATUS {READ, UNREAD }

    Landline(String owner, long ownerNumber) {
        super(owner, ownerNumber);
    }
    Landline(String owner, String ownerNumber) {
        super(owner, ownerNumber);
    }

    /**
     * Receive provides the code to leave a message if the recipient is busy on another call.
     * @param from
     * The caller.
     */
    @Override
    public void receive(Phone from){
        Scanner input = new Scanner(System.in);
        if (!this.isBusy()) {
            this.setWhoOwnerIsCalling(from);
            System.out.println(from.getOwner() + " is on the phone with " + this.getOwner() + ".");
        }
        else {
            String yesOrNo;
            boolean validYN = false;
            System.out.print("Would you like to leave a message? (y/n): ");
            yesOrNo = input.nextLine();
            yesOrNo = yesOrNo.toLowerCase();
            while(!validYN) {
                if(yesOrNo.equals("y")) {
                    validYN = true;
                }
                else if(yesOrNo.equals("n")) {
                    validYN = true;
                }
                else {
                    System.out.print("Invalid input! Try again (y/n): ");
                    yesOrNo = input.nextLine();
                }
            }
            if(yesOrNo.equals("y")) {
                System.out.print("Type out your message: ");
                String message = input.nextLine();
                messages.add(message);
                enums.add(MSG_STATUS.UNREAD);
            }
            else {
                System.out.println("A message will not be sent!");
            }
        }
    }
    /**
     * Reads through all the messages and prints them out. Makes UNREAD --> READ if UNREAD.
     */
    void readMessages() {
        if(!this.isBusy()) {
            System.out.println("Printing out all messages line by line...");
            for (int i = 0; i < messages.size(); i++) {
                if (enums.get(i).equals(MSG_STATUS.UNREAD)) {
                    System.out.println(messages.get(i));
                    enums.set(i, MSG_STATUS.READ);
                } else {
                    System.out.println(messages.get(i));
                }
            }
            System.out.println("Printing is complete.");
        }
    }
    /**
     * Reads through all messages of MSG_STATUS and prints them out. Makes UNREAD --> READ if unread.
     * @param readorunread
     * The status, READ or UNREAD.
     */
    void readMessages(MSG_STATUS readorunread) {
        if (!this.isBusy()) {
            if (readorunread.equals(MSG_STATUS.UNREAD)) {
                System.out.println("Printing out all unread messages line by line...");
                for (int i = 0; i < enums.size(); i++) {
                    if (enums.get(i).equals(MSG_STATUS.UNREAD)) {
                        System.out.println(messages.get(i));
                        enums.set(i, MSG_STATUS.READ);
                    }
                }
                System.out.println("Printing is complete.");
            } else {
                System.out.println("Printing out all read messages line by line...");
                for (int i = 0; i < enums.size(); i++) {
                    if (enums.get(i).equals(MSG_STATUS.READ)) {
                        System.out.println(messages.get(i));
                    }
                }
                System.out.println("Printing is complete.");
            }
        }
    }
}

