/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Laptop;

/**
 *
 * @author dangc
 */
public interface ILaptopService {
    ArrayList<Laptop> getList();
    String addLaptopService(Laptop l);
    String updateLaptopService(Laptop l);
    String deleteLaptopService(Laptop l);
    List<Laptop> findLaptopByName(String ten);
}
