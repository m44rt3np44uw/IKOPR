package Week_1.Opdracht_3;

import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;


public class SouthPane extends HBox
{
    public SouthPane(BallController controller)
    {
        setAlignment(Pos.CENTER);
        Slider slSpeed = new Slider(); //a slider-object
        
        // maximum (slider) equals 20
        slSpeed.setMax(20);
        
        // minimum (slider) equals 5
        slSpeed.setMin(5);
        
        // show min and max  
        slSpeed.setShowTickLabels(true);
        slSpeed.setShowTickMarks(true);
        
        // What does this do?  see BallController
        controller.rateProperty().bind(slSpeed.valueProperty());
        
        // add additional controls (if necessary to the Hbox) 
        getChildren().add(slSpeed);       
    }
    
}
