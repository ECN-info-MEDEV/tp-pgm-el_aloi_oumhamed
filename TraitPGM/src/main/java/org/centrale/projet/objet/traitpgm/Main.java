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
        
        // l'image à lire
        String filePath = "brain.pgm";
        
        // Buffer Object
        Reader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);
        
        // Lignes non utiles
        br.readLine();
        br.readLine();
        
        // Initialisation du Tokenizer
        StringTokenizer sta = new StringTokenizer(br.readLine(), " ");
        
        // Les constantes de l'image
        int picWidth = Integer.parseInt(sta.nextToken()); // 720
        int picHeight = Integer.parseInt(sta.nextToken()); // 486
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
        
        // Affichage de l'histograme des valeurs
       for(int i=0;i<255;i++){
           System.out.print(pixles[i]);
       }
        
        // Reading image
        int[][] image = new int[picHeight][picWidth];
        int i = 1;
        int j = 0;
        while (line != null) {
            if (j == picWidth) {
                j = 0;
                i++;
            }
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
                int pixel = Integer.parseInt(st.nextToken());
                System.out.println(pixel);
                image[i - 1][j] = pixel;
                j++;
            }
            line = br.readLine();
        }

        // Affichage de l'image
        for (int row = 0; row < picHeight; row++) {
            for (int col = 0; col < picWidth; col++) {
                System.out.print(image[row][col] + "  ");
            }
            System.out.println();
        }
        
        // Seuillage
        int seuil = 100;
        for (int row = 0; row < picHeight; row++) {
            for (int col = 0; col < picWidth; col++) {
                if (image[row][col] > seuil) {
                    image[row][col] = 1;
                } else {
                    image[row][col] = 0;
                }
            }
            System.out.println();
        }
    }
}
