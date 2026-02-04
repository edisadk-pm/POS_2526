package domain;

public record Customer(String firstName, String lastName, String country, int age) {

    public Customer {
        if (firstName.isBlank() || lastName.isBlank() || country.isBlank())
            throw new IllegalArgumentException();
        if (age < 0)
            throw new IllegalArgumentException();
    }
}
