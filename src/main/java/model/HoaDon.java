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
@Table(name = "BaoHanh")
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
    @Column(name = "NgayDatHanh")
    private String ngayDatHang;
    @Column(name = "NgayShip")
    private String ngayShip;
    @Column(name = "NgayNhanHang")
    private String ngayNhanHang;
    @Column(name = "TinhTrang")
    private String tinhTrang;
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
