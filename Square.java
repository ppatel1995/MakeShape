
public class Square implements Shapes
{
  private double length;


  public Square()
  {
    length = 0;
  }
  // initializes properties for shape if applicacle
  public Square(double l) throws Exception
  {
    if(l > 0)
    {
      length = l;
    }else{
      throw new Exception("Data is not valid - tried to create Square");
    }
  }
  // returns objects field and its perimeter
  public String toString()
  {
    return "Square{l="+ length + "} " + getPerimeter();
  }

  //Calculates perimeter using length
  public double getPerimeter()
  {
    Shapes Square = () ->{return 4*length;};

    return Square.getPerimeter();
  }


  //Generates a unique value based up on objects parameters
  public int hashCode()
  {
    int l = (int)Math.round(length)*3410/1424;


    return l + 12;
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
		if(!(shape instanceof Square))
    {
			return false;
    }
		return length == ((Square)shape).getLength();
	}
  //gets length
  public double getLength()
	{
		return length;
	}



}
