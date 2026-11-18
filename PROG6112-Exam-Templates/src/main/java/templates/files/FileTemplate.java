package templates.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * TEMPLATE: text files (write, append, read, split CSV) and random access files.
 * Files without a folder in the name are created in the NetBeans project folder.
 */
public class FileTemplate {

    private static final String FILE_NAME = "travel.txt";

    // Overwrite the file with new content
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Could not write: " + e.getMessage());
        }
    }

    // Add one record to the END of the file (true = append mode)
    public static void appendLine(String fileName, String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Could not append: " + e.getMessage());
        }
    }

    // Read every line; split each CSV record into fields; return how many were read
    public static int readRecords(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {     // null = end of file
                String[] fields = line.split(",");
                System.out.println(fields[0] + " -> " + fields[1] + " by " + fields[2]);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Could not read: " + e.getMessage());
        }
        return count;
    }

    // Read the whole file into one String (e.g. to show in a JTextArea)
    public static String readAll(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Could not read file: " + e.getMessage();
        }
        return sb.toString();
    }

    // Random access: fixed-length records, jump straight to record n
    public static void randomAccessDemo() throws IOException {
        final String newLine = System.lineSeparator();
        final String BLANK = "000,     ,00000.00" + newLine;
        final int RECSIZE = BLANK.length();                   // every record the same length
        Path path = Paths.get("accounts.dat");

        // 1. Create the file with 100 blank records
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(path, CREATE))) {
            for (int i = 0; i < 100; i++) {
                out.write(BLANK.getBytes());
            }
        }

        // 2. Write record 42 into its slot
        String record = "042,Thabo,01500.00" + newLine;
        try (FileChannel fc = (FileChannel) Files.newByteChannel(path, READ, WRITE)) {
            fc.position(42L * RECSIZE);
            fc.write(ByteBuffer.wrap(record.getBytes()));
        }

        // 3. Read only record 42
        try (FileChannel fc = (FileChannel) Files.newByteChannel(path, READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(RECSIZE);
            fc.position(42L * RECSIZE);
            fc.read(buffer);
            System.out.print("Record 42: " + new String(buffer.array()));
        }
    }

    public static void main(String[] args) throws IOException {
        writeFile(FILE_NAME, "Cape Town,Durban,Airplane" + System.lineSeparator());
        appendLine(FILE_NAME, "Durban,Port Elizabeth,Train");
        int count = readRecords(FILE_NAME);
        System.out.println(count + " records read");
        System.out.print(readAll(FILE_NAME));
        randomAccessDemo();
    }
}
