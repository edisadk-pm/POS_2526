import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Order {
    //Order(id, orderDate, deliveryDate, status, customerId)

    private Integer id;
    private LocalDate date; //why not orderDate? -> because of simplicity
                            //why LocalDate? -> because date only, no time needed
    private LocalDate delivery;
    private String status;
    private Integer customerId;

    //what is a set? -> a collection of unique items
    //what is a HashSet? -> a set that uses a hash table for storage
    //why use a set for products? -> because an order can have multiple products, but no duplicates
    //what is a hash table? -> a data structure that maps keys to values for efficient lookup

    Set<Product> products = new HashSet<>();
    private Customer customer;

    public Order(int id, String date, String delivery, String status, int customerId) {
        this.id = id;
        this.date = LocalDate.parse(date);
        this.delivery = LocalDate.parse(delivery);
        this.status = status;
        this.customerId = customerId;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDate delivery) {
        this.delivery = delivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", delivery=" + delivery +
                ", status='" + status + '\'' +
                ", customer=" + (customer == null ? "null" : customer.toString()) +
                ", products=" + products +
                '}';
    }
}
