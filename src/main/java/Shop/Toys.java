package Shop;

import java.util.Objects;

public class Toys {
    private int id;
    private String name;
    private int amount;
    private int weight;

    public Toys(int id, String name, int amount, int weight) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Toys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                '}';
    }
}
