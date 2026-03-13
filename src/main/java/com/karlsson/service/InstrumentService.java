package com.karlsson.service;

import com.karlsson.entity.Instrument;
import com.karlsson.entity.Member;
import com.karlsson.repo.InstrumentRepository;

import java.util.List;
import java.util.Scanner;



public class InstrumentService {

    private final InstrumentRepository instrumentRepository;
    public InstrumentService(InstrumentRepository instrumentRepository) { this.instrumentRepository = instrumentRepository; }

    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public void listAllInstruments() {
        List<Instrument> instruments = getAllInstruments();
        for (Instrument instrument : instruments) {
            System.out.println(instrument.getType() + ", " + instrument.getBrand() + ", " + instrument.getName());
        }
    }

    public void createInstrument(Scanner userInput) {
        userInput.nextLine();
        Instrument.Type type = null;
        while (type == null) {
            System.out.println("What type of instrument is it? Guitar/Bass/Keyboard?");
            String input = userInput.nextLine().toUpperCase().trim();

            try {
                type = Instrument.Type.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid instrument type. Please try again.");
            }
        }
        System.out.println("What brand is it?");
        String brand = userInput.nextLine();
        System.out.println("What model is it?");
        String name = userInput.nextLine();
        System.out.println("How much does it cost per day to rent this item?");
        double cost = userInput.nextDouble();


        if (name == null || name.isBlank()) throw new IllegalArgumentException("Model cannot be null or blank");
        if (brand == null || brand.isBlank()) throw new IllegalArgumentException("Brand cannot be null or blank.");

        Instrument instrument = new Instrument(name.trim(), type, brand.trim(), cost);
        instrumentRepository.save(instrument);
    }

    public void deleteInstrument(Scanner userInput) {
        userInput.nextLine();
        System.out.println("Which instrument would you like to delete?");
        Instrument instrument = chooseInstrumentFromList(userInput);
        System.out.println("WARNING!!! Are you sure you want to delete this instrument? Y/N");
        if(userInput.nextLine().equals("Y") || userInput.nextLine().equals("y")) {
            instrumentRepository.delete(instrument);
            System.out.println("Instrument successfully deleted!");
        }
        else {
            System.out.println("Deletion aborted.");
        }
    }

    public void updateInstrument(Scanner userInput) {
        userInput.nextLine();
        System.out.println("Which instrument would you like to update?");
        Instrument instrument = chooseInstrumentFromList(userInput);

        //TODO logic for choosing which field to update
        userInput.nextLine();
        System.out.println("Please enter new Brand: ");
        String brand = userInput.nextLine();
        instrument.setBrand(brand);
        System.out.println("Please enter model/make: ");
        String model = userInput.nextLine();
        instrument.setName(model);
        Instrument.Type type = null;
        while (type == null) {
            System.out.println("What type of instrument is it? Guitar/Bass/Keyboard?");
            String input = userInput.nextLine().toUpperCase().trim();

            try {
                type = Instrument.Type.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid instrument type. Please try again.");
            }
        }
        System.out.println("What does it cost per day to rent this item? Old price: " + instrument.getPricePerDay() + " :-");
        try {
            double cost = userInput.nextDouble();
            instrument.setPricePerDay(cost);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid price per day. Please try again.");
        }

        if(model == null || model.isBlank()) throw new IllegalArgumentException("Model/make cannot be null or blank");
        if (brand == null || brand.isBlank()) throw new IllegalArgumentException("Brand cannot be null or blank.");

        instrumentRepository.update(instrument);
        System.out.println("Instrument successfully updated!");
    }

    //reusing code
    private Instrument chooseInstrumentFromList(Scanner userInput) {
        List<Instrument> instruments = instrumentRepository.findAll();
        for (int i = 0; i < instruments.size(); i++) {
            System.out.println(i + 1 + ", " + instruments.get(i).getType() + ". " + instruments.get(i).getName() + ", " + instruments.get(i).getBrand() + ", " + instruments.get(i).getPricePerDay() + ":-");
        }
        return instruments.get(userInput.nextInt() -1);
    }


}
