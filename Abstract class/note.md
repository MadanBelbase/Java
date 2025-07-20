An **abstract class** in Java is a class that cannot be instantiated directly and is used as a blueprint for other classes. It is designed to be inherited by subclasses that provide implementations for its abstract methods. Abstract classes are useful for defining a common structure and behavior for a group of related classes while allowing specific implementations to vary.

### Key Features of Abstract Classes
1. **Cannot Be Instantiated**: You cannot create objects of an abstract class directly.
2. **Abstract Methods**: These are methods declared without an implementation (no body) using the `abstract` keyword. Subclasses must provide implementations for these methods unless they are also abstract.
3. **Concrete Methods**: Abstract classes can have regular methods with implementations.
4. **Inheritance**: Abstract classes are meant to be extended by subclasses using the `extends` keyword.
5. **Partial Implementation**: They allow a mix of implemented (concrete) and unimplemented (abstract) methods.
6. **Access Modifiers**: Abstract classes can use any access modifier (public, protected, etc.) for their methods and fields.
7. **Fields and Constructors**: Abstract classes can have fields, constructors, and instance variables like regular classes.

### When to Use Abstract Classes
- When you want to define a template for a group of subclasses with shared behavior.
- When you want to enforce certain methods to be implemented by subclasses.
- When you want to share code (fields or methods) among related classes.

### Syntax
```java
abstract class ClassName {
    // Fields
    // Concrete methods
    // Abstract methods
    abstract void methodName();
}
```

### Example of an Abstract Class
Here’s an example to illustrate an abstract class in Java:

```java
// Abstract class
abstract class Animal {
    // Instance variable
    protected String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Concrete method
    public void eat() {
        System.out.println(name + " is eating.");
    }

    // Abstract method (no implementation)
    abstract void makeSound();
}

// Concrete subclass
class Dog extends Animal {
    public Dog(String name) {
        super(name); // Call the constructor of the abstract class
    }

    // Provide implementation for the abstract method
    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof!");
    }
}

// Another concrete subclass
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meows: Meow!");
    }
}

// Main class to test the abstract class
public class Main {
    public static void main(String[] args) {
        // Cannot instantiate: Animal animal = new Animal("Generic"); // Error

        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");

        dog.eat();        // Output: Buddy is eating.
        dog.makeSound();  // Output: Buddy barks: Woof!
        cat.eat();        // Output: Whiskers is eating.
        cat.makeSound();  // Output: Whiskers meows: Meow!
    }
}
```

### Workflow Explanation
1. **Define the Abstract Class**:
   - The `Animal` class is declared as `abstract` and includes a field (`name`), a constructor, a concrete method (`eat`), and an abstract method (`makeSound`).
   - The abstract method `makeSound` has no implementation, forcing subclasses to provide their own.

2. **Extend the Abstract Class**:
   - The `Dog` and `Cat` classes extend `Animal` using the `extends` keyword.
   - They must implement the `makeSound` method, or the compiler will throw an error.
   - They can use the inherited `eat` method and the `name` field via the constructor.

3. **Instantiation and Usage**:
   - You cannot create an `Animal` object directly (e.g., `new Animal("Generic")` will cause a compilation error).
   - Subclasses like `Dog` and `Cat` can be instantiated, and their objects can call both inherited methods (`eat`) and their own implementations of `makeSound`.

4. **Polymorphism**:
   - You can use an `Animal` reference to point to `Dog` or `Cat` objects (e.g., `Animal animal = new Dog("Buddy");`).
   - This allows calling `eat` and `makeSound` polymorphically, where `makeSound` executes the subclass-specific implementation.

### Workflow Diagram (Conceptual)
1. **Abstract Class Creation**:
   - Define `Animal` with shared fields, methods, and abstract methods.
2. **Subclass Implementation**:
   - Subclasses (`Dog`, `Cat`) inherit from `Animal` and implement `makeSound`.
3. **Object Creation**:
   - Create objects of `Dog` or `Cat`, not `Animal`.
4. **Method Invocation**:
   - Call concrete methods (`eat`) and overridden abstract methods (`makeSound`) on subclass objects.

### Key Points
- **Abstract vs. Interface**:
  - Abstract classes can have state (fields) and concrete methods, while interfaces (before Java 8) could not.
  - Abstract classes are used when you want to share code and enforce a contract; interfaces are for defining a contract without implementation.
- **Restrictions**:
  - A class with even one abstract method must be declared `abstract`.
  - Subclasses must implement all abstract methods or be declared `abstract` themselves.
- **Use Case**:
  - Abstract classes are ideal for scenarios like a `Vehicle` class with subclasses like `Car` and `Bike`, where `Vehicle` defines common behavior (e.g., `startEngine`) but leaves specific behavior (e.g., `move`) to subclasses.

### Benefits of Abstract Classes
- **Code Reusability**: Shared code in the abstract class reduces duplication.
- **Enforced Structure**: Subclasses must implement abstract methods, ensuring consistency.
- **Flexibility**: Subclasses can override methods or add new ones as needed.

This example and explanation demonstrate how abstract classes provide a foundation for inheritance and polymorphism in Java, enabling structured and reusable code. If you need further clarification or additional examples, let me know!