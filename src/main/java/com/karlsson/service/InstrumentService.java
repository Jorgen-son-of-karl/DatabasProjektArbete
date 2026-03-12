package com.karlsson.service;

import com.karlsson.entity.Instrument;
import com.karlsson.entity.Member;
import com.karlsson.repo.InstrumentRepository;
import com.karlsson.repo.MemberRepository;

import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class InstrumentService {

    private final InstrumentRepository instrumentRepository;
    public InstrumentService(InstrumentRepository instrumentRepository) { this.instrumentRepository = instrumentRepository; }

    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public void listAllInstruments() {
        List<Instrument> instruments = getAllInstruments();
        for (Instrument instrument : instruments) {
            System.out.println(instrument.getBrand() + ", " + instrument.getName());
        }
    }

    public void createInstrument(Scanner userInput) {
        userInput.nextLine();
        Instrument.Type type = null;
//        try {
//            type = Instrument.Type.valueOf(instrumentType.toUpperCase().trim());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Invalid instrument type");
//        }
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

}
