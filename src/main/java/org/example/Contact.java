package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Contact {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;

    public Contact(String firstName, String lastName, int age, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Иван", "Иванов", 30, "+1-555-123-4567"));
        contacts.add(new Contact("Иван", "Сидоров", 30, "+1-555-123-4567"));
        contacts.add(new Contact("Мария", "Петрова", 25, "+1-555-987-6543"));
        contacts.add(new Contact("Петр", "Сидоров", 35, "+1-555-111-2222"));
        contacts.add(new Contact("Анна", "Сидорова", 35, "+1-555-111-2222"));
        // Добавьте остальные контакты по аналогии.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите подстроку для поиска фамилии: ");
        String substring = scanner.nextLine();

        String result = contacts.stream()
                .filter(contact -> contact.getLastName().contains(substring))
                .map(Contact::getFirstName)
                .sorted((name1, name2) -> name2.compareTo(name1)) // Сортируем в обратном алфавитном порядке
                                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        if (!result.isEmpty()) {
            System.out.println(contacts.size() + " контактов зовут: " + result + ";");
        } else {
            System.out.println("Такой фамилии нет");
        }
    }
}
