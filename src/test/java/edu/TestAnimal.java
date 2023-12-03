package edu;
import edu.Animal.Sex;
import edu.Animal.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

public class TestAnimal {
    private final List<Animal> animals = new ArrayList<>();

    @BeforeEach
    public void clearList() {
        animals.clear();
    }

    @Test
    @DisplayName("#sortAnimalsByHeight test")
    public void sortByHeightByHeight() {
        animals.add(Animal.builder().height(32).build());
        animals.add(Animal.builder().height(24).build());
        animals.add(Animal.builder().height(11).build());
        animals.add(Animal.builder().height(54).build());
        List<Integer> actual =
            AnimalUtils.sortAnimalsByHeight(animals).stream().map(Animal::height).collect(Collectors.toList());
        assertThat(actual).containsExactly(
            11, 24, 32, 54
        );
    }

    @Test
    @DisplayName("#sortAnimalsByWeightAndGetTopK test")
    public void sortByWeightDesc() {
        animals.add(Animal.builder().weight(32).build());
        animals.add(Animal.builder().weight(24).build());
        animals.add(Animal.builder().weight(11).build());
        animals.add(Animal.builder().weight(54).build());
        List<Integer> actual =
            AnimalUtils.sortAnimalsByWeightAndGetTopK(animals, 3).stream().map(Animal::weight).collect(Collectors.toList());
        assertThat(actual).containsExactly(
            54, 32, 24
        );
    }

    @Test
    @DisplayName("#countAnimalTypes test")
    public void countAnimalTypesItsNumbers() {
        animals.add(Animal.builder().type(Type.DOG).build());
        animals.add(Animal.builder().type(Type.DOG).build());
        animals.add(Animal.builder().type(Type.CAT).build());
        animals.add(Animal.builder().type(Type.FISH).build());
        Map<Type, Long> actual = AnimalUtils.countAnimalTypes(animals);
        assertThat(actual).contains(entry(Type.FISH, 1L), entry(Type.DOG, 2L), entry(Type.CAT, 1L));
    }

    @Test
    @DisplayName("#findAnimalWithLongestName test")
    public void getAnimalWithLongestName() {
        animals.add(Animal.builder().name("Richard").build());
        animals.add(Animal.builder().name("Bulka").build());
        animals.add(Animal.builder().name("Sharick").build());
        animals.add(Animal.builder().name("Alexandr").build());
        Animal actual = AnimalUtils.findAnimalWithLongestName(animals);
        assertThat(actual.name()).isEqualTo("Alexandr");
    }

    @Test
    @DisplayName("#findDominantSex test")
    public void getMostPopularSex() {
        animals.add(Animal.builder().sex(Sex.M).build());
        animals.add(Animal.builder().sex(Sex.F).build());
        animals.add(Animal.builder().sex(Sex.F).build());
        animals.add(Animal.builder().sex(Sex.F).build());
        Sex actual = AnimalUtils.findDominantSex(animals);
        assertThat(actual).isEqualTo(Sex.F);
    }

    @Test
    @DisplayName("#findHeaviestAnimalOfEachType test")
    public void getHeaviestAnimalOfEachType() {
        animals.add(Animal.builder().type(Type.DOG).weight(400).build());
        animals.add(Animal.builder().type(Type.DOG).weight(350).build());
        animals.add(Animal.builder().type(Type.DOG).weight(200).build());
        animals.add(Animal.builder().type(Type.CAT).weight(70).build());
        Map<Type, Animal> actual = AnimalUtils.findHeaviestAnimalOfEachType(animals);
        assertThat(actual).contains(
            entry(Type.DOG, Animal.builder().type(Type.DOG).weight(400).build()),
            entry(Type.CAT, Animal.builder().type(Type.CAT).weight(70).build())
        );
    }

    @Test
    @DisplayName("#findKthOldestAnimal test")
    public void getTheKthOldestAnimal() {
        animals.add(Animal.builder().age(10).build());
        animals.add(Animal.builder().age(7).build());
        animals.add(Animal.builder().age(2).build());
        animals.add(Animal.builder().age(15).build());
        Animal actual = AnimalUtils.findKthOldestAnimal(animals, 3);
        assertThat(actual.age()).isEqualTo(7);
    }

    @Test
    @DisplayName("#findHeaviestAnimalBelowHeight test")
    public void getTheHeaviestAnimalUnderGivenHeightGivenHeight() {
        animals.add(Animal.builder().height(110).weight(200).build());
        animals.add(Animal.builder().height(120).weight(150).build());
        animals.add(Animal.builder().height(100).weight(250).build());
        animals.add(Animal.builder().height(90).weight(80).build());
        Optional<Animal> actual = AnimalUtils.findHeaviestAnimalBelowHeight(animals, 115);
        assertThat(actual.get()).isEqualTo(Animal.builder().height(100).weight(250).build());
    }

