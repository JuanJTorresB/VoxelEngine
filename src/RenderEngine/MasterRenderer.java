package RenderEngine;

import org.lwjgl.opengl.GL11; // Used To Grapic Rendering

public class MasterRenderer {

    public void prepare(){

        GL11.glClearColor(0.4F, 0.7F, 1.0F, 1); // Set The Background Color To The Sky Color In The Display
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); // * Clean The Color Buffer (image stored in GPU memory) To Avoid Frames To Mixed Up

    }
}
