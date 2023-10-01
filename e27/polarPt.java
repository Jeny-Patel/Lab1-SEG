public class polarPt extends abstractPt {
    private double rho;
    private double theta;
    
    public polarPt(double rho, double theta){
        this.rho=rho;
        this.theta=theta;
    }

    public double getRho(){
        return rho;
    }

    public double getTheta(){
        return theta;
    }

    public void setTheta(double theta){
        this.theta=theta;
    }
    
    public void setRho(double rho){
        this.rho=rho;
    }

    public Object compute(){
        cartesianPt point = new cartesianPt((Math.cos(Math.toRadians(theta)) * rho),(Math.sin(Math.toRadians(theta)) * rho));
        return point;
    }

    public double getDistance(Object point){
        cartesianPt pt = (cartesianPt) compute();
        cartesianPt pointC= (cartesianPt) point;
        double deltaX = pt.getX() - pointC.getX();
        double deltaY = pt.getY() - pointC.getY();
    
        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public cartesianPt rotatePoint(double rotation){
        cartesianPt pt = (cartesianPt) compute();
        double radRotation = Math.toRadians(rotation);
    double X = pt.getX();
    double Y = pt.getY();
        
    return new cartesianPt((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString()
  {
    return "rho: "+ rho + " theta: "+ theta;
  }
}