    @Test
    @DisplayName("#getTotalNumberOfPaws test")
    public void countPawsAmountOfPaws() {
        animals.add(Animal.builder().type(Type.SPIDER).build());
        animals.add(Animal.builder().type(Type.DOG).build());
        animals.add(Animal.builder().type(Type.CAT).build());
        animals.add(Animal.builder().type(Type.CAT).build());
        Integer actual = AnimalUtils.getTotalNumberOfPaws(animals);
        assertThat(actual).isEqualTo(20);
    }

    @Test
    @DisplayName("#getTotalNumberOfPaws test")
    public void getAnimalsWhichAgeDoesntEqualTheirPawsOfRightAnimals() {
        animals.add(Animal.builder().type(Type.CAT).age(4).build());
        animals.add(Animal.builder().type(Type.DOG).age(5).build());
        animals.add(Animal.builder().type(Type.FISH).age(4).build());
        animals.add(Animal.builder().type(Type.FISH).age(0).build());
        List<Animal> actual = AnimalUtils.findAnimalsWithMismatchedAgeAndPaws(animals);
        assertThat(actual.stream().map(Animal::age).collect(Collectors.toList())).containsExactly(5, 4);
    }

    @Test
    @DisplayName("#findBitingAnimalsAboveHeight test")
    public void getBitingAnimalsBitingAnimals() {
        animals.add(Animal.builder().bites(true).height(110).build());
        animals.add(Animal.builder().bites(true).height(70).build());
        animals.add(Animal.builder().bites(false).height(120).build());
        List<Animal> actual = AnimalUtils.findBitingAnimalsAboveHeight(animals);
        assertThat(actual).hasSize(1);
    }

