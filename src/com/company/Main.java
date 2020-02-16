package com.company;

import org.mindrot.jbcrypt.BCrypt;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String gensalt = BCrypt.gensalt();
        String hashedPass = BCrypt.hashpw("HASLO",BCrypt.gensalt());
        String hashedPass2 = BCrypt.hashpw("HASLO",BCrypt.gensalt());
        System.out.println(hashedPass);
        System.out.println(hashedPass2);
        System.out.println("-------");

        String userPass = "HASLO";

        boolean cheeckpw1=BCrypt.checkpw(userPass,hashedPass);
        boolean cheeckpw2=BCrypt.checkpw(userPass,hashedPass2);

        System.out.println(cheeckpw1);
        System.out.println(cheeckpw2);
    }
}
