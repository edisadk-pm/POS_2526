package service;

import domain.Customer;
import domain.CustomerParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerService {

    private final Collection<Customer> customers;

    public CustomerService(Collection<Customer> customers) {
        this.customers = customers;
    }

    /**
     * Creates a CustomerService by reading customers from a given csv file.
     *
     * @param path   the path to the file
     * @param parser the parser
     * @throws IOException
     */

    public CustomerService(Path path, CustomerParser parser) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            this.customers = lines
                    .skip(1) // skip header
                    .map(parser::parse)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        }
    }

    public Stream<Customer> getCustomers() {
        return customers.stream();
    }

    /**
     * Returns a map of all customers grouped by their countries, sorted alphabetically
     *
     * @return the map with sorted keys and values
     */
    public SortedMap<String, List<Customer>> getCustomersGroupedByCountry() {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::country, TreeMap::new, Collectors.toList()));
    }

    /**
     * Returns the total age of all customers
     *
     * @return sum of all ages
     */
    public int getTotalAge() {
        return customers.stream().mapToInt(Customer::age).sum();
    }

    /**
     * Returns a stream of all customers with the given names, sorted by their countries
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the sorted stream
     */
    public Stream<Customer> getByName(String firstName, String lastName) {
        return customers.stream()
                .filter(c -> c.firstName().equals(firstName) && c.lastName().equals(lastName))
                .sorted(Comparator.comparing(Customer::country));
    }

    /**
     * Returns one of the youngest customers from a given country
     *
     * @param country the country
     * @return the customer, wrapped in an Optional
     */
    public Optional<Customer> getYoungestCustomerByCountry(String country) {
        return customers.stream()
                .filter(c -> c.country().equals(country))
                .min(Comparator.comparingInt(Customer::age));
    }

    /**
     * Returns all countries alphabetically sorted
     *
     * @return the countries
     */
    public SortedSet<String> getAllCountries() {
        return customers.stream()
                .map(Customer::country)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
