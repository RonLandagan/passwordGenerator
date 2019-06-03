import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
   This class demonstrates the List Component.
*/

public class ListWindow extends JFrame 
{
   private JPanel monthPanel;         // To hold components
   private JList monthList;           // The months
   /**
      Constructor
   */

   public ListWindow()
   {
      // Set the title.
      setTitle("List of Passwords");

      // Add a BorderLayout manager.
      setLayout(new BorderLayout());

      // Build the month and selectedMonth panels.
      try{
         buildMonthPanel();
      }
      catch(Exception ioe){
         System.out.print("ERROR");
      }

      // Add the panels to the content pane.
      add(monthPanel, BorderLayout.CENTER);

      // Pack and display the window.
      pack();
      setVisible(true);
   }

   /**
      The buildMonthPanel method adds a list containing
      the names of the months to a panel.
   */

   private void buildMonthPanel() throws Exception
   {
      String[] months = Dictionary.getPasswords();
      
      // Create a panel to hold the list.
      monthPanel = new JPanel();

      // Create the list.
      monthList = new JList(months);

      // Set the selection mode to single selection.
      monthList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

      // Add the list to the panel.
      monthPanel.add(monthList);
   }
   /**
      The main method creates an instance of the
      ListWindow class which causes it to display
      its window.
   */

     public static void main(String[] args)
     {
          new ListWindow();
     }
}
