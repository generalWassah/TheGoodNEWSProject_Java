package com.adadu.algorithms;
import com.adadu.formatter.Formatter;
public class South {
    // The South function is an iterated function based on specific solution of homogenous linear Diophantine equation
    /**
     * This class represents one of the four algorithms(functions) which we will call 'South' with following implementation.
     * Given the following homogenous linear Diophantine equation A1*X1 + A2*X2 + ... + Ai-1*Xi-1 + Ai*Xi = 0.
     * where, all Ai's and Xi's represents the coefficients and variables respectively. The solution according to the South function
     * is as follows.
     * Xk+1 = -Xk + Ak - Ak+1, k = 0,1,2,...,n-1
     * This solution is possible because 0 which is the constant in the equation above is always divisible by the greatest common
     * divisor of any given set of integers.
     * In order to ensure consistency of the function, there is need to define the term A0*X0 which are inputs to the function
     * where  X0 = -A1+A2-A3+...-An-1+An,
     * A0 = 0.
     * The South function has an inverse function called the North function. In order to recover all Ai's from all Xi's, all the Xi's
     * is fed into the North function as input.
     * The four algorithms(functions) are collectively referred as NEWS functions. Where the word 'NEWS' is derived from the initials
     * of the function names.
     * Note: inverse exists only when n%2 = 0. i.e the input is even
     */

    // get the first orbit of the iterated sequence
        String text;
    String initText;
    String originalMessage;
    int modulo;
    int strtIndex;
    Formatter formatter;
     public South(String extractedText,String originalMessage){
         this.originalMessage=originalMessage;
       this.text=extractedText.toUpperCase();
       this.initText=this.text;
       
       formatter = new Formatter(this.originalMessage);
     }

    private int getSouthSum(){
        
        if(Character.isLetter(this.initText.charAt(0))){
            
          this.modulo = 26;
          this.strtIndex = 65;
            
        }else if(Character.isDigit(this.initText.charAt(0))){
          
          this.modulo = 10;
          this.strtIndex = 48;
          
         }
        
        int len = this.initText.length();
      int msgTsum = 0;
      int msgPsum = 0, msgNsum = 0;
        for(int i = 0; i<len;i++) {
        if (i % 2 == 0) {
            msgPsum = ((msgPsum + ((int) this.initText.charAt(i) - this.strtIndex)) % this.modulo + this.modulo) % this.modulo;
        } else {
            msgNsum = ((msgNsum - (int) this.initText.charAt(i) - this.strtIndex) % this.modulo + this.modulo) % this.modulo;
        }
        }
          msgTsum =(msgPsum +msgNsum)%this.modulo;
           return msgTsum;
     }
     public String getSouthDiffusion(int dIndex){

            String diffusedText;
            int len = this.initText.length();
            int msgTsum = getSouthSum();
            char[] dChar = new char[len];
            int a1 = 0, x1 = msgTsum;
            int a2, x2;
            for (int j = 0; j < len; j++) {
                x2 = (int) this.initText.charAt(j) - this.strtIndex;
                a2 = ((-x2 + x1 - a1 ) % this.modulo + this.modulo) % this.modulo;
                dChar[j] = (char) ( (a2) + this.strtIndex);
                a1 = a2;
                x1 = x2;
        }//for j
            if ((dIndex > -1) && (dIndex < this.initText.length()) && (this.initText.length() % 2 == 1)) {
                dChar[dIndex] = (char)(msgTsum + this.strtIndex);
            }
        diffusedText = String.valueOf(dChar);
        return diffusedText;
    }// getSouthDiffusion

    public String getFirstOrbit(int dIndex){
        this.initText=this.text;
        return formatter.format(this.getSouthDiffusion(dIndex));
    }
    public String getLastOrbit(int dIndex){
        this.initText=this.text;
        String lastOrbit = "";
        if(this.initText.length()%2==0) {
            North north = new North(this.initText,null);
            lastOrbit = north.getFirstOrbit(dIndex);
        }else{
            SouthReversed southReversed = new SouthReversed(this.initText,null);
            lastOrbit = southReversed.getFirstOrbit(dIndex);
        }

        return formatter.format(lastOrbit);
    }
    public String getOrbitAt(int noOfIters, int dIndex) {
        this.initText = this.text;
        String orbitAt = "";
        int i = 1;
        while (true) {
            orbitAt = this.getSouthDiffusion(dIndex);
            if (i == noOfIters || orbitAt.equals(this.text)) {
                return formatter.format(orbitAt);
            }
            this.initText = orbitAt;
            i++;
        }//while
    }// orbitAt
    public void printOrbitsInRange(int range, int dIndex) {
        this.initText = this.text;
        String orbitsInRange = "";
        int i = 1;
        while (range > 0) {
            orbitsInRange = this.getSouthDiffusion(dIndex);
            System.out.println(i++ +" "+formatter.format(orbitsInRange));
            if (orbitsInRange.equals(this.text)) {
                break;
            }
            this.initText = orbitsInRange;
            range--;

        }
    }// printOrbitsInRange
    public void printAllOrbits(int dIndex) {
        this.initText = this.text;
        String firstOrbit = "";

        firstOrbit = this.getSouthDiffusion(dIndex);

        System.out.println(1+" "+formatter.format(firstOrbit));
        this.initText = firstOrbit;
        String orbitGen = "";
        int t = 2;
        while (true) {
            orbitGen = this.getSouthDiffusion(dIndex);
            if (firstOrbit.equals(orbitGen)) {
                break;
            }
            System.out.println((t++)+" "+formatter.format(orbitGen));
            this.initText = orbitGen;
        }
    }// print all orbit
    public void printCollisions(int dIndex) {
        this.initText = this.text;
        String firstOrbit = this.getSouthDiffusion(dIndex);
        int strLen = firstOrbit.length();
        if (strLen % 2 == 1) {
            String[] collisions = new String[this.modulo];
            char[] textChars = new char[strLen];
            int sz = this.modulo-1;
            while (sz > -1) {
                int a1 = 0, x1 = sz;
                int a2 = 0, x2 = 0;

                for (int j = 0; j < strLen; j++) {
                    x2 = (int)firstOrbit.charAt(j)-this.strtIndex;;
                    a2 = ((-x2 - x1 + a1) % this.modulo + this.modulo) % this.modulo;
                    textChars[j] = (char)(a2+this.strtIndex);
                    a1 = a2;
                    x1 = x2;
                } //  loop
                collisions[sz] = formatter.format(String.valueOf(textChars));
                if (sz == 0) {
                    break;
                }
                sz--;
            }// while loop
            for (int i = 0; i < this.modulo; i++) {
                System.out.println((i+1)+" "+collisions[i]+" "+i);
            }
        } else {

            System.out.println("The length of the text is even and therefore has no collisions");

        }
    }// print collisions

    /*
   //print all orbits in such a way so as to recover odd input
    public void recoverOddInput(String newText){
        if(newText.length()%2!=0){
            System.out.println("Even length of character expected");
       System.exit(99);
        }
        char rec = (char)((this.modulo-msgTsum)+this.strtIndex);
        printAllOrbits(newText+rec);
    }

*/
}//class
