package geometry.reader;

import geometry.exception.FileReaderException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class FileReaderTest {
    private List<String> listExpected;
    private final String FILE_NAME = "file/ballInfo.txt";

    @BeforeMethod
    public void setInfo(){
        listExpected = new ArrayList<String>();
        listExpected.add("155 140 89 50");
        listExpected.add("24 42 124 80");
        listExpected.add("12 14 15 10");
        listExpected.add("121");
        listExpected.add("1000 200 200 1");
        listExpected.add("fff fff fff fff");
    }

    @Test
    public void testLoadBallInfoFromFile() throws FileReaderException{
        List<String> listActual = new ArrayList<>();
        Path path = Paths.get(FILE_NAME);
        try (Stream<String> lines = Files.lines(path)){
            lines.forEach(s -> listActual.add(s));
        } catch (FileNotFoundException e) {
            throw new FileReaderException("Файл не найден" + FILE_NAME);
        } catch (IOException e) {
            throw new FileReaderException("IOException");
        }
        assertEquals(listActual,listExpected);
    }

    @AfterMethod
    public void deleteInfo(){
        listExpected = null;
    }
}