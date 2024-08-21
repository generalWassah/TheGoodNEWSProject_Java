package com.adadu.implementations;

import com.adadu.formatter.Formatter;
import com.adadu.selectNEWS.SelectNEWS;

public class LeftWardReversed {
    String text;
    String initText;
    String originalMessage;
    int _Pi;
    Formatter formatter;
    public LeftWardReversed(String extractedText, String originalMessage, int _Pi){
        this.originalMessage=originalMessage;
        this.text=extractedText.toUpperCase();
        this.initText=this.text;
        this._Pi = _Pi;
        formatter = new Formatter(this.originalMessage);
    }

    String newDiffusedText = ""; // store diffused intermediate chars
    SelectNEWS news = new SelectNEWS();

    // method for outWardDiffuse
    public String getLeftWardReversedDiffusion(String selectNEWS) {
        String leftWardReversed;

        if(!(selectNEWS.equals("N") || selectNEWS.equals("NR") || selectNEWS.equals("E")  || selectNEWS.equals("ER") || selectNEWS.equals("W") || selectNEWS.equals("WR") || selectNEWS.equals("S") || selectNEWS.equals("SR"))){
            System.out.println("enter valid diffusion option");
            System.exit(20);
        }
        int strLen =  this.initText.length();
        int maxIter = (strLen) / 2; // maximum iteration for the while loop

        int start = 0; // iteration starting point 1
        int end = strLen; // iteration starting point 2

        int iter = maxIter;

        // while loop
        while (iter > 0) {
            String extract = this.initText.substring(start,end);
            // diffuse collected subText
            newDiffusedText = news.diffuseExtract(extract,selectNEWS, _Pi);
            char[] textInChars = this.initText.toCharArray();
            int start1 = start;
            int dLen = newDiffusedText.length();
            int j=0;
            while(dLen>0){
                // replace String with diffused txt at
                textInChars[start1] = newDiffusedText.charAt(j);
                start1++;
               j++;
                dLen--;
            } // while loop

            this.initText = String.valueOf(textInChars);
            iter--;
            start+=2;
        } // while

        leftWardReversed =  this.initText;
        return leftWardReversed;
    }// method getLeftToRightDiffused

    public String getFirstOrbit(String selectNEWS){

     return formatter.format(getLeftWardReversedDiffusion(selectNEWS));
    }
    // returns the last orbit of the iterated sequence
    public String getLastOrbit(String selectNEWS) {
        this.initText = this.text;
        LeftWard leftWard = new LeftWard(this.initText,"", _Pi);
        String lastOrbit = "";
        if (selectNEWS.equals("N")&&(this.initText.length()%2==0)){
            lastOrbit = leftWard.getLeftWardDiffusion("S");
        } else if(selectNEWS.equals("NR")){
            lastOrbit = leftWard.getLeftWardDiffusion("N");
        }

        if (selectNEWS.equals("E")&&(this.initText.length()%2==0)){
            lastOrbit = leftWard.getLeftWardDiffusion("W");
        }else if (selectNEWS.equals("ER")){
            lastOrbit = leftWard.getLeftWardDiffusion("E");
        }

        if (selectNEWS.equals("W")&&(this.initText.length()%2==0)){
            lastOrbit = leftWard.getLeftWardDiffusion("E");
        }else if (selectNEWS.equals("WR")){
            lastOrbit = leftWard.getLeftWardDiffusion("W");
        }

        if (selectNEWS.equals("S")&&(this.initText.length()%2==0)){
            lastOrbit = leftWard.getLeftWardDiffusion("N");
        }else if (selectNEWS.equals("SR")){
            lastOrbit = leftWard.getLeftWardDiffusion("S");
        }

        return formatter.format(lastOrbit);
    } // last orbit
      // return orbit at specified index(iter) using one of NEWS function
    public String getOrbitAt(int iter, String selectNEWS) {
        this.initText = this.text;
        int i = 1;
        while (true) {
            String orbitsGen = getLeftWardReversedDiffusion(selectNEWS);
            if (i == iter) {
                return formatter.format(orbitsGen);
            }
            this.initText = orbitsGen;
            i++;
        } // while
    } // orbit at
      // print orbits up to specified index(iter) using one of NEWS function
    public void printOrbitsInRange(int iter, String selectNEWS) {
        this.initText = this.text;
        String diffusedText;
        int i = 1;
        while (iter > 0) {
            diffusedText = getLeftWardReversedDiffusion(selectNEWS);
            System.out.println(formatter.format(diffusedText) + " " + i++);
            this.initText = diffusedText;
            iter--;
        }
    } // orbit up to
      // print all orbits
    public void printAllOrbits(String selectNEWS) {
        this.initText = this.text;
        String originalText = this.initText;
        int t = 1;
        while (true) {
            String orbitsGen = getLeftWardReversedDiffusion(selectNEWS);
            System.out.println(formatter.format(orbitsGen) + " " + t++);
            if (this.text.equals(orbitsGen)) {
                break;
            }
            this.initText = orbitsGen;
        }
    }// print all orbits

}
