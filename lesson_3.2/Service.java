package ru.geekbrains.HomeWork_07_Chat;

import java.util.Collection;

public interface Service<T> {
    Collection<T> findAll();
    T findById(int user_id);
    T findByLoginPasswd(String user_login, String user_passwd);
    void update(T obj);
    boolean add(T obj);

}
