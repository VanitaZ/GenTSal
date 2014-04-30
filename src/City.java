public class City {
    final int id;

    public City(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                '}';
    }
}
