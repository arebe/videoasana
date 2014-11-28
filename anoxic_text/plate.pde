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

  void setMessage(String m){
    message = m;
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
      case 'm':
        mdraw();
        break;
    }
    popMatrix();
  }
  
  void spdraw(){
    float r = 10;
    float theta = 0.5;
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
      theta -= 0.01;
      r += 0.15;
    }
  }

  void mdraw(){
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
      theta += 0.1;
      r += 0.4;
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
    
  
  void update(){
    rot+=rotSpeed;
  }
    
}
