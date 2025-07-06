package com.example.geektrust;

import com.example.geektrust.model.User;
import com.example.geektrust.service.HandleInputService;
import com.example.geektrust.service.SubscriptionService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            HandleInputService inputService= new HandleInputService();
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                inputService.processInput(sc.nextLine());
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }

}
