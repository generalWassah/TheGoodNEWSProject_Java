package com.adadu.formatter;

public class Formatter {
String originalText;
    public Formatter(String originalText) {

        this.originalText = originalText;
    }
    
    // formatted diffusion
   public String format(String textToFormat) {
       
       char[] myFormatArray = new char[this.originalText.length()];

           int letterCount = 0;
           int digitCount = 0;
           for (int i = 0; i < this.originalText.length(); i++) {
               if(Character.isLetter(this.originalText.charAt(i))){
                   if(Character.isLetter(this.originalText.charAt(i))){
                          if (Character.isUpperCase(this.originalText.charAt(i))) {
                            myFormatArray[i] = Character.toUpperCase(textToFormat.charAt(letterCount));

                             letterCount++;
                          } else {
                              myFormatArray[i] = Character.toLowerCase(textToFormat.charAt(letterCount));

                              letterCount++;
                             }
                          
                     }
               }else if(Character.isDigit(this.originalText.charAt(i))){
                   
                        myFormatArray[i] = textToFormat.charAt(digitCount);

                         digitCount++;
               
               }else{
                   myFormatArray[i] = this.originalText.charAt(i);
               }
          
           }// for loop
               
           
       return String.valueOf(myFormatArray);
   }
    
    }// format()

