package lt.ezz.pointinfo.service;

import java.util.List;

import lt.ezz.pointinfo.domain.Point;

public class DistanceCalculatorService {

	public void calculateDistances(List<Point> points) {

		double distances[][] = new double[points.size()+1][points.size()+1];
		
		for (int i = 0; i < points.size(); i++) {
			Point a = points.get(i);
			
			for (int j = 0; j < points.size(); j++) {
				Point b = points.get(j);
				
				double distance = calculateEuclideanDistance(a, b);
				distances[j+1][i+1] = distance;
			}
		}

		printDistanceMatrix(distances);
		
	}

	public void printDistanceMatrix(double distances[][]) {
		for (int x = 1; x < distances.length; x++) {
			for (int y = 1; y < distances.length; y++) {
				System.out.print((int) distances[x][y] + " ");
			}
			System.out.println("");
		}
	}
	
	public double calculateEuclideanDistance(Point a, Point b) {
		
		if (a.equals(b))
			return 0; 
		
		return Math.sqrt( Math.pow (b.getCoordinateX() - a.getCoordinateX(),2 ) + Math.pow( b.getCoordinateY() - a.getCoordinateY() ,2) );

	}
}
