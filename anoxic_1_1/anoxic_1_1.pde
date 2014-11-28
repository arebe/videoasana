// anoxic_1
// stabs at duchamp's anemia
// Si je te donne un sou, me donneras-tu une paire de ciseaux?

// plates rotate and have shapes on them
int nPlates = 14; 
ArrayList<Plate> plates; // ellipses
Plate splate1; // spiral
Plate splate2; // spiral

// shapes are circles or spirals
// centers of shapes are off-set -- or is it center of plate?
// circles are white or black
// stroke is white or black, with varying thickness
color white = color(255, 255, 255);
color black = color(0,0,0);
float iniDiam;
float iniRot;
int iniXOff;
int iniYOff;

void setup(){
  // size(1680, 1050); // mac
  size(858, 480); // pico
  background(black);
  iniDiam = width/10;
  iniRot = 0.01;
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
    plates.add(new Plate(0  , xOff, yOff, diam, 'e'));
    diam += ((width + (width/10)) / nPlates);
  }  
  splate1 = new Plate(30, xOff, yOff, width, 's');
  splate2 = new Plate(30, xOff, yOff, width, 's');
  smooth(); 
}

void draw(){
  background(white);
  fill(black);
  stroke(white);
  strokeWeight(5);
  for(int i=nPlates; i > 0; i--){
    Plate p = plates.get(i);
    p.displate();
    p.update();
  }  
  noFill();
  stroke(black);
  strokeWeight(40);
  splate1.displate();
  splate1.update();
  stroke(white);
  strokeWeight(4);
  splate2.displate();
  splate2.update();
  fill(black);
  noStroke();
  ellipse(width/2, height/2, 10, 10);
  saveFrame("frames/an11_####.png");
  if (millis() > 180000){
    noLoop();
  }

}
