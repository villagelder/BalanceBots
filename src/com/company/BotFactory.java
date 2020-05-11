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
    private static Map<String, List<Integer>> outputBins;
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
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void parseInstructions(String instruction) {

        if (instruction.startsWith("bot")) {
            processBotInstruction(instruction);
        } else if (instruction.startsWith("value")) {
            processValueInstruction(instruction);
        }


    }

    private static void processValueInstruction(String instruction) {
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
            inputBin.add(instruction);
        }
    }

    private static void processBotInstruction(String instruction) {
        List<String> inList = new ArrayList<>();
    }


}
