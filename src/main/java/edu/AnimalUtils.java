package edu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class AnimalUtils {
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

    //Задание 5?
    public static Animal.Sex findDominantSex(List<Animal> animals) {
        long males = animals.stream()
            .filter(a -> a.sex() == Animal.Sex.M)
            .count();
        long females = animals.stream()
            .filter(a -> a.sex() == Animal.Sex.F)
            .count();

        if (males > females) {
            return Animal.Sex.M;
        } else if (females > males) {
            return Animal.Sex.F;
        } else {
            return null;
        }
    }

    //Задание 6?
    public static Map<Animal.Type, Animal> findHeaviestAnimalOfEachType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                a -> a,
                BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
            ));

    }

    //Задание 7?
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
        final int minHeight = 100;
        return animals.stream()
            .filter(Animal::bites)
            .filter(animal -> animal.height() > minHeight)
            .collect(Collectors.toList());
    }

    // Задача 12? long
    public static Integer countAnimalsWithWeightExceedingHeight(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    // Задача 13
    public static List<Animal> findAnimalsWithMultipleWordNames(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    // Задача 14
    public static boolean hasTallDog(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    // Задача 15
    public static Map<Animal.Type, Integer> sumWeightsOfAnimalsInAgeRange(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // Задача 16
    public static List<Animal> sortAnimalsByTypeAndSexAndName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    // Задача 17
    public static boolean spidersBiteMoreOftenThanDogs(List<Animal> animals) {
        long spidersCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();
        long dogsCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        return spidersCount > dogsCount;
    }

    // Задача 18
    public static Animal findHeaviestFishInMultipleLists(List<List<Animal>> animalLists) {
        Animal heaviestFish = null;

        for (List<Animal> animals : animalLists) {
            Animal fish = animals.stream()
                .filter(animal -> animal.type() == Animal.Type.FISH)
                .max(Comparator.comparingInt(Animal::weight))
                .orElse(null);

            if (fish != null && (heaviestFish == null || fish.weight() > heaviestFish.weight())) {
                heaviestFish = fish;
            }
        }

        return heaviestFish;
    }

    // Задача 19
    public static Map<String, Set<ValidationError>> findAnimalsWithErrors(List<Animal> animals) {
        Map<String, Set<ValidationError>> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = new HashSet<>();

            if (animal.name() == null || animal.name().isEmpty()) {
                errors.add(new ValidationError("name", "Имя не должно быть пустым"));
            }

            if (animal.age() < 0) {
                errors.add(new ValidationError("age", "Возраст не может быть отрицательным"));
            }

            if (animal.height() < 0) {
                errors.add(new ValidationError("height", "Рост не может быть отрицательным"));
            }

            if (animal.weight() < 0) {
                errors.add(new ValidationError("weight", "Вес не может быть отрицательным"));
            }

            if (!errors.isEmpty()) {
                animalsWithErrors.put(animal.name(), errors);
            }
        }

        return animalsWithErrors;
    }

    // Задача 20
    public static Map<String, String> findAnimalsWithReadableErrors(List<Animal> animals) {
        Map<String, String> animalsWithReadableErrors = new HashMap<>();

        for (Animal animal : animals) {
            StringBuilder errorsStringBuilder = new StringBuilder();

            if (animal.name() == null || animal.name().isEmpty()) {
                errorsStringBuilder.append("name: Имя не должно быть пустым, ");
            }

            if (animal.age() < 0) {
                errorsStringBuilder.append("age: Возраст не может быть отрицательным, ");
            }

            if (animal.height() < 0) {
                errorsStringBuilder.append("height: Рост не может быть отрицательным, ");
            }

            if (animal.weight() < 0) {
                errorsStringBuilder.append("weight: Вес не может быть отрицательным, ");
            }

            // Добавьте другие проверки по необходимости.

            if (errorsStringBuilder.length() > 0) {
                String errorsString = errorsStringBuilder.substring(
                    0,
                    errorsStringBuilder.length() - 2
                );
                animalsWithReadableErrors.put(animal.name(), errorsString);
            }
        }

        return animalsWithReadableErrors;
    }
}
