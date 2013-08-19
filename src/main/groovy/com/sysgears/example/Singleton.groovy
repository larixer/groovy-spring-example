package com.sysgears.example

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

/**
 * This is an example of singleton that depends on the environment objects
 */
@Named
@javax.inject.Singleton
class Singleton {

    /**
     * Object that contains greeting text passed through environment
     */
    private @Inject EnvObject1 envGreetingText

    /**
     * Object that contains greeting name passed through environment
     */
    private @Inject EnvObject2 envGreetingName

    /**
     * Greeter instance factory 
     */
    private @Inject Provider<Greeter> greeterProvider

    /**
     * Outputs greeting with 2 instance of greeter.
     * 
     * @return greeting text
     */
    public String greet() {
        def greeter1 = greeterProvider.get()
        def greeter2 = greeterProvider.get()
        
        greeter1.greet(envGreetingText.greetingText, envGreetingName.greetingName) + "\n" +
            greeter2.greet(envGreetingText.greetingText, envGreetingName.greetingName)
    }
}
