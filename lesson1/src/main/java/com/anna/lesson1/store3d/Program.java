package com.anna.lesson1.store3d;
import java.util.ArrayList;
import java.util.Collection;

import com.anna.lesson1.store3d.inmemorymodel.CustomService1;
import com.anna.lesson1.store3d.inmemorymodel.CustomService2;
import com.anna.lesson1.store3d.inmemorymodel.CustomService3;
import com.anna.lesson1.store3d.inmemorymodel.ModelStore;
import com.anna.lesson1.store3d.modelelements.Point3D;
import com.anna.lesson1.store3d.modelelements.Poligon;
import com.anna.lesson1.store3d.modelelements.PoligonalModel;
import com.anna.lesson1.store3d.modelelements.Camera;
import com.anna.lesson1.store3d.modelelements.Flash;
import com.anna.lesson1.store3d.modelelements.Scene;


public class Program {
    public static void main(String[] args) {

        CustomService1 observer1 = new CustomService1();
        CustomService2 observer2 = new CustomService2();
        CustomService3 observer3 = new CustomService3();


        Collection<Point3D> points1 = new ArrayList<Point3D>();
        points1.add(new Point3D(1, 1, 0));
        points1.add(new Point3D(0, 0, 1));
        points1.add(new Point3D(2, 2, 3));
        Poligon triangle1 = new Poligon(points1);

        Collection<Poligon> poligons1 = new ArrayList<Poligon>();
        poligons1.add(triangle1);
        PoligonalModel model1 = new PoligonalModel(poligons1);        
        Collection<PoligonalModel> models1 = new ArrayList<PoligonalModel>();
        models1.add(model1);

        Collection<Camera> cameras1 = new ArrayList<Camera>();
        cameras1.add(new Camera(new Point3D(10,10,10)));
        Collection<Flash> flashes1 = new ArrayList<Flash>();
        flashes1.add(new Flash(new Point3D(7,7,7)));

        Collection<Scene> scenes1 = new ArrayList<Scene>();
        scenes1.add(new Scene(models1, cameras1, flashes1));

        ModelStore modelStore = new ModelStore(models1, scenes1, flashes1, cameras1);
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);


    }

}
