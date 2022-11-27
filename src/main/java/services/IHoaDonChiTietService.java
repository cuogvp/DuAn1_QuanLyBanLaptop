/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.math.BigDecimal;
import java.util.UUID;
import model.HoaDonChiTiet;

/**
 *
 * @author dangc
 */
public interface IHoaDonChiTietService {
    Boolean addOrUpdateHDCT(HoaDonChiTiet hdct);
    UUID findByIdLaptop(String ma);
    UUID findByIdHoaDon(String ma);
    BigDecimal findByGia(String ma);
}
