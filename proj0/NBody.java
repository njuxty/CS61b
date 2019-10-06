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

		Planet[] planets = readPlanets(filename);
		Double universeRadius = readRadius(filename);

		/* Draw the background. */
		StdDraw.setScale(-universeRadius, universeRadius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg", 
			2 * universeRadius, 2 * universeRadius);
		planets[1].draw();

		int len = planets.length;
		for (int i = 0; i < len; i++) {
			planets[i].draw();
		}

		StdDraw.show();
		StdDraw.pause(2000);

	}
}