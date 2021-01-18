import edu.duke.*;
public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerimeter = 0.0;
        Point previousPoint = s.getLastPoint();
       // System.out.println(prevPt);
        for (Point currentPoint : s.getPoints()) {
            double currentDist = previousPoint.distance(currentPoint);
            totalPerimeter = totalPerimeter + currentDist;
            previousPoint = currentPoint;
        }
        return totalPerimeter;
    }

    public int getNumPoints (Shape s)
    {
        int numOfPoints = 0;
        for(Point p : s.getPoints()){
            numOfPoints++;
        }
        return numOfPoints;
    }

    public double getAverageLength(Shape s)
    {
        double perimeter = getPerimeter(s);
        double numOfSides = getNumPoints(s);
        double avgLength;
        avgLength = perimeter / numOfSides;
        return avgLength;
    }

    public double getLargestSide(Shape s)
    {
        double longestSide = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist>longestSide)
                longestSide = currDist;
            prevPt = currPt;
        }
        return longestSide;
    }

    public double getLargestX(Shape s) {
        Point lastPoint = s.getLastPoint();
        int lastPointX;
        lastPointX = lastPoint.getX();
        for(Point p : s.getPoints()){
            int newX = p.getX();
            if(newX > lastPointX) {
                lastPointX = newX;
            }
        }
        return lastPointX;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("datatest1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestX = getLargestX(s);
        double largeSide = getLargestSide(s);
            System.out.println("Perimeter: " + length);
            System.out.println("Number of Points: " + numPoints);
            System.out.println("Average Length: " + averageLength);
            System.out.println("Largest X is: " + largestX );
            System.out.println("Longest Side is: " +largeSide);
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}