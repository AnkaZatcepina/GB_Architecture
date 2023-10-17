package com.anna.lesson1.store3d.modelelements;

public class Camera {
    
    //region Constructors
    public Camera(Point3D location, Angle3D angle)
    {
        this.location = location;
        this.angle = angle;
    }

    public Camera(Point3D location) {
        this.location = location;
        this.angle = new Angle3D();
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
    //endregion

    //region Private Fields
    private Point3D location;
    private Angle3D angle;
      //endregion
}

