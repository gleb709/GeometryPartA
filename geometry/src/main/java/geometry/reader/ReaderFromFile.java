package geometry.reader;

import geometry.exception.FileReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReaderFromFile {
    private static final Logger logger = LogManager.getLogger();
    private final String FILE_NAME = "file/ballInfo.txt";

    public List<String> loadBallInfoFromFile() throws FileReaderException {
        List<String> list = new ArrayList<String>();
        Path path = Paths.get(FILE_NAME);
        try (Stream<String> lines = Files.lines(path)){
                lines.forEach(s -> list.add(s));
        } catch (FileNotFoundException e) {
            logger.error("Файл " + FILE_NAME + " не найден");
            throw new FileReaderException("Файл не найден" + FILE_NAME);
        } catch (IOException e) {
            logger.error("Ошибка загрузки данных из файла " + FILE_NAME);
            throw new FileReaderException("IOException");
        }
        return list;
    }
}
