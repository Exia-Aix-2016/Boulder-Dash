package engine;

import engine.fx.FxEngine;
import engine.rendering.RenderingEngine;
import engine.sound.SoundEngine;

public class Engine {

    private static Engine engine = null;

    private FxEngine fxEngine;
    private SoundEngine soundEngine;
    private RenderingEngine renderingEngine;

    private Engine(){
        fxEngine = new FxEngine();
        soundEngine = new SoundEngine();
        renderingEngine = new RenderingEngine();
    }

    public static Engine getInstance(){
        if (engine == null){
            engine = new Engine();
        }
        return engine;
    }

    public FxEngine getFxEngine() {
        return fxEngine;
    }

    public SoundEngine getSoundEngine() {
        return soundEngine;
    }

    public RenderingEngine getRenderingEngine() {
        return renderingEngine;
    }
}
