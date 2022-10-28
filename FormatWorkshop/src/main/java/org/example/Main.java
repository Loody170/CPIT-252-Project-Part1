package org.example;

import Adapter.VideoInformation;
import Adapter.YoutubeAdapter;
import com.convertapi.client.Config;
import com.convertapi.client.ConvertApi;
import com.convertapi.client.Param;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static javax.swing.JFileChooser.DIRECTORIES_ONLY;

public class Main {
    public static JPanel p = new JPanel();
    public static Scanner in = new Scanner(System.in);
    Log logger = Log.createInstance();

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Log logger = Log.createInstance();

        logger.info("Initiating Programm");

        System.out.println("*** Welcome to Format WorkShop, your best place for file conversion ***");
        System.out.println("*** Please select the type of file you want to convert from [Document, Image, Youtube video] ***");
        String answer = in.nextLine();

        ConverterFactory factory = new ConverterFactory();
        Converter converter = factory.getConverter(answer);
        logger.info("User picked and created a: " + answer + " converter");

        if(answer.equalsIgnoreCase("youtube video")){
            VideoInformation ytAdapter = new YoutubeAdapter(converter);
            System.out.println("*** Please type in the name of the YouTube video ***");
            answer = in.nextLine();
            logger.info("Video name is: " + answer);
            ytAdapter.searchByName(answer);
        }

        converter.init();
        while(true) {
            converter.getOptions();
            System.out.println("*** Please type in the name of the format you like to convert to: ***");
            answer = in.nextLine();
            if (converter.checkConversion(answer) == true) {
                converter.convert();
                break;
            } else {
                System.err.println("*** This format is incorrect or not compatiable. Please choose another one ***");
            }
        }//while loop
        System.out.println("*** Your file has been coverted succesfuly, thank you for using Factory WorkShop ***");
    }//main

}