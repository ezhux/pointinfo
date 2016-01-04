package lt.ezz.pointinfo.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Collections2;

import lt.ezz.pointinfo.domain.Point;

@Service
public class DistanceCalculatorService {

	public double[][] calculateDistances(List<Point> points) {

		double distances[][] = new double[points.size() + 1][points.size() + 1];

		for (int i = 0; i < points.size(); i++) {
			Point a = points.get(i);

			for (int j = 0; j < points.size(); j++) {
				Point b = points.get(j);

				double distance = calculateEuclideanDistance(a, b);
				distances[j + 1][i + 1] = distance;
			}
		}
		printDistanceMatrix(distances);
		return distances;
	}

	public double calculateEuclideanDistance(Point a, Point b) {
		if (a.equals(b))
			return 0;

		return Math.sqrt(Math.pow(b.getCoordinateX() - a.getCoordinateX(), 2)
				+ Math.pow(b.getCoordinateY() - a.getCoordinateY(), 2));

	}

	public double calculateTotalDistance(double distances[][]) {
		double totalDistance = 0;

		for (int i = 1; i < distances.length-1; i++) {
			totalDistance += distances[i][i + 1];
		}
		return totalDistance;
	}
	
	public List<Point> findShortestPermutation(List<Point> points) {

		Collection<List<Point>> permutations = Collections2.permutations(points);
		
		double currentShortestDistance = Double.MAX_VALUE;
		List<Point> currentBestPath = null;
		
		for (Iterator<List<Point>> it = permutations.iterator(); it.hasNext();) {
			List<Point> candidate = it.next();
			double totalDistance = calculateTotalDistance(calculateDistances(candidate));
			if (totalDistance < currentShortestDistance) {
				currentShortestDistance = totalDistance;
				currentBestPath = candidate;	
			}
		}
		return currentBestPath;
	}


	public void printDistanceMatrix(double distances[][]) {
		for (int x = 1; x < distances.length; x++) {
			for (int y = 1; y < distances.length; y++) {
				System.out.print(String.format("%.1f", distances[x][y]) + " ");
			}
			System.out.println("");
		}
	}
}
