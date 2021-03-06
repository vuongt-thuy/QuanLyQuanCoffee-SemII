/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.action;

import controller.FactoryDAO;
import controller.dao.interfaces.IGenerticDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import model.Category;
import view.ConfirmDialog;
import view.ErrorsMessageDialog;
import view.SuccessfulMessageDialog;

/**
 *
 * @author THUY
 */
public class ViewListCategory extends javax.swing.JFrame {

    private IGenerticDAO<Category, Integer> catDAO = FactoryDAO.getData("category");
    private DefaultListModel defaultList;
    private List<Category> listCat;

    /**
     * Creates new form View
     */
    public ViewListCategory() {
        initComponents();
        this.setLocationRelativeTo(null);
        listCat = catDAO.getList();
        defaultList = new DefaultListModel<String>();

        setValue();
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
        jListCategory = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(227, 175, 138), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 800));

        bntDelete.setBackground(new java.awt.Color(191, 146, 114));
        bntDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bntDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntDelete.setPreferredSize(new java.awt.Dimension(132, 50));
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
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        bntEdit.setBackground(new java.awt.Color(191, 146, 114));
        bntEdit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bntEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntEdit.setPreferredSize(new java.awt.Dimension(132, 50));
        bntEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntEditMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("UPDATE");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bntEditLayout = new javax.swing.GroupLayout(bntEdit);
        bntEdit.setLayout(bntEditLayout);
        bntEditLayout.setHorizontalGroup(
            bntEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bntEditLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        bntEditLayout.setVerticalGroup(
            bntEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
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

        jListCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 146, 114)));
        jListCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jListCategory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListCategory.setSelectionBackground(new java.awt.Color(191, 146, 114));
        jScrollPane2.setViewportView(jListCategory);

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 35)); // NOI18N
        jLabel2.setText("List Category ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_pizza_35px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(bntEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bntDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSearch))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    int x, y;

    private void bntDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntDeleteMouseClicked
        int indexSelected = jListCategory.getSelectedIndex();

        if (indexSelected == -1) {
            new ErrorsMessageDialog().setMessage("Please choose value!");
        } else {
//            ConfirmDialog confirm = new ConfirmDialog();
//            confirm.setMassage("Do you want delete this?");
//            int reply = new ConfirmDialog().setMassage("Do you want delete this?");
//            if (reply == 1) {
//                int id = listCat.get(indexSelected).getId();
//                catDAO.delete(id);
//                new SuccessfulMessageDialog().setMassage("Delete Successfully!");
//                setValue();
//            }
            int id = listCat.get(indexSelected).getId();
            catDAO.delete(id);
            new SuccessfulMessageDialog().setMassage("Delete Successfully!");
            setValue();
        }
    }//GEN-LAST:event_bntDeleteMouseClicked

    public void setValue() {
        listCat.clear();
        defaultList.removeAllElements();
        listCat = catDAO.getList();
        for (Category c : listCat) {
            defaultList.addElement(c.getName());
            jListCategory.setModel(defaultList);
        }
    }

    private void txtKeySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeySearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeySearchActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        int indexSelected = jListCategory.getSelectedIndex();

        if (indexSelected == -1) {
            new ErrorsMessageDialog().setMessage("Please choose value!");
        } else {
            int id = listCat.get(indexSelected).getId();
            String nameCat = listCat.get(indexSelected).getName();

            EditCategory editCat = new EditCategory();
            editCat.setData(id, nameCat);
            editCat.setVisible(true);
        }

    }//GEN-LAST:event_jLabel12MouseClicked

    private void bntEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEditMouseClicked
        new EditCategory().setVisible(true);
    }//GEN-LAST:event_bntEditMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        String keySearch = txtKeySearch.getText();

        if (keySearch.equals("")) {
            new ErrorsMessageDialog().setMessage("Invalid value!");
        } else {
            listCat.clear();
            listCat = catDAO.selectByName(keySearch);
            if (listCat.size() == 0) {
                new ErrorsMessageDialog().setMessage("No result!");
            } else {
                defaultList.removeAllElements();
                for (Category c : listCat) {
                    defaultList.addElement(c.getName());
                    jListCategory.setModel(defaultList);
                }
            }
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
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
                UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
                new ViewListCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bntDelete;
    private javax.swing.JPanel bntEdit;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListCategory;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtKeySearch;
    // End of variables declaration//GEN-END:variables
}
