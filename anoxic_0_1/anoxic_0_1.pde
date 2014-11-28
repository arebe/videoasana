// anoxic_0
// stabs at duchamp's anemia
// Avez-vous déjà mis la moëlle de l'épée dans le poêle de l'aimée?

// plates rotate and have shapes on them
int nPlates = 14;
ArrayList<Plate> plates;

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
  size(858, 480); // pico  background(black);
  iniDiam = width/10;
  iniRot = 0.01;
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
    diam += ((width + (width/10)- (3.4*i*i)) / nPlates);
    xOff -= 1;
    yOff -= 1;
    
  }  
}

void draw(){
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
