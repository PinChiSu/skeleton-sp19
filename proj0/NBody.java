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
}