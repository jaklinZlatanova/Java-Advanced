package halloween;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return this.data.removeIf(d ->
                d.getName().equals(name));
    }

    public Kid getKid(String street) {
        return this.data.stream()
                .filter(e ->
                        e.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }
    public int getAllKids() {
        return this.data.size();

    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Children who visited a house for candy: "));
        builder.append(System.lineSeparator());

        for (Kid kid : this.data) {
            builder.append(String.format("%s from %s street",kid.getName(),kid.getStreet())) ;
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
