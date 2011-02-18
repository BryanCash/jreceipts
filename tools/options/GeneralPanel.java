/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DBPanel.java
 *
 * Created on 18 Φεβ 2011, 9:10:31 πμ
 */
package tools.options;

import components.Database;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ssoldatos
 */
public class GeneralPanel extends javax.swing.JPanel {

  private static final long serialVersionUID = 34536346456L;
  DefaultComboBoxModel dbmodel = new DefaultComboBoxModel();

  /** Creates new form DBPanel */
  public GeneralPanel() {
    dbmodel = new DefaultComboBoxModel(Database.getDatabases());
    dbmodel.insertElementAt(Options.ASK_FOR_DB, 0);
    initComponents();
    
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    cb_autoUpdate = new javax.swing.JCheckBox();
    jCheckBox1 = new javax.swing.JCheckBox();
    jLabel2 = new javax.swing.JLabel();
    combo_laf = new javax.swing.JComboBox();
    jLabel3 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Γενικές Ρυθμίσεις");

    cb_autoUpdate.setSelected(Options.toBoolean(Options.AUTO_UPDATE));
    cb_autoUpdate.setText("Αναζήτηση νεώτερης έκδοσης στην έναρξη");
    cb_autoUpdate.setName(Options.AUTO_UPDATE);
    cb_autoUpdate.setOpaque(false);

    jCheckBox1.setSelected(Options.toBoolean(Options.DEBUG));
    jCheckBox1.setText("Εγγραφή αρχείου γεγονότων");
    jCheckBox1.setName(Options.DEBUG);
    jCheckBox1.setOpaque(false);

    jLabel2.setText("Εμφάνιση:");

    combo_laf.setModel(new DefaultComboBoxModel(LookAndFeel.LOOK_AND_FEELS));
    combo_laf.setSelectedItem(Options.toString(Options.LOOK_FEEL));
    combo_laf.setName(Options.LOOK_FEEL);

    jLabel3.setText("(Απαιτείτε επανεκίνηση της εφαρμογής)");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(combo_laf, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel3)
          .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cb_autoUpdate))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(combo_laf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addGap(18, 18, 18)
        .addComponent(jCheckBox1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cb_autoUpdate)
        .addContainerGap(47, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox cb_autoUpdate;
  private javax.swing.JComboBox combo_laf;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  // End of variables declaration//GEN-END:variables
}
