package geometry.parser;

import geometry.exception.FileReaderException;
import geometry.exception.InfoBallValidatorException;
import geometry.validator.InfoBallValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ParserTest {
    private List<String> list;
    private int[][] expectedDate;

    @BeforeMethod
    public void setInfo() throws FileReaderException {
        List<String> list = new ArrayList<>();
        list.add("155 140 89 50");
        list.add("24 42 124 80");
        list.add("12 14 15 10");
        list.add("121");
        list.add("1000 200 200 1");
        list.add("fff fff fff fff");
        int[][] date = {{155, 140, 89, 50},
                {24, 42, 124, 80},
                {12, 14, 15, 10},
                {1000, 200, 200, 1}};
        expectedDate = date;
    }

    @Test
    public void testBallDataCreator() {
        int ARRAY_SIZE_Y = 4;
        String divideSymbol = " ";
        InfoBallValidator infoBallValidator = new InfoBallValidator();
        int[][] actualData = new int[list.size()-1][ARRAY_SIZE_Y];
        for(int i = 0; i < list.size() - 1; i++){
            String[] subString = list.get(i).split(divideSymbol);
            try {
                subString = infoBallValidator.checkBallInfo(subString);
            } catch (InfoBallValidatorException e) {
                e.printStackTrace();
                continue;
            }
            for(int y = 0; y < subString.length - 1; y++){
                actualData[i][y] = Integer.parseInt(subString[y]);
            }
        }
        assertEquals(actualData, expectedDate);
    }

    @AfterMethod
    public void deleteInfo(){
        expectedDate = null;
        list = null;
    }
}