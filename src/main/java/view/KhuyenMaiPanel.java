/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
import model.Laptop;
import service.impl.KhuyenMaiService;
import service.impl.LaptopService;
import services.IKhuyenMaiService;
import services.ILaptopService;

/**
 *
 * @author dangc
 */
public class KhuyenMaiPanel extends javax.swing.JPanel {

    private IKhuyenMaiService iKMService = new KhuyenMaiService();
    private ILaptopService iLTService = new LaptopService();
    private DefaultTableModel model;
    private DefaultComboBoxModel defaultComboBoxModel;
    public KhuyenMaiPanel() {
        initComponents();
        this.loadComboBox(iLTService.getList());
        this.loadTableKhuyenMai(iKMService.getList());
        this.loadTableLapTop(iKMService.getList());
    }

    public void loadTableKhuyenMai(List<KhuyenMai> list) {
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        for (KhuyenMai km : list) {
            model.addRow(new Object[]{km.getMa(), km.getTen(), km.getNgayBD(), km.getNgayHH(), km.getLaptop().getMa(),
                km.getGiaTien() });
        }
    }
    public void loadTableLapTop(List<KhuyenMai> list) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (KhuyenMai km : list) {
            model.addRow(new Object[]{km.getLaptop().getImei(), km.getLaptop().getTen(), km.getLaptop().getGiaBan(), km.getGiaTien() });
        }
    }
    public void loadTableTimLapTop(List<KhuyenMai> list) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (KhuyenMai km : list) {
            if (km.getLaptop().getTen().equals(txtTimSP.getText().trim())) {
                model.addRow(new Object[]{km.getLaptop().getImei(), km.getLaptop().getTen(), km.getLaptop().getGiaBan(), km.getGiaTien()});
            }

        }
    }
    public void reset(){
        txtMaKM.setText("");
        txtTenKM.setText("");
        txtNgayBD.setText("");
        txtNgayHH.setText("");
        txtGiaTien.setText("");
    }
     private void loadComboBox(ArrayList<Laptop> listlt) {
         defaultComboBoxModel = (DefaultComboBoxModel) cboMaSP.getModel();
        for (Laptop laptop : listlt) {
            defaultComboBoxModel.addElement(laptop); 
        }
    }
    private boolean check() {
        boolean invalid = true;
        if (txtMaKM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khuyến mãi");
            invalid = false;
        }
        if (txtTenKM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khuyến mãi");
            invalid = false;
        }
        Date date = new Date();
        DateFormat ngayBD = null;
        ngayBD = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (txtNgayBD.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu");
                invalid = false;
            }
            date = ngayBD.parse(txtNgayBD.getText());
        } catch (Exception e) {
            invalid = false;
            JOptionPane.showMessageDialog(this, "Sai kiểu giữ liệu ngày bắt đầu");
        }
        try {
            if (txtNgayHH.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày hết hạn");
                invalid = false;
            }
            date = ngayBD.parse(txtNgayHH.getText());
        } catch (Exception e) {
            invalid = false;
            JOptionPane.showMessageDialog(this, "Sai kiểu giữ liệu ngày hết hạn");
        }
        BigDecimal giatien;
        try {
            if (txtGiaTien.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá khuyến mãi");
                invalid = false;
            }
            String giatienStr = txtGiaTien.getText().trim();
            double giatienDB = Double.parseDouble(giatienStr);
            giatien = BigDecimal.valueOf(giatienDB);
        } catch (Exception e) {
            invalid = false;
            JOptionPane.showMessageDialog(this, "Sai kiểu giữ liệu giá tiền");
        }
        return invalid;
    } 
    public KhuyenMai getDataKM() {
        KhuyenMai km = new KhuyenMai();
        String ma = txtMaKM.getText().trim();
        km.setMa(ma);
        String ten = txtTenKM.getText().trim();
        km.setTen(ten);
        String ngaybd = txtNgayBD.getText().trim();
        km.setNgayBD(ngaybd);
        String ngayhh = txtNgayHH.getText().trim();
        km.setNgayHH(ngayhh);
        String giatienStr = txtGiaTien.getText().trim();
        double giatienDB = Double.parseDouble(giatienStr);
        BigDecimal giatien = BigDecimal.valueOf(giatienDB);
        km.setGiaTien(giatien);
        Laptop laptop = getLaptop();
        km.setLaptop(laptop);
        return km;
    }

    public Laptop getLaptop() {
        Laptop laptop = (Laptop) cboMaSP.getSelectedItem();
        System.out.println(laptop.getId());
        return laptop;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgayBD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayHH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboMaSP = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoaForm = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimKM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(826, 647));

        jPanel1.setBackground(new java.awt.Color(47, 144, 193));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Khuyến mãi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jLabel1)
                .addContainerGap(552, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(47, 144, 193));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLabel2.setText("Mã khuyến mãi");

        jLabel3.setText("Tên khuyến mãi");

        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setText("Ngày hết hạn");

        jLabel6.setText("Giá tiền");

        jLabel7.setText("Ma SP");

        cboMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaSPActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\Them.png")); // NOI18N
        jButton1.setText("Thêm");

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\update.png")); // NOI18N
        jButton2.setText("Sửa");

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\clearForm.png")); // NOI18N
        jButton3.setText("xóa Form");

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\xoa.png")); // NOI18N
        jButton4.setText("Xóa");
