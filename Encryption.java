/**
* The Encryption class has two methods, which can encrypt
* and decrypt Strings
*
* @author Ron Landagan
* @version 1.0
* @since 2017-12-12
*/
public class Encryption
{
   /**
   * The encrypt is used to encrypt a String. It turns each 
   * character of a string into its ASCII number and saves
   * them into a String
   * @param input This is the String to be encrypted
   * @return String This is the encrypted String
   */
   public static String encrypt(String input)
   {     
      String newInput="";
      
      //Go through each character of the input
      for (int i=0; i<input.length(); i++)
      {
         String encryptedChar;
         char currentChar = input.charAt(i);
         
         //Turn the current character into a 3-digit number
         int asciiChar = (int)currentChar;
         if(asciiChar<100)
            encryptedChar = "0"+Integer.toString(asciiChar);
         else
            encryptedChar = Integer.toString(asciiChar);
            
         //Save the number into a String
         newInput += encryptedChar;
      }
      //Return the final, encrypted String
      return newInput;
   }
   
   /**
   * The decrypt method decrypts a String. It reads every 3
   * characters of an encrypted String and converts them
   * into a character. Then it saves all the characters as
   * a String and returns it.
   * @param input This is the String to be decrypted
   * @return String This is the decrypted String
   */
   public static String decrypt(String input)
   {
      String newInput="";
      
      //Read every three characters of the input
      for(int i=0; i<input.length();i+=3)
      {
         //Grab a section of three numbers
         String currentAscii = input.substring(i,i+3);
         int almostChar = Integer.parseInt(currentAscii);
         
         //Turn the section into its character equivalent
         String decryptedChar = Character.toString((char)almostChar);  
         
         //Save the decrypted character into a String  
         newInput += decryptedChar;
      }
      
      //Return the finished, decrypted String
      return newInput;
   }
}