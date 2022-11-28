/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.KhuyenMai;
import repository.KhuyenMaiRepository;
import services.IKhuyenMaiService;

/**
 *
 * @author dangc
 */
public class KhuyenMaiService implements IKhuyenMaiService{
    private final KhuyenMaiRepository repository = new KhuyenMaiRepository();
    
    @Override
    public List<KhuyenMai> getList() {
        return (List<KhuyenMai>) repository.selectAll();
    }

    @Override
    public String addKM(KhuyenMai km) {
        if (repository.addKhuyenMaiRepo(km)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }    }

    @Override
    public String updateKM(KhuyenMai km) {
        if (repository.updateKhuyenMaiRepo(km)) {
            return "sua thanh cong";
        } else {
            return "sua that bai";
        }    }

    @Override
    public String deleteKM(KhuyenMai km) {
        if (repository.deleteKhuyenMaiRepo(km)) {
            return "xoa thanh cong";
        } else {
            return "xoa that bai";
        }
    }

    @Override
    public List<KhuyenMai> findKhuyenMaiByName(String name) {
        return repository.findKhuyenMaiByName(name);
    }

}
