package ru.geekbrains.HomeWork_07_Chat;

import java.util.Set;

public class LoginService {
    private Set<User> users;

    public LoginService() {
        users = Set.of(
            new User("l1","p1","u1"),
            new User("l2","p2","u2"),
            new User("l3","p3","u3")
        );
    }
    public User findUser(String login, String passwd) {
        for(User u: users) {
            if (u.getLogin().equals(login) && u.getPasswd().equals(passwd)){
                return u;
            }
        }
        return null;
    }

    static public class User {
        private String login;
        private String passwd;
        private String name;

        public User(String login, String passwd, String name) {
            this.login = login;
            this.passwd = passwd;
            this.name = name;
        }

        public String getLogin() {
            return login;
        }

        public String getPasswd() {
            return passwd;
        }

        public String getName() {
            return name;
        }
    }
}

