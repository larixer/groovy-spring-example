package com.sysgears.example

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.inject.Inject

@ContextConfiguration(classes = AppConfig.class)
class GreeterSpec extends Specification {
    private @Inject Greeter greeter
    
    def 'check greeting'() {
        expect: 'should generate correct greet string'
        greeter.greet('Hello', 'Test') == 'Hello, Test! (from greeter 1)' 
    }
}
