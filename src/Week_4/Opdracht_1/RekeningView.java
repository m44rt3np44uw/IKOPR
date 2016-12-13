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

public class RekeningView extends Stage
{
	private TextField nummerField;
	private ComboBox<String> personenList;
	private Button rekeningButton;
	
	private ComboBox<String> rekeningenList;
	private TextArea textArea;
	
	private ArrayList<Persoon> dePersonen;
	
	private Persoon currentPersoon;
	private Rekening currentRekening;
	

    public RekeningView(ArrayList<Persoon> dePersonen) 
    {
    	// ........... zie ook PersoonView
    	
    	rekeningButton = new Button("nieuwe rekening");
    	rekeningButton.setOnAction (e -> handleButton());
    	
    	personenList = new ComboBox<String>();
    	personenList.setOnAction( e -> handlePersonenList());
    	
    	rekeningenList = new ComboBox<String>();
        rekeningenList.setOnAction( e -> handleRekeningenList());
    	    	

    	
        // northPane.getChildren().addAll(.........................);
        // centerPane.getChildren().addAll(...........................); 

        BorderPane bPane = new BorderPane();
        bPane.setTop (northPane);
        bPane.setCenter(centerPane);
        
        reportChange();
        Scene scene = new Scene(bPane, 675, 250);
        setTitle ("RekeningView");
        setScene(scene);
        show();              		   	
    }
    
    private void handleButton()
    {
        if (currentPersoon == null)
           // .................................
        else
        {
           currentRekening = // .................................
           // .......................................
           reportChange();
        }        
        
    } 
        
    private void handlePersonenList()
    {
       // zie ook PersoonView          
    }  
        
    private void handleRekeningenList()
    {
       // zie ook PersoonView       
    }
    
    public void reportChange()
    {
       nummerField.setText("");
       refreshPersonenList();
       refreshRekeningenList(); 
       refreshTextArea();
    } 
           
    private void refreshPersonenList()
    {
        // zie ook PersoonView
            
    }
    
    private void refreshRekeningenList()
    {
        // doorloop de personenlijst en
        // voeg alle rekeningnummers (van alle personen) 
        // toe aan rekeningenList
        // laat de actuele waarde van rekeningenList het rekening
        // nummer van currentRekening zijn 
    }  
        
    private void refreshTextArea()
    {
        textArea.setText("");
        // toon op de textArea nummer en saldo van currentRekening
        // en naam en bsn-nummer van de eigenaar 
        
    }         
}