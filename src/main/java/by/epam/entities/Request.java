package by.epam.entities;

import by.epam.enums.ApartmentType;

import java.io.Serializable;
import java.util.Date;

/**
 * Describes entity Request
 *
 * @version 1.0 11 Nov 2015
 * @author Yury Druzenok
 */
public class Request extends Entity implements Serializable {
    int numberOfbeds;
    ApartmentType type;
    Date inDate;
    Date outDate;
    int maxCost;
    int minCost;
    int clientId;
    int adminId;

    public Request() {
    }

    public Request(int id, int numberOfbeds, ApartmentType type, Date inDate, Date outDate, int maxCost, int minCost, int clientId, int adminId) {
        super(id);
        this.numberOfbeds = numberOfbeds;
        this.type = type;
        this.inDate = inDate;
        this.outDate = outDate;
        this.maxCost = maxCost;
        this.minCost = minCost;
        this.clientId = clientId;
        this.adminId = adminId;
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

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(int maxCost) {
        this.maxCost = maxCost;
    }

    public int getMinCost() {
        return minCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "numberOfbeds=" + numberOfbeds +
                ", type=" + type +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", maxCost=" + maxCost +
                ", minCost=" + minCost +
                ", clientId=" + clientId +
                ", adminId=" + adminId +
                "} " + super.toString();
    }
}
