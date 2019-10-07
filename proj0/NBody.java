public class NBody {
/* Run the simulation. */
	public static double readRadius(String string) {
	/* Return a double corresponding 
	to the radius of the universe in that file. */
		In in = new In(string);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	public static Planet[] readPlanets(String string) {
	/* Return  an array of Planets 
	corresponding to the planets in the file. */
		In in = new In(string);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();

		Planet[] planets = new Planet[firstItemInFile];
		for (int i = 0; i < firstItemInFile; i++) {
			double firstPara = in.readDouble();
			double secondPara = in.readDouble();
			double thirdPara = in.readDouble();
			double fourthPara = in.readDouble();
			double fifthPara = in.readDouble();
			String sixthPara = in.readString();
			planets[i] = new Planet(firstPara, secondPara, thirdPara, 
				fourthPara, fifthPara, sixthPara);
		}

		return planets;
	}

	public static void main(String[] args) {
		double T = Double.valueOf(args[0]);
		double dT = Double.valueOf(args[1]);
		String filename = args[2];
		double time = 0;

		Planet[] planets = readPlanets(filename);
		Double universeRadius = readRadius(filename);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-universeRadius, universeRadius);

		while (time <= T) {
			int len = planets.length;
			double[] xForces = new double[len];
			double[] yForces = new double[len];
			for (int j = 0; j < len; j++) {
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
			}

			for (int k = 0; k < len; k++) {
				planets[k].update(dT, xForces[k], yForces[k]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg", 
				2 * universeRadius, 2 * universeRadius);
			planets[1].draw();

			
			for (int i = 0; i < len; i++) {
				planets[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

			time = time + dT;
		}

	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", universeRadius);
	for (int i = 0; i < planets.length; i++) {
		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

	}
}