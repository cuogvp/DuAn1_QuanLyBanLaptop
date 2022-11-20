/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.User;
import model.Userr;
import repository.UserRepository;
import services.IUserService;

/**
 *
 * @author dangc
 */
public class UserService implements IUserService{
     private final UserRepository repository = new UserRepository();
    
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

     @Override
    public List<Userr> selectAll() {
        return (List<Userr>) repository.selectAll();
    }
     @Override
    public String addUser(Userr u) {
        if (repository.addUserrRepo(u)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
    @Override
    public String updateUser(Userr u) {
        if (repository.updateUserrRepo(u)) {
            return "sua thanh cong";
        } else {
            return "sua that bai";
        }
    }
    @Override
    public String deleteUser(Userr u) {
        if (repository.deleteUserrRepo(u)) {
            return "xoa thanh cong";
        } else {
            return "xoa that bai";
        }
    }
}
