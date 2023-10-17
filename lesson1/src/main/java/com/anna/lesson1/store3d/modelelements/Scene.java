package com.anna.lesson1.store3d.modelelements;

import java.util.Collection;

public class Scene {

    //region Constructors

    public Scene(Collection<PoligonalModel> models,  Collection<Camera> cameras, Collection<Flash> flashes)
    {
        this.id = ++counter;
        this.models = models;
        this.cameras = cameras;
        this.flashes = flashes;
    }    
    
    public Scene(Collection<PoligonalModel> models, Collection<Camera> cameras)
    {
        this.id = ++counter;
        this.models = models;
        this.cameras = cameras;
    }
    //endregion

    
    //region Methods
    public void start() {
        //TODO: Запустить сцену
    }
    public void stop() {
        //TODO: Остановить сцену
    }
    public void addPoligonalModel(PoligonalModel model) {
        models.add(model);
    }
    public void delPoligonalModel(PoligonalModel model) {
        models.remove(model);
    }
    //endregion

    //region Public Properties
    public int getId() {
        return id;
    }
    public Collection<PoligonalModel> getPoligonalModels() {
        return models;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public Collection<Camera> getPoligonalCameras() {
        return cameras;
    }
    //endregion


    //region Private Fields

    private static int counter = 0;
    private int id;
    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;

    //endregion
}

