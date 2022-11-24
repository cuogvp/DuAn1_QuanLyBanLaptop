/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Userr;
import service.impl.UserService;
import services.IUserService;

/**
 *
 * @author dangc
 */
public class NhanVienPanel extends javax.swing.JPanel {

    private IUserService iUserService = new UserService();
    private DefaultTableModel model;
    private String duongDanAnh;

    public NhanVienPanel() {
        initComponents();
        loadData(iUserService.selectAll());
    }

    public void loadData(List<Userr> listUs) {
        model = (DefaultTableModel) tblQLNhanVien.getModel();
        model.setRowCount(0);
        for (Userr u : listUs) {
            model.addRow(new Object[]{u.getMa(), u.getTen(), u.getNgaySinh(),
                u.isGioiTinh() == true ? "Nam" : "Nữ", u.getSdt(), u.getDiaChi(), u.getChucVu(),
                u.getMatKhau(), u.getHinhAnh()});
        }
    }

    public Userr getData() {
        Userr u = new Userr();
        String ma = txtMaNV.getText().trim();
        u.setMa(ma);
        String ten = txtTenNV.getText().trim();
        u.setTen(ten);
        String ngaySinh = txtNgaySinh.getText().trim();
        u.setNgaySinh(ngaySinh);
        boolean gioiTinh;
        if (rdoNam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        u.setGioiTinh(gioiTinh);
        String sdt = txtSdt.getText().trim();
        u.setSdt(sdt);
        String diaChi = txtDiaChi.getText().trim();
        u.setDiaChi(diaChi);
        String chuVu = cboChuVu.getSelectedItem().toString();
        u.setChucVu(chuVu);
        String matKhau = txtMatKhau.getText().trim();
        u.setMatKhau(matKhau);

//        String anhNV = duongDanAnh;
//        if (duongDanAnh == "") {
//            anhNV = "NO AVARTAR";
//        }
        u.setHinhAnh("NO AVARTAR");
        return u;

    }

    public boolean checkValidate() {
        String dateStr = null;
        if (txtMaNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        }
        if (txtTenNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return false;
        }
        if (txtNgaySinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày Sinh không được để trống");
            return false;
        }
        if (rdoNam.isSelected() == false && rdoNu.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn giới tính");
            return false;
        }
        if (txtSdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sđt không được để trống");
            return false;
        }
        if (txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            return false;
        }
        if (txtMatKhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày Sinh không được để trống");
            return false;
        }
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            Date d = java.sql.Date.valueOf(txtNgaySinh.getText().trim());
            dateStr = formatDate.format(d);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "date khong dung dinh dang");
            e.printStackTrace();
            return false;
        }
        try {
            String sdt = txtSdt.getText();
            Pattern p1 = Pattern.compile("^0\\d{9}$");
            Matcher matcher1 = p1.matcher(sdt);
            if (matcher1.matches() == false) {
                JOptionPane.showMessageDialog(this, "sdt gồm 10 số bắt đầu bằng số 0");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkTrung() {
        List<Userr> listU = iUserService.selectAll();
        String ma = txtMaNV.getText();
        for (Userr u : listU) {
            if (u.getMa().equals(ma)) {
                JOptionPane.showMessageDialog(this, "mã không được trùng");
                return false;
            }
        }
        return true;
    }

    public void reset() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtNgaySinh.setText("");
        txtSdt.setText("");
        txtDiaChi.setText("");
        txtMatKhau.setText("");
        lbHinhAnh.setText("NO AVATAR");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbHinhAnh = new javax.swing.JLabel();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnXoaForm = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLNhanVien = new javax.swing.JTable();
        cboChuVu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThemNV = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(253, 254, 253));
        setPreferredSize(new java.awt.Dimension(826, 647));

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Tên nhân viên");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Số điện thoại");

        jLabel6.setText("ngày sinh");

        jLabel7.setText("giới tính");

