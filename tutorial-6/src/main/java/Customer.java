import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Iterator<Rental> iterator = rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";

        while (iterator.hasNext()) {
            Rental each = iterator.next();

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getThisAmount()) + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        Iterator<Rental> iterator = rentals.iterator();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            //Show figures for each rental
            result += each.getMovie().getTitle() + ": "
                    + String.valueOf(each.getThisAmount()) + "<BR>\n";
        }

        //Add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalAmount())
                + "</EM><P>\n";
        result += "On this rental you earned <EM>"
                + String.valueOf(getTotalFrequentRenterPoints())
                + "</EM> frequent renter points<P>";
        return result;
    }

    private double getTotalAmount() {
        double result = 0;
        for (Rental rental: rentals) {
            result += rental.getThisAmount();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental: rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}