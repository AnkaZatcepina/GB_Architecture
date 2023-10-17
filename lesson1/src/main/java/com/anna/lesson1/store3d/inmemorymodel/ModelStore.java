package com.anna.lesson1.store3d.inmemorymodel;

import java.util.ArrayList;
import java.util.Collection;

import com.anna.lesson1.store3d.modelelements.Camera;
import com.anna.lesson1.store3d.modelelements.Scene;
import com.anna.lesson1.store3d.modelelements.Flash;
import com.anna.lesson1.store3d.modelelements.PoligonalModel;

public class ModelStore implements ModelChanger {

    //region Constructors

    public ModelStore(  Collection<PoligonalModel> models,
                        Collection<Scene> scenes,
                        Collection<Flash> flashes,
                        Collection<Camera> cameras)
    {
        this.models = models;
        this.scenes = scenes;
        this.flashes = flashes;
        this.cameras = cameras;
    }
    //endregion

    /**
     * Нотифицирует о событии
     */
    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }

    //region Methods
    public Scene getScene(int sceneId) {
        for (Scene scene : scenes) {
            if (scene.getId() == sceneId) {
                return scene;
            }
        }
        return null;
    }
    
    public void addPoligonalModel(PoligonalModel model) {
        models.add(model);
    }
    public void delPoligonalModel(PoligonalModel model) {
        models.remove(model);
    }
    public void addScene(Scene scene) {
        scenes.add(scene);
    }
    public void delScene(Scene scene) {
        scenes.remove(scene);
    }
    //endregion

    //region Public Properties
    public Collection<PoligonalModel> getPoligonalModels() {
        return models;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public Collection<Scene> getPoligonalScenes() {
        return scenes;
    }
    //endregion

    //region Private Fields
    private Collection<PoligonalModel> models;
    private Collection<Scene> scenes;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;
    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();
    //endregion
}

