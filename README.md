## Example of Groovy application architecture utilizing Spring IoC container

### Features
- Programmatic Spring configuration using Environment
- JSR 330 singleton and prototype annotations
- Spock unit tests that override Environment values with test ones
- Example of JSR 330 Provider usage
- Gradle build script that build, test the application and creates standalone JAR

## Building from source
This sample Groovy application uses a [Gradle][]-based build system.
Use the instructions below to build the sample:

### Check out sources
`git clone git://github.com/vlasenko/groovy-spring-example.git`

### Compile and test, build standalone jar
`./gradlew build`

## License
This example is released under version 2.0 of the [Apache License][].

[Gradle]: http://gradle.org
[Apache License]: http://www.apache.org/licenses/LICENSE-2.0
