package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldGenerateTextInvoiceWhenRegularMovieIsRentedForTwoDays() {
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
    public void shouldGenerateTextInvoiceWhenRegularMovieIsRentedForThreeDays() {
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
    public void shouldGenerateTextInvoiceWhenNewReleaseMovieIsRentedForADay() {
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
    public void shouldGenerateTextInvoiceWhenNewReleaseAndRegularMoviesAreRented() {
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
    public void shouldGenerateTextInvoiceWhenChildrenMovieIsRentedForThreeDays() {
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
    public void shouldGenerateTextInvoiceWhenChildrenMovieIsRentedForFiveDays() {
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

    @Test
    public void shouldGenerateHtmlInvoiceWhenRegularMovieIsRentedForTwoDays() {
        String customerName = "John";
        String movieName = "LOTR";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.REGULAR), 2));

        String expected = "<h1>Rental Record for <b>John</b></h1><br />" +
                "\tLOTR\t2.0<br />" +
                "Amount owed is <b>2.0</b><br />" +
                "You earned <b>1</b> frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.htmlStatement());
    }

    @Test
    public void shouldGenerateHtmlInvoiceWhenRegularMovieIsRentedForThreeDays() {
        String customerName = "John";
        String movieName = "LOTR";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.REGULAR), 3));

        String expected = "<h1>Rental Record for <b>John</b></h1><br />" +
                "\tLOTR\t3.5<br />" +
                "Amount owed is <b>3.5</b><br />" +
                "You earned <b>1</b> frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.htmlStatement());
    }

    @Test
    public void shouldGenerateHtmlInvoiceWhenNewReleaseMovieIsRentedForADay() {
        String customerName = "John";
        String movieName = "Star wars 9";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.NEW_RELEASE), 1));

        String expected = "<h1>Rental Record for <b>John</b></h1><br />" +
                "\tStar wars 9\t3.0<br />" +
                "Amount owed is <b>3.0</b><br />" +
                "You earned <b>1</b> frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.htmlStatement());
    }

    @Test
    public void shouldGenerateHtmlInvoiceWhenNewReleaseAndRegularMoviesAreRented() {
        String customerName = "John";
        String movieName1 = "End Game";
        String movieName2 = "LOTR";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1,  Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie(movieName2,  Movie.REGULAR), 1));

        String expected = "<h1>Rental Record for <b>John</b></h1><br />" +
                "\tEnd Game\t6.0<br />" +
                "\tLOTR\t2.0<br />" +
                "Amount owed is <b>8.0</b><br />" +
                "You earned <b>3</b> frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.htmlStatement());
    }

    @Test
    public void shouldGenerateHtmlInvoiceWhenChildrenMovieIsRentedForThreeDays() {
        String customerName = "John";
        String movieName = "ET";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.CHILDRENS), 3));

        String expected = "<h1>Rental Record for <b>John</b></h1><br />" +
                "\tET\t1.5<br />" +
                "Amount owed is <b>1.5</b><br />" +
                "You earned <b>1</b> frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.htmlStatement());
    }

    @Test
    public void shouldGenerateHtmlInvoiceWhenChildrenMovieIsRentedForFiveDays() {
        String customerName = "John";
        String movieName = "ET";

        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName,  Movie.CHILDRENS), 5));

        String expected = "<h1>Rental Record for <b>John</b></h1><br />" +
                "\tET\t4.5<br />" +
                "Amount owed is <b>4.5</b><br />" +
                "You earned <b>1</b> frequent renter points";
        assertEquals("Actual and expected results should match", expected, customer.htmlStatement());
    }
}