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
  
  void displate(){
    pushMatrix();
    translate(width/2, height/2);
    rotate(radians(rot));
    ellipse(xOff, yOff, diam, diam);
    popMatrix();
  }
  
  void update(){
    rot+=rotSpeed;
  }
    
}
