public record Customer( //a record is a special kind of class in Java that is used to model immutable data, with final fields
    Integer id,
    String name,
    Integer tierId) {

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tierId=" + tierId +
                '}';
    }
}
