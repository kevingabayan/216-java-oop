import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The <code>Test<code> class tests the culmination of a whole-hearted attempt of Homework 1.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
public class Test {
    public static void main(String[] args) {
        /*
        Tests illegal constructions. Is commented out because it would crash the code otherwise. The code should compile, but throw a runtime error.
         */
        // OldLandline exception = new OldLandline("Exception", 55);
        // OldLandline string = new OldLandline("String", "ok");

        /*
        Old Landline and basic landline call testing. Tests basic restrictions, and ensures everything works out.
         */
        OldLandline kevin = new OldLandline("Kevin", "5162346721");
        OldLandline brian = new OldLandline("Brian", 5163215468L);
        Landline domenico = new Landline("Domenico", 1222222222);
        kevin.call(brian);
        kevin.call(domenico);
        domenico.call(kevin);
        kevin.end();
        brian.end();
        domenico.call(brian);

        // SmartPhone game testing. Tests basic methods to ensure everything works properly.
        SmartPhone henry = new SmartPhone("Henry", 5165132134L, Computer.State.OFF, 1, 1, 1);
        // Commented out cause it will crash if not. henry.setState("ok");
        henry.setState("off");
        henry.playGame("Anime Simulator 2019");
        henry.installGame("Anime Simulator 2019");
        henry.call(kevin);
        kevin.call(henry);
        henry.setState("on");
        henry.installGame("Anime Simulator 2019");
        henry.installGame("Anime Simulator 2019");
        henry.installGame("Anime Simulator 2020");
        henry.installGame("Anime Simulator 2021");
        henry.installGame("Anime Simulator 2022");
        henry.installGame("Apex Legends");
        henry.installGame("CSE 216 Simulator");
        henry.playGame("Anime Simulator 2019");

        // Sorting Testing for ordering phones by their numbers (increasing) and by owner names
        OldLandline david = new OldLandline("David", "1262346721");
        OldLandline rebecca = new OldLandline("Rebecca", 9872314523L);
        ArrayList<Phone> toSortPhone = new ArrayList<>(Arrays.asList(rebecca, david, domenico, kevin, brian, henry));
        System.out.println("Sorting by Phone Number:");
        Collections.sort(toSortPhone, new Orderings.phoneNumberOrdering());
        for(int i = 0; i < toSortPhone.size(); i++) {
            System.out.println(toSortPhone.get(i).number().getPHONE_NUMBER());
        }
        System.out.println("Sorting by Owner:");
        Collections.sort(toSortPhone, new Orderings.phoneOwnerOrdering());
        for(int i = 0; i < toSortPhone.size(); i++) {
            System.out.println(toSortPhone.get(i).getOwner());
        }
        // Sorting Testing for ordering computers by their screen size, brand names, and amount of RAM
        SmartPhone eric = new SmartPhone("Eric", 7898885085L, Computer.State.ON, 500, 750, 1000);
        SmartPhone isaac = new SmartPhone("Isaac", 5678978888L, Computer.State.ON, 750, 1000, 2000);
        Laptop emma = new Laptop(Computer.State.ON, 200, 7000, 1000, "Apple", "Emma");
        Laptop jay = new Laptop(Computer.State.ON, 2000, 2000, 2000, "HyperLoad", "Jay");
        Laptop tyler = new Laptop(Computer.State.OFF, 1980, 5000, 1, "Deku", "Tyler");
        ArrayList<Computer> toSortComputer = new ArrayList<>(Arrays.asList(henry,eric,isaac,emma,jay,tyler));
        Collections.sort(toSortComputer, new Orderings.computerSizeOrdering());
        System.out.println("Sorting by size:");
        for(int i = 0; i < toSortComputer.size(); i++) {
            System.out.println(toSortComputer.get(i).getScreenSize());
        }
        // We are going through the RAM instead. The order should be (7000, 5000, 2000, 1, 750, 1000).
        System.out.println("Sorting by brand but by RAM:");
        Collections.sort(toSortComputer, new Orderings.computerBrandOrdering());
        for(int i = 0; i < toSortComputer.size(); i++) {
            System.out.println(toSortComputer.get(i).getRAM());
        }
        System.out.println("Sorting by RAM:");
        Collections.sort(toSortComputer, new Orderings.computerRAMOrdering());
        for(int i = 0; i < toSortComputer.size(); i++) {
            System.out.println(toSortComputer.get(i).getRAM());
        }
        // It seems like calling works normally...
        OldLandline spike = new Landline("Spike", 8761234444L);
        Phone naruto = new Landline("Naruto", 9998882341L);
        Phone sasuke = new SmartPhone ("Sasuke", 2228882341L, Computer.State.ON, 1, 1, 1);
        Phone situ = new OldLandline("Situ", 1234567890L);

        situ.call(sasuke);
        spike.call(naruto);
        situ.end();
        situ.call(spike); // You can still leave a message, apparently.
        ((SmartPhone) sasuke).installGame("Cool"); // you'd have to change the apparent type through typecasting if you want to use its methods...
        SmartPhone annie = new SmartPhone("Annie", "5532347898", Computer.State.ON, 500, 750, 1000);
        annie.call(sasuke);


        // Landline message testing. Tests message methods to ensure everything works properly.
        kevin.call(domenico);
        domenico.end();
        domenico.readMessages();
        domenico.readMessages(Landline.MSG_STATUS.UNREAD);
        domenico.readMessages(Landline.MSG_STATUS.READ);

    }
}
