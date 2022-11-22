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
@Table(name = "Laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @Column(name = "Hang")
    private String hang;
    @Column(name = "CPU")
    private String cpu;
    @Column(name = "Ram")
    private String ram;
    @Column(name = "OCung")
    private String oCung;
    @Column(name = "ManHinh")
    private String manHinh;
    @Column(name = "TheLoai")
    private String theLoai;
    @Column(name = "GiaNhap")
    private String giaNhap;
    @Column(name = "GiaBan")
    private String giaBan;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "TrangThai")
    private int trangThai;
    @Column(name = "HinhAnh")
    private String hinhAnh;
}
