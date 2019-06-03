import java.util.Random;   //For random number generation
import java.io.*;          //To open and close files
import java.util.Scanner;  //To read files
import java.util.ArrayList;

/**
* The Dictionary program contains a library of simple, English
* words and has several methods to create and save passwords
* using words from the library.
*
* @author Ron Landagan
* @version 1.0
* @since 2017-12-12
*/
public class Dictionary
{
   //A collection of simple, English words
   private static String[] dictionary = {"Account", "Act", "Addition", "Adjustment", 
      "Advertisement", "Agreement", "Air", "Amount", "Amusement", 
      "Animal", "Answer", "Apparatus", "Approval", "Argument", "Art", 
      "Attack", "Attempt", "Attention", "Attraction", "Authority", "Back", 
      "Balance", "Base", "Behaviour", "Belief", "Birth", "Bit", "Bite", 
      "Blood", "Blow", "Body", "Brass", "Bread", "Breath", "Brother", 
      "Building", "Burn", "Burst", "Business", "Butter", "Canvas", "Care", 
      "Cause", "Chalk", "Chance", "Change", "Cloth", "Coal", "Color", 
      "Comfort", "Committee", "Company", "Comparison", "Competition", 
      "Condition", "Connection", "Control", "Cook", "Copper", "Copy", 
      "Cork", "Cotton", "Cough", "Country", "Cover", "Crack", "Credit", 
      "Crime", "Crush", "Cry", "Current", "Curve", "Damage", "Danger", 
      "Daughter", "Day", "Death", "Debt", "Decision", "Degree", "Design", 
      "Desire", "Destruction", "Detail", "Development", "Digestion", 
      "Direction", "Discovery", "Discussion", "Disease", "Disgust", 
      "Distance", "Distribution", "Division", "Doubt", "Drink", "Driving", 
      "Dust", "Earth", "Edge", "Education", "Effect", "End", "Error", 
      "Event", "Example", "Exchange", "Existence", "Expansion", "Experience", 
      "Expert", "Fact", "Fall", "Family", "Father", "Fear", "Feeling", 
      "Fiction", "Field", "Fight", "Fire", "Flame", "Flight", "Flower", 
      "Fold", "Food", "Force", "Form", "Friend", "Front", "Fruit", "Glass", 
      "Gold", "Government", "Grain", "Grass", "Grip", "Group", "Growth", 
      "Guide", "Harbour", "Harmony", "Hate", "Hearing", "Heat", "Help", 
      "History", "Hole", "Hope", "Hour", "Humour", "Ice", "Idea", "Impulse", 
      "Increase", "Industry", "Ink", "Insect", "Instrument", "Insurance", 
      "Interest", "Invention", "Iron", "Jelly", "Join", "Journey", "Judge", 
      "Jump", "Kick", "Kiss", "Knowledge", "Land", "Language", "Laugh", 
      "Law", "Lead", "Learning", "Leather", "Letter", "Level", "Lift", 
      "Light", "Limit", "Linen", "Liquid", "List", "Look", "Loss", "Love", 
      "Machine", "Man", "Manager", "Mark", "Market", "Mass", "Meal", 
      "Measure", "Meat", "Meeting", "Memory", "Metal", "Middle", "Milk", 
      "Mind", "Mine", "Minute", "Mist", "Money", "Month", "Morning", 
      "Mother", "Motion", "Mountain", "Move", "Music", "Name", "Nation", 
      "Need", "News", "Night", "Noise", "Note", "Number", "Observation", 
      "Offer", "Oil", "Operation", "Opinion", "Order", "Organization", 
      "Ornament", "Owner", "Page", "Pain", "Paint", "Paper", "Part", 
      "Paste", "Payment", "Peace", "Person", "Place", "Plant", "Play", 
      "Pleasure", "Point", "Poison", "Polish", "Porter", "Position", 
      "Powder", "Power", "Price", "Print", "Process", "Produce", "Profit", 
      "Property", "Prose", "Protest", "Pull", "Punishment", "Purpose", 
      "Push", "Quality", "Question", "Rain", "Range", "Rate", "Ray", 
      "Reaction", "Reading", "Reason", "Record", "Regret", "Relation", 
      "Religion", "Representative", "Request", "Respect", "Rest", 
      "Reward", "Rhythm", "Rice", "River", "Road", "Roll", "Room", "Rub", 
      "Rule", "Run", "Salt", "Sand", "Scale", "Science", "Sea", "Seat", 
      "Secretary", "Selection", "Self", "Sense", "Servant", "Shade", 
      "Shake", "Shame", "Shock", "Side", "Sign", "Silk", "Silver", "Sister", 
      "Size", "Sky", "Sleep", "Slip", "Slope", "Smash", "Smell", "Smile", 
      "Smoke", "Sneeze", "Snow", "Soap", "Society", "Son", "Song", "Sort", 
      "Sound", "Soup", "Space", "Stage", "Start", "Statement", "Steam", 
      "Steel", "Step", "Stitch", "Stone", "Stop", "Story", "Stretch", 
      "Structure", "Substance", "Sugar", "Suggestion", "Summer", "Support", 
      "Surprise", "Swim", "System", "Talk", "Taste", "Tax", "Teaching", 
      "Tendency", "Test", "Theory", "Thing", "Thought", "Thunder", "Time", 
      "Tin", "Top", "Touch", "Trade", "Transport", "Trick", "Trouble", 
      "Turn", "Twist", "Unit", "Use", "Value", "Verse", "Vessel", "View", 
      "Voice", "Walk", "War", "Wash", "Waste", "Water", "Wave", "Wax", 
      "Way", "Weather", "Week", "Weight", "Wind", "Wine", "Winter", "Woman", 
      "Wood", "Wool", "Word", "Work", "Wound", "Writing", "Year"};
   
