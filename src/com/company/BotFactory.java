package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BotFactory {

    //read instruction list
    //start input list
    //start output list - output hold more than one?
    //start bot list
    //iterate and parse instructions assigning to bot list
    //value "goes to" means assigned to at start?
    //only transfer chips if bot holds two chips to process higher and lower
    //do bots only drop both items once, or do they refill?

    private static List<String> inputBin;
    private static Map<String, List<String>> outputBins;
    private static Map<String, Bot> botsMap;

    private static List<String> readInstructions() throws IOException {
        InputStream input = BotFactory.class.getResourceAsStream("instructions.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(input));

        List<String> instructionsList = new ArrayList<>();

        String line = null;
        while ((line = br.readLine()) != null) {
            instructionsList.add(line);
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
        }
        return instructionsList;
    }

    private static void processInstructions() {
        inputBin = new ArrayList<>();
        outputBins = new HashMap<>();
        botsMap = new HashMap<>();

        try {
            List<String> instructionsList = readInstructions();
            for (String instruction : instructionsList)
                parseInstructions(instruction);

            do {

                Iterator it = botsMap.entrySet().iterator();
                while (it.hasNext()) {
                    Bot deliveredBot;
                    Map.Entry entry = (Map.Entry) it.next();
                    Bot workingBot = (Bot) entry.getValue();
                    if (workingBot.getHoldingValues().size() == 2) {
                        deliveredBot = deliverMicrochips(workingBot);
                        botsMap.put(deliveredBot.getId(), deliveredBot);
                    }

                }

            } while (!inputBin.isEmpty());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Bot deliverMicrochips(Bot workingBot) {
        String lowDest = workingBot.getLowDestination();
        String lowDestID = workingBot.getLowDestinationID();
        String highDest = workingBot.getHighDestination();
        String highDestID = workingBot.getHighDestinationID();
        String lowValue = workingBot.getHoldingValues().first();
        String highValue = workingBot.getHoldingValues().last();
        TreeSet<String> undeliveredList = new TreeSet<>();

        //attempt delivery twice

        for (String str : workingBot.getHoldingValues()) {
        //deliver low destination to output bin
        if (lowDest.equalsIgnoreCase("output")) {
            //check if output bin already represented and add to output bin
            if (outputBins.containsKey(lowDestID)) {

                List<String> valueList = outputBins.get(lowDest);
                valueList.add(lowValue);
                outputBins.put(lowDestID, valueList);

            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(lowValue);
                outputBins.put(lowDestID, valueList);
            }

            //deliver low destination to bot
        } else if (lowDest.equalsIgnoreCase("bot")) {
            //check if bot already has two assigned
            if (workingBot.getHoldingValues().size() > 1) {
                //cannot deliver
                //hold this item
                undeliveredList.add(lowValue);
            } else {
                TreeSet<String> valueList = workingBot.getHoldingValues();
                valueList.add(lowValue);
                workingBot.setHoldingValues(valueList);
            }

            //deliver high destination to output bin
        } else if (highDest.equalsIgnoreCase("output")) {
            //check if output bin already represented and add to output bin
            if (outputBins.containsKey(highDestID)) {

                List<String> valueList = outputBins.get(highDest);
                valueList.add(highValue);
                outputBins.put(lowDestID, valueList);

            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(highValue);
                outputBins.put(highDestID, valueList);
            }

            //deliver high destination to bot
        } else if (highDest.equalsIgnoreCase("bot")) {
            //check if bot already has two assigned
            if (workingBot.getHoldingValues().size() > 1) {
                //cannot deliver
                //hold this item
                undeliveredList.add(highValue);
            } else {
                TreeSet<String> valueList = workingBot.getHoldingValues();
                valueList.add(highValue);
                workingBot.setHoldingValues(valueList);
            }

        } }
        workingBot.setHoldingValues(undeliveredList);
        return workingBot;
    }


    private static void parseInstructions(String instruction) {

        if (instruction.startsWith("bot")) {
            setBotInstruction(instruction);
        } else if (instruction.startsWith("value")) {
            setValues(instruction);
        }
    }

    private static void setValues(String instruction) {
        List<String> inList = Arrays.asList(instruction.split(" "));
        Bot bot;
        if (botsMap.containsKey(inList.get(5))) {
            bot = botsMap.get(inList.get(5));
        } else {
            bot = new Bot();
            bot.setId(inList.get(5));
        }

        if (bot.getHoldingValues().isEmpty() || bot.getHoldingValues().size() < 2) {
            bot.getHoldingValues().add(inList.get(1));
            botsMap.put(bot.getId(), bot);

        } else {
            //if bot already holds two microships then value instructions must be placed in input bin
            inputBin.add(instruction);
        }
    }

    private static void setBotInstruction(String instruction) {
        List<String> inList = Arrays.asList(instruction.split(" "));
        Bot bot;
        if (botsMap.containsKey(inList.get(1))) {
            bot = botsMap.get(inList.get(1));
        } else {
            bot = new Bot();
            bot.setId(inList.get(1));
            bot.setLowDestination(inList.get(5));
            bot.setLowDestinationID(inList.get(6));
            bot.setHighDestination(inList.get(10));
            bot.setHighDestinationID(inList.get(11));
        }
    }


}
