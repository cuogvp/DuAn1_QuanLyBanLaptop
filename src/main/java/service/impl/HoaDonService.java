/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.UUID;
import model.HoaDon;
import repository.HoaDonRepository;
import services.IHoaDonService;

/**
 *
 * @author dangc
 */
public class HoaDonService implements IHoaDonService{
    private final HoaDonRepository hoaDonRepo = new HoaDonRepository();
    public ArrayList<HoaDon> getList() {
        return (ArrayList<HoaDon>) hoaDonRepo.selectAll();
    }

    @Override
    public String addHd(HoaDon hd) {
        if(hoaDonRepo.add(hd)){
            return "Tạo Hóa Đơn Thành Công";
        }else{
            return "Tạo Hóa Đơn Thất Bại";
        }
    }

    @Override
    public String deleteHd(HoaDon hd) {
        if(hoaDonRepo.delete(hd)){
            return "Xóa Thành Công";
        }else{
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String updateHd(HoaDon hd) {
        if(hoaDonRepo.update(hd)){
            return "Update Thành Công";
        }else{
            return "Update Thất Bại";
        }
    }

    @Override
    public UUID findByIdHoaDon(String ten) {
        return hoaDonRepo.findByIdHoaDon(ten);
    }

    @Override
    public int genMaHD() {
        return hoaDonRepo.genMaHD();
    }
}
