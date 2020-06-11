/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import object.GiaoVien;
import object.LichSuDung;
import object.MonHoc;
import object.PhongMay;
import service.GiaoVienService;
import service.LichSuDungService;
import service.MonHocService;
import service.PhongMayService;

/**
 *
 * @author Truong
 */
public class QuanLyDangKiSuDungPhongMay extends javax.swing.JFrame {

    private LichSuDungService lichSuDungService;
    private DefaultTableModel tableModel;

    /**
     * Creates new form QuanLyDangKiSuDungPhongMay
     */
    public QuanLyDangKiSuDungPhongMay() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);// cho full man hinh
        lichSuDungService = new LichSuDungService();
        tableModel = new DefaultTableModel() {//khong cho sua bang
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };

        jTable1.setModel(tableModel);
        tableModel.setColumnIdentifiers(new Object[]{"Mã phòng", "Vị trí", "Mã giáo viên", "Tên giáo viên", "Mã môn học", "Tên môn hoc", "Bắt đầu", "Kết thúc", "Ghi chú"});
        hienThi(lichSuDungService.getAll());

        //set các item cho combobox       
        for (PhongMay i : (new PhongMayService()).getAll()) {
            String phong = i.getMaPhongMay();
            boolean ktraPhong = false;
            for (int j = 0; j < cbbMaPhong.getItemCount(); j++) {
                if (phong.equalsIgnoreCase(cbbMaPhong.getItemAt(j))) {
                    ktraPhong = true;
                    break;
                }
            }
            if (!ktraPhong) {
                cbbMaPhong.addItem(phong);
                cbbMaPhongCu.addItem(phong);
                cbbMaPhongMoi.addItem(phong);
            }
        }
        //----
        for (GiaoVien i : (new GiaoVienService()).getAll()) {
            String gv = i.getMaGiaoVien();
            boolean ktraGV = false;
            for (int j = 0; j < cbbMaGV.getItemCount(); j++) {
                if (gv.equalsIgnoreCase(cbbMaGV.getItemAt(j))) {
                    ktraGV = true;
                    break;
                }
            }
            if (!ktraGV) {
                cbbMaGV.addItem(gv);
                cbbTenGV.addItem(i.getTenGiaoVien());

                cbbMaGVCu.addItem(gv);
                cbbTenGVCu.addItem(i.getTenGiaoVien());

                cbbMaGVMoi.addItem(gv);
                cbbTenGVMoi.addItem(i.getTenGiaoVien());
            }
        }
        //----
        for (MonHoc i : (new MonHocService()).getAll()) {
            String mh = i.getMaMonHoc();
            boolean ktraMH = false;
            for (int j = 0; j < cbbMaMH.getItemCount(); j++) {
                if (mh.equalsIgnoreCase(cbbMaMH.getItemAt(j))) {
                    ktraMH = true;
                    break;
                }
            }
            if (!ktraMH) {
                cbbMaMH.addItem(mh);
                cbbTenMH.addItem(i.getTenMonHoc());

                cbbMaMHCu.addItem(mh);
                cbbTenMHCu.addItem(i.getTenMonHoc());

                cbbMaMHMoi.addItem(mh);
                cbbTenMHMoi.addItem(i.getTenMonHoc());
            }

        }
        //thêm item trắng cho combobox
        cbbMaPhong.addItem("");
        cbbMaPhong.setSelectedItem("");
        cbbMaGV.addItem("");
        cbbMaGV.setSelectedItem("");
        cbbMaMH.addItem("");
        cbbMaMH.setSelectedItem("");
        cbbTenGV.addItem("");
        cbbTenGV.setSelectedItem("");
        cbbTenMH.addItem("");
        cbbTenMH.setSelectedItem("");
        
        cbbMaPhongCu.addItem("");
        cbbMaPhongCu.setSelectedItem("");
        cbbMaGVCu.addItem("");
        cbbMaGVCu.setSelectedItem("");
        cbbMaMHCu.addItem("");
        cbbMaMHCu.setSelectedItem("");
        cbbTenGVCu.addItem("");
        cbbTenGVCu.setSelectedItem("");
        cbbTenMHCu.addItem("");
        cbbTenMHCu.setSelectedItem("");

        cbbMaPhongMoi.addItem("");
        cbbMaPhongMoi.setSelectedItem("");
        cbbMaGVMoi.addItem("");
        cbbMaGVMoi.setSelectedItem("");
        cbbMaMHMoi.addItem("");
        cbbMaMHMoi.setSelectedItem("");
        cbbTenGVMoi.addItem("");
        cbbTenGVMoi.setSelectedItem("");
        cbbTenMHMoi.addItem("");
        cbbTenMHMoi.setSelectedItem("");
        
        //khởi tạo các ràng buộc chọn cho các combobox
        cbbMaGV.addActionListener((e) -> {
            int i = cbbMaGV.getSelectedIndex();
            cbbTenGV.setSelectedIndex(i);
        });
        cbbTenGV.addActionListener((e) -> {
            int i = cbbTenGV.getSelectedIndex();
            cbbMaGV.setSelectedIndex(i);
        });
        cbbMaMH.addActionListener((e) -> {
            int i = cbbMaMH.getSelectedIndex();
            cbbTenMH.setSelectedIndex(i);
        });
        cbbTenMH.addActionListener((e) -> {
            int i = cbbTenMH.getSelectedIndex();
            cbbMaMH.setSelectedIndex(i);
        });

        cbbMaGVMoi.addActionListener((e) -> {
            int i = cbbMaGVMoi.getSelectedIndex();
            cbbTenGVMoi.setSelectedIndex(i);
        });
        cbbTenGVMoi.addActionListener((e) -> {
            int i = cbbTenGVMoi.getSelectedIndex();
            cbbMaGVMoi.setSelectedIndex(i);
        });
        cbbMaMHMoi.addActionListener((e) -> {
            int i = cbbMaMHMoi.getSelectedIndex();
            cbbTenMHMoi.setSelectedIndex(i);
        });
        cbbTenMHMoi.addActionListener((e) -> {
            int i = cbbTenMHMoi.getSelectedIndex();
            cbbMaMHMoi.setSelectedIndex(i);
        });

        //cho frame ra giữa màn hình
        jFrame1.setLocationRelativeTo(null);
    }

    public void hienThi(List<LichSuDung> listLichSuDung) {
        tableModel.setRowCount(0);
        for (LichSuDung i : listLichSuDung) {
            tableModel.addRow(new Object[]{i.getPhongMay().getMaPhongMay(), i.getPhongMay().getViTri(),
                i.getGiaoVien().getMaGiaoVien(), i.getGiaoVien().getTenGiaoVien(),
                i.getMonHoc().getMaMonHoc(), i.getMonHoc().getTenMonHoc(),
                i.getBatDau(), i.getKetThuc(), i.getGhiChu()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbbMaPhongCu = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaGhiChuCu = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBatDauCu = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtKetThucCu = new javax.swing.JTextField();
        cbbMaGVCu = new javax.swing.JComboBox<>();
        cbbMaMHCu = new javax.swing.JComboBox<>();
        cbbTenGVCu = new javax.swing.JComboBox<>();
        cbbTenMHCu = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cbbMaPhongMoi = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaGhiChuMoi = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtBatDauMoi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtKetThucMoi = new javax.swing.JTextField();
        cbbMaGVMoi = new javax.swing.JComboBox<>();
        cbbMaMHMoi = new javax.swing.JComboBox<>();
        cbbTenGVMoi = new javax.swing.JComboBox<>();
        cbbTenMHMoi = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbbMaPhong = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaGhichu = new javax.swing.JTextArea();
        btnDangKi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBatDau = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtKetThuc = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cbbMaGV = new javax.swing.JComboBox<>();
        cbbMaMH = new javax.swing.JComboBox<>();
        cbbTenGV = new javax.swing.JComboBox<>();
        cbbTenMH = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.setTitle("Sửa lịch đăng kí sử dụng phòng máy");
        jFrame1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFrame1.setMinimumSize(new java.awt.Dimension(610, 570));
        jFrame1.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jFrame1.setResizable(false);
        jFrame1.setType(java.awt.Window.Type.POPUP);
        jFrame1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jFrame1WindowClosed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setText("Chỉnh sửa lịch sử dụng phòng máy");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(113, 113, 113))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jLabel12.setText("Phòng:");

        cbbMaPhongCu.setEnabled(false);

        jLabel13.setText("Mã giáo viên:");

        jLabel14.setText("Tên giáo viên:");

        jLabel15.setText("Ghi chú:");

        txtAreaGhiChuCu.setEditable(false);
        txtAreaGhiChuCu.setColumns(20);
        txtAreaGhiChuCu.setRows(5);
        txtAreaGhiChuCu.setEnabled(false);
        jScrollPane3.setViewportView(txtAreaGhiChuCu);

        jLabel16.setText("Mã môn học:");

        jLabel17.setText("Tên môn học:");

        jLabel18.setText("Bắt đầu vào:");

        txtBatDauCu.setEditable(false);
        txtBatDauCu.setEnabled(false);

        jLabel19.setText("Kết thúc vào:");

        txtKetThucCu.setEditable(false);
        txtKetThucCu.setEnabled(false);

        cbbMaGVCu.setEnabled(false);

        cbbMaMHCu.setEnabled(false);

        cbbTenGVCu.setEnabled(false);

        cbbTenMHCu.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setText("Lịch sử dụng phòng máy cũ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbbTenMHCu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbMaPhongCu, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3)
                                        .addGap(3, 3, 3))
                                    .addComponent(cbbMaGVCu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMaMHCu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbTenGVCu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKetThucCu)
                            .addComponent(txtBatDauCu))))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbbMaPhongCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbbMaGVCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbbTenGVCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbbMaMHCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbbTenMHCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtBatDauCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtKetThucCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(23, 23, 23))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));

        jLabel20.setText("Phòng:");

        jLabel21.setText("Mã giáo viên:");

        jLabel22.setText("Tên giáo viên:");

        jLabel23.setText("Ghi chú:");

        txtAreaGhiChuMoi.setColumns(20);
        txtAreaGhiChuMoi.setRows(5);
        jScrollPane4.setViewportView(txtAreaGhiChuMoi);

        jLabel24.setText("Mã môn học:");

        jLabel25.setText("Tên môn học:");

        jLabel26.setText("Bắt đầu vào:");

        jLabel27.setText("Kết thúc vào:");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setText("Lịch sử dụng phòng máy mới");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbMaPhongMoi, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jScrollPane4)
                                        .addGap(3, 3, 3))
                                    .addComponent(cbbMaGVMoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMaMHMoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbTenGVMoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbbTenMHMoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBatDauMoi)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtKetThucMoi)
                                .addGap(3, 3, 3)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(29, 29, 29))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbbMaPhongMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbbMaGVMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbbTenGVMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbbMaMHMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbbTenMHMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtBatDauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtKetThucMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(23, 23, 23))
        );

        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(175, 175, 175)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý lịch đăng kí sử dụng phòng máy");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Quản lý lịch đăng kí sử dụng phòng máy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(431, 431, 431))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setText("Phòng:");

        jLabel3.setText("Mã giáo viên:");

        jLabel4.setText("Tên giáo viên:");

        jLabel5.setText("Ghi chú:");

        txtAreaGhichu.setColumns(20);
        txtAreaGhichu.setRows(5);
        jScrollPane1.setViewportView(txtAreaGhichu);

        btnDangKi.setText("Đăng kí sử dụng phòng máy");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa lịch sử dụng phòng máy");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã môn học:");

        jLabel8.setText("Tên môn học:");

        jLabel9.setText("Bắt đầu vào:");

        jLabel10.setText("Kết thúc vào:");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa lịch sử dụng phòng máy");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbMaPhong, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addGap(3, 3, 3))
                                    .addComponent(cbbMaGV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMaMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbTenGV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbbTenMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBatDau)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtKetThuc)
                                .addGap(3, 3, 3))))
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbbTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Danh sách đăng kí sử dụng phòng máy");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Phòng", "Vị trí", "Mã giáo viên", "Tên giáo viên", "Bắt đầu", "Kết thúc", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        hienThi(lichSuDungService.getAll());
        cbbMaPhong.setSelectedItem("");
        cbbMaGV.setSelectedItem("");
        cbbTenGV.setSelectedItem("");
        cbbMaMH.setSelectedItem("");
        cbbTenMH.setSelectedItem("");
        txtBatDau.setText("");
        txtKetThuc.setText("");
        txtAreaGhichu.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int row = jTable1.getSelectedRow();
        cbbMaPhong.setSelectedItem(jTable1.getValueAt(row, 0));
        cbbMaGV.setSelectedItem((String) jTable1.getValueAt(row, 2));
        //jComboBox4.setSelectedItem((String) tb.getValueAt(row, 3));
        cbbMaMH.setSelectedItem((String) jTable1.getValueAt(row, 4));
        //jComboBox5.setSelectedItem((String) tb.getValueAt(row, 5));
        txtBatDau.setText((String) jTable1.getValueAt(row, 6));
        txtKetThuc.setText((String) jTable1.getValueAt(row, 7));
        txtAreaGhichu.setText((String) jTable1.getValueAt(row, 8));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        LichSuDung lichSuDung = new LichSuDung();
        lichSuDung.setPhongMay(new PhongMay((String) cbbMaPhong.getSelectedItem(), "", "", "", null));
        lichSuDung.setGiaoVien(new GiaoVien((String) cbbMaGV.getSelectedItem(), "", "", 0, ""));
        lichSuDung.setMonHoc(new MonHoc((String) cbbMaMH.getSelectedItem(), "", "", "", ""));
        lichSuDung.setBatDau(txtBatDau.getText());
        lichSuDung.setKetThuc(txtKetThuc.getText());
        lichSuDung.setGhiChu(txtAreaGhichu.getText());
        int kq = lichSuDungService.insert(lichSuDung);
        if (kq == 0) {
            JOptionPane.showMessageDialog(this, "Thêm không thành công!\n Hãy xem lại dữ liệu được thêm vào!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
        hienThi(lichSuDungService.getAll());
    }//GEN-LAST:event_btnDangKiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        LichSuDung lichSuDung = new LichSuDung();
        lichSuDung.setPhongMay(new PhongMay((String) cbbMaPhong.getSelectedItem(), "", "", "", null));
        lichSuDung.setGiaoVien(new GiaoVien((String) cbbMaGV.getSelectedItem(), "", "", 0, ""));
        lichSuDung.setMonHoc(new MonHoc((String) cbbMaMH.getSelectedItem(), "", "", "", ""));
        lichSuDung.setBatDau(txtBatDau.getText());
        lichSuDung.setKetThuc(txtKetThuc.getText());
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn xóa lịch đăng kí sử dụng phòng máy này?!");
        if (kq == JOptionPane.OK_OPTION) {
            if (lichSuDungService.delete(lichSuDung) == 0) {
                JOptionPane.showMessageDialog(this, "Xóa không thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            }
        }

        hienThi(lichSuDungService.getAll());
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        PhongMay phongMay = null;
        GiaoVien giaoVien = null;
        MonHoc monHoc = null;
        String ngay = null;
        if (!cbbMaPhong.getSelectedItem().equals("")) {
            phongMay = new PhongMay((String) cbbMaPhong.getSelectedItem(), "", "", "", null);
        }
        if (!((String) cbbMaGV.getSelectedItem()).equals("")) {
            giaoVien = new GiaoVien((String) cbbMaGV.getSelectedItem(), "", "", 0, "");
        }
        if (!((String) cbbMaMH.getSelectedItem()).equals("")) {
            monHoc = new MonHoc((String) cbbMaMH.getSelectedItem(), "", "", "", "");
        }
        if (!txtBatDau.getText().equals("")) {
            ngay = txtBatDau.getText();
        } else if (!txtKetThuc.getText().equals("")) {
            ngay = txtKetThuc.getText();
        }

        hienThi(lichSuDungService.find(phongMay, giaoVien, monHoc, ngay));
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        cbbMaPhongCu.setSelectedItem(cbbMaPhong.getSelectedItem());
        cbbMaGVCu.setSelectedItem(cbbMaGV.getSelectedItem());
        cbbMaMHCu.setSelectedItem(cbbMaMH.getSelectedItem());
        txtBatDauCu.setText(txtBatDau.getText());
        txtKetThucCu.setText(txtKetThuc.getText());
        txtAreaGhiChuCu.setText(txtAreaGhichu.getText());

        cbbMaPhongMoi.setSelectedItem(cbbMaPhong.getSelectedItem());
        cbbMaGVMoi.setSelectedItem(cbbMaGV.getSelectedItem());
        cbbMaMHMoi.setSelectedItem(cbbMaMH.getSelectedItem());
        txtBatDauMoi.setText(txtBatDau.getText());
        txtKetThucMoi.setText(txtKetThuc.getText());
        txtAreaGhiChuMoi.setText(txtAreaGhichu.getText());
        
        jFrame1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jFrame1WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame1WindowClosed
        jFrame1.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jFrame1WindowClosed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        jFrame1.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa!?\n"
                + "Bản ghi cũ sẽ bị xóa và thay bằng bản ghi mới!"
                + "Mọi thay đổi sau khi sửa sẽ không được hoàn tác!?");
        if (choose == JOptionPane.OK_OPTION) {
            LichSuDung lichSuDung = new LichSuDung();
            lichSuDung.setPhongMay(new PhongMay((String) cbbMaPhongCu.getSelectedItem(), "", "", "", null));
            lichSuDung.setGiaoVien(new GiaoVien((String) cbbMaGVCu.getSelectedItem(), "", "", 0, ""));
            lichSuDung.setMonHoc(new MonHoc((String) cbbMaMHCu.getSelectedItem(), "", "", "", ""));
            lichSuDung.setBatDau(txtBatDauCu.getText());
            lichSuDung.setKetThuc(txtKetThucCu.getText());
            int ktraXoa = lichSuDungService.delete(lichSuDung);

            lichSuDung.setPhongMay(new PhongMay((String) cbbMaPhongMoi.getSelectedItem(), "", "", "", null));
            lichSuDung.setGiaoVien(new GiaoVien((String) cbbMaGVMoi.getSelectedItem(), "", "", 0, ""));
            lichSuDung.setMonHoc(new MonHoc((String) cbbMaMHMoi.getSelectedItem(), "", "", "", ""));
            lichSuDung.setBatDau(txtBatDauMoi.getText());
            lichSuDung.setKetThuc(txtKetThucMoi.getText());
            lichSuDung.setGhiChu(txtAreaGhiChuMoi.getText());
            int ktraThem = lichSuDungService.insert(lichSuDung);

            if (ktraXoa == 0 && ktraThem == 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            } else if (ktraXoa != 0 && ktraThem == 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa bản ghi cũ nhưng bản ghi mới thêm vào đã tồn tại hoặc sai sót!\n"
                        + "Vui lòng quay lại và thêm mới lịch đăng kí phù hợp!");

            } else if (ktraXoa == 0 && ktraThem != 0) {
                JOptionPane.showMessageDialog(this, "Xóa bản ghi cũ không thành công vì có thể nó đang được sử dụng!\n"
                        + "Bản ghi mới cập nhật sẽ được thêm mới vào lịch đăng kí!");
            } else if (ktraXoa != 0 && ktraThem != 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            }

            jFrame1.setVisible(false);
            this.setVisible(true);
            btnLamMoiActionPerformed(evt);
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbMaGV;
    private javax.swing.JComboBox<String> cbbMaGVCu;
    private javax.swing.JComboBox<String> cbbMaGVMoi;
    private javax.swing.JComboBox<String> cbbMaMH;
    private javax.swing.JComboBox<String> cbbMaMHCu;
    private javax.swing.JComboBox<String> cbbMaMHMoi;
    private javax.swing.JComboBox<String> cbbMaPhong;
    private javax.swing.JComboBox<String> cbbMaPhongCu;
    private javax.swing.JComboBox<String> cbbMaPhongMoi;
    private javax.swing.JComboBox<String> cbbTenGV;
    private javax.swing.JComboBox<String> cbbTenGVCu;
    private javax.swing.JComboBox<String> cbbTenGVMoi;
    private javax.swing.JComboBox<String> cbbTenMH;
    private javax.swing.JComboBox<String> cbbTenMHCu;
    private javax.swing.JComboBox<String> cbbTenMHMoi;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtAreaGhiChuCu;
    private javax.swing.JTextArea txtAreaGhiChuMoi;
    private javax.swing.JTextArea txtAreaGhichu;
    private javax.swing.JTextField txtBatDau;
    private javax.swing.JTextField txtBatDauCu;
    private javax.swing.JTextField txtBatDauMoi;
    private javax.swing.JTextField txtKetThuc;
    private javax.swing.JTextField txtKetThucCu;
    private javax.swing.JTextField txtKetThucMoi;
    // End of variables declaration//GEN-END:variables
}
