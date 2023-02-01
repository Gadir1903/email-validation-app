package org.example;

import java.util.*;

public class EmailValidationApp {
    private static final List<String> DB = new ArrayList<>(
            Arrays.asList("test@.com", "test1@.com")
    );
    public static void main(String[] args) throws EmailAlreadyExistsException {
        String email = new Scanner(System.in).nextLine();
        if (email == null || email.isEmpty()) throw new InvalidEmailException("Email cannot be empty");
        Optional <String> result = DB.stream().filter(info -> info.equalsIgnoreCase(email)).findFirst();
        if (result.isPresent()){
            throw new EmailAlreadyExistsException("email" + email + "already exists");
        }
        DB.add(email);
        System.out.println(DB);
    }
}
