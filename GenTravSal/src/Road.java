public class Road {
    final int length;

    public Road(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                '}';
    }
}
