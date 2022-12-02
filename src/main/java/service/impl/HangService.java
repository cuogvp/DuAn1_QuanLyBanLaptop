/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.Hang;
import model.Laptop;
import repository.HangRepository;
import repository.LaptopRepository;
import services.IHangService;

/**
 *
 * @author dangc
 */
public class HangService implements IHangService{
    private final HangRepository hangRepository = new HangRepository();
    @Override
    public ArrayList<Hang> getList() {
        return (ArrayList<Hang>) hangRepository.selectAll();
    }
     @Override
    public String addHangService(Hang h) {
        if (hangRepository.addHang(h)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
    @Override
    public String updateHangService(Hang h) {
        if (hangRepository.updateHang(h)) {
            return "sua thanh cong";
        } else {
            return "sua that bai";
        }
    }
    @Override
    public String deleteHangService(Hang h) {
        if (hangRepository.deleteHang(h)) {
            return "xoa thanh cong";
        } else {
            return "xoa that bai";
        }
    }
}
