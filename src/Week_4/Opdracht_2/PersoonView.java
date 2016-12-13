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
    	// ..........
    	BorderPane bPane = new BorderPane();
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
      // ..... 
      register.reportChange();              
    }
    
    private void handleDropList()
    {
       // .........        
    }
    
    private void refreshTextArea()
    {
        // .............
    }  
             
    private void refreshDropList()
    {
        //............
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
