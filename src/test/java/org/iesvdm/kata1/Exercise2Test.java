package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.iesvdm.kata1.PetType.BIRD;

public class Exercise2Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    @DisplayName("doAnyPeopleHaveCats 🐱?")
    public void doAnyPeopleHaveCats()
    {
        //TODO
        // replace null with a Predicate lambda which checks for PetType.CAT
        Predicate<Person> predicate = person -> person.hasPet(PetType.CAT); ;
        boolean AnyPersonHasCat = this.people.stream().anyMatch(predicate);
        //TODO
        // replace false by a check in a stream of people
        Assertions.assertTrue(AnyPersonHasCat, "No person in the list has a cat");
    }

    @Test
    @Tag("KATA")
    public void doAllPeopleHavePets()
    {

        Predicate<Person> predicate = Person::isPetPerson;
        //TODO
        // replace with a method call send to people that checks if all people have pets
        boolean result = this.people.stream()
                .allMatch(predicate);

        Assertions.assertFalse(result);
    }

    @Test
    @Tag("KATA")
    @DisplayName("howManyPeopleHaveCats 🐱?")
    public void howManyPeopleHaveCats()
    {
        //TODO
        // replace with a method call send to this.people that checks how many people have cats
        int count = 0;

        Assertions.assertEquals(2, count);
    }

    @Test
    @Tag("KATA")
    public void findMarySmith()
    {
        //TODO
        // replace with a stream on people to obtain Mary Smith
        Person result = this.people.stream().filter(person -> "Mary"
                .equals(person.getFirstName()) && "Smith"
                .equals(person.getLastName())).findFirst().get();

        Assertions.assertEquals("Mary", result.getFirstName());
        Assertions.assertEquals("Smith", result.getLastName());
    }

    @Test
    @Tag("KATA")
    @DisplayName("findPetNamedSerpy 🐍")
    public void findPetNamedSerpy()
    {
        //TODO
        // transform this into a list of pets from people
        List<Pet> petList = this.people.stream().flatMap(person -> person.getPets().stream())
                .collect(Collectors.toList());

        //TODO
        // obtain serpySnake pet from petList
        Pet serpySnake = petList.stream().filter(pet -> "Serpy"
                .equals(pet.getName())).findFirst().orElse(new Pet(PetType.BIRD,"",0));

        Assertions.assertEquals("🐍",serpySnake.getType().toString());
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithPets()
    {
        //TODO
        // replace with only the pet owners
        List<Person> petPeople = this.people.stream()
                .filter(Person::hasPets) // Usamos el método hasPets para verificar si tienen mascotas
                .collect(Collectors.toList());

        Assertions.assertEquals(7, petPeople.size());
    }

    @Test
    @Tag("KATA")
    public void getAllPetTypesOfAllPeople()
    {
        Function<Person, Map<PetType, Long>> function = Person::getPetTypes;

        //TODO
        // use the previous function to obtain the set of pet types
        Set<PetType> petTypes = this.people.stream()
                .flatMap(person -> person.getPetTypes().keySet().stream())
                .collect(Collectors.toSet());

        var expectedSet = Set.of(PetType.CAT, PetType.DOG, PetType.TURTLE, PetType.HAMSTER, BIRD, PetType.SNAKE);
        Assertions.assertEquals(expectedSet, petTypes);
    }

    @Test
    @Tag("KATA")
    public void getAllPetEmojisOfAllPeople()
    {
        Function<Person, Map<String, Long>> function = Person::getPetEmojis;

        //TODO
        // use the previous function to obtain the set of emojis
        Set<String> petEmojis = this.people.stream()
                .flatMap(person -> person.getPetEmojis().keySet().stream())
                .collect(Collectors.toSet());

        var expected = Set.of("🐱", "🐶", "🐢", "🐹", "🐦", "🐍");
        Assertions.assertEquals(expected, petEmojis);
    }

    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {
        //TODO
        // transform this.people into a list of first names
        List<String> firstNames = new ArrayList<>();

        var expectedList = List.of("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedList, firstNames);
    }

    @Test
    @Tag("KATA")
    @DisplayName("doAnyPeopleHaveCatsRefactor 🐱?")
    public void doAnyPeopleHaveCatsRefactor()
    {
        //TODO
        // test with a stream on people, if anyone has a cat at least
        boolean peopleHaveCatsLambda = this.people.stream()
                .anyMatch(pet -> pet.hasPet(PetType.CAT));
        Assertions.assertTrue(peopleHaveCatsLambda);

    }

    @Test
    @Tag("KATA")
    @DisplayName("doAllPeopleHaveCatsRefactor 🐱?")
    public void doAllPeopleHaveCatsRefactor()
    {
        //TODO
        // test if all the people have cats
        boolean peopleHaveCats = this.people.stream()
                .allMatch(pet -> pet.hasPet(PetType.CAT));
        Assertions.assertFalse(peopleHaveCats);
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCatsRefactor 🐱?")
    public void getPeopleWithCatsRefactor()
    {
        //TODO
        // obtain persons with cats
        List<Person> peopleWithCats = new ArrayList<>();
        Assertions.assertEquals(2, peopleWithCats.size());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCatsRefactor 🐱?")
    public void getPeopleWithoutCatsRefactor()
    {
        //TODO
        // obtain persons without cats
        List<Person> peopleWithoutCats = new ArrayList<>();
        Assertions.assertEquals(6, peopleWithoutCats.size());
    }
}
