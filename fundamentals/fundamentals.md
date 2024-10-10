

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

* 
