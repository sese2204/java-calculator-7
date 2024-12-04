package calculator.view;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "결과 : %d";

    public void printSum(int sum){
        System.out.println(String.format(OUTPUT_MESSAGE, sum));
    }
}
