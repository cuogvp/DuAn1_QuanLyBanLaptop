/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iml.service;

import java.util.ArrayList;
import model.HoaDon;

public interface IHoaDonSer {
    ArrayList<HoaDon> getList();
    String addHd(HoaDon hd);
    String deleteHd(HoaDon hd);
    String updateHd(HoaDon hd);
}
