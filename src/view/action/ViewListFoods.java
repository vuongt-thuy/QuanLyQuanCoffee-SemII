/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.action;

import controller.FactoryDAO;
import controller.dao.interfaces.IGenerticDAO;
import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.Product;
import view.DashBoard;
import view.ErrorsMessageDialog;
import view.SuccessfulMessageDialog;

/**
 *
 * @author THUY
 */
public class ViewListFoods extends javax.swing.JFrame {

    private IGenerticDAO<Product, String> proDAO = FactoryDAO.getData("product");
    private IGenerticDAO<Category, Integer> catDAO = FactoryDAO.getData("category");

    private List<Product> listProduct;
    private List<Product> listFoods;
    private List<Category> listCategory;

    private DefaultTableModel modelFoodList;

    /**
     * Creates new form ViewListFoods
     */
    public ViewListFoods(java.awt.Frame parent, boolean modal) {
        initComponents();
        this.setTitle("List Foods");
        this.setLocationRelativeTo(null);

        listProduct = proDAO.getList();
        listFoods = proDAO.getListFoods();
        listCategory = catDAO.getList();

        modelFoodList = (DefaultTableModel) tblListFoods.getModel();
        setDataTable(listFoods);
        customTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bntDelete = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        bntEdit = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        txtKeySearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListFoods = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 175, 138), 2));

        bntDelete.setBackground(new java.awt.Color(191, 146, 114));
        bntDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bntDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntDelete.setPreferredSize(new java.awt.Dimension(135, 50));
        bntDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntDeleteMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("DELETE");

        javax.swing.GroupLayout bntDeleteLayout = new javax.swing.GroupLayout(bntDelete);
        bntDelete.setLayout(bntDeleteLayout);
        bntDeleteLayout.setHorizontalGroup(
            bntDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bntDeleteLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(29, 29, 29))
        );
        bntDeleteLayout.setVerticalGroup(
            bntDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bntEdit.setBackground(new java.awt.Color(191, 146, 114));
        bntEdit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bntEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntEdit.setPreferredSize(new java.awt.Dimension(135, 50));
        bntEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntEditMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("UPDATE");

        javax.swing.GroupLayout bntEditLayout = new javax.swing.GroupLayout(bntEdit);
        bntEdit.setLayout(bntEditLayout);
        bntEditLayout.setHorizontalGroup(
            bntEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bntEditLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        bntEditLayout.setVerticalGroup(
            bntEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnSearch.setForeground(new java.awt.Color(98, 66, 43));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_25px_1.png"))); // NOI18N
        btnSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(191, 146, 114)));
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        txtKeySearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtKeySearch.setForeground(new java.awt.Color(98, 66, 43));
        txtKeySearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(191, 146, 114)));
        txtKeySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeySearchActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jScrollPane2.setOpaque(false);

        tblListFoods.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblListFoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food name", "Image", "Price", "Discount", "Sale Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListFoods.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblListFoods.setOpaque(false);
        tblListFoods.setRowHeight(25);
        tblListFoods.setSelectionBackground(new java.awt.Color(191, 146, 114));
        tblListFoods.setShowVerticalLines(false);
        tblListFoods.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblListFoods);
        if (tblListFoods.getColumnModel().getColumnCount() > 0) {
            tblListFoods.getColumnModel().getColumn(0).setResizable(false);
            tblListFoods.getColumnModel().getColumn(0).setPreferredWidth(300);
            tblListFoods.getColumnModel().getColumn(1).setResizable(false);
            tblListFoods.getColumnModel().getColumn(1).setPreferredWidth(500);
            tblListFoods.getColumnModel().getColumn(2).setResizable(false);
            tblListFoods.getColumnModel().getColumn(2).setPreferredWidth(500);
            tblListFoods.getColumnModel().getColumn(3).setResizable(false);
            tblListFoods.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblListFoods.getColumnModel().getColumn(4).setResizable(false);
            tblListFoods.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblListFoods.getColumnModel().getColumn(5).setResizable(false);
            tblListFoods.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        jPanel2.setBackground(new java.awt.Color(227, 175, 138));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_50px_1.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        btnRefresh.setBackground(new java.awt.Color(191, 146, 114));
        btnRefresh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.setPreferredSize(new java.awt.Dimension(135, 50));
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("RERESH");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_refresh_27px_2.png"))); // NOI18N

        javax.swing.GroupLayout btnRefreshLayout = new javax.swing.GroupLayout(btnRefresh);
        btnRefresh.setLayout(btnRefreshLayout);
        btnRefreshLayout.setHorizontalGroup(
            btnRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRefreshLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRefreshLayout.setVerticalGroup(
            btnRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 35)); // NOI18N
        jLabel2.setText("List Foods ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_pizza_35px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSearch)
                .addGap(517, 517, 517))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(bntDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(558, 558, 558))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(bntDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void txtKeySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeySearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeySearchActionPerformed

    public void customTable() {
        tblListFoods.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblListFoods.getTableHeader().setOpaque(false);
        tblListFoods.getTableHeader().setBackground(new Color(32, 136, 203));
        tblListFoods.getTableHeader().setForeground(new Color(255, 255, 255));
        tblListFoods.setRowHeight(25);

    }


    private void bntDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntDeleteMouseClicked
        int indexSelected = tblListFoods.getSelectedRow();

        if (indexSelected == -1) {
            new ErrorsMessageDialog().setMessage("Plesase choose value!");
        } else {
            String id = listFoods.get(indexSelected).getId();
            proDAO.delete(id);
            new SuccessfulMessageDialog().setMassage("Delete successfully!");
            listFoods = proDAO.getListFoods();
            setDataTable(listFoods);
        }
    }//GEN-LAST:event_bntDeleteMouseClicked
    int x, y;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void bntEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEditMouseClicked
        int indexSelected = tblListFoods.getSelectedRow();

        if (indexSelected == -1) {
            new ErrorsMessageDialog().setMessage("Please choose value!");
        } else {
            EditProduct edit = new EditProduct();
            edit.setData(listFoods.get(indexSelected));
            edit.setVisible(true);
        }
    }//GEN-LAST:event_bntEditMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        List<Product> currentList = new ArrayList<>();

        String keySearch = txtKeySearch.getText();
        listFoods = proDAO.getListFoods();

        if (keySearch.isEmpty()) {
            new ErrorsMessageDialog().setMessage("Invalid value!");
        } else {
            for (Product d : listFoods) {
                if (d.getName().toLowerCase().contains(keySearch.toLowerCase())) {
                    currentList.add(d);
                }
            }

            if (currentList.size() == 0) {
                for (Product d : listFoods) {
                    if (d.getId().equals(keySearch)) {
                        currentList.add(d);
                    }
                }
                if (currentList.size() == 0) {
                    new ErrorsMessageDialog().setMessage("No result!");
                }
            }
            setDataTable(currentList);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        listFoods = proDAO.getListFoods();
        setDataTable(listFoods);
    }//GEN-LAST:event_btnRefreshMouseClicked

    public void setDataTable(List<Product> list) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);

        modelFoodList.setRowCount(0);
        listCategory = catDAO.getListFoods();
        for (Product p : list) {
            modelFoodList.addRow(new Object[]{
                p.getId(), p.getName(), p.getImage(), vn.format(p.getPrice()), (int) p.getDiscount() == 0 ? "" : (int) p.getDiscount() + "%", vn.format(p.getSale_price())
            });
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                ViewListFoods dialog = new ViewListFoods(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bntDelete;
    private javax.swing.JPanel bntEdit;
    private javax.swing.JPanel btnRefresh;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblListFoods;
    private javax.swing.JTextField txtKeySearch;
    // End of variables declaration//GEN-END:variables
}
