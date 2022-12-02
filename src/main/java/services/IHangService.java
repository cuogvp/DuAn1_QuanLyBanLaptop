/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.Hang;

/**
 *
 * @author dangc
 */
public interface IHangService {
    public ArrayList<Hang> getList();
    String addHangService(Hang h);
    String updateHangService(Hang h);
    String deleteHangService(Hang h);
}