    @Test
    @DisplayName("#countAnimalsWithWeightExceedingHeight test")
    public void getNumberOfAnimalsWhichWeightGreater() {
        animals.add(Animal.builder().weight(180).height(100).build());
        animals.add(Animal.builder().weight(150).height(120).build());
        animals.add(Animal.builder().weight(80).height(100).build());
        animals.add(Animal.builder().weight(150).height(100).build());
        Integer actual = AnimalUtils.countAnimalsWithWeightExceedingHeight(animals);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("#findAnimalsWithMultipleWordNames test")
    public void getAnimalsWhichNameConsistsOfTwoWord() {
        animals.add(Animal.builder().name("Michael Bury Johy").build());
        animals.add(Animal.builder().name("John Order").build());
        animals.add(Animal.builder().name("Mike Tyson Ogy").build());
        animals.add(Animal.builder().name("Billy").build());
        List<Animal> actual = AnimalUtils.findAnimalsWithMultipleWordNames(animals);
        assertThat(actual.stream().map(Animal::name).collect(Collectors.toList())).containsExactly(
            "Michael Bury Johy",
            "Mike Tyson Ogy"
        );
    }

    @Test
    @DisplayName("#hasTallDog test")
    public void doesListContainDogWithHeightGreater() {
        animals.add(Animal.builder().type(Type.DOG).height(100).build());
        animals.add(Animal.builder().type(Type.DOG).height(80).build());
        animals.add(Animal.builder().type(Type.CAT).height(100).build());
        animals.add(Animal.builder().type(Type.SPIDER).height(15).build());
        boolean actual = AnimalUtils.hasTallDog(animals, 95);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("#sumWeightsOfAnimalsInAgeRange test")
    public void getTotalWeightOfAnimalsWithAgeInGivenRangeTotalSumm() {
        animals.add(Animal.builder().weight(120).age(10).build());
        animals.add(Animal.builder().weight(120).age(8).build());
        animals.add(Animal.builder().weight(90).age(13).build());
        animals.add(Animal.builder().weight(120).age(11).build());
        Integer actual = AnimalUtils.sumWeightsOfAnimalsInAgeRange(animals, 10, 15);
        assertThat(actual).isEqualTo(330);
    }

    @Test
    @DisplayName("#sortAnimalsByTypeAndSexAndName test")
    public void sortAnimalsByTypeSexNameSortedList() {
        animals.add(Animal.builder().type(Type.BIRD).sex(Sex.F).name("Bird1").build());
        animals.add(Animal.builder().type(Type.BIRD).sex(Sex.M).name("Bird3").build());
        animals.add(Animal.builder().type(Type.BIRD).sex(Sex.F).name("Bird2").build());
        animals.add(Animal.builder().type(Type.CAT).sex(Sex.F).name("Cat1").build());
        animals.add(Animal.builder().type(Type.CAT).sex(Sex.F).name("Cat2").build());
        List<Animal> actual = AnimalUtils.sortAnimalsByTypeAndSexAndName(animals);
        assertThat(actual).containsExactly(
            Animal.builder().type(Type.CAT).sex(Sex.F).name("Cat1").build(),
            Animal.builder().type(Type.CAT).sex(Sex.F).name("Cat2").build(),
            Animal.builder().type(Type.BIRD).sex(Sex.M).name("Bird3").build(),
            Animal.builder().type(Type.BIRD).sex(Sex.F).name("Bird1").build(),
            Animal.builder().type(Type.BIRD).sex(Sex.F).name("Bird2").build()
        );
    }

    @Test
    @DisplayName("#spidersBiteMoreOftenThanDogs test")
    public void isSpidersBiteMoreThanDogs() {
        animals.add(Animal.builder().type(Type.SPIDER).bites(true).build());
        animals.add(Animal.builder().type(Type.SPIDER).bites(true).build());
        animals.add(Animal.builder().type(Type.DOG).bites(true).build());
        boolean actual = AnimalUtils.spidersBiteMoreOftenThanDogs(animals);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("#findHeaviestFishInLists test")
    public void getTheHeaviestFishInTwoOrMoreLists() {
        animals.add(Animal.builder().type(Type.FISH).weight(100).build());
        animals.add(Animal.builder().type(Type.DOG).weight(100).build());
        List<Animal> animals2 = new ArrayList<>();
        animals2.add(Animal.builder().type(Type.CAT).weight(200).build());
        List<Animal> animals3 = new ArrayList<>();
        animals3.add(Animal.builder().type(Type.FISH).weight(300).build());

        Animal actual = AnimalUtils.findHeaviestFishInLists(animals, animals2, animals3);
        assertThat(actual).isEqualTo(animals3.get(0));
    }

    public static Stream<Arguments> validationErrors() {
        return Stream.of(
            Arguments.of(
                List.of(
                    new Animal("Emma", Animal.Type.DOG, Animal.Sex.F,
                        11, -120, 36, false
                    ),
                    new Animal("Grigoryy", Animal.Type.DOG, Animal.Sex.M,
                        10, 103, 20, true
                    ),
                    new Animal("Genadiy", Animal.Type.CAT, Animal.Sex.M,
                        4, 50, 13, true
                    )
                ),
                Map.of(
                    "Emma", Set.of(new ValidationError("height", "Height can be more than 0!"))
                )
            ),
            Arguments.of(
                List.of(
                    new Animal("Emma", Animal.Type.DOG, Animal.Sex.F,
                        11, -120, 36, false
                    ),
                    new Animal("Grigoryy", Animal.Type.DOG, Animal.Sex.M,
                        -10, 103, -20, true
                    ),
                    new Animal("Genadiy", Animal.Type.CAT, Animal.Sex.M,
                        -4, -50, -13, true
                    )
                ),
                Map.of(
                    "Emma", Set.of(new ValidationError("height", "Height can be more than 0!")),
                    "Grigoryy", Set.of(
                        new ValidationError("age", "Age can be more than 0!"),
                        new ValidationError("weight", "Weight can be more than 0!")
                    ),
                    "Genadiy", Set.of(
                        new ValidationError("age", "Age can be more than 0!"),
                        new ValidationError("height", "Height can be more than 0!"),
                        new ValidationError("weight", "Weight can be more than 0!")
                    )
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("validationErrors")
    public void findValidationExceptionsAnimals(
        List<Animal> animals,
        Map<String, Set<ValidationError>> errors
    ) {
        assertThat(AnimalUtils.findExceptionsAnimals(animals)).isEqualTo(errors);
    }

    public static Stream<Arguments> validationErrorsPrettier() {
        return Stream.of(
            Arguments.of(
                List.of(
                    new Animal("Emma", Animal.Type.DOG, Animal.Sex.F,
                        11, -120, 36, false
                    ),
                    new Animal("Grigoryy", Animal.Type.DOG, Animal.Sex.M,
                        10, 103, 20, true
                    ),
                    new Animal("Genadiy", Animal.Type.CAT, Animal.Sex.M,
                        4, 50, 13, true
                    )
                ),
                Map.of(
                    "Emma", "height")
            ),
            Arguments.of(
                List.of(
                    new Animal("Emma", Animal.Type.DOG, Animal.Sex.F,
                        11, -120, 36, false
                    ),
                    new Animal("Grigoryy", Animal.Type.DOG, Animal.Sex.M,
                        -10, 103, -20, true
                    ),
                    new Animal("Genadiy", Animal.Type.CAT, Animal.Sex.M,
                        -4, -50, -13, true
                    )
                ),
                Map.of(
                    "Emma", "height",
                    "Grigoryy", "age, weight",
                    "Genadiy", "age, weight, height"
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("validationErrorsPrettier")
    public void findValidationExceptionsAnimalsPrettier(
        List<Animal> animals,
        Map<String, String> errors
    ) {
        assertThat(AnimalUtils.findValidationExceptionsAnimalsPrettier(animals)).isEqualTo(errors);
    }
}
