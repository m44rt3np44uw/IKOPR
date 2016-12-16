package Week_4.Opdracht_1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class HoofdView extends Application
{

    private ArrayList<Persoon> dePersonenLijst;
    
    @Override 
    public void start (Stage primaryStage)
    {
        
        HBox box = new HBox();
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        
        Button btPersoon = new Button("personen");
        Button btRekening = new Button ("rekeningen");
        
        box.getChildren().addAll(btPersoon, btRekening);        
        dePersonenLijst = new ArrayList<Persoon>();

        btPersoon.setOnAction (e -> new PersoonView (dePersonenLijst));
        btRekening.setOnAction (e -> new RekeningView (dePersonenLijst));
        
        Scene scene = new Scene (box, 400, 100);
        primaryStage.setOnCloseRequest(e -> System.out.println ("closing the main window"));

                                              
        primaryStage.setTitle("HoofdView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }        
}
