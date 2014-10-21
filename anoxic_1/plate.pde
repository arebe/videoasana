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
  
  void displate(){
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
  
  void spdraw(){
    float r = 10;
    float theta = 0.5;
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
      theta -= 0.01;
      r += 0.15;
    }
    
  }
  
  void update(){
    rot+=rotSpeed;
  }
    
}
