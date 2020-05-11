package com.company;

import java.util.TreeSet;

public class Bot {

    private String id;
    private String lowDestinationType;  // bot or output
    private String lowDestinationID; // id of destination
    private String highDestinationType;  //bot or output
    private String highDestinationID; //id of destination
    private TreeSet<Integer> holdingValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLowDestinationType() {
        return lowDestinationType;
    }

    public void setLowDestinationType(String lowDestinationType) {
        this.lowDestinationType = lowDestinationType;
    }

    public String getHighDestinationType() {
        return highDestinationType;
    }

    public void setHighDestinationType(String highDestinationType) {
        this.highDestinationType = highDestinationType;
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

    public TreeSet<Integer> getHoldingValues() {
        return holdingValues;
    }

    public void setHoldingValues(TreeSet<Integer> holdingValues) {
        this.holdingValues = holdingValues;
    }
}
