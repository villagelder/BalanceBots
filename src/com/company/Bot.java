package com.company;

import java.util.TreeSet;

public class Bot {

    private String id;
    private String lowDestination;  // bot or output
    private String lowDestinationID; // id of destination
    private String highDestination;  //bot or output
    private String highDestinationID; //id of destination
    private TreeSet<String> holdingValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLowDestination() {
        return lowDestination;
    }

    public void setLowDestination(String lowDestination) {
        this.lowDestination = lowDestination;
    }

    public String getHighDestination() {
        return highDestination;
    }

    public void setHighDestination(String highDestination) {
        this.highDestination = highDestination;
    }

    public String getLowDestinationID() {
        return lowDestinationID;
    }

    public void setLowDestinationID(String lowDestinationID) {
        this.lowDestinationID = lowDestinationID;
    }

    public String getHighDestinationID() {
        return highDestinationID;
    }

    public void setHighDestinationID(String highDestinationID) {
        this.highDestinationID = highDestinationID;
    }

    public TreeSet<String> getHoldingValues() {
        return holdingValues;
    }

    public void setHoldingValues(TreeSet<String> holdingValues) {
        this.holdingValues = holdingValues;
    }
}
