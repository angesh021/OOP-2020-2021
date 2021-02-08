package ie.tudublin;

import javax.lang.model.util.ElementScanner14;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        switch (mode)
        {
            case 0:
            fill(50,255,255);

            if (mouseX < cx){
                rect(0, 0, cx, height);
            }
            else
            {
                rect(cx, 0, cx, height);
            }
            break;

            case 1:
            fill(50,255,255);

            if(mouseX < cx && mouseY < cy)
            {
                rect(0, 0, cx, cy);
            }
            else if(mouseX > cx && mouseY < cy)
            {
                rect(cx, 0, cx, cy);
            }
            else if(mouseX < cx && mouseY > cy)
            {
                rect(cx, 0, cx, cy);
            }
            else
            {
                rect(cx, cy, cx, cy);
            }
            break;

           case 2:
           int numRects = (int)(mouseX / 10.0f);
           float w = width / (float) numRects;
           float cgap = 255 / (float) numRects;
           for(int i=0; i<numRects; i++)
           {
               fill(i*cgap, 255, 255);
               rect(i * w, 0, w, height);
           }
           break;

           case 3:
           {
               int numCircles = (int)(mouseX / 10.0f);
               float W = width / (float) numCircles;
               float Cgap = 255 / (float) numCircles;
               for(int i =0; i<numCircles; i++)
               {
                   fill(Cgap * i, 255, 255);
                   ellipse(W/2 + (i*W), cy, W, W);
               }
           }

         
        }
    }
}
