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
public class MyRectangle extends MyBoundedShape {

    public MyRectangle() {
        super();
    }

    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getFill()) {
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        } else {
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }

    }

}
