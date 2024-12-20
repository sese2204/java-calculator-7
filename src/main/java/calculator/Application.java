package calculator;

import calculator.controller.Controller;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);
        controller.run();
    }
}
