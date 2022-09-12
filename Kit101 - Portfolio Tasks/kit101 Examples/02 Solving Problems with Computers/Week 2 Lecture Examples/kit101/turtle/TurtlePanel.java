package kit101.turtle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JPanel;

/**
 * A turtle graphics world that can be placed in any container.
 */
public class TurtlePanel extends JPanel implements InteractiveWorld {    
    protected Collection<GraphicElement> elements = new CopyOnWriteArrayList<>();

    public TurtlePanel() {
        setBackground( Color.white );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size = getSize();
        // Redraw all lines
        for (GraphicElement el : elements) {
            el.draw(g, size);
        }
    }

    public void clear() {
        elements.clear();
        repaint();
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color pen) {
        elements.add( new LineSegment(x1, y1, x2, y2, pen) );
        repaint();
    }

    public Point flipYCoordinate(Point p) {
        p.y = getSize().height - p.y;
        return p;
    }

    //TODO See if there are more recent Java API classes that can perform these functions
    protected static abstract class GraphicElement {
        abstract void draw(Graphics g, Dimension size);
    }

    protected static class LineSegment extends GraphicElement {
        private Point p1, p2;
        private Color c;

        LineSegment(int x1, int y1, int x2, int y2, Color c) {
            this.p1 = new Point(x1, y1);
            this.p2 = new Point(x2, y2);
            this.c = c;
        }

        void draw(Graphics g, Dimension size) {
            g.setColor(c);
            g.drawLine(p1.x, size.height - p1.y, p2.x, size.height - p2.y);
        }
        
    }
}
