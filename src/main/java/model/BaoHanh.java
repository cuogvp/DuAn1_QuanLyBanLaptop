/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class BaoHanh {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayBH")
    private String ngayBH;
    @Column(name = "NgayTra")
    private String ngayTra;
    @Column(name = "GiaBaoHanh")
    private BigDecimal giaBH;
    @Column(name = "LyDo")
    private String lyDo;
    @Column(name = "TrangThai")
    private int trangThai;
    
}
