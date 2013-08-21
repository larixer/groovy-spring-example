package com.sysgears.example

import javax.inject.Inject
import javax.inject.Named

/**
 * Class with top-level application logic.
 */
@Named
@javax.inject.Singleton
class Application {
    
    /** Singleton that greets someone. */
    private @Inject MultiGreeter multiGreeter

    /**
     * Main application logic
     */
    public void run() {
        println multiGreeter.greet()
    }
}
