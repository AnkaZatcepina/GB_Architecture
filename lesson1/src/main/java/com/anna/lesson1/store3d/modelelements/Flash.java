package com.anna.lesson1.store3d.modelelements;
import java.awt.*;  

public class Flash {
    
    //region Constructors
    public Flash(Point3D location, Angle3D angle, Color color, float power)
    {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash(Point3D location) {
        this.location = location;
        this.angle = new Angle3D();
        this.color = new Color(255, 255, 255);
        this.power = 100;
    }
    //endregion

    //region Methods
    public void rotate(Angle3D angle){
        this.angle = angle;
    }
    
    public void move(Point3D location) {
        this.location = location;
    }
    //endregion

    //region Public Properties
    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }
    //endregion

    //region Private Fields
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private float power;
    //endregion
}
