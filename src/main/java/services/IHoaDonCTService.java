/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.math.BigDecimal;
import java.util.List;
import model.HoaDonChiTiet;

/**
 *
 * @author dangc
 */
public interface IHoaDonCTService {
    List<HoaDonChiTiet> getList();
    BigDecimal doanhThuTheoNgay();
    BigDecimal doanhThuTheoThang(int thang);
    BigDecimal doanhThuTheoNam();
}
