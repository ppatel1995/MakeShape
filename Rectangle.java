public class Rectangle implements Shapes
{
  private double length;
  private double width;
  // initializes properties for shape if applicacle
  public Rectangle(double l, double w)throws Exception{

    if( l > 0 && w > 0)
    {
      length = l;
      width = w;
    }else
    {
      throw new Exception("Data is not valid - tried to create Rectangle");

    }

  }


  public Rectangle()
  {
    length = 0;
    width = 0;
  }

  //Calculates perimeter using length and width
  public double getPerimeter()
  {
    Shapes Rectangle = () ->{return length*2 + width*2;};

    return Rectangle.getPerimeter();

  }
  // returns objects fields and its perimeter
  public String toString()
  {
    return "Rectangle{l=" + length + ", w="+ width  + "} " + getPerimeter();
  }

  //Generates a unique value based up on objects parameters
  public int hashCode()
  {
    int l = (int)Math.round(length)*3410;
    int w = (int)Math.round(width)*24140;



    return l + w + 12;
  }

  // Getter methods
  public double getLength()
  {
    return length;
  }
  public double getWidth()
  {
    return width;
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
		if(!(shape instanceof Rectangle))
    {
			return false;
    }

		return length == ((Rectangle)shape).getLength() && width == ((Rectangle)shape).getWidth();
  }

}
