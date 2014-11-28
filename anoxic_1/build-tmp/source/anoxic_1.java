import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class anoxic_1 extends PApplet {

// anoxic_1
// stabs at duchamp's anemia
// Si je te donne un sou, me donneras-tu une paire de ciseaux?

// plates rotate and have shapes on them
int nPlates = 14; 
ArrayList<Plate> plates; // ellipses
Plate splate; // spiral

// shapes are circles or spirals
// centers of shapes are off-set -- or is it center of plate?
// circles are white or black
// stroke is white or black, with varying thickness
int white = color(255, 255, 255);
int black = color(0,0,0);
float iniDiam;
float iniRot;
int iniXOff;
int iniYOff;

public void setup(){
  size(400, 400);
  background(black);
  iniDiam = width/10;
  iniRot = 0.01f;
  iniXOff = 0;
  iniYOff = 0;
  // for this one, all circles are alike
  fill(white);
  stroke(black);
  strokeWeight(5);
  // plate stuff
  plates = new ArrayList();
  float diam = iniDiam;
  float rot = iniRot;
  float xOff = iniXOff;
  float yOff = iniYOff;
  for(int i =0; i <= nPlates; i++){
    ///float r, int xo, int yo, float d
    plates.add(new Plate(0.5f, xOff, yOff, diam, 'e'));
    diam += ((width + (width/10)) / nPlates);
  }  
  splate = new Plate(0.7f, xOff, yOff, width, 's');
  smooth(); 
}

public void draw(){
  background(black);
  fill(white);
  stroke(black);
  strokeWeight(5);
  for(int i=nPlates; i > 0; i--){
    Plate p = plates.get(i);
    p.displate();
    p.update();
  }  
  noFill();
  stroke(white);
  strokeWeight(30);
  splate.displate();
  splate.update();
}
class Plate{
  float rot;
  float rotSpeed; 
  float xOff;
  float yOff;
  float diam;
  char type;

  Plate(float r, float xo, float yo, float d, char t){
    rotSpeed = r;
    xOff = xo;
    yOff = yo;
    diam = d;
    type = t;
  }
  
  public void displate(){
    pushMatrix();
    translate(width/2, height/2);
    rotate(radians(rot));
    switch(type){
      case 'e':
        ellipse(xOff, yOff, diam, diam);
        break;
      case 's':
        // draw a spiral
        spdraw();
        break;
    }
    popMatrix();
  }
  
  public void spdraw(){
    float r = 10;
    float theta = 0.5f;
    float x1 = r;
    float y1 = r;
    float x2 = x1;
    float y2 = y1;

    while(r < width/2 + (width/5)){
      x1 = r*cos(theta);
      y1 = r * sin(theta);
      line(x1, y1, x2, y2);
      x2 = x1;
      y2 = y1;
      theta -= 0.01f;
      r += 0.15f;
    }
    
  }
  
  public void update(){
    rot+=rotSpeed;
  }
    
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "anoxic_1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
