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
    @Column(name = "IDHoaDon")
    private String idHoaDon;
    @Column(name = "IDLaptop")
    private String idLaptop;
    @Column(name = "IDBaoHanh")
    private String idBaoHanh;
    @Column(name = "TrangThai")
    private int trangThai;
    
}
