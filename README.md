# Demonstration of IntelliJ issue

IntelliJ 2020.1.1 201.7223.91 has isse if a source directory is used in two Gradle projects

The `build.gradle` in `buildSrc` has following entry:

```groovy
sourceSets{
    main {
        java {
            srcDir "${project.rootDir}/../src/main/java/shared"
        }
    }
}
```

If a Java class in `src/main/java` accesses a class in that directory, it is not found by the IntelliJ compiler:

```java
package code;

import shared.Loader;

public class App {
    public static void main(String[] args) {
        System.out.println(Loader.TARGET);
    }
}
```

```text
Error:(3, 14) java: package shared does not exist
```

Execution using gradle works:

```terminal
$ ./gradlew run

> Task :run
loader

BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
```
