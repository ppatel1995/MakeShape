public class Triangle implements Shapes
{
  private double a;
  private double b;
  private double c;


  public Triangle()
  {
    a=0;
    b=0;
    c=0;
  }
  // initializes properties for shape if applicacle
  public Triangle(double e , double f, double g) throws Exception
  {
    if((e > 0 && f > 0 && g > 0) && (( e + f ) > g ) && ((e + g) > f) && ((f + g) > e))
    {
      a = e;
      b = f;
      c = g;
    }else{
      throw new Exception("Data is not valid - tried to create Triangle");

    }
  }

  //Getter methods
  public double getA()
  {
    return a;
  }
  public double getB()
  {
    return b;
  }
  public double getC()
  {
    return c;
  }

  //Calculates perimeter using a,b and c
  public double getPerimeter()
  {
    Shapes Triangle = () ->{return a+b+c;};

    return Triangle.getPerimeter();
  }

  // returns objects fields and its perimeter
  public String toString()
  {
      return "Triangle{a=" + a + ", b="+ b  + ", c="+ c + "} "  + getPerimeter();
  }
  //Generates a unique value based up on objects parameters
  public int hashCode()
  {
    int aTri = (int)Math.round(a)*3410;
    int bTri = (int)Math.round(b)*24140;
    int cTri = (int)Math.round(c)*24140;

    return aTri + bTri + cTri + 12;
  }

  // checks if its equal based on defined conditions and returns appropriate boolean
  public boolean equals(Shapes shape)
	{
		if(this == shape)
    {
			return true;
    }
		if(shape == null)
    {
			return false;
    }
		if(!(shape instanceof Triangle))
    {
			return false;
    }
		return a == ((Triangle)shape).getA() && b == ((Triangle)shape).getB() && c == ((Triangle)shape).getC();
	}







}
