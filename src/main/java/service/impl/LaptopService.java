/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Laptop;
import repository.LaptopRepository;
import services.ILaptopService;

/**
 *
 * @author dangc
 */
public class LaptopService implements ILaptopService{
    private final LaptopRepository laptopRepository = new LaptopRepository();
    @Override
    public ArrayList<Laptop> getList() {
        return (ArrayList<Laptop>) laptopRepository.selectAll();
    }
     @Override
    public String addLaptopService(Laptop l) {
        if (laptopRepository.addLaptop(l)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
    @Override
    public String updateLaptopService(Laptop l) {
        if (laptopRepository.updateLaptop(l)) {
            return "sua thanh cong";
        } else {
            return "sua that bai";
        }
    }
    @Override
    public String deleteLaptopService(Laptop l) {
        if (laptopRepository.delete(l)) {
            return "xoa thanh cong";
        } else {
            return "xoa that bai";
        }
    }

    @Override
    public List<Laptop> findAllByName(String name) {
        return laptopRepository.findAllByName(name);
    }

    

    
}
