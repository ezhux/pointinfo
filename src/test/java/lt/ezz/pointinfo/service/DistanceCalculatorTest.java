package lt.ezz.pointinfo.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Collections2;

import lt.ezz.pointinfo.domain.Point;

public class DistanceCalculatorTest {

	@Test
	public void testPrint() {
		double adjacency_matrix[][] = new double [4][4];
		
		adjacency_matrix[1][1] = 0;
		adjacency_matrix[1][2] = 3;
		adjacency_matrix[1][3] = 9;
		
		adjacency_matrix[2][1] = 3;
		adjacency_matrix[2][2] = 0;
		adjacency_matrix[2][3] = 4;

		adjacency_matrix[3][1] = 9;
		adjacency_matrix[3][2] = 4;
		adjacency_matrix[3][3] = 0;
		
		DistanceCalculatorService service = new DistanceCalculatorService();
		service.printDistanceMatrix(adjacency_matrix);
	}
	
	@Test
	public void testEucDistanceCalculator() {
		Point a = new Point(1, 1);
		Point b = new Point(2, 2);
		
		DistanceCalculatorService service = new DistanceCalculatorService();
		double x = service.calculateEuclideanDistance(a, b);
		assertEquals(1.414, x, 0.001);
	}
	
	@Test
	public void testDistanceCalculator() {
		
		Point a = new Point(1,1);
		Point b = new Point(5,4);
		Point c = new Point(3,1);
		
		List<Point> points = Arrays.asList(a, b, c);
		
		DistanceCalculatorService service = new DistanceCalculatorService();
		service.calculateDistances(points);
	}
	
	@Test
	public void testDistanceCalculatorMoreComplex() {
		Point a = new Point(0,0);
		Point b = new Point(1,3);
		Point c = new Point(3,1);
		Point d = new Point(3,3);
		Point e = new Point(5,0);
		Point f = new Point(5,3);
		
		List<Point> points = Arrays.asList(a, b, c, d, e, f);
		
		DistanceCalculatorService service = new DistanceCalculatorService();
		service.calculateDistances(points);
	}
	
	@Test
	public void testPerm() {
		List<Integer> ints = Arrays.asList(1,2,3,4);
		Collection<List<Integer>> x = Collections2.permutations(ints);
		for (Iterator<List<Integer>> it = x.iterator(); it.hasNext();) {
			List<Integer> aa = it.next();
			System.out.println(aa);
		}
	}
	
	@Test
	public void testCalculatedTotalDistance() {
		Point a = new Point(0,0);
		Point b = new Point(1,3);
		Point c = new Point(3,1);
		Point d = new Point(3,3);
		Point e = new Point(5,0);
		Point f = new Point(5,3);
		
		List<Point> points = Arrays.asList(a, b, c, d, e, f);
		DistanceCalculatorService service = new DistanceCalculatorService();
		Collection<List<Point>> permutations = Collections2.permutations(points);
		
		double currentShortestDistance = Double.MAX_VALUE;
		List<Point> currentBestPath = null;
		
		for (Iterator<List<Point>> it = permutations.iterator(); it.hasNext();) {
			List<Point> candidate = it.next();
			double totalDistance = service.calculateTotalDistance(service.calculateDistances(candidate));
			if (totalDistance < currentShortestDistance) {
				currentShortestDistance = totalDistance;
				currentBestPath = candidate;	
			}
			
		}
		System.out.println(currentShortestDistance);
		System.out.println(currentBestPath);
	}
}
