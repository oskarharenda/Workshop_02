package plCoderslabWorkshop2;

import jdk.jfr.DataAmount;
import plCoderslabWorkshop2.dao.UserDao;
import plCoderslabWorkshop2.model.User;

public class App {
    public static void main(String[] args) {
//        User user1 = new User("asteroida@wp.pl","mJAn kowalksi","pantera");
//        System.out.println(user1);
//
//        UserDao userDao = new UserDao();
//        user1 = userDao.create(user1);
//        System.out.println(user1);


//        UserDao userDao = new UserDao();
//        User userRead1 = userDao.read(1);
//
//        System.out.println(userRead1);
//
//        if (userRead1!= null){
//            userRead1.setUserName("brzydki dzik");
//            userDao.update(userRead1);
//        }
//
//        System.out.println(userRead1);

     UserDao userDuo = new UserDao();
     User[] all = userDuo.findAll();

     for(User user: all){
         System.out.println(user);
     }

    }
}
