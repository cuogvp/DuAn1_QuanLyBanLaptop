/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.math.BigDecimal;
import java.util.UUID;
import model.HoaDonChiTiet;
import repository.HoaDonCTRepository;
import services.IHoaDonChiTietService;

/**
 *
 * @author dangc
 */
public class HoaDonCTService implements IHoaDonChiTietService{
    private final HoaDonCTRepository hoaDonCTRepository = new HoaDonCTRepository();

    @Override
    public Boolean addOrUpdateHDCT(HoaDonChiTiet hdct) {
        return hoaDonCTRepository.addOrUpdateHDCT(hdct);
    }

    @Override
    public UUID findByIdLaptop(String ma) {
        return hoaDonCTRepository.findByIdLaptop(ma);
    }

    @Override
    public UUID findByIdHoaDon(String ma) {
        return hoaDonCTRepository.findByIdHoaDon(ma);
    }

    @Override
    public BigDecimal findByGia(String ma) {
        return hoaDonCTRepository.findByGia(ma);
    }

   
  
    
    
}
