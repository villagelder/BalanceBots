package com.company;

public class Bot {

    private int id;
    private int lowDestination;  // 0-bot, 1-output
    private int lowDestinationID; // id of destination
    private int highDestination;  // 0-bot, 1-output
    private int highDestinationID; //id of destination

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLowDestination() {
        return lowDestination;
    }

    public void setLowDestination(int lowDestination) {
        this.lowDestination = lowDestination;
    }

    public int getLowDestinationID() {
        return lowDestinationID;
    }

    public void setLowDestinationID(int lowDestinationID) {
        this.lowDestinationID = lowDestinationID;
    }

    public int getHighDestination() {
        return highDestination;
    }

    public void setHighDestination(int highDestination) {
        this.highDestination = highDestination;
    }

    public int getHighDestinationID() {
        return highDestinationID;
    }

    public void setHighDestinationID(int highDestinationID) {
        this.highDestinationID = highDestinationID;
    }



}
