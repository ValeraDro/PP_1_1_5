package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Igor", "Ivanov", (byte) 20);
        userService.saveUser("Ivan", "Olegov", (byte) 25);
        userService.saveUser("Oleg", "Alexov", (byte) 31);
        userService.saveUser("Alex", "Igorov", (byte) 38);
        userService.removeUserById(6);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
