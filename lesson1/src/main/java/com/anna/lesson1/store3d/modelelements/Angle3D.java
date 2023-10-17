package com.anna.lesson1.store3d.modelelements;

public class Angle3D {

    //region Constructors

    public Angle3D(double horizontal, double vertical)
    {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public Angle3D() {}

    //endregion

    //region Public Properties

    public double getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(double horizontal) {
        this.horizontal = horizontal;
    }

    public double getVertical() {
        return vertical;
    }

    public void setVertical(double vertical) {
        this.vertical = vertical;
    }

    //endregion

    //region Private Fields

    private double horizontal = 0, vertical = 0;

    //endregion
    
}