   /**
   * The randomWord method returns a randomly selected word
   * from the dictionary array 
   * @return String This is a randomly selected word
   */ 
   public static String randomWord()
   {
      Random rand = new Random();
      int randomInt = rand.nextInt(dictionary.length);
      return dictionary[randomInt];
   }
   
   /**
   * The generatePassword method creates a password from four
   * randomly selected words
   * @return String This is the final generated password
   */
   public static String generatePassword()
   {
      String password = randomWord() + randomWord() + randomWord() + randomWord();
      return password;
   }
   
   /**
   * The savePassword method encrypts and saves a password onto
   * a text file called "Passwords.txt"
   * @param pass This is the password to be saved
   */
   public static void savePassword(String pass, Boolean password) throws IOException
   {
      //Open or create the "Passwords.txt" file
      PrintWriter outputFile;
      File file = new File("Passwords.txt");
      if (!file.exists())
      {
         outputFile = new PrintWriter("Passwords.txt");
      }
      else
      { 
         FileWriter fw = new FileWriter("Passwords.txt", true);
         outputFile = new PrintWriter(fw);
      }
      
      //Encrypt the password
      String encryptedPassword = Encryption.encrypt(pass);
      
      //Save the encrypted password in "Passwords.txt"
      if (password==true)
         outputFile.println(encryptedPassword+"\n");
      else
         outputFile.println(encryptedPassword);
      outputFile.close();   
   }
   
   /**
   * The getPasswords method decrypts and displays the saved
   * passwords found in the "Passwords.txt" file.
   * @return String This is a String containing all of the 
   *                saved, decrypted passwords 
   */
   public static String[] getPasswords() throws IOException
   {
      String totalPasswords = "Your saved passwords are: \n\n";
      ArrayList<String> passwordList = new ArrayList<String>();
      
      //Open the "Passwords.txt" file
      File file = new File("Passwords.txt");
      Scanner inputFile = new Scanner(file);
      
      //Read and decrypt all of the passwords and save as 
      //one string
      while(inputFile.hasNext())
      {
         passwordList.add(Encryption.decrypt(inputFile.nextLine()));
      }
      
      //Return the finished String
      return passwordList.toArray(new String[0]);
   }
}
         
         