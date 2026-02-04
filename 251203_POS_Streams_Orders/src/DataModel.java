import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DataModel {

    // your turn: make the singleton great again.

    private static DataModel INSTANCE;

    public static DataModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataModel();
            INSTANCE.init();
        }
        return INSTANCE;
    }


    // your turn: create and implement the missing classes.
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();


    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void init() {
        initCustomer();
        initProduct();
        initOrder();

        initOrderProductionRelation();

    }

    private void initOrderProductionRelation() {
        Map<Integer, List<Integer>> relation = new HashMap<>();
        for (int i = 1; i <= 50; i++) {
            relation.put(i, new ArrayList<>());
        }
        relation.get(1).add(19);
        relation.get(1).add(21);
        relation.get(1).add(5);
        relation.get(2).add(17);
        relation.get(2).add(11);
        relation.get(2).add(14);
        relation.get(2).add(13);
        relation.get(3).add(5);
        relation.get(3).add(3);
        relation.get(3).add(19);
        relation.get(3).add(13);
        relation.get(3).add(15);
        relation.get(4).add(22);
        relation.get(4).add(26);
        relation.get(4).add(12);
        relation.get(5).add(5);
        relation.get(6).add(5);
        relation.get(6).add(12);
        relation.get(7).add(8);
        relation.get(7).add(25);
        relation.get(7).add(21);
        relation.get(7).add(1);
        relation.get(7).add(13);
        relation.get(7).add(10);
        relation.get(8).add(12);
        relation.get(8).add(8);
        relation.get(9).add(8);
        relation.get(10).add(14);
        relation.get(10).add(8);
        relation.get(11).add(12);
        relation.get(11).add(6);
        relation.get(11).add(21);
        relation.get(11).add(22);
        relation.get(11).add(27);
        relation.get(11).add(11);
        relation.get(12).add(19);
        relation.get(12).add(13);
        relation.get(12).add(11);
        relation.get(12).add(6);
        relation.get(13).add(11);
        relation.get(13).add(24);
        relation.get(13).add(26);
        relation.get(13).add(23);
        relation.get(14).add(18);
        relation.get(15).add(16);
        relation.get(15).add(13);
        relation.get(15).add(7);
        relation.get(16).add(23);
        relation.get(16).add(29);
        relation.get(16).add(18);
        relation.get(16).add(16);
        relation.get(16).add(22);
        relation.get(16).add(26);
        relation.get(17).add(18);
        relation.get(17).add(4);
        relation.get(18).add(13);
        relation.get(18).add(3);
        relation.get(18).add(27);
        relation.get(18).add(2);
        relation.get(19).add(26);
        relation.get(19).add(22);
        relation.get(19).add(18);
        relation.get(19).add(14);
        relation.get(19).add(15);
        relation.get(19).add(13);
        relation.get(20).add(22);
        relation.get(21).add(21);
        relation.get(21).add(26);
        relation.get(22).add(7);
        relation.get(22).add(6);
        relation.get(23).add(27);
        relation.get(23).add(7);
        relation.get(23).add(11);
        relation.get(23).add(5);
        relation.get(24).add(24);
        relation.get(24).add(2);
        relation.get(24).add(6);
        relation.get(24).add(28);
        relation.get(24).add(4);
        relation.get(25).add(28);
        relation.get(25).add(17);
        relation.get(25).add(2);
        relation.get(25).add(29);
        relation.get(25).add(19);
        relation.get(26).add(4);
        relation.get(27).add(6);
        relation.get(27).add(15);
        relation.get(27).add(24);
        relation.get(28).add(22);
        relation.get(28).add(9);
        relation.get(29).add(22);
        relation.get(30).add(29);
        relation.get(30).add(6);
        relation.get(30).add(8);
        relation.get(31).add(16);
        relation.get(31).add(12);
        relation.get(31).add(28);
        relation.get(32).add(8);
        relation.get(32).add(5);
        relation.get(33).add(12);
        relation.get(33).add(26);
        relation.get(33).add(21);
        relation.get(33).add(23);
        relation.get(33).add(29);
        relation.get(33).add(13);
        relation.get(34).add(1);
        relation.get(34).add(6);
        relation.get(34).add(22);
        relation.get(34).add(19);
        relation.get(34).add(13);
        relation.get(34).add(27);
        relation.get(35).add(5);
        relation.get(35).add(11);
        relation.get(35).add(26);
        relation.get(35).add(9);
        relation.get(36).add(28);
        relation.get(36).add(7);
        relation.get(37).add(15);
        relation.get(37).add(11);
        relation.get(38).add(18);
        relation.get(38).add(11);
        relation.get(38).add(14);
        relation.get(38).add(20);
        relation.get(38).add(7);
        relation.get(39).add(1);
        relation.get(39).add(21);
        relation.get(40).add(12);
        relation.get(40).add(10);
        relation.get(40).add(11);
        relation.get(40).add(29);
        relation.get(40).add(1);
        relation.get(41).add(13);
        relation.get(41).add(19);
        relation.get(41).add(5);
        relation.get(41).add(29);
        relation.get(41).add(14);
        relation.get(41).add(4);
        relation.get(42).add(2);
        relation.get(43).add(6);
        relation.get(44).add(20);
        relation.get(44).add(18);
        relation.get(44).add(8);
        relation.get(44).add(24);
        relation.get(44).add(26);
        relation.get(44).add(13);
        relation.get(45).add(23);
        relation.get(45).add(1);
        relation.get(45).add(25);
        relation.get(45).add(15);
        relation.get(46).add(16);
        relation.get(46).add(24);
        relation.get(46).add(19);
        relation.get(46).add(13);
        relation.get(46).add(11);
        relation.get(47).add(23);
        relation.get(47).add(28);
        relation.get(47).add(20);
        relation.get(47).add(21);
        relation.get(48).add(15);
        relation.get(48).add(3);
        relation.get(48).add(26);
        relation.get(48).add(7);
        relation.get(48).add(19);
        relation.get(48).add(10);
        relation.get(49).add(5);
        relation.get(49).add(13);
        relation.get(49).add(29);
        relation.get(49).add(3);
        relation.get(49).add(12);
        relation.get(49).add(17);
        relation.get(50).add(15);
        relation.get(50).add(16);

        relation.forEach((k, v) -> {
            for (int p : v) {
                orders.get(k - 1).addProduct(products.get(p - 1));
            }
        });
    }

    private void initOrder() {

        orders = new ArrayList<>();
        //Order(id, orderDate, deliveryDate, status, customerId)
        orders.add(new Order(1, "2021-02-28", "2021-03-08", "NEW", 5)); //why are all args constructer bad? -> too many args
        orders.add(new Order(2, "2021-02-28", "2021-03-05", "NEW", 3));
        orders.add(new Order(3, "2021-04-10", "2021-04-18", "DELIVERED", 5));
        orders.add(new Order(4, "2021-03-22", "2021-03-27", "PENDING", 3));
        orders.add(new Order(5, "2021-03-04", "2021-03-12", "NEW", 1));
        orders.add(new Order(6, "2021-03-30", "2021-04-07", "DELIVERED", 9));
        orders.add(new Order(7, "2021-03-05", "2021-03-09", "PENDING", 8));
        orders.add(new Order(8, "2021-03-27", "2021-04-05", "NEW", 4));
        orders.add(new Order(9, "2021-04-14", "2021-04-18", "NEW", 10));
        orders.add(new Order(10, "2021-03-10", "2021-03-19", "NEW", 8));
        orders.add(new Order(11, "2021-04-01", "2021-04-04", "DELIVERED", 1));
        orders.add(new Order(12, "2021-02-24", "2021-02-28", "PENDING", 5));
        orders.add(new Order(13, "2021-03-15", "2021-03-21", "NEW", 5));
        orders.add(new Order(14, "2021-03-30", "2021-04-07", "PENDING", 4));
        orders.add(new Order(15, "2021-03-13", "2021-03-14", "DELIVERED", 5));
        orders.add(new Order(16, "2021-03-13", "2021-03-21", "NEW", 1));
        orders.add(new Order(17, "2021-03-31", "2021-03-31", "DELIVERED", 6));
        orders.add(new Order(18, "2021-03-25", "2021-03-31", "PENDING", 9));
        orders.add(new Order(19, "2021-02-28", "2021-03-09", "DELIVERED", 9));
        orders.add(new Order(20, "2021-03-23", "2021-03-30", "NEW", 5));
        orders.add(new Order(21, "2021-03-19", "2021-03-24", "DELIVERED", 9));
        orders.add(new Order(22, "2021-02-27", "2021-03-01", "NEW", 5));
        orders.add(new Order(23, "2021-04-19", "2021-04-24", "PENDING", 4));
        orders.add(new Order(24, "2021-03-24", "2021-03-24", "DELIVERED", 1));
        orders.add(new Order(25, "2021-03-03", "2021-03-10", "NEW", 1));
        orders.add(new Order(26, "2021-03-17", "2021-03-26", "NEW", 10));
        orders.add(new Order(27, "2021-03-20", "2021-03-25", "NEW", 1));
        orders.add(new Order(28, "2021-04-09", "2021-04-16", "DELIVERED", 2));
        orders.add(new Order(29, "2021-04-06", "2021-04-08", "PENDING", 1));
        orders.add(new Order(30, "2021-04-19", "2021-04-20", "DELIVERED", 1));
        orders.add(new Order(31, "2021-03-03", "2021-03-04", "NEW", 3));
        orders.add(new Order(32, "2021-03-15", "2021-03-24", "DELIVERED", 2));
        orders.add(new Order(33, "2021-04-18", "2021-04-24", "PENDING", 1));
        orders.add(new Order(34, "2021-03-28", "2021-03-28", "NEW", 6));
        orders.add(new Order(35, "2021-03-15", "2021-03-17", "NEW", 1));
        orders.add(new Order(36, "2021-03-04", "2021-03-08", "DELIVERED", 2));
        orders.add(new Order(37, "2021-03-18", "2021-03-25", "NEW", 8));
        orders.add(new Order(38, "2021-04-11", "2021-04-20", "NEW", 8));
        orders.add(new Order(39, "2021-04-12", "2021-04-17", "NEW", 9));
        orders.add(new Order(40, "2021-03-12", "2021-03-12", "PENDING", 3));
        orders.add(new Order(41, "2021-02-24", "2021-02-26", "NEW", 5));
        orders.add(new Order(42, "2021-04-08", "2021-04-14", "DELIVERED", 9));
        orders.add(new Order(43, "2021-03-03", "2021-03-11", "NEW", 3));
        orders.add(new Order(44, "2021-03-12", "2021-03-14", "DELIVERED", 4));
        orders.add(new Order(45, "2021-04-01", "2021-04-06", "DELIVERED", 1));
        orders.add(new Order(46, "2021-03-16", "2021-03-22", "NEW", 10));
        orders.add(new Order(47, "2021-04-07", "2021-04-12", "PENDING", 2));
        orders.add(new Order(48, "2021-04-05", "2021-04-06", "NEW", 2));
        orders.add(new Order(49, "2021-04-10", "2021-04-13", "NEW", 7));
        orders.add(new Order(50, "2021-03-18", "2021-03-21", "NEW", 9));

        for (Order o : orders) {
            o.setCustomer(customers.get(o.getCustomerId() - 1));
        }
    }

    private void initCustomer() {
        customers = new ArrayList<>();
        //Customer(id, name, tier)
        customers.add(new Customer(1, "Stefan Walker", 1));
        customers.add(new Customer(2, "Daija Von", 1));
        customers.add(new Customer(3, "Ariane Rodriguez", 1));
        customers.add(new Customer(4, "Marques Nikolaus", 2));
        customers.add(new Customer(5, "Rachelle Greenfelder", 0));
        customers.add(new Customer(6, "Larissa White", 2));
        customers.add(new Customer(7, "Fae Heidenreich", 1));
        customers.add(new Customer(8, "Dino Will", 2));
        customers.add(new Customer(9, "Eloy Stroman", 1));
        customers.add(new Customer(10, "Brisa O'Connell", 1));
    }

    private void initProduct() {
        products = new ArrayList<>();
        //Product(id, name, category, price)
        products.add(new Product(1, "omnis quod consequatur", "Games", 184.83));
        products.add(new Product(2, "vel libero suscipit", "Toys", 12.66));
        products.add(new Product(3, "non nemo iure", "Grocery", 498.02));
        products.add(new Product(4, "voluptatem voluptas aspernatur", "Toys", 536.80));
        products.add(new Product(5, "animi cum rem", "Games", 458.20));
        products.add(new Product(6, "dolorem porro debitis", "Toys", 146.52));
        products.add(new Product(7, "aspernatur rerum qui", "Books", 656.42));
        products.add(new Product(8, "deleniti earum et", "Baby", 41.46));
        products.add(new Product(9, "voluptas ut quidem", "Books", 697.57));
        products.add(new Product(10, "eos sed debitis", "Baby", 366.90));
        products.add(new Product(11, "laudantium sit nihil", "Toys", 95.50));
        products.add(new Product(12, "ut perferendis corporis", "Grocery", 302.19));
        products.add(new Product(13, "sint voluptatem ut", "Toys", 295.37));
        products.add(new Product(14, "quos sunt ipsam", "Grocery", 534.64));
        products.add(new Product(15, "qui illo error", "Baby", 623.58));
        products.add(new Product(16, "aut ex ducimus", "Books", 551.39));
        products.add(new Product(17, "accusamus repellendus minus", "Books", 240.58));
        products.add(new Product(18, "aut accusamus quia", "Baby", 881.38));
        products.add(new Product(19, "doloremque incidunt sed", "Games", 988.49));
        products.add(new Product(20, "libero omnis velit", "Baby", 177.61));
        products.add(new Product(21, "consectetur cupiditate sunt", "Toys", 95.46));
        products.add(new Product(22, "itaque ea qui", "Baby", 677.78));
        products.add(new Product(23, "non et nulla", "Grocery", 70.49));
        products.add(new Product(24, "veniam consequatur et", "Books", 893.44));
        products.add(new Product(25, "magnam adipisci voluptate", "Grocery", 366.13));
        products.add(new Product(26, "reiciendis consequuntur placeat", "Toys", 359.27));
        products.add(new Product(27, "dolores ipsum sit", "Toys", 786.99));
        products.add(new Product(28, "ut hic tempore", "Toys", 316.09));
        products.add(new Product(29, "quas quis deserunt", "Toys", 772.78));
        products.add(new Product(30, "excepturi nesciunt accusantium", "Toys", 911.46));
    }

    public static void main(String[] args) {
        DataModel dataModel = new DataModel();
        dataModel.init();
    }
}