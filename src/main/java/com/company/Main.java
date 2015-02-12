package com.company;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Usage: ShadedMaven <inputImage>");
            System.exit(1);
        }

        File imageFile = new File(args[0]);
        Tesseract instance = Tesseract.getInstance();

        //In case you don't have your own tessdata, let it also be extracted for you
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");

        //Set the tessdata path
        instance.setDatapath(tessDataFolder.getAbsolutePath());

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
