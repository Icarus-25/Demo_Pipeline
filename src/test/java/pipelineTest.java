import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class pipelineTest {

    @Test
    void mainPrintsHelloWorld() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            pipeline.main(new String[0]);

            assertEquals("Hello, world!" + System.lineSeparator(), output.toString(StandardCharsets.UTF_8));
        } finally {
            System.setOut(originalOut);
        }
    }
}
