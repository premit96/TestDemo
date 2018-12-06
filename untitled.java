import java.util.*;

public class untitled
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int [] key = new int[50];
      int quest, i, correct, ans;
      char again;
      System.out.println("How many questions on the quiz? ");
      quest = in.nextInt();
      System.out.print("Enter the answer key ");
      for(i = 0; i < quest; i++)
         key[i] = in.nextInt();
      do 
      {
         correct = 0;
      System.out.print("Enter the students answers: ");
      for(i = 0; i < quest; i++)
      {
         ans = in.nextInt();
         if(ans == key[i])
            correct++;
      }
      
      System.out.println("You got " +correct+" questions right");
      System.out.println("Your grade is" +(double)correct/quest*100.+"%");
      System.out.println("grade another quiz?(y/n)");
      again = in.next().charAt(0);
      }
       while(again == 'y');
       
      }
      }
            