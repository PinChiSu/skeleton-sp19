public class NBody{
	public static double readRadius(String filename){
		In in = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();
		return r;
	}

	public static Body[] readBodies(String filename){
		In in = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();
		Body[] b = new Body[n];
		for(int i = 0; i < n; i++){
			b[i] = new Body(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}
		return b;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = NBody.readRadius(filename);
		Body[] b = NBody.readBodies(filename);
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-3e+11, 3e+11);
		StdDraw.clear();
		//StdDraw.pause(2000);
		
		//time loop
		double[] xForces = new double[b.length];
		double[] yForces = new double[b.length];
		for(double time = 0; time < T; time = time +dt){
			//Calculate the net x and y forces for each Body
			for(int i = 0; i < b.length; i++){
				xForces[i] = b[i].calcNetForceExertedByX(b);
				yForces[i] = b[i].calcNetForceExertedByY(b);
			}

			//update Bodies
			for(int i = 0; i < b.length; i++){
				b[i].update(dt,xForces[i],yForces[i]);
			}

			//draw the background
			StdDraw.picture(0, 0,"images/starfield.jpg");

			//draw NBodies
			for(int i = 0; i < b.length; i++){
				b[i].draw(); 
			}

			StdDraw.show();
			StdDraw.pause(10);

		}

		StdOut.printf("%d\n", b.length);
        StdOut.printf("%.2e\n", r);

        for (int i = 0; i < b.length; i++) {
        	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            b[i].xxPos, b[i].yyPos, b[i].xxVel,
            b[i].yyVel, b[i].mass, b[i].imgFileName);   
        }

	}
}