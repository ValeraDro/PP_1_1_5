package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Igor", "LastName1", (byte) 20);
        userService.saveUser("Ivan", "LastName2", (byte) 25);
        userService.saveUser("Olag", "LastName3", (byte) 31);
        userService.saveUser("Alex", "LastName4", (byte) 38);

        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
