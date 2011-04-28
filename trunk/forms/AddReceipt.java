/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddReceipt.java
 *
 * Created on 14 Ιαν 2010, 7:03:19 μμ
 */
package forms;

import components.MyDraggable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import models.Afm;
import models.Type;
import receipts.Main;
import com.googlecode.svalidators.formcomponents.SComboBox;
import com.googlecode.svalidators.formcomponents.STextField;
import com.googlecode.svalidators.validators.CustomValidator;
import com.googlecode.svalidators.validators.LengthValidator;
import com.googlecode.svalidators.validators.PositiveNumberValidator;
import com.googlecode.svalidators.validators.RequiredValidator;
import com.googlecode.svalidators.validators.SValidator;
import models.Database;
import java.sql.ResultSet;
import java.util.Date;
import models.Receipt;
import tools.Helper;
import tools.options.Options;

/**
 *
 * @author lordovol
 */
public class AddReceipt extends MyDraggable {

  public String afm, type, amount, date, comments;
  public double multiplier = 1.0;
  public int type_id = 0;
  public boolean cancel;

  /** Creates new form AddReceipt */
  public AddReceipt() {
    initComponents();
    textfield_newType.setVisible(false);
    spinner_multiplier.setVisible(false);
    textfield_afm.addValidator(new PositiveNumberValidator(textfield_afm.getText(), true, false));
    textfield_afm.addValidator(new LengthValidator(textfield_afm.getText(), 9, 0, 0, false));
    textfield_afm.addValidator(new CustomValidator(textfield_afm.getText(), false));
    CustomValidator cv = (CustomValidator) textfield_afm.getValidator(SValidator.CUSTOM);
    cv.setErrorMessage("Η τιμή θα πρέπει να είναι ένας έγκυρος Α.Φ.Μ.");
    textfield_amount.addValidator(new PositiveNumberValidator(textfield_amount.getText(), true, false));
    setLocationRelativeTo(null);
    setVisible(true);
    textfield_afm.requestFocusInWindow();
    getRootPane().setDefaultButton(button_ok);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        panel_left = new javax.swing.JPanel();
        label_afm = new javax.swing.JLabel();
        textfield_afm = new STextField();
        label_type = new javax.swing.JLabel();
        combo_type = new SComboBox(new RequiredValidator());
        checkbox_newType = new javax.swing.JCheckBox();
        textfield_newType = new STextField(new RequiredValidator());
        label_amount = new javax.swing.JLabel();
        textfield_amount = new STextField();
        label_date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_afm = new javax.swing.JComboBox();
        spinner_multiplier = new javax.swing.JSpinner();
        combo_date = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        label_comment = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_comments = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        button_ok = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setMaximumSize(new java.awt.Dimension(510, 400));
        panel.setPreferredSize(new java.awt.Dimension(510, 362));

        panel_left.setBackground(new java.awt.Color(255, 255, 255));

        label_afm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_afm.setLabelFor(textfield_afm);
        label_afm.setText("Α.Φ.Μ.");

        textfield_afm.setName("Α.Φ.Μ."); // NOI18N
        textfield_afm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textfield_afmFocusLost(evt);
            }
        });
        textfield_afm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfield_afmKeyReleased(evt);
            }
        });

        label_type.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_type.setLabelFor(combo_type);
        label_type.setText("Είδος");

        combo_type.setModel(Type.getModel());
        combo_type.setName("Είδος"); // NOI18N
        combo_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_typeActionPerformed(evt);
            }
        });

        checkbox_newType.setText("Νέο Είδος");
        checkbox_newType.setOpaque(false);
        checkbox_newType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_newTypeActionPerformed(evt);
            }
        });

        textfield_newType.setName("Νέο είδος"); // NOI18N
        textfield_newType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfield_newTypeKeyReleased(evt);
            }
        });

        label_amount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_amount.setLabelFor(textfield_amount);
        label_amount.setText("Ποσό");

        textfield_amount.setName("Ποσό"); // NOI18N
        textfield_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textfield_amountFocusLost(evt);
            }
        });
        textfield_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfield_amountKeyReleased(evt);
            }
        });

        label_date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_date.setText("Ημερομηνία");

        jLabel1.setText("Επιλογή Α.Φ.Μ.");

        combo_afm.setModel(Afm.getModel());
        combo_afm.setPreferredSize(new java.awt.Dimension(201, 20));
        combo_afm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_afmActionPerformed(evt);
            }
        });

        spinner_multiplier.setModel(new javax.swing.SpinnerNumberModel(100, 1, 500, 10));

        javax.swing.GroupLayout panel_leftLayout = new javax.swing.GroupLayout(panel_left);
        panel_left.setLayout(panel_leftLayout);
        panel_leftLayout.setHorizontalGroup(
            panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_leftLayout.createSequentialGroup()
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_leftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textfield_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                    .addGroup(panel_leftLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label_afm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfield_afm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_leftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(combo_type, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addGroup(panel_leftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_type, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_date, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox_newType)
                    .addComponent(label_date)
                    .addGroup(panel_leftLayout.createSequentialGroup()
                        .addComponent(textfield_newType, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinner_multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_afm, 0, 209, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_leftLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textfield_afm, textfield_amount});

        panel_leftLayout.setVerticalGroup(
            panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_afm)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_afm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_afm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textfield_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkbox_newType, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_newType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinner_multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel_leftLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_type, textfield_afm, textfield_amount, textfield_newType});

        label_comment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_comment.setText("Σχόλια");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textArea_comments.setColumns(20);
        textArea_comments.setRows(5);
        jScrollPane1.setViewportView(textArea_comments);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(label_comment, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(288, 288, 288))))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_comment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | java.awt.Font.BOLD, title.getFont().getSize()+2));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Προσθήκη απόδειξης");

        button_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
        button_ok.setToolTipText("Εισαγωγή");
        button_ok.setBorder(null);
        button_ok.setBorderPainted(false);
        button_ok.setContentAreaFilled(false);
        button_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
            }
        });

        button_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        button_cancel.setToolTipText("Κλείσιμο φόρμας");
        button_cancel.setBorder(null);
        button_cancel.setBorderPainted(false);
        button_cancel.setContentAreaFilled(false);
        button_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_cancel.setFocusPainted(false);
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(title)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
      cancel = true;
      dispose();
      Main.glassPane.deactivate();
    }//GEN-LAST:event_button_cancelActionPerformed

    private void checkbox_newTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_newTypeActionPerformed
      textfield_newType.setVisible(checkbox_newType.isSelected());
      spinner_multiplier.setVisible(checkbox_newType.isSelected());
      panel_left.revalidate();
      combo_type.setEnabled(!checkbox_newType.isSelected());
      if (checkbox_newType.isSelected()) {
        combo_type.clearError();
      } else {
        combo_type.validateValue();
      }
    }//GEN-LAST:event_checkbox_newTypeActionPerformed

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
      boolean error = false;
      String errorMessage = "";

      afm = textfield_afm.getText().trim();
      if (afm.equals("") || !Helper.isValidAfm(afm)) {
        error = true;
        errorMessage += "To πεδίο Α.Φ.Μ. θα πρέπει να είναι ένας έγκυρος Α.Φ.Μ.\n";
      }
      String regex = "^\\$?\\d+(\\.(\\d{2}))?$";
      amount = textfield_amount.getText().trim();
      if (!amount.matches(regex)) {
        textfield_amount.setText("");
        error = true;
        errorMessage += "Το ποσό πρέπει να είναι στη μορφή XXXXXX.XX ή XXXX\n";
      }
      SimpleDateFormat sdf = new SimpleDateFormat(Options.DATE_FORMAT);
      if (combo_date.getDate() != null) {
        date = sdf.format(combo_date.getDate());
      } else {
        error = true;
        errorMessage += "Η ημερομηνία πρέπει να είναι στη μορφή ΗΗ/ΜΜ/ΕΕΕΕ\n";
        combo_date.setDate(null);
      }
      if (checkbox_newType.isSelected()) {
        type_id = 0;
        type = textfield_newType.getText().trim();
        multiplier = Double.parseDouble(String.valueOf(spinner_multiplier.getValue()).replaceAll(",", ".")) / 100;
      } else {
        type = "";
        Type t = (Type) combo_type.getSelectedItem();
        type_id = t.getType_id();
      }
      if (type.equals("") && type_id == 0) {
        error = true;
        errorMessage += "Το είδος δεν πρέπει να είναι κενό\n";
      }
      comments = textArea_comments.getText().trim();
      if (error) {
        Helper.message(errorMessage, "Εισαγωγή απόδειξης", JOptionPane.WARNING_MESSAGE);
        Main.glassPane.activate(null);
      } else {
        Main.glassPane.deactivate();
        dispose();
        //Receipt r = new Receipt(0, afm, amount, date, type_id, comments);
      }
    }//GEN-LAST:event_button_okActionPerformed

    private void textfield_amountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_amountFocusLost
      String am = Helper.fixAmount(textfield_amount.getText().trim());
      textfield_amount.setText(am);
    }//GEN-LAST:event_textfield_amountFocusLost

    private void combo_afmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_afmActionPerformed
      if (combo_afm.getSelectedIndex() > 0) {
        Afm a = (Afm) combo_afm.getSelectedItem();
        textfield_afm.setText(a.getAfm());
        setTypeCombo(a.getType());
        
      } else {
        textfield_afm.setText("");
        setTypeCombo(null);
      }
      textfield_afmFocusLost(null);
    }//GEN-LAST:event_combo_afmActionPerformed

    private void textfield_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_amountKeyReleased
      textfield_amount.setText(textfield_amount.getText().replaceAll(",", "."));
    }//GEN-LAST:event_textfield_amountKeyReleased

    private void textfield_afmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_afmFocusLost
      validateAfm();
    }//GEN-LAST:event_textfield_afmFocusLost

    private void textfield_afmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_afmKeyReleased
      try {
        String tmpAfm = textfield_afm.getText().trim();
        String sql = "SELECT * from " + Receipt.TABLE + " WHERE `" + Receipt.COLUMN_AFM + "` LIKE '" + tmpAfm + "%'";
        ResultSet rs = Database.stmt.executeQuery(sql);
        if (rs.next()) {
          String foundAfm = rs.getString(Receipt.COLUMN_AFM);
          textfield_afm.setText(foundAfm);
          textfield_afm.setSelectionStart(tmpAfm.length());
          textfield_afm.setSelectionEnd(foundAfm.length());
        }
      } catch (SQLException ex) {
        Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_textfield_afmKeyReleased

    private void textfield_newTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_newTypeKeyReleased
    }//GEN-LAST:event_textfield_newTypeKeyReleased

    private void combo_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_typeActionPerformed
    }//GEN-LAST:event_combo_typeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_ok;
    private javax.swing.JCheckBox checkbox_newType;
    private javax.swing.JComboBox combo_afm;
    private com.toedter.calendar.JDateChooser combo_date;
    private com.googlecode.svalidators.formcomponents.SComboBox combo_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_afm;
    private javax.swing.JLabel label_amount;
    private javax.swing.JLabel label_comment;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_type;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_left;
    private javax.swing.JPanel panel_main;
    private javax.swing.JSpinner spinner_multiplier;
    private javax.swing.JTextArea textArea_comments;
    private com.googlecode.svalidators.formcomponents.STextField textfield_afm;
    private com.googlecode.svalidators.formcomponents.STextField textfield_amount;
    private com.googlecode.svalidators.formcomponents.STextField textfield_newType;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

  private void setTypeCombo(Type type) {
    if (type == null) {
      combo_type.setSelectedIndex(0);
      return;
    }
    ComboBoxModel mod = combo_type.getModel();
    for (int i = 0; i < mod.getSize(); i++) {
      Type t = (Type) mod.getElementAt(i);
      if (t.getType_id() == type.getType_id()) {
        combo_type.setSelectedItem(t);
      }
    }

  }

  private void validateAfm() {
    String val = textfield_afm.getText().trim();
    CustomValidator cv = (CustomValidator) textfield_afm.getValidator(SValidator.CUSTOM);
    if (Helper.isValidAfm(val)) {
      cv.setValid(true);
      Afm a = new Afm(0, val, "");
      setTypeCombo(a.getType());
    } else {
      cv.setValid(false);
    }
    textfield_afm.validate();
  }
}
