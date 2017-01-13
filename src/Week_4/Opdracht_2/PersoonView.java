package Week_4.Opdracht_2;

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

public class PersoonView extends View
{

	private TextField naamField;
	private TextField bsnField;
	private Button persoonButton;
	
	private ComboBox<String> dropList;
	private TextArea textArea;
	
	private ArrayList<Persoon> dePersonen;
	private ViewRegister register;	
	private Persoon currentPersoon;
	

    public PersoonView(ArrayList<Persoon> dePersonen, ViewRegister register) 
    {
    	this.dePersonen    = dePersonen;
    	this.register      = register;

        this.textArea      = new TextArea ();
        this.naamField     = new TextField();
        this.bsnField      = new TextField();
        this.persoonButton = new Button("voegtoe persoon");
        this.dropList      = new ComboBox<String>();

        BorderPane bPane      = new BorderPane();
        FlowPane   northPane  = new FlowPane();
        FlowPane   centerPane = new FlowPane();

        northPane.setHgap(10);
        northPane.setVgap(10);
        centerPane.setHgap(10);
        centerPane.setVgap(10);
        northPane.setAlignment(Pos.CENTER);
        centerPane.setAlignment(Pos.CENTER);

        persoonButton.setOnAction( e -> handleButton());

        dropList.setOnAction( e -> handleDropList());

        northPane.getChildren().addAll(new Label("naam"), naamField, new Label ("bsn"), bsnField, persoonButton);
        centerPane.getChildren().addAll(new Label ("alle personen"), dropList, new ScrollPane(textArea));

    	bPane.setTop (northPane);
    	bPane.setCenter(centerPane);
    	
    	register.add(this);
    	reportChange();
    	
        this.setOnCloseRequest(e -> handleClose());
    	
    	Scene scene = new Scene(bPane, 650, 250);
    	setTitle ("PersoonView");
    	setScene(scene);
    	show();    	
    }
    
    private void handleButton()
    {
      currentPersoon = new Persoon(bsnField.getText(), naamField.getText());
      dePersonen.add(currentPersoon);
      register.reportChange();              
    }
    
    private void handleDropList()
    {
       String selected = (String) dropList.getValue();

       for (Persoon persoon: dePersonen)
       {
           if (persoon.getBsn().equals(selected))
           {
               currentPersoon = persoon;
               refreshTextArea();
               return;
           }
       }
    }
    
    private void refreshTextArea()
    {
        textArea.setText("");

        if (currentPersoon != null)
        {
            textArea.appendText(currentPersoon.getBsn() + "\t" + currentPersoon.getNaam());
            textArea.appendText("\n\n Rekeningen: \n\n");
            for (Rekening rekening: currentPersoon.getRekeningen())
            {
                textArea.appendText(rekening.getNummer() + "\t" + rekening.getSaldo() + "\n");
            }
        }
    }  
             
    private void refreshDropList()
    {
        dropList.getItems().clear();

        for (Persoon persoon: dePersonen)
        {
            dropList.getItems().add(persoon.getBsn());
        }

        if (currentPersoon != null)
        {
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
    	
    private void handleClose()
    {
    	register.remove(this);
    	System.out.println ("closing a PersoonView");
    	this.close();	
    }

}
