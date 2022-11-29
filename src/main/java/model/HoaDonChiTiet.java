/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@IdClass(HoaDonChiTietID.class)
@Table(name = "HoaDonChiTiet")

@ToString
public class HoaDonChiTiet {
    @Id
    @Column(name = "IdHoaDon")
    private UUID idHoaDon;

    @Id
    @Column(name = "IdLaptop")
    private UUID idLaptop;

    @ManyToOne
    @MapsId("idHoaDon")
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("idLaptop")
    @JoinColumn(name = "IdLaptop", referencedColumnName = "Id")
    private Laptop laptop;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private double donGia;
    
    @ManyToOne
    @JoinColumn(name = "IDBaoHanh")
    private BaoHanh baohanh;
    
    @Column(name = "TrangThai")
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(UUID idHoaDon, UUID idLaptop, HoaDon hoaDon, Laptop laptop, int soLuong, double donGia, BaoHanh baohanh, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.idLaptop = idLaptop;
        this.hoaDon = hoaDon;
        this.laptop = laptop;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.baohanh = baohanh;
        this.trangThai = trangThai;
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

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public BaoHanh getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(BaoHanh baohanh) {
        this.baohanh = baohanh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setDonGia(String donGia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
