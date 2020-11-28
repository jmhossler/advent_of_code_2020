package advent_of_code;

import lombok.Builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Builder
public class Input implements InputProvider {
    final private String filepath;

    @Override
    public String getInput() throws IOException {
        return Files.readString(Path.of(filepath));
    }
}
