Star sun;
void setup() {
  size(800, 800, P3D);
  fill(255);
  sun = new Star(50, 0, 0);
  sun.satellites(7, 1);
}

void draw() {
  background(0);
  lights();
  translate(width/2, height/2);
  sun.body();
  sun.orbit();
}
