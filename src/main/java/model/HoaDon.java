/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
<<<<<<< HEAD
@Table(name = "BaoHanh")
=======
@Table(name = "HoaDon")
>>>>>>> aa4c10f6655314f599fb6db4c87e94cbfe5c61d9
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HoaDon {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private UUID id;
    @Column(name = "NgayTao")
    private String ngayTao;
<<<<<<< HEAD
    @Column(name = "NgayDatHanh")
=======
    @Column(name = "NgayDatHang")
>>>>>>> aa4c10f6655314f599fb6db4c87e94cbfe5c61d9
    private String ngayDatHang;
    @Column(name = "NgayShip")
    private String ngayShip;
    @Column(name = "NgayNhanHang")
    private String ngayNhanHang;
    @Column(name = "TinhTrang")
    private String tinhTrang;
    @Column(name = "DiaChi")
    private String diaChi;
<<<<<<< HEAD
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "IDKH")
    private String idKH;
    @Column(name = "IDUserr")
    private String idUserr;
=======
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "SoLuong")
    private String soLuong;
    @Column(name = "IDKH")
    private String idkh;
    @Column(name = "IDUserr")
    private String iduser;
>>>>>>> aa4c10f6655314f599fb6db4c87e94cbfe5c61d9
}
