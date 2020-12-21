package geometry.validator;

import geometry.exception.InfoBallValidatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfoBallValidator {
    private static final Logger logger = LogManager.getLogger();

    public String[] checkBallInfo(String[] list) throws InfoBallValidatorException {
        if(list.length != 4){
            logger.info("Некорректные данные в строке\nНедостаточно исходных данных");
            throw new InfoBallValidatorException("Некорректные данные в строке\nНедостаточно исходных данных");
        }
        for(int i = 0; i < list.length - 1; i ++) {
            try {
                Integer.parseInt(list[i]);
            }catch (NumberFormatException e){
                logger.info("Некорректные данные в строке: {}\nОшибка: {}", i, list[i]);
                throw new InfoBallValidatorException("Некорретные данные:" + list[i] + "Строки: " + i);
            }
        }
        for(int i = 0; i < list.length - 1; i ++) {
            if(Integer.parseInt(list[i]) <= 0){
                Integer.parseInt(list[i]);
                logger.info("Некорректные данные в строке: {}\nОшибка: {}", i, list[i]);
                throw new InfoBallValidatorException("Некорретные данные:" + list[i] + "Строки: " + i);
            }
        }
        return list;
    }
}
