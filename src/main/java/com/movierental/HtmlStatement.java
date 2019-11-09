package com.movierental;

public class HtmlStatement {
    public String display(Rentals rentals, String customerName) {
        String result = "<h1>Rental Record for <b>" + customerName + "</b></h1><br />";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.amount()) + "<br />";
        }

        //add footer lines result
        result += "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br />";
        result += "You earned <b>" + String.valueOf(rentals.frequentRenterPoints())
                + "</b> frequent renter points";
        return result;
    }
}