        jLabel8.setText("Chức vụ");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        lbHinhAnh.setText("NO AVATAR");
        lbHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        btnSuaNV.setBackground(new java.awt.Color(204, 255, 255));
        btnSuaNV.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\update.png")); // NOI18N
        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnXoaNV.setBackground(new java.awt.Color(204, 255, 255));
        btnXoaNV.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\xoa.png")); // NOI18N
        btnXoaNV.setText("Xóa");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        btnXoaForm.setBackground(new java.awt.Color(204, 255, 255));
        btnXoaForm.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\clearForm.png")); // NOI18N
        btnXoaForm.setText("xóa from");
        btnXoaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        btnTimKiem.setBackground(new java.awt.Color(204, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\find.png")); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        tblQLNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày Sinh", "Giới tính", "SDT", "Địa chỉ", "Chức vụ", "Mật Khẩu", "Hình ảnh"
            }
        ));
        tblQLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLNhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );

        cboChuVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên", " " }));

        jPanel3.setBackground(new java.awt.Color(47, 144, 193));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(47, 144, 193));

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nhân viên");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemNV.setBackground(new java.awt.Color(204, 255, 255));
        btnThemNV.setIcon(new javax.swing.ImageIcon("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh\\Them.png")); // NOI18N
        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        jLabel10.setText("Mật khẩu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNu)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChi)
                            .addComponent(cboChuVu, 0, 160, Short.MAX_VALUE)
                            .addComponent(txtMatKhau))))
                .addGap(72, 72, 72))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnXoaForm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboChuVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(rdoNam)
                                    .addComponent(rdoNu)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormActionPerformed

//        reset();
    }//GEN-LAST:event_btnXoaFormActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        if (checkValidate()) {
            if (checkTrung()) {
                Userr u = getData();
                String query = iUserService.addUser(u);
                JOptionPane.showMessageDialog(this, query);
                loadData(iUserService.selectAll());
                reset();
            }
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        int row = tblQLNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        if (checkValidate()) {
            
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Xác nhận sửa?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
                Userr u = getData();
                u.setId(iUserService.selectAll().get(row).getId());
                String query = iUserService.updateUser(u);
                JOptionPane.showMessageDialog(this, query);
                loadData(iUserService.selectAll());
                reset();
            
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void tblQLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNhanVienMouseClicked
        int rows = tblQLNhanVien.getSelectedRow();
        Userr u = iUserService.selectAll().get(rows);
        txtMaNV.setText(u.getMa());
        txtTenNV.setText(u.getTen());
        txtNgaySinh.setText(u.getNgaySinh());
        if (u.isGioiTinh()) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtSdt.setText(u.getSdt());
        txtDiaChi.setText(u.getDiaChi());
        cboChuVu.setSelectedItem(u.getChucVu());
        txtMatKhau.setText(u.getMatKhau());
        lbHinhAnh.setText(u.getHinhAnh());
//        if (u.getHinhAnh().equalsIgnoreCase("NO AVARTAR")) {
//            lbHinhAnh.setText("NO AVARTAR");
//        } else {
//
//            lbHinhAnh.setText("");
//            ImageIcon icon = new ImageIcon(getClass().getResource("..//anh//." + u.getHinhAnh()));
//            Image image = icon.getImage();
//            image.getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), 0);
//            lbHinhAnh.setIcon(icon);
//        }
    }//GEN-LAST:event_tblQLNhanVienMouseClicked

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        int row = tblQLNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Xác nhận xóa?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Userr u = getData();
        u.setId(iUserService.selectAll().get(row).getId());
        String query = iUserService.deleteUser(u);
        JOptionPane.showMessageDialog(this, query);
        loadData(iUserService.selectAll());
        reset();
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void lbHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhAnhMouseClicked
        try {
            JFileChooser jfc = new JFileChooser("D:\\DUAN_1\\DuAn1_QuanLyBanLaptop\\anh");
            jfc.showOpenDialog(null);
            File f = jfc.getSelectedFile();
            if (f == null) {
                return;
            }
            duongDanAnh = f.getName();
            Image img = ImageIO.read(f);
            lbHinhAnh.setText("");
            int width = lbHinhAnh.getWidth();
            int height = lbHinhAnh.getHeight();
            lbHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));

        } catch (IOException ex) {
            System.out.println("ERRO" + ex.toString());
        }
    }//GEN-LAST:event_lbHinhAnhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaForm;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChuVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbHinhAnh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblQLNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
