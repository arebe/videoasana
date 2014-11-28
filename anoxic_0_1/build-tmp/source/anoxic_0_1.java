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

public class anoxic_0_1 extends PApplet {

// anoxic_0
// stabs at duchamp's anemia
// Avez-vous d\u00e9j\u00e0 mis la mo\u00eblle de l'\u00e9p\u00e9e dans le po\u00eale de l'aim\u00e9e?

// plates rotate and have shapes on them
int nPlates = 14;
ArrayList<Plate> plates;

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
  // size(1680, 1050); // mac
  size(858, 480); // pico  background(black);
  iniDiam = width/10;
  iniRot = 0.01f;
  iniXOff = nPlates;
  iniYOff = nPlates+2;
  // for this one, all circles are alike
  fill(white);
  stroke(black);
  strokeWeight(3);
  // plate stuff
  plates = new ArrayList();
  float diam = iniDiam;
  float rot = iniRot;
  float xOff = iniXOff;
  float yOff = iniYOff;
  for(int i =0; i <= nPlates; i++){
    ///float r, int xo, int yo, float d
    plates.add(new Plate(5, xOff, yOff, diam));
    diam += ((width + (width/10)- (3.4f*i*i)) / nPlates);
    xOff -= 1;
    yOff -= 1;
    
  }  
}

public void draw(){
  background(black);
  for(int i=nPlates; i > 0; i--){
    Plate p = plates.get(i);
    p.displate();
    p.update();
  }  
  // saveFrame("frames/an01_####.png");
  // if (millis() > 90000){
  //   noLoop();
  // }
}
class Plate{
  float rot;
  float rotSpeed; 
  float xOff;
  float yOff;
  float diam;

  Plate(float r, float xo, float yo, float d){
    rotSpeed = r;
    xOff = xo;
    yOff = yo;
    diam = d;
  }
  
  public void displate(){
    pushMatrix();
    translate(width/2, height/2);
    rotate(radians(rot));
    ellipse(xOff, yOff, diam, diam);
    popMatrix();
  }
  
  public void update(){
    rot+=rotSpeed;
  }
    
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "anoxic_0_1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
