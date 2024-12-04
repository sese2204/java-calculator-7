package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator = new Calculator();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int sum = 0;
        while (true) {
            try{
                String input = getInputWithRetry();
                sum = calculator.calculate(input);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        outputView.printSum(sum);
    }

    private String getInputWithRetry(){
        while (true) {
            try{
                String input = inputView.requestInput();
                return input;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
