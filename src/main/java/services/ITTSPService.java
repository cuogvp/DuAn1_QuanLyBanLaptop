/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.Laptop;

/**
 *
 * @author dangc
 */
public interface ITTSPService {
    ArrayList<Laptop> getList();
    List<Laptop> findAllByName(String name);
    Boolean update(Laptop l);
}
