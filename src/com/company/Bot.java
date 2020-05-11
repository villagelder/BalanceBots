package com.company;

import java.util.TreeSet;

public class Bot {

    private int id;
    private int lowDestination;  // 0-bot, 1-output
    private int lowDestinationID; // id of destination
    private int highDestination;  // 0-bot, 1-output
    private int highDestinationID; //id of destination
    private TreeSet<Integer> holdingValues;

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

    public TreeSet<Integer> getHoldingValues() {
        return holdingValues;
    }

    public void setHoldingValues(TreeSet<Integer> holdingValues) {
        this.holdingValues = holdingValues;
    }
}