package Week_1.Opdracht_3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BallApp extends Application 
{
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) 
  {
     Ball ball = new Ball(20, 30, 10); // Model, x- en y-coordinates and radius(in pixels).      
     BallView view = new BallView (ball); // View    
     BallController controller = new BallController (ball, view); //Controller
     
     SouthPane southPane = new SouthPane(controller);
     
     BorderPane pane = new BorderPane();
     pane.setCenter(view);
     pane.setBottom(southPane);
     
          
     // Create a scene and place it in the stage
     Scene scene = new Scene(pane, 450, 250);
     primaryStage.setTitle("BounceBallSlider"); // Set the stage title
     primaryStage.setScene(scene); // Place the scene in the stage
     primaryStage.show(); // Display the stage   
  }
    
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}