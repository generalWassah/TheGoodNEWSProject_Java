package com.adadu.implementations;
import com.adadu.formatter.Formatter;
import com.adadu.selectNEWS.SelectNEWS;

import java.util.Locale;

public class LeftWard {
    String text;
    String initText;
    String originalMessage;
    int _Pi;
    Formatter formatter;
    public LeftWard(String extractedText, String originalMessage, int _Pi){
        this.originalMessage=originalMessage;
        this.text=extractedText.toUpperCase();
        this.initText=this.text;
        this._Pi = _Pi;
        formatter = new Formatter(this.originalMessage);
    }

        String newDiffusedText = ""; //store diffused intermediate chars
    SelectNEWS news = new SelectNEWS();
        //method for outWardDiffuse
      public String getLeftWardDiffusion(String selectNEWS) {
          String leftWardDiffused;
          if(!(selectNEWS.equals("N") || selectNEWS.equals("NR") || selectNEWS.equals("E")  || selectNEWS.equals("ER") || selectNEWS.equals("W") || selectNEWS.equals("WR") || selectNEWS.equals("S") || selectNEWS.equals("SR"))){
              System.out.println("enter valid diffusion option");
              System.exit(20);
          }
            int strLen = this.initText.length();
            int maxIter = (strLen) / 2; //maximum iteration for the while loop

            int start = strLen-2;
            int end = strLen;

          if(strLen%2==1){
              start--;
          }
            int iter=maxIter;
            while(iter>0){

                String extract = this.initText.substring(start,end);
                // diffuse collected subText
                newDiffusedText = news.diffuseExtract(extract,selectNEWS,_Pi);

                //replace corresponding newDiffusedText into newText
                char[] textInChars = this.initText.toCharArray();
                int start1 = start;
                int dLen = newDiffusedText.length();
                int j=0;
               while(dLen>0){
                    //replace String with diffused txt at
                   textInChars[start1] = newDiffusedText.charAt(j);
                   start1++;
                   j++;
                   dLen--;
                }//while
                this.initText = String.valueOf(textInChars);
                start-=2;
                iter--;

            }// while
              leftWardDiffused=this.initText;
            return leftWardDiffused;
        }// method getLeftToRightDiffused

      public String getFirstOrbit(String selectNEWS){
        this.initText = this.text;
        return formatter.format(getLeftWardDiffusion(selectNEWS));
      }
    // returns the last orbit of the iterated sequence
    public String getLastOrbit(String selectNEWS){
        this.initText = this.text;
          LeftWardReversed leftWardReversed = new LeftWardReversed(this.initText,"", _Pi);
        String lastOrbit="";
        if (selectNEWS.equals("N")&&(this.initText.length()%2==0)){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("S");
        } else if(selectNEWS.equals("NR")){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("N");
        }

        if (selectNEWS.equals("E")&&(this.initText.length()%2==0)){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("W");
        }else if (selectNEWS.equals("ER")){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("E");
        }

        if (selectNEWS.equals("W")&&(this.initText.length()%2==0)){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("E");
        }else if (selectNEWS.equals("WR")){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("W");
        }

        if (selectNEWS.equals("S")&&(this.initText.length()%2==0)){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("N");
        }else if (selectNEWS.equals("SR")){
            lastOrbit = leftWardReversed.getLeftWardReversedDiffusion("S");
        }

        return formatter.format(lastOrbit);
    } // last orbit
    // return orbit at specified index(iter) using one of NEWS function
    public String getOrbitAt(int iter,String selectNEWS){
          int i = 1;
        while(true) {
            String orbitsGen = getLeftWardDiffusion(selectNEWS);
            if(i==iter) {
                return formatter.format(orbitsGen);
            }
            this.initText = orbitsGen;
            i++;
        }// while
    } // orbit at
    // print orbits up to specified index(iter) using one of NEWS function
    public void printOrbitsInRange(int iter,String selectNEWS){
        this.initText = this.text;
          String diffusedText;
        int i = 1;
        while(iter>0){
            diffusedText = getLeftWardDiffusion(selectNEWS);
            System.out.println(formatter.format(diffusedText)+" "+i++);
            this.initText = diffusedText;
            iter--;
        }
    } // orbit up to
    // print all orbits
    public void printAllOrbits(String selectNEWS){
        this.initText = this.text;
        int t = 1;
        while(true){
            String orbitsGen = getLeftWardDiffusion(selectNEWS);
            System.out.println(formatter.format(orbitsGen)+" "+t++);
            if(this.text.equals(orbitsGen)){
                break;
            }
            this.initText=orbitsGen;
        }
    }// print all orbits

    }
