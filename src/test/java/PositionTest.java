import amani.fr.entities.Coordinates;
import amani.fr.entities.Lawn;
import amani.fr.entities.Orientation;
import amani.fr.entities.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void should_move_y_by_one_when_its_north() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.NORTH);
        Lawn lawn = new Lawn(5, 5);

        position.move(lawn);

        Coordinates expectedCoordinates = new Coordinates(1, 3);
        Position expected = new Position(expectedCoordinates, Orientation.NORTH);
        assertThat(position).isEqualTo(expected);
    }

    @Test
    public void should_move_y_by_minus_one_when_its_south() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.SOUTH);
        Lawn lawn = new Lawn(5, 5);

        position.move(lawn);

        Coordinates expectedCoordinates = new Coordinates(1, 1);
        Position expected = new Position(expectedCoordinates, Orientation.SOUTH);

        assertThat(position).isEqualTo(expected);
    }

    @Test
    public void should_move_y_by_one_when_its_east() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.EAST);
        Lawn lawn = new Lawn(5, 5);

        position.move(lawn);

        Coordinates expectedCoordinates = new Coordinates(2, 2);
        Position expected = new Position(expectedCoordinates, Orientation.EAST);

        assertThat(position).isEqualTo(expected);
    }

    @Test
    public void should_move_x_by_minus_one_when_its_west() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.WEST);
        Lawn lawn = new Lawn(5, 5);


        position.move(lawn);

        Coordinates expectedCoordinates = new Coordinates(0, 2);
        Position expected = new Position(expectedCoordinates, Orientation.WEST);

        assertThat(position).isEqualTo(expected);
    }

    @Test
    public void should_do_nothing_when_x_outrun_lawn_size() {
        Coordinates coordinates = new Coordinates(5, 2);
        Position position = new Position(coordinates, Orientation.EAST);
        Lawn lawn = new Lawn(5, 5);

        position.move(lawn);

        Coordinates expectedCoordinates = new Coordinates(5, 2);
        Position expected = new Position(expectedCoordinates, Orientation.EAST);

        assertThat(position).isEqualTo(expected);

    }

    @Test
    public void should_do_nothing_when_y_outrun_lawn_size() {
        Coordinates coordinates = new Coordinates(2, 5);
        Position position = new Position(coordinates, Orientation.NORTH);
        Lawn lawn = new Lawn(5, 5);


        position.move(lawn);

        Coordinates expectedCoordinates = new Coordinates(2, 5);
        Position expected = new Position(expectedCoordinates, Orientation.NORTH);


        assertThat(position).isEqualTo(expected);

    }
}
