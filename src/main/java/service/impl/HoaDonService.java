/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.HoaDon;
import model.HoaDonChiTiet;
import repository.HoaDonRepository;
import services.IHoaDonService;

/**
 *
 * @author dangc
 */
public class HoaDonService implements IHoaDonService{
    private final HoaDonRepository hoaDonRepo = new HoaDonRepository();
    @Override
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
    public UUID findByIdKhachHang(String ten) {
        return hoaDonRepo.findByIdKhachHang(ten);
    }

    @Override
    public int genMaHD() {
        return hoaDonRepo.genMaHD();
    }

    @Override
    public List<HoaDon> findAllTrangThai(int trangThai) {
        return hoaDonRepo.findAllTrangThai(trangThai);
    }

    @Override
    public UUID findByIdUser(String ten) {
        return hoaDonRepo.findByIdUser(ten);
    }

    @Override
    public List<HoaDonChiTiet> selectAllHoaDonChiTiet() {
        return hoaDonRepo.selectAllHoaDonChiTiet();
    }

    @Override
    public Boolean addOrUpdateHDCT(HoaDonChiTiet hdct) {
        return hoaDonRepo.addOrUpdateHDCT(hdct);
    }

    @Override
    public UUID findByIdLaptop(String ma) {
        return hoaDonRepo.findByIdLaptop(ma);
    }

    @Override
    public UUID findByIdHoaDon(String ma) {
        return hoaDonRepo.findByIdHoaDon(ma);
    }

    
    
}
