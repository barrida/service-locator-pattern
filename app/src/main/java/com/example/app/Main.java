
package com.example.app;

import com.example.api.User;
import com.example.api.UserService;

public class Main {
    public static void main(String[] args) {
        UserService service = UserServiceLocator.getUserService();

        User created = service.create("Suleyman");
        System.out.println("Created: " + created);

        service.getUser(created.getId())
                .ifPresentOrElse(
                        u -> System.out.println("Found by id: " + u),
                        () -> System.out.println("User not found")
                );
    }
}
