public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV,double yV, double m, String img){
		xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

	}

	public Body(Body b){
		xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		return Math.sqrt(Math.pow(this.xxPos - b.xxPos,2) + Math.pow(this.yyPos - b.yyPos,2));
	}

	public double calcForceExertedBy(Body b){
		return (this.mass * b.mass * (6.67e-11)) / Math.pow(this.calcDistance(b),2);
	}

	public double calcForceExertedByX(Body b){
		return (this.calcForceExertedBy(b) * (b.xxPos - this.xxPos)) / this.calcDistance(b);
	}

	public double calcForceExertedByY(Body b){
		return (this.calcForceExertedBy(b) * (b.yyPos - this.yyPos)) / this.calcDistance(b);
	}

	public double calcNetForceExertedByX(Body[] allBodys){
		double sum = 0;
		for(int i = 0; i < allBodys.length; i++){
			if(this.equals(allBodys[i]) == true){
				continue;
			}
			sum = sum + this.calcForceExertedByX(allBodys[i]);
		} 
		return sum;
	}

	public double calcNetForceExertedByY(Body[] allBodys){
		double sum = 0;
		for(int i = 0; i < allBodys.length; i++){
			if(this.equals(allBodys[i]) == true){
				continue;
			}
			sum = sum + this.calcForceExertedByY(allBodys[i]);
		} 
		return sum;
	}

	public void update(double dt, double fX, double fY){
		double a_netx = fX / this.mass;
		double a_nety = fY / this.mass;
		this.xxVel = this.xxVel + (dt * a_netx);
		this.yyVel = this.yyVel + (dt * a_nety);
		this.xxPos = this.xxPos + (dt * this.xxVel);
		this.yyPos = this.yyPos + (dt * this.yyVel);
	}




}