package lt.ezz.pointinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.ezz.pointinfo.domain.Point;
import lt.ezz.pointinfo.service.PointInfoService;

@RequestMapping(value = "/")
@RestController
public class PointInfoController {

	@Autowired
	PointInfoService pointInfoService;

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String testApp() throws Exception{
	    return "pointinfo index";
	}
	
	@RequestMapping(value = "/point/add", method = RequestMethod.PUT)
	public ResponseEntity<Void> addPoint(@RequestBody Point point) {
		pointInfoService.addPoint(point);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/point/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Point>> getAllPoints() {
		List<Point> x = pointInfoService.getAllPoints();
		return new ResponseEntity<List<Point>>(x, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/point/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePoint() {
		return null;
	}
	
	@RequestMapping(value = "/point/getpath", method = RequestMethod.GET)
	public ResponseEntity<List<Point>> getShortestPath() {
		return null;
	}
	
}
