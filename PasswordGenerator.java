import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface

/**
* The PasswordGenerator class displays a JFrame that
* lets the user create a randomly generated password. 
* When the "Generate Password" button is clicked, a 
* randomly generated password is is displayed.
* When the "Save Password" button is clicked, the currently
* displayed password is encrypted and saved onto the 
* "Passwords.txt" file. 
* When the "Display Saved Passwords" button is clicked, 
* the user is asked to enter the master password. If
* correct, the user is shown all of the saved passwords.
*
* @author Ron Landagan
* @version 1.0
* @since 2017-12-12
*/

public class PasswordGenerator extends JFrame
{
   private JPanel panel;             // To reference a panel
   private JLabel messageLabel;      // To reference a label
   private JLabel responseLabel;      // To reference a response label
   private JTextField passwordTextField; // To reference a master password text field
   private JButton generateButton;       // To reference a "Generate Password" button
   private JButton saveButton;      // To reference a "Save Password" Button
   private JButton displayButton;   // To reference a "Display Saved Passwords" Button
   private final int WINDOW_WIDTH = 500;  // Window width
   private final int WINDOW_HEIGHT = 167; // Window height
   private String newPassword = "";

   /**
      Constructor
   */
   public PasswordGenerator()
   {
      // Set the window title.
      setTitle("Password Generator");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Build the panel and add it to the frame.
      buildPanel();

      // Add the panel to the frame's content pane.
      add(panel);

      // Display the window.
      setVisible(true);
   }

   /**
   * The buildPanel method adds the "Generate Password",
   * "Save Password", and "Display Saved Passwords" buttons
   * and two labels to the panel.
   */

   private void buildPanel()
   {
      // Create a label to display instructions.
      messageLabel = new JLabel("Hello. Welcome to the Password Generator. "+
                                 "What would you like to do?");

      // Create a button with the caption "Generate Password".
      generateButton = new JButton("Generate Password");
      
      // Create a button with the caption "Save Password".
      saveButton = new JButton("Save Password");

      // Create a button with the caption "Display Saved Passwords".
      displayButton = new JButton("Display Saved Passwords");

      // Add action listeners to the buttons.
      generateButton.addActionListener(new GenerateButtonListener());
      saveButton.addActionListener(new SaveButtonListener());
      displayButton.addActionListener(new DisplayButtonListener());
      
      // Create a blank response label
      responseLabel = new JLabel("");

      // Create a JPanel object and let the panel
      // field reference it.
      panel = new JPanel();

      // Add the label, text field, and button
      // components to the panel.
      panel.add(messageLabel);
      panel.add(generateButton);
      panel.add(saveButton);
      panel.add(displayButton);
      panel.add(responseLabel);
   }

   /**
   * GenerateButtonListener is an action listener class for
   * the "Generate Password" button.
   */
   private class GenerateButtonListener implements ActionListener
   {
      /**
      * The actionPerformed method executes when the user
      * clicks on the "Generate Password" button.
      * @param e The event object.
      */
      public void actionPerformed(ActionEvent e)
      {      
         //Remove the current responseLabel
         panel.remove(4);
         panel.updateUI();
         
         //Generate a new password
         newPassword = Dictionary.generatePassword();
         
         //Display the new password
         responseLabel = new JLabel("Freshly Generated Password: "+ newPassword);    
         panel.add(responseLabel);
         add(panel);
         setVisible(true);       
      }
   } // End of GenerateButtonListener class

   /**
   * SaveButtonListener is an action listener class for
   * the "Save Password" button.
   */   
   private class SaveButtonListener implements ActionListener
   {
      /**
      * The actionPerformed method executes when the user
      * clicks on the "Save Password" button.
      * @param e The event object.
      */
      public void actionPerformed(ActionEvent e)
      {
         //Remove the current responseLabel
         panel.remove(4);
         panel.updateUI();
         
         //If password has just been generated, save it
         if((newPassword != "")&&((!responseLabel.getText().equals(
                                   "Password has been saved."))&&
                                  (!responseLabel.getText().equals(
                                   "Password couldn't be saved"))))
         {
            try
               {
                  String passwordUsername = JOptionPane.showInputDialog(null, 
                                       "Where will you use this Password?");
                  Dictionary.savePassword(passwordUsername+":",false);
                  Dictionary.savePassword(newPassword+"\n\n",true);
               }
            catch(Exception g)
               {
                  System.out.println("There was an error writing the file");
               }
         
            //Inform the user that the password has been saved to the database.
            responseLabel = new JLabel("Password has been saved.");
            
         }
         else
            responseLabel = new JLabel("Password couldn't be saved");
         
         panel.add(responseLabel);
         add(panel);
         setVisible(true);
      }
   } // End of SaveButtonListener class
  
   /**
   * DisplayButtonListener is an action listener class for
   * the "Display Saved Passwords" button.
   */   
   private class DisplayButtonListener implements ActionListener
   {
      /**
      * The actionPerformed method executes when the user
      * clicks on the "Display Saved Passwords" button.
      * @param e The event object.
      */
      public void actionPerformed(ActionEvent e)
      {
         String attemptedPassword; 
         
         //Ask user for password to display data
         attemptedPassword = JOptionPane.showInputDialog(null, 
                                       "Please enter the Master Password");   
                                       
         //The master password is "password" 
         if(attemptedPassword.equals("password")) 
         {
            //If correct, the other passwords are displayed
            try
            {new ListWindow();}
            catch(Exception g)
            {System.out.println("Error: Passwords not found");}
         }
         else
         {
            //If incorrect, the program informs the user
            JOptionPane.showMessageDialog(null, "Incorrect Password");
         }

      }
   } // End of DisplayButtonListener class

   /**
   * The main method creates an instance of the
   * PasswordGenerator class, which displays
   * its window on the screen.
   */
   public static void main(String[] args)
   {
      //Create an instance of PasswordGenerator class
      new PasswordGenerator();      
   }
}