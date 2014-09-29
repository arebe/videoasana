PImage photo;
int sampleWidth = 10;
IntList sample;
int sampleX = 0;
int sampleY = 0;
int[][] newPixels;
int col = 0;

void setup(){
  size(800,600);
  background(0);
  sample = new IntList();
  newPixels = new int[width/sampleWidth][height/sampleWidth];
  photo = loadImage("roofscape.jpg");
  photo.resize(width, height);
  image(photo, 0, 0);
  for (int i = 0; i < height/sampleWidth; i++){
    for (int j = 0; j < width/sampleWidth; j++){
      sample.append(photo.get(sampleX, sampleY));
      sampleX++;
    }
    sample.sort();
    newPixels[col][sampleY]=sample.get(5); // get the median (because, lazy)
    sampleX=0;
    sampleY++;
  }
  
}


