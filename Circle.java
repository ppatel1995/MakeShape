import java.lang.Math;

public class Circle implements Shapes
{
  private double radius;


  // initializes properties for shape if applicacle
  public Circle(double d) throws Exception
  {
    if( d > 0)
    {
      radius = d;
    }else{
      throw new Exception("Data is not valid - tried to create Circle");
    }

  }

  public Circle()
  {
    radius = 0;
  }

  // returns objects field and its perimeter
  public String toString()
  {
    return "Circle{r=" + radius + "} " + getPerimeter();
  }

  //Calculates perimeter using radius
  public double getPerimeter()
  {
    Shapes Circle = () ->{return Math.PI*2.0*radius;};

    return Circle.getPerimeter();
  }

  //Generates a unique value based up on objects parameters
  public int hashCode()
  {
    int r = (int)Math.round(radius)*3410/1424;
    return r + 12;
  }

  // checks if its equal based on defined conditions and returns appropriate boolean
  public boolean equals(Shapes shape)
  {
    if(this == shape)
			return true;
		if(shape == null)
			return false;
		if(!(shape instanceof Circle))
			return false;
		return radius == ((Circle)shape).getRadius();
  }
  //gets radius
  public double getRadius()
  {
    return radius;
  }



}
