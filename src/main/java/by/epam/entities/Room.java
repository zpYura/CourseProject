package by.epam.entities;

import by.epam.enums.ApartmentType;

import java.util.Date;

/**
 * Describes entity Room
 *
 * @version 1.0 11 Nov 2015
 * @author Yury Druzenok
 */
public class Room extends Entity {
    int numberOfbeds;
    ApartmentType type;
    int costPerDay;
    Date releaseDate;

    public Room() {
    }

    public Room(int id, int numberOfbeds, ApartmentType type, int costPerDay, Date releaseDate) {
        super(id);
        this.numberOfbeds = numberOfbeds;
        this.type = type;
        this.costPerDay = costPerDay;
        this.releaseDate = releaseDate;
    }

    public int getNumberOfbeds() {
        return numberOfbeds;
    }

    public void setNumberOfbeds(int numberOfbeds) {
        this.numberOfbeds = numberOfbeds;
    }

    public ApartmentType getType() {
        return type;
    }

    public void setType(ApartmentType type) {
        this.type = type;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberOfbeds=" + numberOfbeds +
                ", type=" + type +
                ", costPerDay=" + costPerDay +
                ", releaseDate=" + releaseDate +
                "} " + super.toString();
    }
}
