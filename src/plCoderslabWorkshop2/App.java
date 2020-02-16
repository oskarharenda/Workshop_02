package plCoderslabWorkshop2;

import jdk.jfr.DataAmount;
import plCoderslabWorkshop2.dao.ExerciseDao;
import plCoderslabWorkshop2.dao.SolutionsDao;
import plCoderslabWorkshop2.dao.UserDao;
import plCoderslabWorkshop2.model.Exercise;
import plCoderslabWorkshop2.model.Solutions;
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

//     UserDao userDuo = new UserDao();
//     User[] all = userDuo.findAll();
//
//     for(User user: all){
//         System.out.println(user);
//     }

//        Exercise exercise_1= new Exercise("exercise3","description_3");
//        ExerciseDao exDao_1 = new ExerciseDao();
//        exercise_1=exDao_1.read(3);
//        //exDao_1.create(exercise_1);
//
//                if (exercise_1!= null){
//            exercise_1.setTitle("title3");
//            exDao_1.update(exercise_1);
//        }
//
//        System.out.println(exercise_1);

//        exDao_1.delete(4);

        SolutionsDao solution1 = new SolutionsDao();
        Solutions[] tab=solution1.SolutionsUser(1);

        for(int i=0; i<tab.length; i++){
            System.out.println(tab[i]);
        }

        System.out.println(solution1.read(1));


    }
}
