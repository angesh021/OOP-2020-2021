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

    float offset = 0;

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
            {
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
        }
            break;

           case 2:
           {
           int numRects = (int)(mouseX / 10.0f);
           float w = width / (float) numRects;
           float cgap = 255 / (float) numRects;
           for(int i=0; i<numRects; i++)
           {
               fill(i*cgap, 255, 255);
               rect(i * w, 0, w, height);
           }
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
           break;

           case 4:
           {
               background(50,255,255);
               int numLines = 5;
               float theta = TWO_PI / (float) numLines;
               float radius = 100;
               for(int i=0; i<numLines; i++)
               {
                   float angle = theta * i;
                   float x = sin(angle) * radius;
                   float y = cos(angle) * radius;
                   line(cx, cy, cx+x, cy+y );
               }
           }
           break;

           case 5:
           {
              float w = 200;
              float h = 50;
              rectMode(CENTER); 
              if(mouseX >cx - (w/2) && mouseY > cy-(h/2) && mouseY<cy +(h/2))
              {
                  fill(50, 255, 255);
                  rect(0, 0, cx, cy);
              }
              else if(mouseX > cx && mouseY < cy)
              {
                  rect(cx, 0, cx, cy);
              }
              else if(mouseX < cx && mouseY > cy)
              {
                  rect(0, cy, cx, cy);
              }
              else
              {
                  rect(cx, cy, cx, cy);
              }
           }
           break;

           case 6:
           {
               rectMode(CORNER);
               int numRect = (int) mouseX/10;
               float wid = width / (float) numRect;
               float colourgap = 255/(float)numRect;
               for(int i=0; i<numRect; i++)
               {
                   fill(colourgap * i, 255, 255);
                   rect(i*wid, i*wid, wid, wid);
                   rect(width - (i+1)*wid, i*wid, wid, wid);
                }
            }
            break;

            case 7:
            {
                int numCircles = (int) mouseX/10;
                float w = width / (float) numCircles;
                float cgap = 255/(float)numCircles;
                float gap = width/(float)numCircles;
                for(int i=0; i<numCircles; i++)
                {
                    fill(i*cgap, 255, 255);
                    ellipse(cx, cy, w, w);
                    w -= gap;
                }
            }
            break;

            case 8:
            {
                offset += (mouseX/100);
                int numCircles = 20;
                float wi =width/(float)numCircles;
                float cogap = 255/(numCircles + numCircles);
                for(int i=0; i<numCircles; i++)
                {
                    for(int j=0; j< numCircles; j++)
                    {
                        float c = ((cogap * (i+j)) + offset) % 255;
                        fill(c, 255, 255);
                        ellipse((wi/2) + wi*j, (wi/2) +wi*i, wi, wi);
                    }
                }
            }
            break;

            case 9:
            {
                int sides = (mouseX/50);
                float theta = TWO_PI / (float) sides;
                float radius = 200;
                stroke(255);
                for(int i=1; i<=sides; i++)
                {
                    float x1 = sin(theta *(i - 1)) * radius;
                    float y1 = cos(theta *(i - 1)) * radius;
                    float x2 = sin(theta *i) * radius;
                    float y2 = cos(theta *i) * radius;
                    line(cx+x1, cy+y1, cx+x2, cy+y2);
                }

            }

         
        }
    }
}
