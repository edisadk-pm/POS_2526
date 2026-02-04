import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//die erklärungen bitte alle auf deutsch! verstanden? -> verstanden!
public class HomeWork {

    public List<Product> books(String category, double price) {
        // Obtain a list of products belongs to category "Books" with price > 100
        List<Product> products = DataModel.getInstance().getProducts();
        return products.stream()
                .filter(p -> p.getCategory().equals(category.toUpperCase()) && p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<Order> babies() {
        // Obtain a list of order with products belong to category "Baby"
        //NO ANYMATCH HERE
        List<Order> orders = DataModel.getInstance().getOrders();
        return orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equals("Baby"))) //anymatch returns true if any product in the order belongs to category "Baby" and false otherwise
                .collect(Collectors.toList());

        //now without anyMatch
    }

    public List<Product> discount(List<Product> products){
        // Obtain a list of all Toys with a price reduction of 10%
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(p ->
                        new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9)) //map creates a new product list with the discounted price
                .collect(Collectors.toList());
    }

    public List<Product> tier2(List<Order> orders) {
        // Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        LocalDate today = LocalDate.parse("01,feb,2021", java.time.format.DateTimeFormatter.ofPattern("dd,LLL,yyyy")); //LLL Means locally sensitive month
        return orders.stream()
                .filter(o -> o.getCustomer().tierId() == 2)
                .filter(o -> o.getDate().isAfter(LocalDate.of(2021, 2, 1)) && o.getDate().isBefore(LocalDate.of(2021, 4, 1)))
                .flatMap(o -> o.getProducts().stream()) //flatMap flattens the stream of orders to a stream of products -> auf deutsch: "flacht den Stream von Bestellungen zu einem Stream von Produkten ab"
                .distinct() //distinct entfernt doppelte Produkte
                .collect(Collectors.toList());
    }

    public Product cheapest(List<Product> products){
        // Get the cheapest products of “Books” category
        return products.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public List<Order> getNextThree(List<Order> orders){
        //Get the 3 most recent orders, dont use Comparator.comparing
        return orders.stream()
                .sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        HomeWork streamExamples = new HomeWork();
//        streamExamples.books("Baby", 500.0).forEach(System.out::println);
//        streamExamples.babies().forEach(System.out::println);
        streamExamples.discount(DataModel.getInstance().getProducts()).forEach(System.out::println);
//        //streamExamples.tier2(DataModel.getInstance().getOrders()).forEach(System.out::println);
//        System.out.println(streamExamples.cheapest(DataModel.getInstance().getProducts()));
//        streamExamples.getNextThree(DataModel.getInstance().getOrders()).forEach(System.out::println);

        //how to test if right -> manually check the output or write unit tests
        //what is a unit test -> a piece of code that tests a specific functionality of your code to ensure it works as expected
        //where do i do the unit test -> in a separate test class, usually in a test folder
        //code:
        /*
        @Test
        public void testBooks() {
            HomeWork hw = new HomeWork();
            List<Product> result = hw.books("Books", 100.0);
            assertEquals(3, result.size());
            for (Product p : result) {
                assertEquals("Books", p.getCategory());
                assertTrue(p.getPrice() > 100.0);
            }
         */
    }
}
