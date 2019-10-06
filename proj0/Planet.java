public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67 * Math.pow(10, -11);

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
	/* Calculate the distance between this and p. */
		return (Math.sqrt((this.xxPos - p.xxPos) * 
			(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * 
			(this.yyPos - p.yyPos)));
	}

	public double calcForceExertedBy(Planet p) {
	/* Calculate the force exerted on this planet 
	by the given planet. */
		double r = this.calcDistance(p);
		return (G * this.mass * p.mass / (r * r));
	}

	public double calcForceExertedByX(Planet p) {
	/* Calculate the force exerted on this planet in the X 
	by the given planet. */
		double force = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		return (force * (p.xxPos - this.xxPos) / r);
	}

	public double calcForceExertedByY(Planet p) {
	/* Calculate the force exerted on this planet in the Y 
	by the given planet. */
		double force = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		return (force * (p.yyPos - this.yyPos) / r);
	}

	public double calcNetForceExertedByX(Planet[] planets) {
	/* Calculate the net X force exerted by all planets 
	in that array upon the current Planet. */
		double netForceX = 0;
		int len = planets.length;
		for(int i = 0; i < len; i++) {
			if(this.equals(planets[i]) != true) {
				netForceX = netForceX + 
				this.calcForceExertedByX(planets[i]);
			}
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Planet[] planets) {
	/* Calculate the net Y force exerted by all planets 
	in that array upon the current Planet. */
		double netForceY = 0;
		int len = planets.length;	
		for(int i = 0; i < len; i++) {
			if(this.equals(planets[i]) != true) {
				netForceY = netForceY + 
				this.calcForceExertedByY(planets[i]);
			}
		}
		return netForceY;
	}

	public double update(double dt, double fX, double fY) {
	/* Update the planet’s position and velocity
	 instance variables. */
		double acceX = fX / this.mass;
		double acceY = fY / this.mass;
		this.xxVel = this.xxVel + acceX * dt;
		this.yyVel = this.yyVel + acceY * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
		return 0;
	}

	public void draw() {
	/* Draw the planet. */
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

}