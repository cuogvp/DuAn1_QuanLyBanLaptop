/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Laptop")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Laptop {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private UUID id;
    
    @Column(name = "Imei")
    private String imei;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @ManyToOne
    @JoinColumn(name = "IdHang")
    private Hang hang;
    
    @Column(name = "CPU")
    private String cpu;
    
    @Column(name = "Ram")
    private String ram;
    
    @Column(name = "Ocung")
    private String oCung;
    
    @Column(name = "ManHinh")
    private String manHinh;
    
    @Column(name = "TheLoai")
    private String theLoai;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgayBan")
    private Date ngayBan;
    
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    
    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    
    @Column(name = "MoTa")
    private String moTa;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "HinhAnh")
    private String hinhAnh;
   
    @OneToMany(mappedBy = "laptop",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;
    
    @OneToMany(mappedBy = "laptop",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<KhuyenMai> listKM;

    public Laptop() {
    }

    public Laptop(UUID id, String imei, String ma, String ten, Hang hang, String cpu, String ram, String oCung, String manHinh, String theLoai, Date ngayTao, Date ngayBan, BigDecimal giaNhap, BigDecimal giaBan, String moTa, int trangThai, String hinhAnh, List<HoaDonChiTiet> listHDCT, List<KhuyenMai> listKM) {
        this.id = id;
        this.imei = imei;
        this.ma = ma;
        this.ten = ten;
        this.hang = hang;
        this.cpu = cpu;
        this.ram = ram;
        this.oCung = oCung;
        this.manHinh = manHinh;
        this.theLoai = theLoai;
        this.ngayTao = ngayTao;
        this.ngayBan = ngayBan;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
        this.listHDCT = listHDCT;
        this.listKM = listKM;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getoCung() {
        return oCung;
    }

    public void setoCung(String oCung) {
        this.oCung = oCung;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public List<HoaDonChiTiet> getListHDCT() {
        return listHDCT;
    }

    public void setListHDCT(List<HoaDonChiTiet> listHDCT) {
        this.listHDCT = listHDCT;
    }

    public List<KhuyenMai> getListKM() {
        return listKM;
    }

    public void setListKM(List<KhuyenMai> listKM) {
        this.listKM = listKM;
    }

    

    @Override
    public String toString() {
        return ten ;
    }
   
   

    

    
    
}
