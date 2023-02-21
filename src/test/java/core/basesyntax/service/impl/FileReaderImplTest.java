package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FileReaderImplTest {
    private FileReader fileReader;
    private String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private String WRONG_INPUT_FILE_NAME = "src/main/resources/inpur.csv";

    @Before
    public void setUp() {
        fileReader = new FileReaderImpl();
    }

    @Test
    public void read_ok() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        expected.add("p,banana,13");
        expected.add("r,apple,10");
        expected.add("p,apple,20");
        expected.add("p,banana,5");
        expected.add("s,banana,50");
        List<String> actual = fileReader.read(INPUT_FILE_NAME);
        assertEquals(expected, actual);
    }

    @Test
    public void readWrongFileName_notOk() {
        assertThrows(RuntimeException.class, () -> {
            fileReader.read(WRONG_INPUT_FILE_NAME);
        });
    }

    @Test
    public void readNullFileName_notOk() {
        assertThrows(RuntimeException.class, () -> {
            fileReader.read(null);
        });
    }
}