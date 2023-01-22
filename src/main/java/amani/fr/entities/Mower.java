package amani.fr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Mower {
    private Position position;
    private Lawn lawn;
    private List<Command> commands;


    public Position move() {
        for (Command command : commands) {
            execute(command);
        }
        return position;
    }

    public void execute(Command command) {
        switch (command) {
            case LEFT -> position.turnLeft();
            case RIGHT -> position.turnRight();
            case FORWARD -> position.move(lawn);

        }
    }
}
