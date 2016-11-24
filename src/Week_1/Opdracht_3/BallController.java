package Week_1.Opdracht_3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.beans.property.DoubleProperty;

import java.awt.event.ActionListener;

public class BallController {
    private Ball ball;
    private BallView view;
    private Timeline animation;

    private double dx = 1, dy = 1;


    public BallController(Ball ball, BallView view) {
        this.ball = ball;
        this.view = view;

        // Creata a Timeline-object to start an animation (within the JavaFX-thread)
        // call the moveBall()-method every (say) 50/100 msecs
        animation = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                moveBall();
            }
        }));

        // Start the animation
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        // Pause the animatie when pressing the mouse on the view
        view.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                animation.pause();
            }
        });

        // Resume the animation when releasing the mouse
        view.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                animation.play();
            }
        });
    }

    // A binding property value for the 'rate' of  the  animation
    // see class SouthPane ... what is it for?
    public DoubleProperty rateProperty() {
        return (animation.rateProperty());
    }


    private void moveBall() {
        // Check view-bounderies .. when colliding, change horizontal direction
        if (ball.getX() < ball.getRadius() || ball.getX() > view.getWidth() - ball.getRadius()){
            dx *= -1;
        }

        // Check view-bounderies .. when colliding, change vertical direction
        if (ball.getY() < ball.getRadius() || ball.getY() > view.getHeight() - ball.getRadius()){
            dy *= -1;
        }

        // adapt ball-properties (which one?)
        ball.setX(ball.getX() + dx);
        ball.setY(ball.getY() + dy);

        // adapt the view (why?)
        view.adjust();
    }
}
