## Groovy application using Spring IoC template

### Features
- Programmatic [Spring][] configuration using Environment
- [JSR 330][] singleton and prototype annotations
- [Spock][] unit tests that override Environment values with test ones
- Example of [JSR 330][] Provider usage
- [Gradle][] build script that builds, tests the application and creates standalone JAR

## Building from source
This sample Groovy application uses a [Gradle][]-based build system.
Use the instructions below to build the sample:

### Check out sources
`git clone https://github.com/vlasenko/groovy-spring-example.git`

### Compile and test, build standalone jar
`./gradlew`

### Check standalone jar launching
`java -jar build/libs/groovy-spring-example-1.0.jar Guest`

## License
This example is released under [Public Domain License][].

[Spring]: http://www.springsource.org/spring-framework
[JSR 330]: http://download.oracle.com/otndocs/jcp/dependency_injection-1.0-final-oth-JSpec/
[Spock]: http://docs.spockframework.org/en/latest/
[Gradle]: http://gradle.org
[Public Domain License]: UNLICENSE
