package Week_4.Opdracht_1;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class PersoonView extends Stage 
{

	private TextField naamField;
	private TextField bsnField;
	private Button persoonButton;
	
	private ComboBox<String> dropList;
	private TextArea textArea;
	
	private ArrayList<Persoon> dePersonen;	
	private Persoon currentPersoon;
	

    public PersoonView(ArrayList<Persoon> dePersonen) 
    {
    	// ...................................
    	FlowPane northPane = new FlowPane();
    	FlowPane centerPane = new FlowPane();
        northPane.setHgap(10);
        // ........
            
                   
        persoonButton = new Button("voegtoe persoon");      
        persoonButton.setOnAction( e -> handleButton());        
                
        dropList = new ComboBox<String>();
        dropList.setOnAction( e -> handleDropList());
        
    	
    	// northPane.getChildren().addAll(............);
    	// centerPane.getChildren().addAll(..............);
    	
    	BorderPane bPane = new BorderPane();
    	bPane.setTop (northPane);
    	bPane.setCenter(centerPane);
    	
    	reportChange();
    	
    	Scene scene = new Scene(bPane, 650, 250);
    	setTitle ("PersoonView");
    	setScene(scene);
    	show();    	
    }
    
    private void handleButton()
    {
      // currentPersoon = .......................
      // ........................................
      reportChange();              
    }
    
    private void handleDropList()
    {
       String selected = (String) dropList.getValue();
       // laat currentPersoon de geselecteerde persoon zijn
       // ververs de textArea           
    }
    
    private void refreshTextArea()
    {
        textArea.setText("");
        // toon op de textArea de bsn, naam, reknummers en saldo
        // van currentPersoon 
    }  
             
    private void refreshDropList()
    {
        // doorloop de personenlijst en voeg alle bsn-nummers
        // toe aan de droplist 
        // laat de actuele waarde van de droplist het bsn-nummer zijn
        // van currentPersoon 
    }


    public void reportChange()
    {
       naamField.setText("");
       bsnField.setText("");
       refreshDropList();
       refreshTextArea();   
    }       
}