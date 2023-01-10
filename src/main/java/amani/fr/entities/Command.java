package amani.fr.entities;

import lombok.Getter;

@Getter
public enum Command {
    FORWARD("A"),
    LEFT("G"),
    RIGHT("D");
    private final String movement;

    Command(String movement) {
        this.movement = movement;
    }

    public static Command getCommandFromMovement(String movement) {
        for (Command command : Command.values()) {
            if (movement.equals(command.getMovement())) {
                return command;
            }
        }
        return null;
    }
}
