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
    	this.dePersonen = dePersonen;

        nummerField = new TextField();
        textArea = new TextArea ();

        FlowPane northPane = new FlowPane();
        FlowPane centerPane = new FlowPane();
        northPane.setHgap(10);
        northPane.setVgap(10);
        centerPane.setHgap(10);
        centerPane.setVgap(10);
        northPane.setAlignment(Pos.CENTER);
        centerPane.setAlignment(Pos.CENTER);
    	
    	rekeningButton = new Button("nieuwe rekening");
    	rekeningButton.setOnAction (e -> handleButton());
    	
    	personenList = new ComboBox<String>();
    	personenList.setOnAction( e -> handlePersonenList());
    	
    	rekeningenList = new ComboBox<String>();
        rekeningenList.setOnAction( e -> handleRekeningenList());


        northPane.getChildren().addAll(new Label("nummer"), nummerField, new Label ("alle personen"), personenList, rekeningButton);
        centerPane.getChildren().addAll(new Label ("alle rekeningen"), rekeningenList, new ScrollPane(textArea));

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
           System.out.println("Er is geen persoon geselecteerd.");
        else
        {
           currentRekening = new Rekening(nummerField.getText(), currentPersoon);
           currentPersoon.voegRekeningToe(currentRekening);
           reportChange();
        }        
        
    } 
        
    private void handlePersonenList()
    {
       String selected = (String) personenList.getValue();

       for (Persoon persoon: dePersonen)
       {
           if(persoon.getBsn().equals(selected))
           {
               currentPersoon = persoon;
               return;
           }
       }
    }  
        
    private void handleRekeningenList()
    {
        String selected = (String) rekeningenList.getValue();

        for (Persoon persoon: dePersonen)
        {
            for (Rekening rekening: persoon.getRekeningen())
            {

                if(rekening.getNummer().equals(selected))
                {
                    currentRekening = rekening;
                    refreshTextArea();
                    return;
                }
            }
        }
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
        personenList.getItems().clear();

        for (Persoon persoon: dePersonen)
        {
            personenList.getItems().add(persoon.getBsn());
        }

        if(currentPersoon != null)
        {
            personenList.setValue(currentPersoon.getBsn());
        }
            
    }
    
    private void refreshRekeningenList()
    {
        // doorloop de personenlijst en
        // voeg alle rekeningnummers (van alle personen) 
        // toe aan rekeningenList
        // laat de actuele waarde van rekeningenList het rekening
        // nummer van currentRekening zijn
        rekeningenList.getItems().clear();

        for (Persoon persoon: dePersonen)
        {
            if (persoon.getRekeningen() != null)
            {
                for(Rekening rekening: persoon.getRekeningen())
                {
                    rekeningenList.getItems().add(rekening.getNummer());
                }
            }
        }

        if (currentRekening != null)
        {
            rekeningenList.setValue(currentRekening.getNummer());
        }
    }  
        
    private void refreshTextArea()
    {
        textArea.setText("");
        // toon op de textArea nummer en saldo van currentRekening
        // en naam en bsn-nummer van de eigenaar
        if (currentRekening != null)
        {
            textArea.appendText(currentRekening.getNummer() + "\t" + currentRekening.getSaldo());
            textArea.appendText("\n\n Rekeninghouder: \n\n");
            textArea.appendText(currentRekening.getPersoon().getNaam() + "\t" + currentRekening.getPersoon().getBsn());
        }
        
    }         
}