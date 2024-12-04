package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\\\n(.*)");

    public int calculate(String input) {
        String numbers = input;
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] Custom delimiters must not be empty");
            }
            delimiters.add(matcher.group(1));
        }

        // 파싱
        String regex = String.join("|", delimiters);
        String[] splitedNumbers = numbers.split(regex);
        // 합 리턴
        return sum(splitedNumbers);
    }

    private int parseNumber(String number) {
        try{
            int num = Integer.parseInt(number);
            if (num < 0) throw new IllegalArgumentException("[ERROR] 음수는 허용되지 않습니다.");
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 숫자입니다.");
        }
    }

    private int sum(String[] splitedNumbers) {
        int sum = 0;
        for (String s : splitedNumbers) {
            int parsedNumber = parseNumber(s);
            sum += parsedNumber;
        }
        return sum;
    }
    
}
