package edu;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class AnimalUtils {
    private final static int MIN_HEIGHT = 100;

    private AnimalUtils() {

    }

    //Задание 1
    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    //Задание 2
    public static List<Animal> sortAnimalsByWeightAndGetTopK(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    //Задание 3
    public static Map<Animal.Type, Long> countAnimalTypes(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    //Задание 4
    public static Animal findAnimalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparing(a -> a.name().length()))
            .orElse(null);
    }

    //Задание 5
    public static Animal.Sex findDominantSex(List<Animal> animals) {
        return animals.stream().collect(Collectors
                .groupingBy(Animal::sex, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue()).get().getKey();
    }

    //Задание 6
    public static Map<Animal.Type, Animal> findHeaviestAnimalOfEachType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                a -> a,
                BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
            ));

    }

    //Задание 7
    public static Animal findKthOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    //Задание 8
    public static Optional<Animal> findHeaviestAnimalBelowHeight(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    //Задание 9
    public static Integer getTotalNumberOfPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    //Задание 10
    public static List<Animal> findAnimalsWithMismatchedAgeAndPaws(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.age() != a.paws())
            .collect(Collectors.toList());
    }

    // Задача 11
    public static List<Animal> findBitingAnimalsAboveHeight(List<Animal> animals) {

        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > MIN_HEIGHT)
            .toList();
    }

    // Задача 12
    public static Integer countAnimalsWithWeightExceedingHeight(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    // Задача 13
    public static List<Animal> findAnimalsWithMultipleWordNames(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    // Задача 14
    public static boolean hasTallDog(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    // Задача 15
    public static Integer sumWeightsOfAnimalsInAgeRange(List<Animal> animals, int k, int l) {
        return animals
            .stream()
            .filter(elem -> elem.age() >= k && elem.age() <= l)
            .mapToInt(Animal::weight)
            .sum();
    }

    // Задача 16
    public static List<Animal> sortAnimalsByTypeAndSexAndName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    // Задача 17
    public static boolean spidersBiteMoreOftenThanDogs(List<Animal> animals) {
        Map<Animal.Type, Integer> bitesCountByType = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER || animal.type() == Animal.Type.DOG)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> animal.bites() ? 1 : 0)));

        int spiderBites = bitesCountByType.getOrDefault(Animal.Type.SPIDER, 0);
        int dogBites = bitesCountByType.getOrDefault(Animal.Type.DOG, 0);

        return spiderBites > dogBites;
    }

    // Задача 18
    public static Animal findHeaviestFishInLists(List<Animal>... animalLists) {
        return Arrays.stream(animalLists)
            .flatMap(Collection::stream)
            .filter(elem -> elem.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).orElse(null);
    }

    // Задача 19
    public static Map<String, Set<ValidationError>> findExceptionsAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(elem -> !validateAnimal(elem).isEmpty())
            .collect(Collectors.toMap(Animal::name, AnimalUtils::validateAnimal));

    }

    // Задача 20
    public static Map<String, String> findValidationExceptionsAnimalsPrettier(List<Animal> animalsList) {
        return animalsList
            .stream()
            .filter(elem -> !validateAnimal(elem).isEmpty())
            .collect(Collectors.toMap(Animal::name, animal -> validateAnimal(animal)
                .stream()
                .map(ValidationError::errorName)
                .collect(Collectors.joining(", "))));
    }

    private static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.name() == null || animal.name().isEmpty()) {
            errors.add(new ValidationError("name", "Name can`t be empty or null!"));
        }
        if (animal.age() <= 0) {
            errors.add(new ValidationError("age", "Age can be more than 0!"));
        }
        if (animal.height() <= 0) {
            errors.add(new ValidationError("height", "Height can be more than 0!"));
        }
        if (animal.weight() <= 0) {
            errors.add(new ValidationError("weight", "Weight can be more than 0!"));
        }
        return errors;
    }
}

