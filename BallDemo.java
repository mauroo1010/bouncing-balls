import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int bolas)
    {
        int ground = 400;   // position of the ground line
        ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>();
        Random random = new Random();
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        int i = 0;
        while (i < bolas) {
            int rojo = random.nextInt(256);
            int verde = random.nextInt(256);
            int azul = random.nextInt(256);
            Color ramColor = new Color(rojo, verde, azul);
            int diametro = random.nextInt(50) + 10;
            int x = random.nextInt(151);
            int y = random.nextInt(151);

            BouncingBall ball = new BouncingBall(x, y,diametro,ramColor,ground,myCanvas);

            balls.add(ball);
            ball.draw();
            i++;
        }        

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(20); // small delay
            int n = 0;
            while (n < balls.size()) {
                balls.get(n).move();
                // stop once ball has travelled a certain distance on x axis
                if (balls.get(n).getXPosition() >= 550) {
                    finished = true;
                }
                n++;
            }
        }
    }
}