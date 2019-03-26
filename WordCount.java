/*
Project 5 by Numaan Cheema
COS 210 - Professor Gao
*/

import java.util.*;
import java.io.*;

public class WordCount 
{
   public static void main (String[] args) 
   {
      //Scanner object created to scan the file saved inside project folder 
      Scanner console = new Scanner(System.in);
      String fileName = "wordfile1.txt";
      
      //try being used to parse through the file
      try
      {
         Scanner input = new Scanner(new FileReader(fileName));
         countWords(input);  
      }//end try
      
      //if the file is not found, the File not found error is given using catch
      catch (FileNotFoundException ex)
      {
         System.out.println("File not found");
      }
  }//end main

   //countWords method uses a Tree to take the words expressed in the file 
   //    and compared them to see how many there are
   public static void countWords(Scanner scan)
   {
   Map<String, Integer> words = new TreeMap<String, Integer>();
   String word, lowercase;
   while (scan.hasNextLine())
      {
     
     //this ensures that the even if the words are in lower case, it works 
      while ((word=scan.findInLine("[\\p{L}\\p{N}']+")) !=null)
         {
            lowercase = word.toLowerCase();
            if(words.get(lowercase)!=null)
            {
               words.put(lowercase, words.get(lowercase)+1);
            }
            else words.put(lowercase, 1);
            
         }//end nestedwhile
      scan.nextLine();   
      }//end while
    
    //once the document finishes, the resutls get displayed   
    displayResults(words);
    
   }//end countWords
   
   //displayresults is to call all the words being counted (ones in paranthesis)
   //   and displays them showing how many times theyre found
   public static void displayResults(Map<String, Integer> words)
   {
      for (Map.Entry<String, Integer> entry : words.entrySet())
      {
         System.out.print(entry.getKey() + ": ");
         System.out.println(entry.getValue());
      }//end for
   }//end display results 
}//end WordCount