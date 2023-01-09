import amani.fr.entities.Command;
import amani.fr.entities.Lawn;
import amani.fr.entities.Orientation;
import amani.fr.entities.Position;
import amani.fr.exception.FileFormatIsNotValid;
import amani.fr.utils.InstructionExtractorUtility;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionExtractorTest {

    @SneakyThrows
    @Test
    public void should_extract_lawn_size() {

        Lawn lawn = InstructionExtractorUtility.extractLawnSize("5 5");

        assertThat(lawn.x()).isEqualTo(5);
        assertThat(lawn.y()).isEqualTo(5);
    }

    @Test
    public void should_throw_not_valid_format_exception_when_size_is_wrong() {
        assertThrows(FileFormatIsNotValid.class, () -> InstructionExtractorUtility.extractLawnSize("5 A"));
    }

    @SneakyThrows
    @Test
    public void should_extract_initial_position() {
        Position position = InstructionExtractorUtility.extractLawnInitialPosition("5 5 N");

        assertThat(position.getCoordinates().getX()).isEqualTo(5);
        assertThat(position.getCoordinates().getY()).isEqualTo(5);
        assertThat(position.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void should_throw_not_valid_format_exception_when_position_is_wrong() {

        assertThrows(FileFormatIsNotValid.class, () -> InstructionExtractorUtility.extractLawnInitialPosition("5 5 A"));
    }

    @SneakyThrows
    @Test
    public void should_extract_command() {
        List<Command> commands = InstructionExtractorUtility.extractCommand("GAGAGAGAA");

        assertThat(commands.size()).isEqualTo(9);

    }

    @Test
    public void should_throw_not_valid_format_exception_when_command_is_wrong() {
        assertThrows(FileFormatIsNotValid.class, () -> InstructionExtractorUtility.extractCommand("GACADFTRD"));
    }
}
