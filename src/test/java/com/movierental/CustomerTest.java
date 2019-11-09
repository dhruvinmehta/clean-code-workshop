package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void test_regular_movie_2_days() {
        String customerName = "John";
        String movieName = "LOTR";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.REGULAR), 2));

        String expected = "Rental Record for John\n" +
                "\tLOTR\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.statement());
    }

    @Test
    public void test_regular_movie_3_days() {
        String customerName = "John";
        String movieName = "LOTR";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.REGULAR), 3));

        String expected = "Rental Record for John\n" +
                "\tLOTR\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.statement());
    }

    @Test
    public void test_new_release_movie_1_days() {
        String customerName = "John";
        String movieName = "Star wars 9";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.NEW_RELEASE), 1));

        String expected = "Rental Record for John\n" +
                "\tStar wars 9\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.statement());
    }

    @Test
    public void test_new_release_movie_2_days_regular_1_day() {
        String customerName = "John";
        String movieName1 = "End Game";
        String movieName2 = "LOTR";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1,  Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie(movieName2,  Movie.REGULAR), 1));

        String expected = "Rental Record for John\n" +
                "\tEnd Game\t6.0\n" +
                "\tLOTR\t2.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 3 frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.statement());
    }

    @Test
    public void test_children_movie_3_days() {
        String customerName = "John";
        String movieName = "ET";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.CHILDRENS), 3));

        String expected = "Rental Record for John\n" +
                "\tET\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.statement());
    }

    @Test
    public void test_children_movie_5_days() {
        String customerName = "John";
        String movieName = "ET";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.CHILDRENS), 5));

        String expected = "Rental Record for John\n" +
                "\tET\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.statement());
    }
}