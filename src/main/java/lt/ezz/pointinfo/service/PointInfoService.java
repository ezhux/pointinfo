package lt.ezz.pointinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lt.ezz.pointinfo.domain.Point;

@Service
public class PointInfoService {

	List<Point> pointList = new ArrayList<Point>();
	
	
	public void addPoint(Point point) {
		pointList.add(point);
	}
	
	public void removePoint(Point point) {
		pointList.remove(0);
	}
	
	public List<Point> getAllPoints() {
		return pointList;
	}
	
}
