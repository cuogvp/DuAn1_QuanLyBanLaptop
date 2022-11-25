/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.Userr;

/**
 *
 * @author dangc
 */
public interface IUserService {
    List<Userr> selectAll();
    String addUser(Userr u);
    String updateUser(Userr u);
    String deleteUser(Userr u);
    List<Userr> findAllByName(String name);
}
