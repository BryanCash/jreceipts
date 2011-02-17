/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import components.MyTableModel;
import components.MyTablePanel;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import models.Afm;
import models.Receipt;
import models.Type;
import receipts.Main;
import tools.Global;
import tools.Helper;

/**
 *
 * @author lordovol
 */
public class AfmsTablePanel extends MyTablePanel {

  private final Main m;

  /** Creates new form TypoesPanel */
  public AfmsTablePanel(Main m) {
    setModel();
    super.init();
    bt_popup.setVisible(false);
    this.m = m;
    _NUMBER_OF_FIELDS = 3;
    setTitle("Λίστα Α.Φ.Μ.");
    setHint("Κάντε διπλό κλικ σε κάποιο πεδίο για να το μετατρέψετε και δεξί κλικ για να το διαγράψετε");
    object = Type.class;
    addColumns();
    addRows();
    tableModel.addTableModelListener(this);
    setVisible(true);
  }

  public void addRows() {
    Vector<Object> col = Afm.getCollection(false);
    Iterator<Object> it = col.iterator();
    while (it.hasNext()) {
      Afm afm = (Afm) it.next();
      Object data[] = {afm.getAfm_id(), afm.getAfm(), afm.getName()};
      tableModel.addRow(data);
    }

  }

  public void addColumns() {
    String[] names = {"Α/Α", "Α.Φ.Μ.", "Εταιρεία"};
    int[] pref = {40, 300, 400};
    int[] min = {40, 200, 200};
    int[] max = {60, 400, 1000};
    super.addColumns(names, pref, min, max);

  }

  public void update() {
    tableModel.setRowCount(0);
    addRows();
  }

  @Override
  public void delete(int id) {
    if (Helper.confirm("Διαγραφή Α.Φ.Μ.", "Θέλετε να διαγραφεί το Α.Φ.Μ.;") == JOptionPane.YES_OPTION) {
      Afm.deleteById(id);
      m.updateAfmPanel();
    }
  }

  private void setModel() {
    tableModel = new MyTableModel() {

      @Override
      public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
          return Integer.class;
        }
        return super.getColumnClass(columnIndex);
      }



      @Override
      public boolean isCellEditable(int row, int col) {
        if (col > 0) {
          return true;
        } else {
          return false;
        }
      }
    };

  }

  public void tableChanged(TableModelEvent e) {
    String oldValue = (String) Global.selectedValue;
    String rec[] = new String[_NUMBER_OF_FIELDS];
    if (e.getType() == TableModelEvent.UPDATE) {
      int row = e.getFirstRow();
      TableModel model = (TableModel) e.getSource();

      for (int i = 0; i < _NUMBER_OF_FIELDS; i++) {
        rec[i] = String.valueOf(model.getValueAt(row, i));
      }
      Afm afm = new Afm(Integer.parseInt(rec[0]), rec[1], rec[2]);
      try {
        afm.save();
        if(colSelected == 1 && !oldValue.equals(rec[1])){
          Receipt.updateField("afm",rec[1],oldValue);
          System.out.println("AFM changed from " + oldValue + " to " +rec[1]);
        }
      } catch (SQLException ex) {
        Helper.message("Κάποιο λάθος δημιουργήθηκε στη βάση.\n Η εγγραφη δεν αποθηκεύθηκε.", "SQL σφάλμα", JOptionPane.ERROR_MESSAGE);
        Main.log(Level.SEVERE, "Κάποιο λάθος δημιουργήθηκε στη βάση.\n Η εγγραφη δεν αποθηκεύθηκε.", ex);
      }

    }
  }
}

