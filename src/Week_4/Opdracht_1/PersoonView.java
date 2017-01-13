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
    	this.dePersonen = dePersonen;

    	FlowPane northPane = new FlowPane();
    	FlowPane centerPane = new FlowPane();

    	naamField = new TextField();
    	bsnField = new TextField();
    	textArea = new TextArea();

        northPane.setHgap(10);
        northPane.setVgap(10);
        centerPane.setHgap(10);
        centerPane.setVgap(10);
        northPane.setAlignment(Pos.CENTER);
        centerPane.setAlignment(Pos.CENTER);
            
                   
        persoonButton = new Button("voegtoe persoon");      
        persoonButton.setOnAction( e -> handleButton());        
                
        dropList = new ComboBox<String>();
        dropList.setOnAction( e -> handleDropList());
        
    	
    	 northPane.getChildren().addAll(new Label("Naam"), naamField, new Label("BSN"), bsnField, persoonButton);
    	 centerPane.getChildren().addAll(new Label("alle personen"), dropList, new ScrollPane(textArea));
    	
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
        currentPersoon = new Persoon(bsnField.getText(), naamField.getText());
        dePersonen.add(currentPersoon);
        reportChange();
    }
    
    private void handleDropList()
    {
        String selected = (String) dropList.getValue();

        // laat currentPersoon de geselecteerde persoon zijn
        for (Persoon persoon: dePersonen) {
            if(persoon.getBsn().equals(selected)) {
                currentPersoon = persoon;

                // ververs de textArea
                refreshTextArea();
                return;
            }
        }
    }
    
    private void refreshTextArea()
    {
        textArea.setText("");
        // toon op de textArea de bsn, naam, reknummers en saldo
        // van currentPersoon
        if(currentPersoon != null)
        {
            textArea.appendText(currentPersoon.getBsn() + "\t" + currentPersoon.getNaam());

            if(currentPersoon.getRekeningen() != null)
            {
                textArea.appendText("\n\n rekeningen: \n\n");

                for (Rekening rekening: currentPersoon.getRekeningen())
                {
                    textArea.appendText(rekening.getNummer() + "\t" + rekening.getSaldo() + "\n");
                }
            }

        }
    }  
             
    private void refreshDropList()
    {
        dropList.getItems().clear();
        // doorloop de personenlijst en voeg alle bsn-nummers
        // toe aan de droplist
        for(Persoon persoon: dePersonen) {
            dropList.getItems().add(persoon.getBsn());
        }

        // laat de actuele waarde van de droplist het bsn-nummer zijn
        // van currentPersoon
        if(currentPersoon != null) {
            dropList.setValue(currentPersoon.getBsn());
        }
    }


    public void reportChange()
    {
       naamField.setText("");
       bsnField.setText("");
       refreshDropList();
       refreshTextArea();   
    }       
}