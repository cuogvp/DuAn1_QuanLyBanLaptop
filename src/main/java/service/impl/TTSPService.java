/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.Laptop;
import repository.TTSPRepository;
import services.ITTSPService;

/**
 *
 * @author dangc
 */
public class TTSPService implements ITTSPService {
    private final TTSPRepository ttspRepo = new TTSPRepository();

    @Override
    public ArrayList<Laptop> getList() {
        return (ArrayList<Laptop>)ttspRepo.selectAll();
    }
}
