/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.User;
import repository.UserRepository;

/**
 *
 * @author dangc
 */
public class UserService {
     private UserRepository repository = new UserRepository();
    
    public User checkLogin(String ma, String password) {
        List<User> list = this.repository.getAllRepoStory();
        for (User u : list) {
            if (u.getMa().equalsIgnoreCase(ma)) {
                if (u.getMatKhau().equalsIgnoreCase(password)) {
                    return u;
                }
            }
        }
        return null;
    }
}
