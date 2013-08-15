package com.sysgears.example

import javax.inject.Inject
import javax.inject.Named

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
     * @param subject whom to greet
     * 
     * @return greeting string 
     */
    public String greet(String text, String subject) {
        "${text}, ${subject}! (from greeter ${instanceNo})"
    }
}