=======
        btnThem.setBackground(new java.awt.Color(253, 254, 253));
        btnThem.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\Them.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(253, 254, 253));
        btnSua.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\update.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoaForm.setBackground(new java.awt.Color(253, 254, 253));
        btnXoaForm.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\clearForm.png")); // NOI18N
        btnXoaForm.setText("xóa Form");
        btnXoaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(253, 254, 253));
        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\xoa.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
>>>>>>> nhom7

        jPanel2.setBackground(new java.awt.Color(253, 254, 253));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
<<<<<<< HEAD
                "Mã KM", "Tên KM", "Ngày BĐ", "Ngày HH", "Giá Tiền", "Tên SP"
=======
                "Mã", "Tên KM", "Ngày BĐ", "Ngày Hết hạn", "Sản phẩm", "Giá tiền"
>>>>>>> nhom7
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhuyenMai);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(253, 254, 253));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei", "Tên SP", "Giá cũ", "Giá KM"
            }
        ));
        jScrollPane3.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtTimKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKMCaretUpdate(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tìm Khuyến Mãi");

        txtTimSP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimSPCaretUpdate(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tìm Sản Phẩm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnXoaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaKM)
                            .addComponent(txtTenKM)
                            .addComponent(txtNgayBD)
                            .addComponent(txtNgayHH)
                            .addComponent(txtGiaTien)
                            .addComponent(cboMaSP, 0, 164, Short.MAX_VALUE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKM, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 507, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNgayHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 198, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int rows = tblKhuyenMai.getSelectedRow();
        KhuyenMai km = this.iKMService.getList().get(rows);
        txtMaKM.setText(km.getMa());
        txtTenKM.setText(km.getTen());
        txtNgayBD.setText(km.getNgayBD());
        txtNgayHH.setText(km.getNgayHH());
        txtGiaTien.setText(String.valueOf(km.getGiaTien()));
        cboMaSP.setSelectedItem(km.getLaptop().getMa());
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (check() == true) {
            KhuyenMai km = getDataKM();
            String query = iKMService.addKM(km);
            JOptionPane.showMessageDialog(this, query);
            loadTableKhuyenMai(iKMService.getList());
            loadTableLapTop(iKMService.getList());
            this.reset();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Xác nhận sửa?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        if (check() == true) {
            KhuyenMai km = getDataKM();
            km.setId(iKMService.getList().get(row).getId());
            String query = iKMService.updateKM(km);
            JOptionPane.showMessageDialog(this, query);
            loadTableKhuyenMai(iKMService.getList());
            loadTableLapTop(iKMService.getList());
            this.reset();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Xác nhận xóa?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        KhuyenMai km = getDataKM();
        km.setId(iKMService.getList().get(row).getId());
        String query = iKMService.deleteKM(km);
        JOptionPane.showMessageDialog(this, query);
        loadTableKhuyenMai(iKMService.getList());
        loadTableLapTop(iKMService.getList());
        this.reset();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormActionPerformed
        reset();
    }//GEN-LAST:event_btnXoaFormActionPerformed

    private void cboMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaSPActionPerformed
        getLaptop();
    }//GEN-LAST:event_cboMaSPActionPerformed

    private void txtTimKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKMCaretUpdate
        loadTableKhuyenMai(iKMService.findKhuyenMaiByName(txtTimKM.getText().trim()));
    }//GEN-LAST:event_txtTimKMCaretUpdate

    private void txtTimSPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimSPCaretUpdate
        loadTableTimLapTop(iKMService.getList());
    }//GEN-LAST:event_txtTimSPCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaForm;
    private javax.swing.JComboBox<String> cboMaSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayHH;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTimKM;
    private javax.swing.JTextField txtTimSP;
    // End of variables declaration//GEN-END:variables
}
