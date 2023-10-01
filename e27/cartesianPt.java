public class cartesianPt extends abstractPt{
    private double x;
    private double y;
    
    public cartesianPt(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x=x;
    }
    
    public void setY(double y){
        this.y=y;
    }

    public Object compute(){
        polarPt point = new polarPt((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))),Math.toDegrees(Math.atan2(y, x)));
        return point;
    }

    public double getDistance(Object point){
        cartesianPt pointC= (cartesianPt) point;
        double deltaX = this.getX() - pointC.getX();
        double deltaY = this.getY() - pointC.getY();
    
        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public cartesianPt rotatePoint(double rotation){
        
        double radRotation = Math.toRadians(rotation);
        double X = this.getX();
        double Y = this.getY();
        
        return new cartesianPt((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString()
  {
    return "X: "+ x + " Y: "+ y;
  }
}
