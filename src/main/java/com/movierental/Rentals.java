package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this) {
            frequentRenterPoints += each.frequentRentalPoint();
        }
        return frequentRenterPoints;
    }

    double totalAmount() {
        double totalAmount = 0;
        for (Rental each : this) {
            totalAmount += each.amount();
        }
        return totalAmount;
    }
}
