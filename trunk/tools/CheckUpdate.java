/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CheckUpdate.java
 *
 * Created on 23 Ιαν 2009, 10:50:03 πμ
 */
package tools;

import components.MyDraggable;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import receipts.Main;

/**
 * Checking for updates of the application
 * @author ssoldatos
 */
public class CheckUpdate extends MyDraggable {

  private boolean isConected;
  private Update up;
  private static final long serialVersionUID = 34646758678L;
  private boolean onStartUp;
  /** The url to project on google code : "http://code.google.com/p/jreceipts/" **/
  public static final String MYSERIESPROJECT_URL = "http://code.google.com/p/jreceipts/";
  /** The url of the downloads list : "http://code.google.com/p/jreceipts//downloads/list" **/
  public static final String MYSERIESPROJECT_DOWNLOAD_LIST = "http://code.google.com/p/jreceipts/downloads/list";

  /** Creates new form CheckUpdate
   * @param onStartUp 
   */
  public CheckUpdate(boolean onStartUp) {
    
    initComponents();
    this.onStartUp = onStartUp;
    if (check()) {
      Main.log(Level.INFO, "Έλεγχος έκδοσης", null);
      up = new Update();
      Thread t = new Thread(up);
      t.start();
    } else {
      return;
    }
    setLocationRelativeTo(null);
    if (!onStartUp) {
      Main.glassPane.activate(null);
      setVisible(true);
    }
  }

  class Update implements Runnable {

    protected String latestVersion;
    private String currentVersion;
    private String latestVersionUri;

    public void run() {
      try {
        latestVersion = getLatestVersion();
        if (latestVersion != null) {
          currentVersion = Main.version + "(r"+Main.revision+")";
          label_latestVersion.setText(latestVersion);
          if (currentVersion.compareTo(latestVersion) < 0) {
            Main.log(Level.INFO, "Βρέθηκε νέα έκδοση!!!", null);
            label_needUpdate.setText("Βρέθηκε νέα έκδοση");
            label_needUpdate1.setText("Κατεβάστε την νέα έκδοση.");
            if (onStartUp) {
              Main.glassPane.activate(null);
              setVisible(true);
            }
          } else {
            label_needUpdate.setText("Δεν υπάρχει νεώτερη έκδοση!!!");
            Main.log(Level.INFO, "Δεν υπάρχει νεώτερη έκδοση!!!", null);
          }
        } else {
          Main.log(Level.WARNING, "Δεν ήταν δυνατή η σύνδεση για τον έλεγχο", null);
          label_needUpdate.setText("Δεν ήταν δυνατή η σύνδεση για τον έλεγχο!!!");
        }
      } catch (MalformedURLException ex) {
        Main.logger.log(Level.WARNING, null, ex);
        label_needUpdate.setText("Δεν ήταν δυνατή η σύνδεση για τον έλεγχο!!!");
      } catch (IOException ex) {
        Main.logger.log(Level.WARNING, null, ex);
        label_needUpdate.setText("Δεν ήταν δυνατή η σύνδεση για τον έλεγχο!!!");
      }
    }

    private String getLatestVersion() throws MalformedURLException, IOException {
      URL v = new URL(MYSERIESPROJECT_URL);
      BufferedReader in = new BufferedReader(new InputStreamReader(v.openStream()));
      label_needUpdate.setText("Σύνδεση με server!!!");
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        int pos = inputLine.indexOf("Current version :");
        if (pos > -1) {
          inputLine = inputLine.substring(pos + 17);
          inputLine = Helper.stripHTML(inputLine).trim();
          String uri = inputLine.replaceAll("[\\(\\)]", "").replaceAll("rev", "r");
          latestVersionUri = MYSERIESPROJECT_DOWNLOAD_LIST;
          in.close();
          progressBar_checkUpdates.setIndeterminate(false);
          progressBar_checkUpdates.setString("");
          return inputLine;
        }
      }
      return null;
    }
  }

  private boolean check() {
    isConected = Helper.hasInternetConnection(MYSERIESPROJECT_URL);
    if (!isConected) {
      Main.log(Level.WARNING, "Δεν ήταν δυνατή η σύνδεση στο Internet", null);
      Helper.message("Δεν ήταν δυνατή η σύνδεση στο Internet", "Έλεγχος έκδοσης", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    return true;
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    label_currentVersion = new javax.swing.JLabel();
    label_latestVersion = new javax.swing.JLabel();
    progressBar_checkUpdates = new javax.swing.JProgressBar();
    jPanel3 = new javax.swing.JPanel();
    label_needUpdate = new javax.swing.JLabel();
    label_needUpdate1 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    button_close = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Check for  updates");

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel1.setPreferredSize(new java.awt.Dimension(300, 196));

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Έκδοση :");

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel3.setText("Τελευταία έκδοση :");

    label_currentVersion.setText(Main.version + "(r"+Main.revision+")");

    label_latestVersion.setText(" ");

    progressBar_checkUpdates.setIndeterminate(true);
    progressBar_checkUpdates.setString("Έλεγχος έκδοσης");
    progressBar_checkUpdates.setStringPainted(true);

    jPanel3.setOpaque(false);

    label_needUpdate.setText(" ");

    label_needUpdate1.setFont(label_needUpdate1.getFont().deriveFont(label_needUpdate1.getFont().getStyle() | java.awt.Font.BOLD, label_needUpdate1.getFont().getSize()+1));
    label_needUpdate1.setText(" ");
    label_needUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        label_needUpdate1MouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        label_needUpdate1MouseExited(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        label_needUpdate1MouseReleased(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(label_needUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(label_needUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
            .addContainerGap())))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(label_needUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(label_needUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label_currentVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
              .addComponent(label_latestVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
          .addComponent(progressBar_checkUpdates, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(label_currentVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(label_latestVersion))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(progressBar_checkUpdates, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText(Main.TITLE + " - Έλεγχος έκδοσης");

    button_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
    button_close.setToolTipText("Close");
    button_close.setBorder(null);
    button_close.setBorderPainted(false);
    button_close.setContentAreaFilled(false);
    button_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    button_close.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_closeActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
            .addContainerGap())
          .addComponent(button_close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel1)
          .addComponent(button_close, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void button_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_closeActionPerformed
      Main.glassPane.deactivate();
      dispose();
    }//GEN-LAST:event_button_closeActionPerformed

  private void downloadUpdate() {
    try {
      URI download = new URI(up.latestVersionUri);
      Helper.browse(download);
    } catch (URISyntaxException ex) {
      Main.log(Level.SEVERE, null, ex);
    } catch (UnsupportedOperationException ex) {
      Main.log(Level.WARNING, ex.getMessage(), ex);
    } catch (IOException ex) {
      Main.log(Level.WARNING, ex.getMessage(), ex);
    }
  }
    private void label_needUpdate1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_needUpdate1MouseEntered
      this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_label_needUpdate1MouseEntered

    private void label_needUpdate1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_needUpdate1MouseExited
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_label_needUpdate1MouseExited

    private void label_needUpdate1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_needUpdate1MouseReleased
      downloadUpdate();
    }//GEN-LAST:event_label_needUpdate1MouseReleased
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_close;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JLabel label_currentVersion;
  private javax.swing.JLabel label_latestVersion;
  private javax.swing.JLabel label_needUpdate;
  private javax.swing.JLabel label_needUpdate1;
  private javax.swing.JProgressBar progressBar_checkUpdates;
  // End of variables declaration//GEN-END:variables
}