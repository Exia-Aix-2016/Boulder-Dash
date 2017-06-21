package engine;

import java.awt.*;
import java.awt.event.KeyListener;

public interface IEngine {
    void addKeyListener(KeyListener keyListener);
    Context getContext(Rectangle rectangle);
}
