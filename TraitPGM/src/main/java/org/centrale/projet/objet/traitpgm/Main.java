/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet.traitpgm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

/**
 *
 * @author Otmane
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = "brain.pgm";
        Reader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);

        br.readLine();
        br.readLine();
        
        StringTokenizer sta = new StringTokenizer(br.readLine(), " ");
        
        int picWidth = Integer.parseInt(sta.nextToken());
        int picHeight = Integer.parseInt(sta.nextToken());
        int maxvalue = Integer.parseInt(br.readLine());
        String line = br.readLine();
        
        // Histogram
        int[] pixles = new int[256];
        while(line !=null){
            StringTokenizer st = new StringTokenizer(line, " ");
            while(st.hasMoreTokens()){
                  int pixel =Integer.parseInt(st.nextToken());
                  pixles[pixel]++;
                }
            line = br.readLine();
        }
        
//        for(int i=0;i<255;i++){
//            System.out.print(pixles[i]);
//        }
             


    }
}
