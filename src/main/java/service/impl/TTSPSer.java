package service.impl;

import iml.service.ITTSPSer;
import java.util.ArrayList;
import model.Laptop;
import repository.TTSPrepo;

public class TTSPSer implements ITTSPSer{
    private final TTSPrepo ttspRepo = new TTSPrepo();

    @Override
    public ArrayList<Laptop> getList() {
        return (ArrayList<Laptop>)ttspRepo.selectAll();
    }
//
//    @Override
//    public String AddTTSP(TTSP ttsp) {
//        if(ttspRepo.add(ttsp)){
//            return "Thêm Thành Công";
//        }
//    }
//
//    @Override
//    public String UpdateTTSP(TTSP ttsp) {
//        
//    }
//
//    @Override
//    public String DeleteTTSP(TTSP ttsp) {
//        
//    }
    
}
