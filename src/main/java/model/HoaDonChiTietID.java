/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author dangc
 */
public class HoaDonChiTietID implements Serializable{
    private UUID idHoaDon;
    private UUID idLaptop;

    public HoaDonChiTietID() {
    }

    public HoaDonChiTietID(UUID idHoaDon, UUID idLaptop) {
        this.idHoaDon = idHoaDon;
        this.idLaptop = idLaptop;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public UUID getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(UUID idLaptop) {
        this.idLaptop = idLaptop;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idHoaDon);
        hash = 89 * hash + Objects.hashCode(this.idLaptop);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDonChiTietID other = (HoaDonChiTietID) obj;
        if (!Objects.equals(this.idHoaDon, other.idHoaDon)) {
            return false;
        }
        return Objects.equals(this.idLaptop, other.idLaptop);
    }
    
    
}
