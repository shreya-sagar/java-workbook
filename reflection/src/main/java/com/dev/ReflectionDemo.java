package com.dev;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
        Person person = new Person();
        Class<?> personClass = person.getClass();
        System.out.println("getName: " + personClass.getName());
        System.out.println("getPackage: " + personClass.getPackage());
        fieldDemo();
        methodDemo();
        newInstanceDemo();
    }

    public static void fieldDemo() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        Class<?> personClass = person.getClass();

        //getField can only access public fields, will throw java.lang.NoSuchFieldException for private/default/protected fields
        Field fieldLastName = personClass.getField("lastName");
        String lastName = (String) fieldLastName.get(person);
        System.out.println("lastName: " + lastName);

        Field fieldFirstName = personClass.getDeclaredField("firstName");
        //will throw java.lang.IllegalAccessException if setAccessible(true) not called on private fields
        fieldFirstName.setAccessible(true);
        String firstName = (String) fieldFirstName.get(person);
        System.out.println("firstName: " + firstName);

        fieldFirstName.set(person, "Johnnie");
        System.out.println("Updated firstName: " + fieldFirstName.get(person));
    }

    public static void methodDemo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class<?> personClass = person.getClass();

        Method getDefaultPerson = personClass.getMethod("getDefaultPerson");
        Method getPublicCustomPerson = personClass.getMethod("getPublicCustomPerson", String.class, String.class);

        /*
          Java differentiates between primitive types (e.g., int) and their wrapper classes (e.g., Integer).
          Even though Java's autoboxing can automatically convert int to Integer when passing values to methods, reflection does not handle autoboxing for method signatures.
        */
        Method getPrivateCustomPerson = personClass.getDeclaredMethod("getPrivateCustomPerson", String.class, int.class);
        getPrivateCustomPerson.setAccessible(true);
        String privatePerson = (String) getPrivateCustomPerson.invoke(person, "Shreya", 123);
        System.out.println("privatePerson: " + privatePerson);
    }

    public static void newInstanceDemo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("java.util.Date");
        Object object = aClass.getDeclaredConstructor().newInstance();
        System.out.println("new instance of java.util.Date: " + object);

        Class<?> personClass = Class.forName("com.dev.Person");
        Object newPersonInstance = personClass.getDeclaredConstructor().newInstance();
        System.out.println("new instance of com.dev.Person: " + newPersonInstance);
    }
}