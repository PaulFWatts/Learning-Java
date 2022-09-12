/* -*- Mode: java; tab-width: 2; indent-tabs-mode: t; c-basic-offset: 2 -*- */
package kit101.turtle;

import java.awt.*;
import java.awt.event.*;

public class InteractiveTurtle extends Turtle
    implements MouseListener, KeyListener, MouseMotionListener
{

    /**
     * Sets the Turtle's {@linkplain InteractiveWorld world} and returns a
     * reference to this Turtle.
     *
     * @param world - the new {@code InteractiveWorld}
     * @return this Turtle
     * @throws IllegalArgumentException if the given world is an
     * {@code InteractiveWorld}.
     */
    public Turtle setWorld(TurtleWorld world) {
        if (! (world instanceof InteractiveWorld))
            throw new IllegalArgumentException("InteractiveTurtle requires an InteractiveWorld to inhabit, but given world is " + world.getClass());

        if (this.world != null) {
            InteractiveWorld oldWorld = (InteractiveWorld) this.world;
            oldWorld.removeMouseListener(this);
            oldWorld.removeKeyListener(this);
        }
        super.setWorld(world);
        ((InteractiveWorld)world).addMouseListener(this);
        ((InteractiveWorld)world).addKeyListener(this);
        return this;
    }
    
    public Point flipYCoordinate(Point p) {
        return ((InteractiveWorld) world).flipYCoordinate(p);
    }

    //FIXME Use adapters or any other more modern approach.

    /* implementing MouseListener */
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    /* implementing KeyListener */
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }

    /* implementing MouseMotionListener */
    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }
}

