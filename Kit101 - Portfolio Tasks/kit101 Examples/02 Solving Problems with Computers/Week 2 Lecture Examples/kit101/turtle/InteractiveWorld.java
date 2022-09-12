package kit101.turtle;

import java.awt.*;
import java.awt.event.*;

public interface InteractiveWorld extends TurtleWorld {
    //FIXME These don't really need to be part of an interface we define, since they're already in other ones
    public void addMouseListener(MouseListener l);
    public void addKeyListener(KeyListener l);
    public void addMouseMotionListener(MouseMotionListener l);

    public void removeMouseListener(MouseListener l);
    public void removeKeyListener(KeyListener l);
    public void removeMouseMotionListener(MouseMotionListener l);

    public Point flipYCoordinate(Point p);
}

