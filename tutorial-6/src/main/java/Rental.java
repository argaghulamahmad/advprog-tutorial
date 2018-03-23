class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    double getThisAmount() {
        double result = 0;
        // Determine amount for each line
        if (getMovie().getPriceCode() == Movie.REGULAR) {
            result += 2;
            if (getDaysRented() > 2) {
                result += (getDaysRented() - 2) * 1.5;
            }

        } else if (getMovie().getPriceCode() == Movie.NEW_RELEASE) {
            result += getDaysRented() * 3;

        } else if (getMovie().getPriceCode() == Movie.CHILDREN) {
            result += 1.5;
            if (getDaysRented() > 3) {
                result += (getDaysRented() - 3) * 1.5;
            }

        }
        return result;
    }

    int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}