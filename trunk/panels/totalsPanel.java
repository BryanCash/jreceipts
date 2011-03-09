/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * totalsPanel.java
 *
 * Created on 17 Ιαν 2010, 3:11:48 μμ
 */
package panels;

import java.util.Vector;
import models.Receipt;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import tools.Helper;

/**
 *
 * @author lordovol
 */
public class totalsPanel extends javax.swing.JPanel {
  private ChartPanel cpanel;
  private JFreeChart pieChart;
  private Vector<Object> collection;

  /** Creates new form totalsPanel */
  public totalsPanel() {
   
    initComponents();
    getTotals();
  
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
    jPanel1 = new javax.swing.JPanel();
    label_titleYear = new javax.swing.JLabel();
    label_apYear_lektiko = new javax.swing.JLabel();
    label_posoYear_lektiko = new javax.swing.JLabel();
    label_totalMonthLektiko = new javax.swing.JLabel();
    label_apMonth_lektiko = new javax.swing.JLabel();
    label_posoMonth_lektiko = new javax.swing.JLabel();
    label_apYear = new javax.swing.JLabel();
    label_posoYear = new javax.swing.JLabel();
    label_apMonth = new javax.swing.JLabel();
    label_posoMonth = new javax.swing.JLabel();

    jLabel1.setText("jLabel1");

    setOpaque(false);

    jPanel1.setOpaque(false);

    label_titleYear.setFont(label_titleYear.getFont().deriveFont(label_titleYear.getFont().getStyle() | java.awt.Font.BOLD, label_titleYear.getFont().getSize()+2));
    label_titleYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_titleYear.setText("Σύνολα Έτους");

    label_apYear_lektiko.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_apYear_lektiko.setText("Αποδείξεις:");

    label_posoYear_lektiko.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_posoYear_lektiko.setText("Ποσό:");

    label_totalMonthLektiko.setFont(label_totalMonthLektiko.getFont().deriveFont(label_totalMonthLektiko.getFont().getStyle() | java.awt.Font.BOLD, label_totalMonthLektiko.getFont().getSize()+2));
    label_totalMonthLektiko.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_totalMonthLektiko.setText("Σύνολα Μήνα");

    label_apMonth_lektiko.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_apMonth_lektiko.setText("Αποδείξεις:");

    label_posoMonth_lektiko.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_posoMonth_lektiko.setText("Ποσό:");

    label_apYear.setFont(label_apYear.getFont().deriveFont(label_apYear.getFont().getStyle() | java.awt.Font.BOLD));
    label_apYear.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_apYear.setText("0");

    label_posoYear.setFont(label_posoYear.getFont().deriveFont(label_posoYear.getFont().getStyle() | java.awt.Font.BOLD));
    label_posoYear.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_posoYear.setText("0");

    label_apMonth.setFont(label_apMonth.getFont().deriveFont(label_apMonth.getFont().getStyle() | java.awt.Font.BOLD));
    label_apMonth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_apMonth.setText("0");

    label_posoMonth.setFont(label_posoMonth.getFont().deriveFont(label_posoMonth.getFont().getStyle() | java.awt.Font.BOLD));
    label_posoMonth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_posoMonth.setText("0");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(label_titleYear, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_apYear_lektiko)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(label_apYear, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
          .addComponent(label_totalMonthLektiko, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_apMonth_lektiko)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(label_apMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_posoYear_lektiko)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(label_posoYear, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_posoMonth_lektiko)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(label_posoMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
        .addContainerGap())
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {label_apMonth_lektiko, label_apYear_lektiko, label_posoMonth_lektiko, label_posoYear_lektiko});

    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label_titleYear)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_apYear_lektiko)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
            .addComponent(label_posoYear_lektiko)
            .addGap(2, 2, 2))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_apYear, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(label_posoYear, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(26, 26, 26)
        .addComponent(label_totalMonthLektiko)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_apMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(label_posoMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(label_posoMonth_lektiko)))
          .addComponent(label_apMonth_lektiko))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel label_apMonth;
  private javax.swing.JLabel label_apMonth_lektiko;
  private javax.swing.JLabel label_apYear;
  private javax.swing.JLabel label_apYear_lektiko;
  private javax.swing.JLabel label_posoMonth;
  private javax.swing.JLabel label_posoMonth_lektiko;
  private javax.swing.JLabel label_posoYear;
  private javax.swing.JLabel label_posoYear_lektiko;
  private javax.swing.JLabel label_titleYear;
  private javax.swing.JLabel label_totalMonthLektiko;
  // End of variables declaration//GEN-END:variables

  private void getTotals() {
    int totalReceiptsYear = Receipt.getCount("");
    label_apYear.setText(String.valueOf(totalReceiptsYear));
    float totalAmountYear = Receipt.getAmount("");
    label_posoYear.setText(Helper.convertAmountForViewing(totalAmountYear));
    int totalReceiptsMonth = Receipt.getCount("strftime('%m', "+Receipt.COLUMN_BUY_DATE+") = '" + Helper.getThisMonth()+"'" );
    label_apMonth.setText(String.valueOf(totalReceiptsMonth));
    float totalAmountMonth = Receipt.getAmount("strftime('%m', "+Receipt.COLUMN_BUY_DATE+") = '" + Helper.getThisMonth()+"'" );
    label_posoMonth.setText(Helper.convertAmountForViewing(totalAmountMonth));
    label_totalMonthLektiko.setText(Helper.getCurrentGreekMonth() + ":");
  }

 
}
