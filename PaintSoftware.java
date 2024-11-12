/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vit.adda.reg22mic0102.paintsoftware;

/**
 *
 * @author gokul
 */
import java.awt.*;
import javax.swing.*;

class Frame {
    JFrame frame;

    public Frame() {
        frame = new JFrame("Paint Software");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Window extends Frame {
    public void open() {
        System.out.println("Window opened.");
    }

    public void close() {
        System.out.println("Window closed.");
    }

    public void move(int x, int y) {
        frame.setLocation(x, y);
        System.out.println("Window moved to (" + x + ", " + y + ").");
    }

    public void display() {
        frame.setVisible(true);
        System.out.println("Window displayed.");
    }

    public void handleEvent(String event) {
        System.out.println("Handling event: " + event);
    }
}

class Event {
    public void triggerEvent(String eventName) {
        System.out.println("Event triggered: " + eventName);
    }
}

abstract class Shape {
    Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw(Graphics g);

    public void erase(Graphics g) {
        g.setColor(Color.WHITE);
    }

    public void move(int x, int y) {
        System.out.println("Shape moved to (" + x + ", " + y + ").");
    }

    public void resize(double scale) {
        System.out.println("Shape resized by a factor of " + scale);
    }
}

class Circle extends Shape {
    private float radius;
    private int centerX, centerY;

    public Circle(int centerX, int centerY, float radius, Color color) {
        super(color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public void setCenter(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(centerX - (int) radius, centerY - (int) radius, (int) radius * 2, (int) radius * 2);
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}

class Polygon extends Shape {
    private int[] xPoints, yPoints;

    public Polygon(int[] xPoints, int[] yPoints, Color color) {
        super(color);
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class DrawingContext {
    public void setPoint(Point point) {
        System.out.println("Setting point at (" + point.x + ", " + point.y + ")");
    }

    public void clearScreen(Graphics g) {
        g.clearRect(0, 0, 800, 600);
        System.out.println("Screen cleared.");
    }

    public int getVerticalSize() {
        return 600;
    }

    public int getHorizontalSize() {
        return 800;
    }
}

class ConsoleWindow extends Window {
    public void displayConsole() {
        System.out.println("Console window displayed.");
    }
}

class DialogBox extends Window {
    public void showDialog() {
        System.out.println("Dialog box displayed.");
    }
}

class DataController {
    public void saveData() {
        System.out.println("Data saved.");
    }

    public void loadData() {
        System.out.println("Data loaded.");
    }
}

public class PaintSoftware extends Window {
    public static void main(String[] args) {
        PaintSoftware app = new PaintSoftware();
        app.open();
        app.display();

        DrawingContext drawingContext = new DrawingContext();
        DataController dataController = new DataController();

        app.frame.add(new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Shape circle = new Circle(250, 300, 50, Color.PINK);
                Shape rectangle = new Rectangle(400, 400, 100, 50, Color.BLUE);
                int[] xPoints = {400, 450, 500};
                int[] yPoints = {400, 350, 400};
                Shape polygon = new Polygon(xPoints, yPoints, Color.GREEN);

                circle.draw(g);
                rectangle.draw(g);
                polygon.draw(g);
            }
        });

        app.frame.setVisible(true);
    }
}
