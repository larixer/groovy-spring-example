package com.sysgears.example

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.env.MapPropertySource
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.inject.Inject

@ContextConfiguration(classes = AppConfig.class, initializers = TestContextInitializer.class)
class MultiGreeterSpec extends Specification {
    private @Inject MultiGreeter multiGreeter

    public static class TestContextInitializer implements
            ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext ctx) {
            def appProps = new MapPropertySource("appProps", [
                    greetInfo: new GreetInfo(text: "TestHello", name: "TestWorld")
            ] as Map<String, Object>)

            ctx.getEnvironment().getPropertySources().addFirst(appProps);
        }
    }

    def 'check greeting generation'() {
        expect: 'should generate correct greeting'

        multiGreeter.greet().trim() == '''
TestHello, TestWorld! (from greeter 1)
TestHello, TestWorld! (from greeter 2)
'''.trim()
    }
}
