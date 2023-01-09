package org.amani;

import amani.fr.entities.Position;
import amani.fr.exception.FileFormatIsNotValid;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, FileFormatIsNotValid {
        final List<String> lines = Files.readAllLines(Paths.get("src/main/resources/inputFile.txt"), StandardCharsets.UTF_8);

        Control control = new Control(new ArrayList<>());
        control.buildMower(lines);
        List<Position> positions = control.process();

        positions.forEach(x -> System.out.println(x.getCoordinates().getX() + " "
                + x.getCoordinates().getY() + " "
                + x.getOrientation().getBasic()));
    }


}