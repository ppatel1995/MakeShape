public class Parallelogram implements Shapes
{
  private double length;
  private double height;

  // initializes properties for shape if applicacle
  public Parallelogram(double l,double h) throws Exception
  {
    if(l>0 && h > 0)
    {
      length = l;
      height = h;
    }else{
      throw new Exception("Data is not valid - tried to create Parallelogram");

    }
  }
  //calculates perimeter
  public double getPerimeter()
  {
    Shapes Parallelogram = () ->{return 2*length + 2*height;};

    return Parallelogram.getPerimeter();

  }

  // returns objects fields and its perimeter
  public String toString()
  {
    return "Parallelogram{l=" + length + ", h="+ height  + "} " + getPerimeter();
  }


  //getter methods
  public double getLength()
  {
    return length;
  }
  public double getHeight()
  {
    return height;
  }

  //Generates a unique value based up on objects parameters
  public int hashCode()
  {
    int l = (int)Math.round(length)*3410;
    int h = (int)Math.round(height)*24110/4;

    return l + h + 12;

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
    if(!(shape instanceof Parallelogram))
    {
      return false;
    }

    return length == ((Parallelogram)shape).getLength() && height == ((Parallelogram)shape).getHeight();

  }


}
