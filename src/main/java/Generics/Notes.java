package Generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notes {

    //Generics allow the author of a class or method to introduce type parameters, which are symbols that can be substituted for any concrete type
    //Generics allow us to create classes that work with different data types
    //With generics, you can create type-safe collections where more problems are caught at compile-time instead of runtime
    //The idea is to allow type (Integer, String, etc, and user-defined types) to be a parameter to methods, classes, and interfaces.
    //Object is the super class of all other classes, so using Object as a reference can refer to any object
    //This lacks type-safety
    //Generics allow us to have type-safety
    //In Parameter type we can not use primitives like int, char, or double
    //3 main things to know about Generics
    //Creating instances of generified classes
    //Example: When u make an arraylist, u have to tell it the type of objects u will allow in the list
    //Declaring and assigning variables of generic types
    //Declaring and invoking methods that take generic types
    //A generic class means that the class declaration includes a type parameter
    //A generic method means that the method declaration uses a type parameter in its signature
    //In generics, "extends" means "extends or implements"
    //You can bound type parameters by using the extends keyword

    public static <Person> void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        final Person youngestCastMember = min(madMen, new AgeComparator());

        System.out.println(youngestCastMember);
    }

    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("Unable to find the minimum of an empty list");
        }

        T lowestFound = values.get(0);

        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if (comparator.compare(element, lowestFound) < 0) {
                lowestFound = element;
            }
        }

        return lowestFound;
    }
}
