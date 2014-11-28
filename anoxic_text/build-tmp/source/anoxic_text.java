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

public class anoxic_text extends PApplet {

// anoxic_text
// stabs at duchamp's anemia
// Si je te donne un sou, me donneras-tu une paire de ciseaux?

// plates rotate and have text on them
Plate plate;

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
ArrayList<String> messages = new ArrayList<String>();
int mIndex;

PFont font;

public void setup(){
  // size(1680, 1050); // mac
  size(858, 480); // pico
  background(black);
  font = createFont("Courier", 32);
  // load messages
  // chosen from twitter, #anoxic & #climate
  messages.add("NO HEAVEN WITHOUT HELL");
  messages.add("SPEWING SEWAGE INTO THE OCEAN IS BAD");
  messages.add("CLIMATE CHANGE WILL MEAN LESS SUSHI - AND MORE JELLYFISH");
  messages.add("ELECTRIC CABLES CREATED BY BACTERIA");
  messages.add("STUCK UP A CREEK WITHOUT A PADDLE");
  messages.add("VIOLATION OF OUR BASIC HUMAN RIGHTS");
  messages.add("HISTORY WILL NOT BE KIND");
  messages.add("TIME TO CHANGE THIS");
  messages.add("A SPECIES DIVIED CANNOT EVOLVE");
  messages.add("THUS WE PLEDGE OUR LOVE FOR GENERATIONS TO COME");
  messages.add("SOMEHOW CERTAIN ORGANISMS CAN LIVE THERE");
  mIndex = 0;

  // plate stuff
  float diam = width/10;
  float rot = -0.5f;
  float xOff = 0;
  float yOff = 0;
  plate = new Plate(-0.5f, xOff, yOff, diam, 'm');
  plate.setMessage(messages.get(mIndex));
  smooth(); 
}

public void draw(){
  background(black);
  fill(white);
  stroke(white);
  strokeWeight(5);
  plate.displate();
  plate.update();
  noFill();
  stroke(black);
  strokeWeight(40);
  fill(black);
  noStroke();
  if ((frameCount % 200) == 0){
    mIndex = mIndex < messages.size()-1 ? mIndex+1 : 0;
    plate.setMessage(messages.get(mIndex));
  }

  // ellipse(width/2, height/2, 10, 10);
  // saveFrame("frames/antext_####.png");
  // if (millis() > 1){
  //   noLoop();
  // }

}
class Plate{
  float rot;
  float rotSpeed; 
  float xOff;
  float yOff;
  float diam;
  char type;
  String message;


  Plate(float r, float xo, float yo, float d, char t){
    rotSpeed = r;
    xOff = xo;
    yOff = yo;
    diam = d;
    type = t;
  }

  public void setMessage(String m){
    message = m;
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
      case 'm':
        mdraw();
        break;
    }
    popMatrix();
  }
  
  public void spdraw(){
    float r = 10;
    float theta = 0.5f;
    float x1 = 0;
    float y1 = 0;
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

  public void mdraw(){
    float r = width/4;
    float theta = 0;
    float x1 = 0;
    float y1 = 0;
    float x2 = x1;
    float y2 = y1;
    int c = 0;
    float tSize = (width)/(message.length());
    textFont(font);
    textSize(tSize);
    while(c <= message.length()-1){
      x1 = r*cos(theta);
      y1 = r * sin(theta);
      pushMatrix();
      translate(x1, y1);
      rotate(theta+radians(90));
      text(message.charAt(c)+"  ", 0,0);
      popMatrix();
      c++;
      x2 = x1;
      y2 = y1;
      theta += 0.1f;
      r += 0.4f;
    }
  }
  // void mdraw(){
  //   float x1=0;
  //   float y1=0;
  //   float tSize = (width/2)/(3*message.length());
  //   int c=0;
  //   textSize(tSize);
  //   while(x1 < message.length()*6){
  //     text(message.charAt(c), x1, y1);
  //     c = (c < message.length()-1) ? c+1 : 0;
  //     x1+=tSize;
  //   }
  // }
    
  
  public void update(){
    rot+=rotSpeed;
  }
    
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "anoxic_text" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
