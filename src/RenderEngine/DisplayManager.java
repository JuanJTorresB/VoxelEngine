package RenderEngine;

import org.lwjgl.LWJGLException; // * Importation To Handle Exception Related To The Use Of LWJGJ
import org.lwjgl.input.Keyboard; // * Importation To Handle The Keyboard Inputs
import org.lwjgl.input.Mouse; // * Importation To Handle The Mouse Input
import org.lwjgl.opengl.*; // * Importation To Work Whit OpenGL

public class DisplayManager {

    private static final int WIDTH = 1280; // * Display Width
    private static final int HEIGHT = 720; // * Display Height
    private static final int FPS_CAP = 120; // * FPS Limiter

    public static void createDisplay(){ // * Start Running The Display in Wich The Game Will Apear

        ContextAttribs attribs = new ContextAttribs(3,2) //OpenGL 3.2
                .withForwardCompatible(true) // Makes The Context Ignore Obsolete Features
                .withProfileCore(true); // Use The Default Profile For OpenGL
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT)); // Create The Display With The Widht And Height Previusly Specified
            Display.create(new PixelFormat(), attribs); // * Create The Display Wiht The Pixel Format And With The Previus Configuration Of OpenGl 3.2
            Display.setTitle("JavaCraft");
            Display.setFullscreen(true); // todo Set Fullscreen But Is Not Implemented Yet
            GL11.glViewport(0,0,Display.getWidth(),Display.getHeight()); // Where OpenGl Is Going To Render The Our Game
        } catch (LWJGLException e) {
            throw new RuntimeException(e);
        }
        Mouse.setGrabbed(true); // Blocks The Mouse For Default
    }

    public static void updateDisplay(){ // * Start Running The Display in Wich The Game Will Apear

        Display.sync(FPS_CAP); // Set The FPS Cap
        Display.update(); // Refresh The Display To Show The Next Frame

        while (Keyboard.next()){
            if (Keyboard.getEventKeyState() ){ // Checks If The Keyboard Is Being Pressed
                if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
                    closeDisplay(); // Close The Display If ESC Key Is Pressed
                }

                if (Keyboard.isKeyDown(Keyboard.KEY_E) && Mouse.isGrabbed()){ // * This Code Togle The Mouse Pressing The Key E in the Keyboard
                    Mouse.setGrabbed(false);
                } else if (Keyboard.isKeyDown(Keyboard.KEY_E) && !Mouse.isGrabbed()) {
                    Mouse.setGrabbed(true);
                }
            }
        }
    }

    public static void closeDisplay(){

        Display.destroy(); // Unleash Graphic Resource
        System.exit(0); // Finish The Display

    }

}
