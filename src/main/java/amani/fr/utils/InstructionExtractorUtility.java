package amani.fr.utils;

import amani.fr.entities.*;
import amani.fr.exception.FileFormatIsNotValid;

import java.util.ArrayList;
import java.util.List;


public class InstructionExtractorUtility {


    public static Lawn extractLawnSize(String line) throws FileFormatIsNotValid {
        if (CheckLineUtils.checkLineForLawnSize(line)) {
            String[] split = line.split(" ");
            return new Lawn(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        throw new FileFormatIsNotValid();
    }


    public static Position extractLawnInitialPosition(String line) throws FileFormatIsNotValid {
        if (CheckLineUtils.checkLineForPosition(line)) {
            String[] split = line.split(" ");
            Coordinates coordinates = new Coordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            return new Position(coordinates, Orientation.getOrientationValue(split[2]));
        }
        throw new FileFormatIsNotValid();
    }


    public static List<Command> extractCommand(String line) throws FileFormatIsNotValid {
        if (CheckLineUtils.checkLineForCommand(line)) {
            List<Command> commands = new ArrayList<>();
            char[] listOfCommands = line.toCharArray();
            for (char cmd : listOfCommands) {
                commands.add(Command.getCommandFromMovement(String.valueOf(cmd)));
            }
            return commands;
        }
        throw new FileFormatIsNotValid();
    }
}
