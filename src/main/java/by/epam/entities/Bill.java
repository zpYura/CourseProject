package by.epam.entities;

import java.io.Serializable;

/**
 * Describes entity Bill
 *
 * @version 1.0 11 Nov 2015
 * @author Yury Druzenok
 */
public class Bill  extends Entity implements Serializable{
    int cost;

    public Bill() {
    }

    public Bill(int id, int cost) {
        super(id);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "cost=" + cost +
                "} " + super.toString();
    }
}
