/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.UUID;
import model.HoaDon;

/**
 *
 * @author dangc
 */
public interface IHoaDonService {
    ArrayList<HoaDon> getList();
    String addHd(HoaDon hd);
    String deleteHd(HoaDon hd);
    String updateHd(HoaDon hd);
    UUID findByIdKhachHang(String ten);
    public int genMaHD();
}
