/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "HoaDon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HoaDon {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private UUID id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgayDatHang")
    private Date ngayDatHang;
    
    @Column(name = "NgayShip")
    private Date ngayShip;
    
    @Column(name = "NgayNhanHang")
    private Date ngayNhanHang;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "IDKH")
    private String idKH;
    
    @Column(name = "IDUserr")
    private String idUserr;
}
