package org.amani;

import amani.fr.entities.Command;
import amani.fr.entities.Lawn;
import amani.fr.entities.Mower;
import amani.fr.entities.Position;
import amani.fr.exception.FileFormatIsNotValid;
import amani.fr.utils.InstructionExtractorUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public record Control(List<Mower> mowers) {


    public void buildMower(List<String> lines) throws FileFormatIsNotValid {
        Iterator<String> iterator = lines.iterator();
        String lawnSize = iterator.next();

        Lawn lawn = InstructionExtractorUtility.extractLawnSize(lawnSize);
        while (iterator.hasNext()) {
            String mowerPosition = iterator.next();
            Position position = InstructionExtractorUtility.extractLawnInitialPosition(mowerPosition);

            String mowerCommands = iterator.next();
            List<Command> commands = InstructionExtractorUtility.extractCommand(mowerCommands);

            Mower mower = new Mower(position, lawn, commands);
            mowers.add(mower);
        }
    }

    public List<Position> process() {
        List<Position> mowerPositions = new ArrayList<>(mowers.size());
        for (Mower mower : mowers) {
            mowerPositions.add(mower.move());
        }
        return mowerPositions;
    }
}
