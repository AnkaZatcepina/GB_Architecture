package com.anna.lesson5;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);
    void renderAllModels();
    
    Texture createTexture();
    Boolean deleteTexture(Texture texture);

}
