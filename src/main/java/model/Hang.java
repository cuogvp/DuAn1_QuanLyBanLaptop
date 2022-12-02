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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Hang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hang {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TrangThai")
    private int trangThai;
    @OneToMany(mappedBy = "hang",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Laptop> listLT;
}
