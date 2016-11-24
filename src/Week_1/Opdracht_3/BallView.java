package Week_1.Opdracht_3;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallView extends Pane {
    private Circle circle;
    private Ball ball;

    public BallView(Ball ball) {
        this.ball = ball;
        this.createCircle();
        this.getChildren().add(circle); // what is the meaning of getChildren()?
    }

    private void createCircle() {
        this.circle = new Circle(ball.getX(), ball.getY(), ball.getRadius()); // initialize with ball-properties

        //Set fill-color of the circle to green
        this.circle.setFill(Color.GREEN);

        //Set border-color of the circle to black
        this.circle.setStroke(Color.BLACK);
    }

    // adjust the centerpoint of the circle,
    // use properties of the ball
    public void adjust() {
        this.circle.setCenterX(ball.getX());
        this.circle.setCenterY(ball.getY());
    }

}
