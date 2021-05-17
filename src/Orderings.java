import java.util.Comparator;

/**
 * The <code>Orderings<code> class implements the orderings that were provided in the homework implementation.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
class Orderings {
    public static class phoneNumberOrdering implements Comparator {
        @Override
        public int compare(java.lang.Object o1, java.lang.Object o2) {
            Phone w1 = (Phone) o1;
            Phone w2 = (Phone) o2;
            return Long.compare(w1.number().getPHONE_NUMBER(), w2.number().getPHONE_NUMBER());
        }
    }
    public static class phoneOwnerOrdering implements Comparator {
        @Override
        public int compare(java.lang.Object o1, java.lang.Object o2) {
            Phone w1 = (Phone) o1;
            Phone w2 = (Phone) o2;
            return w1.getOwner().compareToIgnoreCase(w2.getOwner());
        }
    }
    public static class computerSizeOrdering implements Comparator {
        @Override
        public int compare(java.lang.Object o1, java.lang.Object o2) {
            Computer w1 = (Computer) o1;
            Computer w2 = (Computer) o2;
            return Integer.compare(w1.getScreenSize(), w2.getScreenSize());
        }
    }
    public static class computerBrandOrdering implements Comparator {
        @Override
        public int compare(java.lang.Object o1, java.lang.Object o2) {
            if(o1 instanceof SmartPhone)
                return 1;
            else if(o2 instanceof SmartPhone)
                return -1;
            Laptop w1 = (Laptop) o1;
            Laptop w2 = (Laptop) o2;
            return w1.getBrand().compareToIgnoreCase(w2.getBrand());
        }
    }
    public static class computerRAMOrdering implements Comparator {
        @Override
        public int compare(java.lang.Object o1, java.lang.Object o2) {
            Computer w1 = (Computer) o1;
            Computer w2 = (Computer) o2;
            return Integer.compare(w1.getRAM(), w2.getRAM());
        }
    }

}
