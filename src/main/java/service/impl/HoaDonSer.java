package service.impl;

import iml.service.IHoaDonSer;
import java.util.ArrayList;
import model.HoaDon;
import repository.HoaDonRepo;

public class HoaDonSer implements IHoaDonSer{

    private final HoaDonRepo hoaDonRepo = new HoaDonRepo();
    @Override
    public ArrayList<HoaDon> getList() {
        return (ArrayList<HoaDon>) hoaDonRepo.selectAll();
    }

    @Override
    public String addHd(HoaDon hd) {
        if(hoaDonRepo.add(hd)){
            return "Thêm Thành Công";
        }else{
            return "Thêm Thất Bại";
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

}
