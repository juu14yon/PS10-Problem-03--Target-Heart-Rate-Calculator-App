import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class TargetHeartRateCalculatorController {

    private static final NumberFormat rounding = NumberFormat.getInstance();

    @FXML private TextField ageTextField;
    @FXML private Button calculateButton;
    @FXML private Label resultLabel;
    @FXML private Label maxRateLabel;


    @FXML
    void calculateButtonPressed(ActionEvent event) {
        rounding.setRoundingMode(RoundingMode.HALF_UP);
        try {
            int age = Integer.parseInt(ageTextField.getText());
            while (age<1 | age>130){
                invalidAge();
                age = Integer.parseInt(ageTextField.getText());
            }
            int maxRate = 220 - age;
            maxRateLabel.setText(""+maxRate);
            resultLabel.setText("" + rounding.format(maxRate*0.5) + "-" + rounding.format(maxRate*0.85));
        }
        catch (NumberFormatException ex){
            invalidAge();
        }
    }
    void invalidAge(){
        ageTextField.setText("Invalid age");
        ageTextField.selectAll();
        ageTextField. requestFocus();
    }

}
