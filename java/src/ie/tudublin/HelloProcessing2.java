package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		
	}
	
	public void draw()
	{	
		background(255, 0, 0); //(RBG) red background
		stroke(255);  // pen colour
		//line(10, 10, 200, 200); // x1, y1, x2, y2
	
		noStroke();
		fill(255, 255, 0);
		ellipse(250, 300, 400, 400);  //cx, cy, w, h
		
		fill(0, 0, 255);
		//rect(20, 100, 70, 90); // topLeftx, topLefty, w, h
		point(200, 60);
		
		fill(255, 255, 255);
		triangle(250, 50, 50, 450, 450, 450);
		//triangle(x1, y1, x2, y2, x3, y3);
		
		fill(211, 211, 211);
		ellipse(250, 250, 190, 90);
		
		fill(0);
		ellipse(250, 250, 70, 70);

		fill(0);
		text("Hello World From Angesh", 50, 50);
		text("The See All Eyes", 50, 70);


		float x = 0;
		

		ellipse(x, height / 2, 70, 70);
		x++;
		println(x);
	}
}
