package com.adadu.implementations;
import com.adadu.formatter.Formatter;
import com.adadu.selectNEWS.SelectNEWS;

public class RightWard {
    String text;
    String initText;
    String originalMessage;
    int _Pi;
    Formatter formatter;
    public RightWard(String extractedText, String originalMessage, int _Pi){
        this.originalMessage=originalMessage;
        this.text=extractedText.toUpperCase();
        this.initText=this.text;
        this._Pi = _Pi;
        formatter = new Formatter(this.originalMessage);
    }

    String newDiffusedText = ""; //store diffused intermediate chars
    SelectNEWS news = new SelectNEWS();
    //method for outWardDiffuse
    public String getRightWardDiffusion(String selectNEWS) {
        String rightWardDiffused;

        if(!(selectNEWS.equals("N") || selectNEWS.equals("NR") || selectNEWS.equals("E")  || selectNEWS.equals("ER") || selectNEWS.equals("W") || selectNEWS.equals("WR") || selectNEWS.equals("S") || selectNEWS.equals("SR"))){
            System.out.println("enter valid diffusion option");
            System.exit(20);
        }
        int strLen = this.initText.length();
        int maxIter = (strLen) / 2; //maximum iteration for the while loop
        int start = 0;
        int end = 2;

        if(strLen%2==1){
            end++;
        }
        int iter=maxIter;
        // while loop
        while(iter>0){

            String extract = this.initText.substring(start,end);
            // diffuse collected subText
            newDiffusedText = news.diffuseExtract(extract,selectNEWS, _Pi);

            char[] textInChars = this.initText.toCharArray();
            int dLen = newDiffusedText.length();
            int start1 = start;
            int j=0;
            while (dLen>0) {
                textInChars[start1] = newDiffusedText.charAt(j);
                start1++;
                j++;
                dLen--;
            }//while
            this.initText = String.valueOf(textInChars);
           end+=2;
            iter--;
        }// while
            rightWardDiffused=this.initText;
        return rightWardDiffused;
    }// method getLeftToRightDiffused

    public String getFirstOrbit(String selectNEWS){
        this.initText = this.text;
        return formatter.format(getRightWardDiffusion(selectNEWS));
     }
    // returns the last orbit of the iterated sequence
    public String getLastOrbit(String selectNEWS){
        this.initText = this.text;
        RightWardReversed rightWardReversed = new RightWardReversed(this.initText,"", _Pi);
        String lastOrbit="";
        if (selectNEWS.equals("N")&&(this.initText.length()%2==0)){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("S");
        } else if(selectNEWS.equals("NR")){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("N");
        }

        if (selectNEWS.equals("E")&&(this.initText.length()%2==0)){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("W");
        }else if (selectNEWS.equals("ER")){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("E");
        }

        if (selectNEWS.equals("W")&&(this.initText.length()%2==0)){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("E");
        }else if (selectNEWS.equals("WR")){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("W");
        }

        if (selectNEWS.equals("S")&&(this.initText.length()%2==0)){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("N");
        }else if (selectNEWS.equals("SR")){
            lastOrbit = rightWardReversed.getRightWardReversedDiffusion("S");
        }
        return formatter.format(lastOrbit);
    } // last orbit
    // return orbit at specified index(iter) using one of NEWS function
    public String getOrbitAt(int iter,String selectNEWS){
        this.initText = this.text;
        int i = 1;
        while(true) {
            String orbitsGen = getRightWardDiffusion(selectNEWS);
            if(i==iter) {
                return formatter.format(orbitsGen);
            }
            this.initText = orbitsGen;
            i++;
        }// while
    } // orbit at
    // print orbits up to specified index(iter) using one of NEWS function
    public void printOrbitsInRange(int iter,String selectNEWS){
        String diffusedText;
        int i = 1;
        while(iter>0){
            diffusedText = getRightWardDiffusion(selectNEWS);
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
            String orbitsGen = getRightWardDiffusion(selectNEWS);
            System.out.println(formatter.format(orbitsGen)+" "+t++);
            if(this.text.equals(orbitsGen)){
                break;
            }
            this.initText=orbitsGen;
        }
    }// print all orbits

}
