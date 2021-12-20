package ru.vsu.sc.tretyakov_d_s.Console;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import ru.vsu.sc.tretyakov_d_s.Console.CmdArgs.CmdParams;
import ru.vsu.sc.tretyakov_d_s.GUI.GuiMain;
import ru.vsu.sc.tretyakov_d_s.Sorting;
import ru.vsu.sc.tretyakov_d_s.Utils.ListUtils;

public class ConsoleMain {

  public static void main(String[] args) throws Exception {

    CmdArgs.CmdParams params = CmdArgs.parseArgs(args);

    if (params.help) {
      printHelp(params.error);
      System.exit(params.error ? 1 : 0);
    } else if (params.window) {
      GuiMain.main(args);
    } else {
      printResult(params);
    }
  }

  private static void printHelp(boolean error) {
    PrintStream out = error ? System.err : System.out;
    out.println("Usage: ");
    out.println("  <cmd> args <input-file> (<output-file>)");
    out.println("  <cmd> --help");
    out.println("  <cmd> --window  // show window");
  }

  private static List<List<String>> executeCheck(CmdParams params) throws FileNotFoundException {

    List<List<String>> list = ListUtils.loadStringList2FromFile(params.inputFile);

    if (list == null) {
      System.err.printf("Can't read list from \"%s\"%n", params.inputFile);
      System.exit(2);
    }

   Sorting sorting = new Sorting();
    return sorting.sortList(list);
  }

  private static void printResult(CmdArgs.CmdParams params)
      throws FileNotFoundException {
    if (params.outputFile != null) {
      ListUtils.writeList2ToFile(params.outputFile, executeCheck(params));
    } else {
      ListUtils.printList2InConsole(executeCheck(params));
    }
  }
}
