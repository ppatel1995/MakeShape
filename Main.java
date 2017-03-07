/*
*************************************
Name: Parthkumar Patel
Student ID: 123183154
codeboard Username: ppatel221
*************************************
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Iterator;
import java.text.DecimalFormat;

public class Main
{
  public static void main(String[] args) throws Exception {
    System.out.println("---------Java Assignment 1 - Parthkumar Patel-------------\n");

    System.out.println("------------------------Task 1----------------------------\n");

    Shapes[] t = buildShapesFromFile("shapes.txt");
    System.out.println("   ");


    for(int i=0; i < t.length ; i++)
    {
      if(t[i] != null)
      {
        System.out.println( t[i].toString());
      }
    }

    System.out.println("\n");
    System.out.println("------------------------Task 2----------------------------\n");

    double maxPara = 0;
    int index = 0;

    for(int i=1; i < t.length ; i++)
    {
      if(t[i] instanceof Circle)
      {
        if(t[i].getPerimeter() > maxPara)
        {
          maxPara = t[i].getPerimeter();
          index = i;

        }

      }
    }

    for(int i =0; i < t.length ; i++)
    {
      if(t[i] instanceof Circle && t[i].getPerimeter() == maxPara)
      {
        t[i] = null;
      }
    }

    double findMax = 0;
    double minPara = 0;
    index = 0;

    double [] minParas= null;

    // fetches the maximum Perimeter of Triangle
    for(int i=0; i < t.length ; i++)
    {
      if(t[i] instanceof Triangle)
      {

        if(t[i].getPerimeter() >= findMax)
        {
            findMax = t[i].getPerimeter();
            index = i;
        }
      }
    }
    /*Uses the largest Triangles perimeter index value to use it as comparison to find its lowest triangle perimeter index value*/
    minPara = t[index].getPerimeter();
    int [] delete = new int[50];
    for(int i=1; i < t.length ; i++)
    {
      if(t[i] instanceof Triangle)
      {
        if(t[i].getPerimeter() <= minPara)
        {
          minPara = t[i].getPerimeter();
          index = i;
        }
      }
    }

    /*deletes alls  of Triangles with minimum paramter value fetched*/
    for(int i =0; i < t.length ; i++)
    {
      if(t[i] instanceof Triangle && t[i].getPerimeter() == minPara)
      {
        t[i]=null;
      }
    }

    for(int i=0; i < t.length ; i++)
    {
      if(t[i] != null)
        System.out.println( t[i]);

    }

    System.out.println("\n");
    //Adds All perimeters of specified Shape types and prints the value
    System.out.println("------------------------Task 3----------------------------\n");


    double totalp = 0;

    for(int p = 0 ; p < t.length ; p++)
    {
      if(t[p] instanceof Parallelogram)
      {
        totalp = totalp + t[p].getPerimeter();

      }
    }
    DecimalFormat twoD = new DecimalFormat("0.00");



    System.out.println("Total Perimeter of Parallelograms is : " + twoD.format(totalp));

    double totalt = 0;
    for(int m = 0 ; m < t.length ; m++)
    {
      if(t[m] instanceof Triangle)
      {
        totalt = totalt + t[m].getPerimeter();
      }
    }

    System.out.println("Total Perimeter of Triangles is : " + twoD.format(totalt));
    System.out.println("\n");

    System.out.println("------------------------Task 4----------------------------\n");

    /* Converted t to an arraylist and stored all objects from t to an array list shp
    and sorted the arraylist using a comparator.*/

      List<Shapes> shp = new ArrayList<Shapes>(Arrays.asList(t));


      Iterator<Shapes>  it = shp.iterator();
      int o = 0;
      while(it.hasNext())
      {
        if(it.next() == null)
        {
          it.remove();
        }
      }




      Comparator<Shapes> comparator = Comparator.comparing(gt -> gt.getClass().getSimpleName());
      comparator = comparator.thenComparing(Comparator.comparing(gt -> gt.getPerimeter()));

      Stream<Shapes> streamS = shp.stream().sorted(comparator);

      List<Shapes> sortedS = streamS.collect(Collectors.toList());


      for(Shapes r : sortedS)
      {
        if(r != null)
        {
          System.out.println(r);
        }
      }



    }

  /*Function reads the input file and creates a type of shape defined in the input file*/
  public  static Shapes[] buildShapesFromFile(String filename) throws Exception
  {

    BufferedReader readern = new BufferedReader(new FileReader("/Users/parth/Desktop/java/shapes.txt"));
    int lines = 0;
    while (readern.readLine() != null)
    lines++;
    readern.close();

    Shapes[] sp =  new Shapes[lines];


    String s;
    String test;

    //until the end of file is reached, It reads each line and creates shapes based on input value recieved
    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/parth/Desktop/java/shapes.txt")) )
    {
      int i = 0;


        while((s = reader.readLine()) != null)
        {
          String[] tok = s.split(",");


          if(tok[0].equals("Square"))
          {
            String[] sq;

            sq = s.split(",");

              double len = Double.parseDouble(sq[1]);

                try{
                sp[i] = new Square(len);
              }catch(Exception e)
              {
                System.out.println(e.getMessage());
              }

          }else if(tok[0].equals("Circle"))
          {


            String[] circ;

            circ = s.split(",");
            double d = Double.parseDouble(circ[1]);

            try
            {
              sp[i] = new Circle(d);

            }catch( Exception e)
            {
              System.out.println(e.getMessage());

            }

          }
          else if(tok[0].equals("Triangle"))
          {

            String[] tri;
            tri = s.split(",");
            double e = Double.parseDouble(tri[1]);
            double f = Double.parseDouble(tri[2]);
            double g = Double.parseDouble(tri[3]);

            try
            {
              sp[i] = new Triangle(e,f,g);
            }catch(Exception t)
            {
              System.out.println(t.getMessage());
            }


          }
          else if(tok[0].equals("Parallelogram"))
          {
            String[] para;
            para = s.split(",");
            double a = Double.parseDouble(para[1]);
            double b = Double.parseDouble(para[2]);
            try
            {
              sp[i] = new Parallelogram(a,b);
            }catch(Exception p)
            {
              System.out.println(p.getMessage());
            }
          }else if(tok[0].equals("Rectangle"))
          {
            String[] rec;
            rec = s.split(",");
            double l = Double.parseDouble(rec[1]);
            double w = Double.parseDouble(rec[2]);

            try
            {
              sp[i] = new Rectangle(l,w);
            }catch(Exception r)
            {
              System.out.println(r.getMessage());
            }

          }
          i++;
        }
    } catch (IOException e)
    {
        System.out.println("error");
    }



        return sp;
    }

}
