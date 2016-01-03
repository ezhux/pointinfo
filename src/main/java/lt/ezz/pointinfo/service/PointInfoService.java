package lt.ezz.pointinfo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lt.ezz.pointinfo.domain.Point;

@Service
public class PointInfoService {

	Map<Integer, Point> pointMap = new HashMap<Integer, Point>();
	
	public void addPoint(Point point) {
		pointMap.put(pointMap.size()+1, point);
	}
	
	public void removePoint(Integer pointId) {
		pointMap.remove(pointId);
	}
	
	public Map<Integer, Point> getAllPoints() {
		return pointMap;
	}
	
}
