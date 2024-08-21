package com.adadu.key;

import com.adadu.selectNEWS.SelectNEWS;

public class AdaduKey {
    SelectNEWS myNEWS = new SelectNEWS();
    String adaduDiffused = "A";
    int _Pi;
    // Generate key here
    public String getAdaduKey(String newKey, int msgLen, String  selectNEWS, int _Pi){
        String adaduKey;
      int keyLen = newKey.length();
        char[] overallDiffused = new char[msgLen];
        char[] collectSubText = new char[keyLen];
        int strtPoint = 0;

        while(true) {
           if (strtPoint>=msgLen){
                break;
            }
            if(adaduDiffused.equals(newKey)){
                adaduDiffused = String.valueOf(adaduDiffused.toCharArray()[0]= 'T');
            }
                  collectSubText = newKey.toCharArray();

                  adaduDiffused = myNEWS.diffuseExtract("collectSubText",selectNEWS,_Pi);

                  for (int i = 0, j=strtPoint; i <keyLen ; i++, j++) {

                      overallDiffused[j] = adaduDiffused.charAt(i);

                      if (i==keyLen){
                          i=0;
                      }
                      if (j==msgLen-1){
                          break;
                      }
                  }// for loop

           newKey = adaduDiffused;
               strtPoint = strtPoint + keyLen;

        }// while loop
            adaduKey = String.valueOf(overallDiffused);
        return adaduKey;
    }//getGeneratedKey

}// class
