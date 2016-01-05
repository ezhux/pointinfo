package lt.ezz.pointinfo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ezz.pointinfo.domain.Point;

@Service
public class PointInfoService {

	@Autowired
	DistanceCalculatorService distanceCalculatorService;
	
	Map<Integer, Point> pointMap = new HashMap<Integer, Point>();
	
	public void addPoint(List<Point> points) {
		for (int i = 0; i < points.size(); i++) {
			pointMap.put(pointMap.size()+1, points.get(i));
		}
	}
	
	public void removePoint(Integer pointId) throws Exception {
		if (pointMap.get(pointId) == null) {
			throw new Exception("no point with this id"); 
		}
		pointMap.remove(pointId);
	}
	
	public Map<Integer, Point> getAllPoints() {
		return pointMap;
	}
	
	public List<Point> findShortestPath() {
		List<Point> points = new ArrayList<Point>(pointMap.values());
		return distanceCalculatorService.findShortestPermutation(points);
	}
	
}
