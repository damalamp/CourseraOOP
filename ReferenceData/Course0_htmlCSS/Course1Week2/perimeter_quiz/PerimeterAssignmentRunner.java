package perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        int pointcounter = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            pointcounter++;
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            //System.out.println("dist btwn pt " + (pointcounter-1));
            //System.out.println("and pt " + pointcounter);
            //System.out.println("is: " +  prevPt.distance(currPt));
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point p : s.getPoints()){
            numPoints++;
        }
        return (numPoints);
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double length = 0;
        double largestSide = 0;
        Point prevPt = s.getLastPoint();           
        for (Point currPt : s.getPoints()) {
            length = prevPt.distance(currPt);
            prevPt = currPt;
            // Find distance from prevPt point to currPt 
            if (largestSide < length){
                //System.out.println("found a new longest: " + length);
                largestSide = length;
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int maxX = s.getLastPoint().getX();
        int currentMaxX;
        for (Point currPt : s.getPoints()) {
            currentMaxX = currPt.getX();
            if (currentMaxX > maxX){
                maxX = currentMaxX;
            }
        }
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0;
        int counter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > largestPerim){
                largestPerim = getPerimeter(s);
                temp = f;
            }
        }
        System.out.println("largest parim file's name: " + temp.getName());
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + getNumPoints(s));
        System.out.println("average length = " + getAverageLength(s));
        System.out.println("largest side = " + getLargestSide(s));
        System.out.println("max x = " + getLargestX(s));        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0;
        int counter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > largestPerim){
                largestPerim = getPerimeter(s);
                
            }
            counter++;
            double length = getPerimeter(s);
            System.out.println("File Count = " + counter);                        
            System.out.println("perimeter = " + length);
            System.out.println("number of points = " + getNumPoints(s));
            System.out.println("average length = " + getAverageLength(s));
            System.out.println("largest side = " + getLargestSide(s));
            System.out.println("max x = " + getLargestX(s));
        }
        System.out.println("largest perim = " + largestPerim);
    }
    
    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        //pr.getFileWithLargestPerimeter();
    }
}
