package domain;

import service.CustomerService;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path csv = Path.of("src/main/resources/persons.csv");
        CustomerParser parser = new CustomerParser();

        try {
            CustomerService service = new CustomerService(csv, parser);

            long totalCustomers = service.getCustomers().count();
            System.out.println("Loaded customers: " + totalCustomers);

            System.out.println("Total age: " + service.getTotalAge());

            System.out.println("Countries (sorted): " + service.getAllCountries());

            System.out.println("Youngest in Portugal: " + service.getYoungestCustomerByCountry("Portugal"));

            System.out.println("Group sizes by country:");
            service.getCustomersGroupedByCountry().forEach((country, list) ->
                    System.out.println(country + " -> " + list.size())
            );

            System.out.println("First 5 customers:");
            service.getCustomers().limit(5).forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Failed to read CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
