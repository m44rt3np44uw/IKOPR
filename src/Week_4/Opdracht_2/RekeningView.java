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

public class RekeningView extends View
{
	private TextField nummerField;
	private ComboBox<String> personenList;
	private Button rekeningButton;
	
	private ComboBox<String> rekeningenList;
	private TextArea textArea;
	
	private ArrayList<Persoon> dePersonen;
	private ViewRegister register;
	
	private Persoon currentPersoon;
	private Rekening currentRekening;
	

    public RekeningView(ArrayList<Persoon> dePersonen, ViewRegister register) 
    {
    	// .......... 
    	
    	register.add(this);
    	reportChange();
    	
        this.setOnCloseRequest(e -> handleClose());        

        Scene scene = new Scene(bPane, 675, 250);
        setTitle ("RekeningView");
        setScene(scene);
        show();              		   	
    }
    
    private void handleButton()
    {
        if (currentPersoon == null)
           // ..............................
        else
        {
           //...........................
           register.reportChange();
        }        
        
    } 
        
    private void handlePersonenList()
    {
       // ....................           
    }  
        
    private void handleRekeningenList()
    {
        // ......................          
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
        // ..................
            
    }
    
    private void refreshRekeningenList()
    {
        // ..........................
    }  
        
    private void refreshTextArea()
    {
        // ............................
        
    } 
     
    private void handleClose()
    {
    	// zie PersoonView
    }        
}
