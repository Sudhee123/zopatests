package com.Zopa;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    Faker faker = new Faker();
    Faker ukFaker = new Faker(new Locale("en-GB"));


    public String Firstname() {
        return faker.name().firstName();
    }

    public String LastName() {
        return faker.name().lastName();
    }

    public String EmailId() {
        return faker.internet().emailAddress();
    }

    public String RandomDigitDate() {
        return faker.random().nextInt(1, 28).toString();
    }

    public String RandomDigitMonth() {
        return faker.random().nextInt(1, 12).toString();
    }

    public String RandomDigitYear() {
        return faker.random().nextInt(19570, 1990).toString();
    }

    public String PhoneNumber()
    {
        return ukFaker.phoneNumber().toString();
    }

    public String PostCode() {
        return ukFaker.address().zipCode();
    }

    public int AnnualIncome() {
        return faker.random().nextInt(40000, 50000);
    }
}

