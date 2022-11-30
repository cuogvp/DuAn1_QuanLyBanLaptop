/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.HoaDonChiTiet;
import repository.HoaDonCTRepository;
import services.IHoaDonCTService;

/**
 *
 * @author dangc
 */
public class HoaDonCTService implements IHoaDonCTService{
    private final HoaDonCTRepository repository = new HoaDonCTRepository();
            
    @Override
    public List<HoaDonChiTiet> getList() {
        return repository.selectAll();
    }
    
}
