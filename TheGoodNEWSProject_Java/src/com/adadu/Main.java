package com.adadu;

import com.adadu.algorithms.*;
import com.adadu.formatter.Formatter;
import com.adadu.implementations.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
 
        
        String originalMessage;
        String option="";
        Scanner sc = new Scanner(System.in);
        
        int count = 3;
        while(count>0){
        System.out.println("Select \n L: for letters \n D: for digits \n");
            option = sc.nextLine().toUpperCase();
        if(option.equals("L") || option.equals("D")){
            if(option.equals("L")){
                System.out.println("You've chosen LETTERS");
            }else{
                System.out.println("You've chosen DIGITS");
            }
            break;
            
        }else{
            System.out.println("Select valid option \n");
            count--;
            if(count==0){
                System.out.println("Exiting ...");
                System.out.println("Exited");
                System.exit(-1);
            }
        }
        }
        
        System.out.println("Enter message");
        originalMessage = sc.nextLine();
        String extractedDigits = extractDigitsFrom(originalMessage);
        String extractedLetters = extractLettersFrom(originalMessage);

        int lettersLen = extractedLetters.length();
        int digitsLen = extractedDigits.length();
        int _Pi = -1;
        
        if(lettersLen%2==1&&option.equals("L")){
            System.out.print("Shannon's indexL: ");
            _Pi = sc.nextInt();
        }else if(digitsLen%2==1&&option.equals("D")){
            System.out.print("Shannon's indexD: ");
            _Pi = sc.nextInt();
        }
        
        North north = new North("","");
        NorthReversed northReversed = new NorthReversed("","");
        East east = new East("","");
        EastReversed eastReversed = new EastReversed("","");
        West west = new West("","");
        WestReversed westReversed = new WestReversed("","");
        South south = new South("","");
        SouthReversed southReversed = new SouthReversed("","");
        
        
        if(option.equals("L")){
        // declaring object variable for the algorithms
         north = new North(extractedLetters,originalMessage);
            northReversed = new NorthReversed(extractedLetters,originalMessage);
         east = new East(extractedLetters,originalMessage);
         eastReversed = new EastReversed(extractedLetters,originalMessage);
         west = new West(extractedLetters,originalMessage);
         westReversed = new WestReversed(extractedLetters,originalMessage);
         south = new South(extractedLetters,originalMessage);
         southReversed = new SouthReversed(extractedLetters,originalMessage);
        
        }else if(option.equals("D")){
            north = new North(extractedDigits,originalMessage);
          northReversed = new NorthReversed(extractedDigits,originalMessage);
         east = new East(extractedDigits,originalMessage);
         eastReversed = new EastReversed(extractedDigits,originalMessage);
         west = new West(extractedDigits,originalMessage);
         westReversed = new WestReversed(extractedDigits,originalMessage);
         south = new South(extractedDigits,originalMessage);
         southReversed = new SouthReversed(extractedDigits,originalMessage);
        
        }
        
        InWard inWard = new InWard("","",-1);
        OutWard outWard = new OutWard("","",-1);

        RightWard rightWard = new RightWard("","",-1);
        RightWardReversed rightWardReversed = new RightWardReversed("","",-1);

        LeftWard leftWard = new LeftWard("","",-1);
        LeftWardReversed leftWardReversed = new LeftWardReversed("","",-1);

         
        if(option.equals("L")){
            // object variable for the six different implementations
         inWard = new InWard(extractedLetters,originalMessage, _Pi);
         outWard = new OutWard(extractedLetters,originalMessage, _Pi);

         rightWard = new RightWard(extractedLetters,originalMessage, _Pi);
         rightWardReversed = new RightWardReversed(extractedLetters,originalMessage, _Pi);

         leftWard = new LeftWard(extractedLetters,originalMessage, _Pi);
         leftWardReversed = new LeftWardReversed(extractedLetters,originalMessage, _Pi);

        }else if(option.equals("D")){
            // object variable for the six different implementations
         inWard = new InWard(extractedDigits,originalMessage, _Pi);
         outWard = new OutWard(extractedDigits,originalMessage, _Pi);

         rightWard = new RightWard(extractedDigits,originalMessage, _Pi);
         rightWardReversed = new RightWardReversed(extractedDigits,originalMessage, _Pi);

         leftWard = new LeftWard(extractedDigits,originalMessage, _Pi);
         leftWardReversed = new LeftWardReversed(extractedDigits,originalMessage, _Pi);

        }
        
        Formatter formatter = new Formatter(originalMessage);

        System.out.println("Select option:\n 1.Algorithm(Function) \n 2.Implementation \n 3.Simple Encryption");

        int myNum = sc.nextInt();
        if (myNum == 1) {
            System.out.println("you have chosen Algorithm(Function)");
            System.out.println(
                    "Select option:\n 1.North function \n 2.East function \n 3.West function \n 4.South function \n 5.InNorth function \n 6.InEast function" +
                            "\n 7.InWest function \n 8.InSouth function");
            int chooseNEWS = sc.nextInt();
            if (chooseNEWS == 1) {// North function
                System.out.println("you have chosen North Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits \n 6.printCollisions");
                int N_method = sc.nextInt();
                if (N_method == 1) {
                    System.out.println(north.getFirstOrbit(_Pi));
                } else if (N_method == 2) {
                    System.out.println(north.getLastOrbit(_Pi));
                } else if (N_method == 3) {
                    System.out.print("select index: ");
                    int N_index1 = sc.nextInt();
                    System.out.println(north.getOrbitAt(N_index1,_Pi));
                } else if (N_method == 4) {
                    System.out.print("select range: ");
                    int N_index2 = sc.nextInt();
                    north.printOrbitsInRange(N_index2,_Pi);
                } else if (N_method == 5) {
                    north.printAllOrbits(_Pi);
                } else if (N_method == 6) {
                    north.printCollisions(-1);
                }
                System.exit(11);
            }
            else if (chooseNEWS == 2) {// East function
                System.out.println("you have chosen East Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits \n 6.printCollisions");
                int E_method = sc.nextInt();
                if (E_method == 1) {
                    System.out.println(east.getFirstOrbit(_Pi));
                } else if (E_method == 2) {
                    System.out.println(east.getLastOrbit(_Pi));
                } else if (E_method == 3) {
                    System.out.print("select index: ");
                    int E_index1 = sc.nextInt();
                    System.out.println(east.getOrbitAt(E_index1,_Pi));
                } else if (E_method == 4) {
                    System.out.print("select range: ");
                    int E_index2 = sc.nextInt();
                    east.printOrbitsInRange(E_index2,_Pi);
                } else if (E_method == 5) {
                    east.printAllOrbits(_Pi);
                } else if (E_method == 6) {
                    east.printCollisions(-1);
                }
                System.exit(22);
            }
            else if (chooseNEWS == 3) {// West function
                System.out.println("you have chosen West Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits \n 6.printCollisions");
                int W_method = sc.nextInt();
                if (W_method == 1) {
                    System.out.println(west.getFirstOrbit(_Pi));
                } else if (W_method == 2) {
                    System.out.println(west.getLastOrbit(_Pi));
                } else if (W_method == 3) {
                    System.out.print("select index: ");
                    int W_index1 = sc.nextInt();
                    System.out.println(west.getOrbitAt(W_index1,_Pi));
                } else if (W_method == 4) {
                    System.out.print("select range: ");
                    int W_index2 = sc.nextInt();
                    west.printOrbitsInRange(W_index2,_Pi);
                } else if (W_method == 5) {
                    west.printAllOrbits(_Pi);
                } else if (W_method == 6) {
                    west.printCollisions(-1);
                }
                System.exit(33);
            }
            else if (chooseNEWS == 4) {// South function
                System.out.println("you have chosen South Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits \n 6.printCollisions");
                int S_method = sc.nextInt();
                if (S_method == 1) {
                    System.out.println(south.getFirstOrbit(_Pi));
                } else if (S_method == 2) {
                    System.out.println(south.getLastOrbit(_Pi));
                } else if (S_method == 3) {
                    System.out.print("select index: ");
                    int S_index1 = sc.nextInt();
                    System.out.println(south.getOrbitAt(S_index1,_Pi));
                } else if (S_method == 4) {
                    System.out.print("select range: ");
                    int S_index2 = sc.nextInt();
                    south.printOrbitsInRange(S_index2,_Pi);
                } else if (S_method == 5) {
                    south.printAllOrbits(_Pi);
                } else if (S_method == 6) {
                    south.printCollisions(-1);
                }
                System.exit(44);
            }else if(chooseNEWS == 5){
                System.out.println("you have chosen InNorth Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int IN_method = sc.nextInt();
                if (IN_method == 1) {
                    System.out.println(northReversed.getFirstOrbit(_Pi));
                } else if (IN_method == 2) {
                    System.out.println(northReversed.getLastOrbit(_Pi));
                } else if (IN_method == 3) {
                    System.out.print("select index: ");
                    int IN_index1 = sc.nextInt();
                    System.out.println(northReversed.getOrbitAt(IN_index1,_Pi));
                } else if (IN_method == 4) {
                    System.out.print("select range: ");
                    int IN_index2 = sc.nextInt();
                    northReversed.printOrbitsInRange(IN_index2,_Pi);
                } else if (IN_method == 5) {
                    northReversed.printAllOrbits(_Pi);
                }
                System.exit(55);
            }else if(chooseNEWS == 6){
                System.out.println("you have chosen InEast Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int IE_method = sc.nextInt();
                if (IE_method == 1) {
                    System.out.println(eastReversed.getFirstOrbit(_Pi));
                } else if (IE_method == 2) {
                    System.out.println(eastReversed.getLastOrbit(_Pi));
                } else if (IE_method == 3) {
                    System.out.print("select index: ");
                    int IE_index1 = sc.nextInt();
                    System.out.println(eastReversed.getOrbitAt(IE_index1,_Pi));
                } else if (IE_method == 4) {
                    System.out.print("select range: ");
                    int IE_index2 = sc.nextInt();
                    eastReversed.printOrbitsInRange(IE_index2,_Pi);
                } else if (IE_method == 5) {
                    eastReversed.printAllOrbits(_Pi);
                }
                System.exit(66);
            }else if(chooseNEWS == 7){
                System.out.println("you have chosen InWest Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int IW_method = sc.nextInt();
                if (IW_method == 1) {
                    System.out.println(westReversed.getFirstOrbit(_Pi));
                } else if (IW_method == 2) {
                    System.out.println(westReversed.getLastOrbit(_Pi));
                } else if (IW_method == 3) {
                    System.out.print("select index: ");
                    int IW_index1 = sc.nextInt();
                    System.out.println(westReversed.getOrbitAt(IW_index1,_Pi));
                } else if (IW_method == 4) {
                    System.out.print("select range: ");
                    int IW_index2 = sc.nextInt();
                    westReversed.printOrbitsInRange(IW_index2,_Pi);
                } else if (IW_method == 5) {
                    westReversed.printAllOrbits(_Pi);
                }
                System.exit(77);
            }else if(chooseNEWS == 8){
                System.out.println("you have chosen InSouth Function");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int IS_method = sc.nextInt();
                if (IS_method == 1) {
                    System.out.println(southReversed.getFirstOrbit(_Pi));
                } else if (IS_method == 2) {
                    System.out.println(southReversed.getLastOrbit(_Pi));
                } else if (IS_method == 3) {
                    System.out.print("select index: ");
                    int IS_index1 = sc.nextInt();
                    System.out.println(southReversed.getOrbitAt(IS_index1,_Pi));
                } else if (IS_method == 4) {
                    System.out.print("select range: ");
                    int IS_index2 = sc.nextInt();
                    southReversed.printOrbitsInRange(IS_index2,_Pi);
                } else if (IS_method == 5) {
                    southReversed.printAllOrbits(_Pi);
                }
                System.exit(88);
            }
            else {
                System.out.println("option does not exists");
                System.exit(55);
            }

        } else if (myNum == 2) { // implementation
            System.out.println("you have chosen Implementation");
            System.out.println(
                    "Select option:\n 1.InWard \n 2.OutWard \n 3.RightWard \n 4.RightWardReversed \n 5.LeftWard \n 6.LeftWardReversed");
            int implementNEWS = sc.nextInt();
            String diffType;
            if (implementNEWS == 1) {// InWard
                System.out.println("you have chosen InWard Implementation");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int i_method = sc.nextInt();
                if (i_method == 1) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(inWard.getFirstOrbit(diffType));
                } else if (i_method == 2) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(inWard.getLastOrbit(diffType));
                } else if (i_method == 3) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select index: ");
                    int i_index1 = sc.nextInt();
                    System.out.println(inWard.getOrbitAt(i_index1, diffType));
                } else if (i_method == 4) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select range: ");
                    int i_index2 = sc.nextInt();
                    inWard.printOrbitsInRange(i_index2, diffType);
                } else if (i_method == 5) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    inWard.printAllOrbits(diffType);
                }

            } else if (implementNEWS == 2) {// OutWard
                System.out.println("you have chosen outWard Implementation");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int o_method = sc.nextInt();
                if (o_method == 1) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(outWard.getFirstOrbit(diffType));
                } else if (o_method == 2) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(outWard.getLastOrbit(diffType));
                } else if (o_method == 3) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select index: ");
                    int o_index1 = sc.nextInt();
                    System.out.println(outWard.getOrbitAt(o_index1, diffType));
                } else if (o_method == 4) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select range: ");
                    int o_index2 = sc.nextInt();
                    outWard.printOrbitsInRange(o_index2, diffType);
                } else if (o_method == 5) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    outWard.printAllOrbits(diffType);
                }

            } else if (implementNEWS == 3) {// RightWard
                System.out.println("you have chosen RightWard Implementation");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int r_method = sc.nextInt();
                if (r_method == 1) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(rightWard.getFirstOrbit(diffType));
                } else if (r_method == 2) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(rightWard.getLastOrbit(diffType));
                } else if (r_method == 3) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select index: ");
                    int r_index1 = sc.nextInt();
                    System.out.println(rightWard.getOrbitAt(r_index1, diffType));
                } else if (r_method == 4) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select range: ");
                    int r_index2 = sc.nextInt();
                    rightWard.printOrbitsInRange(r_index2, diffType);
                } else if (r_method == 5) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    rightWard.printAllOrbits(diffType);
                }

            } else if (implementNEWS == 4) {// RightWardReversed
                System.out.println("you have chosen RightWardReversed Implementation");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int rr_method = sc.nextInt();
                if (rr_method == 1) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(rightWardReversed.getFirstOrbit(diffType));
                } else if (rr_method == 2) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(rightWardReversed.getLastOrbit(diffType));
                } else if (rr_method == 3) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select index: ");
                    int rr_index1 = sc.nextInt();
                    System.out.println(rightWardReversed.getOrbitAt(rr_index1, diffType));
                } else if (rr_method == 4) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select range: ");
                    int rr_index2 = sc.nextInt();
                    rightWardReversed.printOrbitsInRange(rr_index2, diffType);
                } else if (rr_method == 5) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    rightWardReversed.printAllOrbits(diffType);
                }

            } else if (implementNEWS == 5) {// LeftWard
                System.out.println("you have chosen LeftWard Implementation");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int l_method = sc.nextInt();
                if (l_method == 1) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(leftWard.getFirstOrbit(diffType));
                } else if (l_method == 2) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(leftWard.getLastOrbit(diffType));
                } else if (l_method == 3) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select index: ");
                    int l_index1 = sc.nextInt();
                    System.out.println(leftWard.getOrbitAt(l_index1, diffType));
                } else if (l_method == 4) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select range: ");
                    int l_index2 = sc.nextInt();
                    leftWard.printOrbitsInRange(l_index2, diffType);
                } else if (l_method == 5) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    leftWard.printAllOrbits(diffType);
                }

            } else if (implementNEWS == 6) {// LeftWardReversed
                System.out.println("you have chosen LeftWardReversed Implementation");
                System.out.println(
                        "Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsInRange \n 5.printAllOrbits");
                int lr_method = sc.nextInt();
                if (lr_method == 1) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(leftWardReversed.getFirstOrbit(diffType));
                } else if (lr_method == 2) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.println(leftWardReversed.getLastOrbit(diffType));
                } else if (lr_method == 3) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select index: ");
                    int lr_index1 = sc.nextInt();
                    System.out.println(leftWardReversed.getOrbitAt(lr_index1, diffType));
                } else if (lr_method == 4) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    System.out.print("select range: ");
                    int lr_index2 = sc.nextInt();
                    leftWardReversed.printOrbitsInRange(lr_index2, diffType);
                } else if (lr_method == 5) {
                    System.out.print("Select function: ");
                    diffType = sc.next().toUpperCase();
                    leftWardReversed.printAllOrbits(diffType);
                }

            } else {
                System.out.println("option does not exists");
            }

        } else if (myNum == 3) {
            System.out.println("you have chosen Simple Encryption");

            System.exit(874);
        } else {
            System.out.println("option does not exist");
        }
        
    }// main method
    
   public static String extractLettersFrom(String text) {

      String extractedLetters = "";
      text = text.toUpperCase();

      for (int i = 0; i < text.length(); i++) {

        if (Character.isLetter(text.charAt(i))) {
          extractedLetters = extractedLetters + text.charAt(i);
        } else {
          continue;
        }
      }

      return extractedLetters;
    }
    
    public static String extractDigitsFrom(String text) {

      String extractedDigits = "";

      for (int i = 0; i < text.length(); i++) {

        if (Character.isDigit(text.charAt(i))) {
          extractedDigits = extractedDigits + text.charAt(i);
        } else {
          continue;
        }
      }

      return extractedDigits;
    }
    
/*
    public static boolean isLetter(char myChar) {
       myChar = myChar.toUpperCase();
      boolean result = false;
      if ((int)myChar >= 65 && (int)myChar <= 91) {

        result = true;
      }
      return result;
    }
*/
    // method to encrypt diffused text
    public static String encrypt(String diffusedText, String newMyKey) {

        int newLen = diffusedText.length();
        char[] NewEncryptedMessage = new char[newLen];
        for (int i = 0; i < newLen; i++) {
            NewEncryptedMessage[i] = (char) (((((int) diffusedText.charAt(i) + (int) newMyKey.charAt(i)) % 26 + 26)
                    % 26) + 65);
        }
        return String.valueOf(NewEncryptedMessage);
    }// method encrypt
     // method to decrypt diffused text

    public static String decrypt(String newEncryptedMessage, String newMyKey) {

        int oldLen = newEncryptedMessage.length();
        char[] decryptedMessage = new char[oldLen];

        for (int i = 0; i < oldLen; i++) {
            decryptedMessage[i] = (char) (((((int) newEncryptedMessage.charAt(i) - (int) newMyKey.charAt(i)) % 26 + 26)
                    % 26) + 65);
        }
        return String.valueOf(decryptedMessage);
    }// method decrypt

}
