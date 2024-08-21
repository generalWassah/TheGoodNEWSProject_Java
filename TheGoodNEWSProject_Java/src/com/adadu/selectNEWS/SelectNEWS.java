package com.adadu.selectNEWS;

import com.adadu.algorithms.*;

public class SelectNEWS {

    // implementation

    String newDiffusedText = ""; //store diffused intermediate chars

    public String diffuseExtract(String extract, String newsFunction, int _Pi) {
        
        // choose the type of diffusion u want
        if (newsFunction.equals("N")) {
            North north = new North(extract,"");
            newDiffusedText = north.getNorthDiffusion(_Pi);
        }else if(newsFunction.equals("NR")){
            NorthReversed northReversed = new NorthReversed(extract,"");
            newDiffusedText = northReversed.getNorthReversedDiffusion(_Pi);
        } else if (newsFunction.equals("E")) {
            East east = new East(extract,"");
            newDiffusedText = east.getEastDiffusion(_Pi);
        } else if (newsFunction.equals("ER")) {
            EastReversed eastReversed = new EastReversed(extract,"");
            newDiffusedText = eastReversed.getEastReversedDiffusion(_Pi);
        } else if (newsFunction.equals("W")) {
            West west = new West(extract,"");
            newDiffusedText = west.getWestDiffusion(_Pi);
        } else if (newsFunction.equals("WR")) {
            WestReversed westReversed = new WestReversed(extract,"");
            newDiffusedText = westReversed.getWestReversedDiffusion(_Pi);
        } else if (newsFunction.equals("S")) {
            South south = new South(extract,"");
            newDiffusedText = south.getSouthDiffusion(_Pi);
        }else if (newsFunction.equals("SR")){
            SouthReversed southReversed = new SouthReversed(extract,"");
            newDiffusedText = southReversed.getSouthReversedDiffusion(_Pi);
        }else {
            System.out.println("Wrong option");
            System.exit(405);
        }
        return newDiffusedText;
    }// method DiffusionChoice

}// class SelectNEWS
