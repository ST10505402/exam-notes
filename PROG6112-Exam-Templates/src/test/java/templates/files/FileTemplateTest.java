package templates.files;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// JUnit 4 project instead: import org.junit.Test; import static org.junit.Assert.*;

/**
 * TEMPLATE: testing file code with a temporary file (never your real data file).
 */
public class FileTemplateTest {

    private String tempFile() throws IOException {
        File f = File.createTempFile("test", ".txt");
        f.deleteOnExit();                       // tidy up after the tests
        return f.getAbsolutePath();
    }

    @Test
    public void WriteThenAppend_ReadRecords_ReturnsCount() throws IOException {
        String path = tempFile();
        FileTemplate.writeFile(path, "Cape Town,Durban,Airplane" + System.lineSeparator());
        FileTemplate.appendLine(path, "Durban,Port Elizabeth,Train");
        assertEquals(2, FileTemplate.readRecords(path));
    }

    @Test
    public void ReadAll_ReturnsFileContents() throws IOException {
        String path = tempFile();
        FileTemplate.writeFile(path, "Line one" + System.lineSeparator());
        assertEquals("Line one\n", FileTemplate.readAll(path));
    }

    @Test
    public void ReadRecords_MissingFile_ReturnsZero() {
        assertEquals(0, FileTemplate.readRecords("does-not-exist-12345.txt"));
    }
}
