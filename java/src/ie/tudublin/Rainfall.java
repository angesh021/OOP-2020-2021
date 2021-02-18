package ie.tudublin;

import processing.core.PApplet;

public class Rainfall extends PApplet {

    public float map1(float from, float start1, float stop1, float start2, float stop2)
    {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
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
        stroke(255);
        textAlign(CENTER, CENTER);
        float gap = width * 0.1f;
        //two line draw for metric
        line(gap, gap, gap, height - gap);
        line(gap, height - gap, width - gap, height - gap);
        float w = (width-gap*2)/(float) rainfall.length; 
        

        //draw the number to the line
        for(int i = 0 ; i <= 120; i +=10)
        {
            float y = map(i, 0, 120, height - gap, gap);
            line(gap -5, y, gap, y);
            text(i, gap / 2, y);
        }  

        for(int i = 0 ; i < rainfall.length ; i ++) 
        {
            float x= map(i, 0, rainfall.length, gap, width-gap);
            fill(colors[i], 255, 255);
            float h = map(rainfall[i], 0, 120, 0, -(height-(gap*2))); //leveling the bar accordingly
            rect(x, height-gap-1, w, h);
            text(months[i], x + (w*0.5f), height-(gap*0.5f));
    
        } 
        text("Rainfall Barchart", width*0.5f, gap*0.5f);

    }

    void drawLine()
    {
        float gap = width * 0.1f;
        stroke(255);
        line(gap, gap, gap, height - gap);
        line(gap, height - gap, width - gap, height - gap);

        textAlign(CENTER, CENTER);
        for (int i = 0 ; i < months.length ; i ++)
        {
            float x = map(i, 0, months.length - 1, gap, width - gap);
            line(x, height - gap, x, height - gap + 5);
            fill(255);
            float ty = height - (gap / 2);
            text(months[i], x, ty);
        }

        for(int i = 0 ; i <= 120; i +=10)
        {
            float y = map(i, 0, 120, height - gap, gap);
            line(gap - 5, y, gap, y);
            text(i, gap / 2, y);
        }

        for(int i = 1 ; i < rainfall.length ; i ++)
        {
            float x1 = map(i - 1, 0, rainfall.length - 1, gap, width - gap); 
            float y1 = map(rainfall[i - 1], 0, 120, height - gap, gap);
            float x2 = map(i, 0, rainfall.length - 1, gap, width - gap); 
            float y2 = map(rainfall[i], 0, 120, height - gap, gap);
            line(x1, y1, x2, y2);           
        }
        text("Rainfall LineGraph", width*0.5f, gap*0.5f);

    }

    void drawPieChart()
    {
        float cx = width / 2;
        float cy = height / 2;

        float w = width * 0.8f;
        //arc(cx, cy, w, w, 0, TWO_PI, ARC);

        float total = 0;
        colorMode(HSB);
        for (int i = 0 ; i < months.length ; i ++)
        {
            float x = map(i, 0, months.length - 1, cy, width - cy);
            line(x, height - cy, x, height - cy + 5);
            fill(255);
            float ty = height - (cy / 2);
            text(months[i], x, ty);
        }

        for (int i = 0 ; i < rainfall.length ; i ++)
        {
            total += rainfall[i];
        }

        float runningSum = 0;
        for (int i = 0 ; i < rainfall.length ; i ++)
        {
            float next = runningSum + rainfall[i];
            float start = map(runningSum, 0, total, 0, TWO_PI);
            float end = map(next, 0, total, 0, TWO_PI);
            fill(map(i, 0, rainfall.length, 0, 255), 255, 255);
            arc(cx, cy, w, w, start, end, ARC);
            runningSum = next;
    
        }

    }

    public void draw() {
        background(0);
        noStroke();
        
        colorMode(HSB);
        background(0,0,0); 
        switch(mode){
            case 0:
            {
                drawBarChart();
            }
            break;

            case 1:
            {
                drawLine();
            }
            break;

            case 2:
            {
                drawPieChart();
            }

        }

    }
}
