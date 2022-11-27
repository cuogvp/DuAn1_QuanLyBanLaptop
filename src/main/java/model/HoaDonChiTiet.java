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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "HoaDonChiTiet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HoaDonChiTiet {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private UUID id;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    @ManyToOne
    @JoinColumn(name = "IDHoaDon")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "IDLaptop")
    private Laptop laptop;
    @ManyToOne
    @JoinColumn(name = "IDBaoHanh")
    private BaoHanh baohanh;
    @Column(name = "TrangThai")
    private int trangThai;
    
}
