package com.adadu.algorithms;
import com.adadu.formatter.Formatter;
public class WestReversed {
    String text;
    String initText;
    String originalMessage;
    int modulo;
    int strtIndex;
    Formatter formatter;
    
    public WestReversed(String extractedText,String originalMessage){
        this.originalMessage = originalMessage;
        this.text=extractedText;
        this.initText=this.text;
        formatter = new Formatter(this.originalMessage);
    }

    private int getWestReversedSum(int dIndex) {
        if(this.initText.length()%2!=1){
            System.out.println("odd string length expected");
            System.exit(1);
        }
        
        if(Character.isLetter(this.initText.charAt(0))){
            
          this.modulo = 26;
          this.strtIndex = 65;
            
      }else if(Character.isDigit(this.initText.charAt(0))){
          
        this.modulo = 10;
        this.strtIndex = 48;
          
      }
        
        int textNsum = 0;
        int aski = 0;
        for (int i = 0; i < this.initText.length(); i++) {
            if (i != dIndex) {
                aski = (int) this.initText.charAt(i) - this.strtIndex;
                textNsum = ((textNsum - aski) % this.modulo + this.modulo) % this.modulo;
            } else {
                continue;
            } // else

        }// for loop
        return textNsum;
    }
    public String getWestReversedDiffusion(int dIndex){

        if(this.initText.length()%2!=1){
            System.out.println("odd string length expected");
            System.exit(1);
        }

            int textNsum = getWestReversedSum(dIndex);
            char discardedChar = (char)(textNsum + this.strtIndex);
            char[] dChar = this.initText.toCharArray();
            dChar[dIndex] = discardedChar;
            char[] newArray = new char[dChar.length];
            int a1 = 0, x1 = (int)this.initText.charAt(dIndex) - this.strtIndex;
            int a2 = 0, x2 = 0;
            for (int j = 0; j < dChar.length; j++) {
                a2 =(int)dChar[j] - this.strtIndex;
                x2 = ((a2 + x1 + a1) % this.modulo + this.modulo) % this.modulo;
                newArray[j] = (char)(x2 + this.strtIndex);
                a1 = a2;
                x1 = x2;
            } // for loop
        String inWestDiffusedText = String.valueOf(newArray);
            return inWestDiffusedText;
        }// getInWestDiffusion
    public String getFirstOrbit(int dIndex) {
        this.initText = this.text;
        return formatter.format(this.getWestReversedDiffusion(dIndex));
    }// first orbit
    public String getLastOrbit(int dIndex){
        this.initText = this.text;
        West west = new West(this.initText,null);
        return formatter.format(west.getFirstOrbit(dIndex));
    }
    public String getOrbitAt(int index, int dIndex) {
        this.initText = this.text;
        int i = 1;
        while (true) {
            String orbitAt = this.getWestReversedDiffusion(dIndex);
            if (i == index || orbitAt.equals(this.text)) {
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
            orbitsInRange = this.getWestReversedDiffusion(dIndex);
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
        int t = 1;
        while (true) {
            String orbitGen = this.getWestReversedDiffusion(dIndex);
            System.out.println(t++ +" "+formatter.format(orbitGen));
            if (this.text.equals(orbitGen)) {
                break;
            }
            this.initText = orbitGen;
        }
    }// print all orbit
}// class
