/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.KhachHang;
import repository.KhachHangRepository;
import services.IKhachHangService;

/**
 *
 * @author dangc
 */
public class KhachHangService implements IKhachHangService{
    private final KhachHangRepository repository = new KhachHangRepository();
     
     @Override
    public List<KhachHang> selectAll() {
        return (List<KhachHang>) repository.selectAll();
    }
     @Override
    public String addKH(KhachHang kh) {
        if (repository.addUserrRepo(kh)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
    @Override
    public String updateKH(KhachHang kh) {
        if (repository.updateUserrRepo(kh)) {
            return "sua thanh cong";
        } else {
            return "sua that bai";
        }
    }
    @Override
    public String deleteKH(KhachHang kh) {
        if (repository.deleteUserrRepo(kh)) {
            return "xoa thanh cong";
        } else {
            return "xoa that bai";
        }
    }

    @Override
    public List<KhachHang> findAllByName(String name) {
        return repository.findAllByName(name);
    }
}
