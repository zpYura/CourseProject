package by.epam.entities;

import java.io.Serializable;

/**
 * Describes guide table
 *
 * @author Yury Druzenok
 * @version 1.0 11 Nov 2015
 */
public class RoomGuide extends Entity implements Serializable {
    int roomId;
    int requestId;
    int billId;

    public RoomGuide() {
    }

    public RoomGuide(int id, int roomId, int requestId, int billId) {
        super(id);
        this.roomId = roomId;
        this.requestId = requestId;
        this.billId = billId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "RoomGuide{" +
                "roomId=" + roomId +
                ", requestId=" + requestId +
                ", billId=" + billId +
                "} " + super.toString();
    }
}
