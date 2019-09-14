package by.training.finalproject.connectionPool.jdbctest;

import by.training.finalproject.dao.impl.UserDAOImpl;
import by.training.finalproject.entity.User;

public class Program {
    public static void main(String[] args) {
        try {
            UserDAOImpl userDao = new UserDAOImpl();
            User user = new User();
            user.setLogin("a");
            user.setPassword("a");
            user.setEmail("a@gmail.com");
            user.setAddress("a");
            user.setPhone("8044");
            user.setFirstName("a");
            user.setLastName("a");
            user.setType(1);
            userDao.create(user);
            //int rows = statement.executeUpdate("UPDATE Products SET Price = Price + 5000");
            //System.out.printf("Updated %d rows", rows);
            System.out.println("Rabotaet");
        } catch (Exception ex) {
//            System.out.println("Фиг тебе, Даша, а не работающий пул соединений");
//            System.out.println("Connection failed...");
            System.out.println("Ne rabotaet");
            System.out.println(ex);
        }
    }
}
