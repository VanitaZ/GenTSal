public class City {
    int id;

    public City(int id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o instanceof City) {
            City c = (City) o;
            return this.id == c.id;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                '}';
    }
}
