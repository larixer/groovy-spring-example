package com.sysgears.example

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.core.env.MapPropertySource;

class Main
{
    /**
     * Launches the application.
     * 
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        def ctx = new AnnotationConfigApplicationContext()
       
        // Parse command line parameters and push all the external configuration to application environment 
        def appProps = new MapPropertySource("appProps", [
                greeting: new EnvObject1(greetingText: "Hello"),
                greetingSubject: args.length > 0 ? args[0] : "world" 
        ] as Map<String, Object>)

        // Push environment properties to Spring application context 
        ctx.getEnvironment().getPropertySources().addFirst(appProps);

        // Point Spring to IoC configuration of the application
        ctx.register(AppConfig.class);
        
        // Wire dependencies 
        ctx.refresh();
        
        // Launch the application
        def app = ctx.getBean(Application.class)

        app.run()
    }

}