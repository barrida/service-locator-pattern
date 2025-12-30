
# Service Locator (Java ServiceLoader) – Maven Multi-Module Project

This project demonstrates the Service Locator pattern in Java using the **ServiceLoader** API and the Java Module System (`module-info.java`). It consists of three modules:

- `api`: defines the `Service` API (an interface)
- `impl`: provides an implementation of `Service` and declares it with `provides ... with ...` in `module-info.java`
- `app`: consumes the service via `ServiceLoader` and declares `uses ...` in `module-info.java`

## Requirements
- Java 21 (or Java 17+ should work as well)
- Maven 3.8+

## Structure
```
service-locator-maven/
    ├─ pom.xml                 # parent/aggregator
    api/
    └─ src/main/java/
        ├─ com/example/api/User.java
        ├─ com/example/api/UserService.java
        └─ module-info.java
    
    impl/
    └─ src/main/java/
        ├─ com/example/impl/UserServiceImpl.java
        └─ module-info.java
    
    app/
    └─ src/main/java/
        ├─ com/example/app/UserController.java
        ├─ com/example/app/UserServiceLocator.java
        └─ module-info.java
```

## Compile & Run with javac/java

### Compile (Git Bash)
```bash
javac \
  -d out/api \
  api/src/main/java/module-info.java \
  $(find api/src/main/java -name "*.java" -not -name "module-info.java")
````

```bash
javac \
  --module-path out/api \
  -d out/impl \
  impl/src/main/java/module-info.java \
  $(find impl/src/main/java -name "*.java" -not -name "module-info.java")
````

```bash
javac \
  --module-path out/api \
  -d out/app \
  app/src/main/java/module-info.java \
  $(find app/src/main/java -name "*.java" -not -name "module-info.java")
  
````

### Run

```bash
java --module-path "out/api;out/impl;out/app" --module com.example.app/com.example.app.Main
```

### C) One-shot compile using `--module-source-path` (if you flatten sources)

If you prefer a single `javac` command, put sources under a common root like:

    api/
    └─ src/main/java/
        ├─ com/example/api/User.java
        ├─ com/example/api/UserService.java
        └─ module-info.java
    
    impl/
    └─ src/main/java/
        ├─ com/example/impl/UserServiceImpl.java
        └─ module-info.java
    
    app/
    └─ src/main/java/
        ├─ com/example/app/UserController.java
        ├─ com/example/app/UserServiceLocator.java
        └─ module-info.java

Then compile and run:

```bash
javac --module-source-path src -d out -m com.example.api,com.example.impl,com.example.app
java --module-path out --module com.example.app/com.example.app.Main "Hello"
```