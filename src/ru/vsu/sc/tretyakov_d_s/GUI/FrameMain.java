package ru.vsu.sc.tretyakov_d_s.GUI;


import java.io.File;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import ru.vsu.sc.tretyakov_d_s.Sorting;
import ru.vsu.sc.tretyakov_d_s.Utils.JTableUtils;
import ru.vsu.sc.tretyakov_d_s.Utils.ListUtils;
import ru.vsu.sc.tretyakov_d_s.Utils.SwingUtils;

public class FrameMain extends JFrame {

  private JPanel panelMain;
  private JButton saveTheListToButton;
  private JButton sortTheListButton;
  private JButton loadTheListFromButton;
  private JTable table1;
  private final JFileChooser fileChooserOpen;
  private final JFileChooser fileChooserSave;

  public FrameMain() {
    this.setTitle("Task 10");
    this.setContentPane(panelMain);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    Sorting sorting = new Sorting();
    String[] columnNames = {"ФИО", "Группа", "Курс"};

    JTableUtils.initJTableForArray(table1, 150, true, true, true, false, 25, 15);



    fileChooserOpen = new JFileChooser();
    fileChooserSave = new JFileChooser();
    fileChooserOpen.setCurrentDirectory(new File("."));
    fileChooserSave.setCurrentDirectory(new File("."));
    FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
    fileChooserOpen.addChoosableFileFilter(filter);
    fileChooserSave.addChoosableFileFilter(filter);

    fileChooserSave.setAcceptAllFileFilterUsed(false);
    fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
    fileChooserSave.setApproveButtonText("Save");

    JMenuBar menuBarMain = new JMenuBar();
    setJMenuBar(menuBarMain);

    JMenu menuLookAndFeel = new JMenu();
    menuLookAndFeel.setText("Вид");
    menuBarMain.add(menuLookAndFeel);
    SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

    loadTheListFromButton.addActionListener(e -> {
      try {
        if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
          List<List<String>> list = ListUtils.loadStringList2FromFile(fileChooserOpen.getSelectedFile().getPath());

          JTableUtils.writeArrayToJTable(table1,
              Objects.requireNonNull(ListUtils.toStringArr2(list)), null);

          JTableUtils.renameJTableColumns(table1, columnNames);
        }
      } catch (Exception exception) {
        SwingUtils.showErrorMessageBox(exception);
      }
    });

    sortTheListButton.addActionListener(e -> {
      try {
        String[][] str = JTableUtils.readStringArrayFromJTable(table1);
        List<List<String>> inputList = ListUtils.toList2(str);

        JTableUtils.writeArrayToJTable(table1, ListUtils.toStringArr2(sorting.sortList(inputList)), null);
        JTableUtils.renameJTableColumns(table1, columnNames);

      } catch (Exception exception) {
        SwingUtils.showErrorMessageBox(exception);
      }
    });

    saveTheListToButton.addActionListener(actionEvent -> {
      try {
        if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
          String[][] str = JTableUtils.readStringArrayFromJTable(table1);
          List<List<String>> outputList = ListUtils.toList2(str);
          String file = fileChooserSave.getSelectedFile().getPath();

          if (!file.toLowerCase().endsWith(".txt")) {
            file += ".txt";
          }
          ListUtils.writeList2ToFile(file, outputList);
        }
      } catch (Exception exception) {
        SwingUtils.showErrorMessageBox(exception);
      }
    });

  }
}

