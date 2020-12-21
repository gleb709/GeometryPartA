package geometry.parser;

import geometry.exception.InfoBallValidatorException;
import geometry.validator.InfoBallValidator;

import java.util.ArrayList;

public class Parser {
    public int[][] ballDataCreator(ArrayList<String> list){
        int ARRAY_SIZE_Y = 4;
        String divideSymbol = " ";
        InfoBallValidator infoBallValidator = new InfoBallValidator();
        int[][] ballData = new int[list.size()-1][ARRAY_SIZE_Y];
        for(int i = 0; i < list.size() - 1; i++){
            String[] subString = list.get(i).split(divideSymbol);
            try {
                subString = infoBallValidator.checkBallInfo(subString);
            } catch (InfoBallValidatorException e) {
                e.printStackTrace();
                continue;
            }
            for(int y = 0; y < subString.length - 1; y++){
                ballData[i][y] = Integer.parseInt(subString[y]);
            }
        }
        return ballData;
    }
}
