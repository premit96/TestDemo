import java.util.Scanner;
public class CountLetters
{
   public static void main(String[] args)
   {
       int[] counts = new int[26];
       Scanner scan = new Scanner(System.in);

       //get word from user
       System.out.print("Enter a single word (letters only, please): ");
       String word = scan.nextLine();

       //convert to all upper case
       word = word.toUpperCase();

       //count frequency of each letter in string
       for (int i=0; i < word.length(); i++)
       {
           if(word.charAt(i)>='A' && word.charAt(i)<='Z')
           {
               counts[word.charAt(i)-'A']++;
           }
           else
           {
               System.out.println("The character "+word.charAt(i)+" is not a letter.");
               System.out.println("Please enter only letters next time. See you!");
               return;
           }
       }

       //print frequencies
       System.out.println();
       for (int i=0; i < counts.length; i++)
           if (counts [i] != 0)
               System.out.println((char)(i +'A') + ": " + counts[i]);
   }

}