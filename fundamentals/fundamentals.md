

* The `javac` command _compiles_ the Java source code into an intermediate machine-independent representation, called _byte codes_, and saves them in _class_ files.
* The `java` command launches a _virtual machine_ that loads the class files and executes the byte codes. 
* Once compiled, byte codes can run on any Java virtual machine, whether on your desktop computer or on a device in a galaxy far, far away. The promise of **“write once, run anywhere”** was an important design criterion for Java.
* **If your program consists of a single source file**, then you can skip the compilation step and run the program with the command
```
java ch01/sec01/HelloWorld.java
```
**Java 11 and later** introduced this feature where you can run the Java source file directly. Here's what happens behind the scenes:
1. **Implicit Compilation**: The JVM automatically compiles the `.java` file into bytecode, but this process is done in memory. This means that you don’t get a physical `.class` file saved to the disk.
2. **Temporary Bytecode Execution**: After compiling the source file, the JVM immediately runs the resulting bytecode. The bytecode only exists during the runtime and is discarded after execution, which is why no `.class` file is produced.

**NOTE:**
If your program has dependencies between classes across different files, you'd need to compile and link all these files together explicitly using `javac`.
The `java` command with a single `.java` file won't handle compiling multiple files or managing a project with complex structures (e.g., packages, modules, or libraries).

* On Unix-like operating systems, you can turn a Java file into an executable program by following these steps:

1. Rename the file so that it doesn’t have extension .java:
     ```
     mv HelloWorld.java hello
     ```
2. Make the file executable:
   ```
   chmod +x hello
   ```
3. Add a “shebang” line at the top of the file:
   ```
   #!/path/to/jdk/bin/java --source 17
   ```
   Now you can run the program as
   ```
   ./hello
   ```

* `System.out` is an object. It is an instance of a class called `PrintStream`. The `PrintStream` class has methods `println`, `print`, and so on. These methods are called _instance methods_ because they operate on objects, or instances, of the class.
* You can have `JShell` fill in the type for you or import. Another useful feature of `JShell` is usage of TAB key for autocompletion. In the autocompletion list, methods that may require an argument are only followed by a left parenthesis, such as `nextDouble(`, but methods without arguments have both parentheses, such as `nextBoolean()`.
![image](https://github.com/user-attachments/assets/6331287f-47ef-47e2-ac6d-7656f0fe7b00)
By default, JShell imports the following packages:
```java
java.io
java.math
java.net
java.nio.file
java.util
java.util.concurrent
java.util.function
java.util.prefs
java.util.regex
java.util.stream
```
To get help, type /help and Enter. To exit, type /exit and Enter, or simply Ctrl+D.

* The signed integer types (`byte`, `short`, `int`, `long`) are for numbers without fractional parts. `Integer`, `Long`, `Short`, and `Byte` classes have `MIN_VALUE` and `MAX_VALUE` constants. 
* You write `long` integer literals with a suffix `L` (for example, `4000000000L`). 
* Hexadecimal literals have a prefix `0x` (for example, `0xCAFEBABE`). 
* Binary values have a prefix `0b`. For example, `0b1001` is 9. 
* **CAUTION** : Octal numbers have a prefix 0. For example, 011 is 9. This can be confusing, so it seems best to stay away from octal literals and leading zeroes.
* **NOTE** : If you work with `integer` values that can never be negative and you really need an additional bit, you can, with some care, interpret `signed` integer values as `unsigned`. 
For example, a `byte` value b represents the range from –128 to 127. If you want a range from 0 to 255, you can still store it in a byte. 
Due to the nature of binary arithmetic, addition, subtraction, and multiplication will all work, provided they don’t overflow. 
For other operations, call `Byte.toUnsignedInt(b)` to get an `int` value between 0 and 255, then process the `integer` value, and cast the result back to `byte`. 
The `Integer` and `Long` classes have methods for unsigned division and remainder.
* 
