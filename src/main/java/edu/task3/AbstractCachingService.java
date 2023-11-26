package edu.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractCachingService implements PersonDatabase {
    private final Map<Integer, Person> cachedIds = new HashMap<>();
    private final Map<String, List<Person>> cachedNames = new HashMap<>();
    private final Map<String, List<Person>> cachedAddresses = new HashMap<>();
    private final Map<String, List<Person>> cachedPhones = new HashMap<>();

    @Override
    public void add(Person person) {
        cachedIds.put(person.id(), person);
        cachedNames.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
        cachedAddresses.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
        cachedPhones.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
    }

    @Override
    public void delete(int id) {
        Person person = cachedIds.remove(id);
        if (person == null) {
            return;
        }
        removeFromCacheList(cachedNames, person.name(), id);
        removeFromCacheList(cachedAddresses, person.address(), id);
        removeFromCacheList(cachedPhones, person.phoneNumber(), id);
    }

    @Override
    public List<Person> findByName(String name) {
        return cachedNames.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public List<Person> findByAddress(String address) {
        return cachedAddresses.getOrDefault(address, Collections.emptyList());
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return cachedPhones.getOrDefault(phone, Collections.emptyList());
    }

    private void removeFromCacheList(Map<String, List<Person>> cacheMap, String key, int id) {
        List<Person> list = cacheMap.get(key);
        if (list != null) {
            list.removeIf(person -> person.id() == id);
            if (list.isEmpty()) {
                cacheMap.remove(key);
            }
        }
    }
}

