package com.sysgears.example

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.env.MapPropertySource
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.inject.Inject

@ContextConfiguration(classes = AppConfig.class, initializers = TestContextInitializer.class)
class SingletonSpec extends Specification {
    private @Inject Singleton singleton

    public static class TestContextInitializer implements
            ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext ctx) {
            def appProps = new MapPropertySource("appProps", [
                    greeting: new EnvObject1(greetingText: "TestHello"),
                    greetingSubject: "TestWorld"
            ] as Map<String, Object>)

            ctx.getEnvironment().getPropertySources().addFirst(appProps);
        }
    }

    def 'check singleton greeting generation'() {
        expect: 'should generate correct greeting'

        singleton.greet().trim() == '''
TestHello, TestWorld! (from greeter 1)
TestHello, TestWorld! (from greeter 2)
'''.trim()
    }
}
