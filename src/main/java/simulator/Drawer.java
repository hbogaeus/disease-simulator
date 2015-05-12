package simulator;

import javax.swing.*;
import java.awt.*;


public class Drawer {
    public Drawer () {
        JFrame frame = new JFrame("Disease Simulation");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new PopulationPane());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class PopulationPane extends JPanel {

        Population populationToDraw = new Population(4);

        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            doDrawing(graphics);
        }

        private void doDrawing(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;

            int sizeOfPopulation = populationToDraw.getPopulation().length;

            int w = getWidth() / sizeOfPopulation;
            int h = getHeight() / sizeOfPopulation;

            for (int i = 0; i < sizeOfPopulation; i++) {
                for (int j = 0; j < sizeOfPopulation; j++) {
                    int x = i * w;
                    int y = j * h;
                    Person person = populationToDraw.getPersonInPopulation(j, i);
                    if (person.getStatus() == Status.HEALTHY){
                        graphics2D.setColor(Color.GREEN);
                    }
                    graphics2D.drawRect(x, y, w + w, h + h);

                    graphics2D.setColor(Color.BLACK);
                    graphics2D.drawString(i + "," + j, (x - w / 2), (y - h / 2));
                }
            }
        }
    }
}


/*
public PopulationPane() {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {

                }
            }
        }
 */