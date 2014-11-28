// anoxic_text
// stabs at duchamp's anemia
// Si je te donne un sou, me donneras-tu une paire de ciseaux?

// plates rotate and have text on them
Plate plate;

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
ArrayList<String> messages = new ArrayList<String>();
int mIndex;

PFont font;

void setup(){
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
  float rot = -0.5;
  float xOff = 0;
  float yOff = 0;
  plate = new Plate(-0.5, xOff, yOff, diam, 'm');
  plate.setMessage(messages.get(mIndex));
  smooth(); 
}

void draw(){
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
