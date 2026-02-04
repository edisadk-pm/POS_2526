package domain;

import java.util.Arrays;
import java.util.Optional;

public class CustomerParser {
    //firstname,lastname,country,age(optional)

    public Optional<Customer> parse(String csv) { //here you should read the csv line and create a Customer object
        return Optional.ofNullable(csv)
                .map(s -> Arrays.stream(s.split(",", -1))
                        .map(String::trim)
                        .toArray(String[]::new))
                .filter(tokens -> tokens.length >= 3)
                .flatMap(tokens -> {
                    String first = tokens[0];
                    String last = tokens[1];
                    String country = tokens[2];

                    if (first.isBlank() || last.isBlank() || country.isBlank())
                        return Optional.empty();

                    int age = 0;
                    if (tokens.length > 3 && !tokens[3].isBlank()) {
                        try {
                            age = Integer.parseInt(tokens[3]);
                            if (age < 0) return Optional.empty();
                        } catch (NumberFormatException e) {
                            return Optional.empty();
                        }
                    }

                    try {
                        return Optional.of(new Customer(first, last, country, age));
                    } catch (IllegalArgumentException e) {
                        return Optional.empty();
                    }
                });
    }
}
