/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

/**
 *
 * @author mahmo
 */
public class DrawFrame extends JFrame {

    private JLabel stausLabel;
    private DrawPanel panel;

    private JButton undo;
    private JButton redo;
    private JButton clear;

    private JComboBox colors;

    private String colorOptions[]
            = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
                "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};

    private Color colorArray[]
            = {Color.BLACK, Color.BLUE, Color.CYAN, Color.darkGray, Color.GRAY,
                Color.GREEN, Color.lightGray, Color.MAGENTA, Color.ORANGE,
                Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    private JComboBox shapes;

    private String shapeOptions[]
            = {"Line", "Rectangle", "Oval"};

    private JCheckBox filled;

    private JPanel widgetJPanel;
    private JPanel widgetPadder;

    public DrawFrame() {
        super("Group 1");

        JLabel statusLabel = new JLabel("");

        panel = new DrawPanel(statusLabel);

        undo = new JButton("Undo");
        redo = new JButton("Redo");
        clear = new JButton("Clear");

        colors = new JComboBox(colorOptions);
        shapes = new JComboBox(shapeOptions);

        filled = new JCheckBox("Filled");

        widgetJPanel = new JPanel();
        widgetJPanel.setLayout(new GridLayout(1, 6, 10, 10));

        widgetPadder = new JPanel();
        widgetPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));

        widgetJPanel.add(undo);
        widgetJPanel.add(redo);
        widgetJPanel.add(clear);
        widgetJPanel.add(colors);
        widgetJPanel.add(shapes);
        widgetJPanel.add(filled);
        widgetPadder.add(widgetJPanel);

        add(widgetPadder, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener(buttonHandler);
        redo.addActionListener(buttonHandler);
        clear.addActionListener(buttonHandler);

        ItemListenerHandler handler = new ItemListenerHandler();
        colors.addItemListener(handler);
        shapes.addItemListener(handler);
        filled.addItemListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setVisible(true);

    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("Undo")) {
                panel.clearLastShape();
            } else if (event.getActionCommand().equals("Redo")) {
                panel.redoLastShape();
            } else if (event.getActionCommand().equals("Clear")) {
                panel.clearDrawing();
            }

        }
    }

    private class ItemListenerHandler implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == filled) {
                boolean checkFill = filled.isSelected() ? true : false;
                panel.setCurrentShapeFilled(checkFill);
            }

            if (event.getStateChange() == ItemEvent.SELECTED) {
                if (event.getSource() == colors) {
                    panel.setCurrentShapeColor(colorArray[colors.getSelectedIndex()]);
                } else if (event.getSource() == shapes) {
                    panel.setCurrentShapeType(shapes.getSelectedIndex());
                }
            }

        }
    }

}
