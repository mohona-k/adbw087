class Star { //Declared a new class called Atar

  // The following are attributes of the planets

  float radius; //radius of planet
  float distance; //distance of planet from the sun
  float velocity; //Velocity of circular movement
  float a; //Angle at which the planet will rotate from the normal
  Star[] planets; //Array to store planet and moons of planets

  // The planets do not need an x,y vector as it will be orbiting in a circle


  Star(float r, float d, float v) {
    radius = r;
    distance = d;
    a = random(0, TWO_PI); //Angle of a circle is 360 degrees which is 2 pi in rads
    velocity = v;
    
  }
  
   void orbit(){
      a = a + velocity;
      if (planets != null){
         for (int i = 0; i < planets.length; i=i+1) {
           planets[i].orbit();
         }
      }
   }
  
  //Number of satellites around each planet is different
  // so new function below
  void satellites(int moons, int submoons) { //Level can help determine the speed and the size of the moons and sub-moons
    planets = new Star[moons];
    for (int i = 0; i < planets.length; i=i+1) {
      float r = radius/(submoons*2); 
      float d = random(75, 250);
      float v = random(-0.02,0.001);
      planets[i] = new Star(r, d/submoons, v);
      if (submoons < 3) { //Level 3 to include subsatellites
         int num = int(random(0,4));
         planets[i].satellites(num, submoons+1); //Gives a finite number of moons, otherwise submoons would keep having smaller moons 
      }
    }
  }
  void body() {
    //pushMatrix() popMatrix() will ensure planets are not off the window
    //A matrix is a two-dimensional data structure
    pushMatrix(); 
    noStroke();
    rotate(a);
    //Translations are cumulative
    //The matrix commands will ensure this translation is reset
    translate(distance, 0);
    sphere(radius);
   // ellipse(0, 0, radius*2, radius*2);
    
    if (planets != null) {
      for (int i = 0; i < planets.length; i=i+1) {
        planets[i].body();
      }
    }
    popMatrix();
  }
}
