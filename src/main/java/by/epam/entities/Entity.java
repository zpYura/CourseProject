package by.epam.entities;

import java.io.Serializable;

/**
 * Describes common business entity
 *
 * @version 1.0 10 Nov 2015
 * @author Yury Druzenok
 */
public class Entity implements Serializable {
    //object's id
    private int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
