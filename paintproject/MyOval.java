/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintproject;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author mahmo
 */
public class MyOval extends MyBoundedShape {

    public MyOval() {
        super();
    }

    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getFill()) {
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        } else {
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }

    }

}
