package com.sysgears.example

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

/**
 * Class that uses multiple greeter instances to output several greetings.
 */
@Named
@javax.inject.Singleton
class MultiGreeter {

    /**
     * Object that contains greeting text and name passed through environment
     */
    private @Inject GreetInfo greetInfo

    /**
     * Greeter instance factory 
     */
    private @Inject Provider<Greeter> greeterProvider

    /**
     * Outputs greeting with 2 instances of greeter.
     * 
     * @return greeting text
     */
    public String greet() {
        def greeter1 = greeterProvider.get()
        def greeter2 = greeterProvider.get()
        
        greeter1.greet(greetInfo.text, greetInfo.name) + "\n" +
                greeter2.greet(greetInfo.text, greetInfo.name)
    }
}
