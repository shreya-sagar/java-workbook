package com.dev;

import java.lang.reflect.Field;

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        Class<?> aClass = person.getClass();
        System.out.println("class: " + aClass.getPackage());

        //getField can only access public fields, will throw java.lang.NoSuchFieldException for private/default/protected fields
        Field fieldLastName = aClass.getField("lastName");
        String lastName = (String) fieldLastName.get(person);
        System.out.println("lastName: " + lastName);

        Field fieldFirstName = aClass.getDeclaredField("firstName");
        //will throw java.lang.IllegalAccessException if setAccessible(true) not called on private fields
        fieldFirstName.setAccessible(true);
        String firstName = (String) fieldFirstName.get(person);
        System.out.println("firstName: " + firstName);

        fieldFirstName.set(person, "Johnnie");
        System.out.println("Updated firstName: " + fieldFirstName.get(person));
    }
}