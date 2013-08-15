package com.sysgears.example

import javax.inject.Named

/**
 * Counter of greeter instances
 */
@Named
@javax.inject.Singleton
class GreeterCounter {
    
    /** Greeter instance current count */
    private int instanceCount = 1

    /**
     * Returns Greeter current instance count and increments counter 
     * 
     * @return Greeter current instance count 
     */
    public int incrementCounter() {
        instanceCount++
    } 
}
