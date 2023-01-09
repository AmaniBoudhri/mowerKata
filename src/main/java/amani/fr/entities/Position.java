package amani.fr.entities;

import lombok.Data;

@Data
public class Position {
    private Coordinates coordinates;
    private Orientation orientation;

    public Position(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public void turnRight() {
        orientation = orientation.getRightOrientation();
    }

    public void turnLeft() {
        orientation = orientation.getLeftOrientation();
    }

    public void move(Lawn lawn) {
        switch (orientation) {
            case NORTH:
                if (coordinates.getY() < lawn.y()) {
                    coordinates.setY(coordinates.getY() + 1);
                }
                break;
            case SOUTH:
                if (coordinates.getY() > 0) {
                    coordinates.setY(coordinates.getY() - 1);
                }
                break;
            case EAST:
                if (coordinates.getX() < lawn.x()) {
                    coordinates.setX(coordinates.getX() + 1);
                }
                break;
            case WEST:
                if (coordinates.getX() > 0) {
                    coordinates.setX(coordinates.getX() - 1);
                }
                break;
        }
    }
}
