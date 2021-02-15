package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public float map1(float from, float start1, float stop1, float start2, float stop2)
    {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    public void drawGrid()
    {
        stroke(255,0,0);
        float border = width * .05f;
        textAlign(CENTER, CENTER);
        for(int i=-5; i<=5; i++)
        {
            float x = map1(i, -5, 5, border, width-border);
            line(x, border, x, height-border);
            line(border, x, width-border, x);
            fill(255);
            text(i, x, border*0.5f);
            text(i, border*0.5f, x );
        }
    }

    public void settings() 
    {
        size(500, 500);     
        
        float f = map1(2,0,10,0, width);
        println(f); // should print 100

        f = map1(9,0,1,0,10);
        print(f);  //should print 90

        f = map1(250, 200, 300, 400, 500);
        print(f);  //should print 450

        f = map1(5, 0, 10, 1000, 2000);
        print(f);  //should print 1500
    }

    int mode = 0;

    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept","Oct", "Nov", " Dec"};
    float[] arr = new float[100]; // 100 float array
    int[] colors = new int[rainfall.length];

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        for(int i=0; i<rainfall.length; i++)
        {
            println(months[i] + "\t" + rainfall[i]);
        }

        //Enhanced for loop
        for(float f:rainfall)
        {
            println(f);
        }

        int minIndex = 0;
        int maxIndex = 0;
        float sum = 0;

        for(int i=0; i<rainfall.length; i++)
        {
            if(rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            if(rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }

            sum += rainfall[i];
            
        }

        float average = sum / (float)rainfall.length;
        println("Least rainfall was in " + months[minIndex] + " with " + rainfall[minIndex]);
        println("Most rainfall was in " + months[maxIndex] + " with " + rainfall[maxIndex]);
        println("Average rainfall: " + average);

        for(int i = 0 ; i < rainfall.length ; i ++)        
        {
            colors[i] =(int) random(0, 255);
        }
        
    }

    void drawBarChart()
    {
        colorMode(HSB);
        textAlign(LEFT, CENTER);
        
        float h = height / (float) rainfall.length; 
        float w = width/(float) rainfall.length;       
        for(int i = 0 ; i < rainfall.length ; i ++) 
        {
            fill(225,225,225);
            float x= map(i, 0, rainfall.length, 0, width);//i * h + (h * 0.5f);
            fill(colors[i], 255, 255);
            rect(x, height, w, -rainfall[i]);
            fill(0, 0, 0);
            text(months[i], x, 350);
        }       
    }

    float offset = 0;

    public void draw() {
        background(0);
        noStroke();
        //drawGrid();
        colorMode(HSB);
        float c = map(mouseX, 0, width, 0, 255);
        background(c, 255, 255);
        drawBarChart();

    }
}
