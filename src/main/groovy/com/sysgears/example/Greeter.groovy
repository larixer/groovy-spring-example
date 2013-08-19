package com.sysgears.example

import javax.inject.Inject
import javax.inject.Named

/**
 * Greeter that greets a person with greeting text and output information
 * about instance no of the greeter class.
 */
@Named
class Greeter {
    /** Current greeter instance no */
    private final int instanceNo

    /**
     * Creates an instance of this greater and remembers greeter instance no
     */
    @Inject
    public Greeter(final GreeterCounter greeterCounter) {
        instanceNo = greeterCounter.incrementCounter()
    }

    /**
     * Generates string for greeting {@code subject} with the given {@code text} 
     * 
     * @param text greet text
     * @param name whom to greet
     * 
     * @return greeting string 
     */
    public String greet(String text, String name) {
        "${text}, ${name}! (from greeter ${instanceNo})"
    }
}
