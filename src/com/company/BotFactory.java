package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotFactory {

    //read instruction list
    //start input list - input hold more than one?
    //start output list - output hold more than one?
    //start bot list
    //iterate and parse instructions assigning to bot list
        //value "goes to" means assigned to at start?
        //only transfer chips if bot holds two chips to process higher and lower
            //do bots only drop both items once, or do they refill?


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

    private static void processInstructions(){

        try {
            List<String> instructionsList = readInstructions();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
