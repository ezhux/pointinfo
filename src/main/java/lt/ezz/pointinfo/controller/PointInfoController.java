package lt.ezz.pointinfo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.ezz.pointinfo.domain.Point;
import lt.ezz.pointinfo.service.PointInfoService;

@RequestMapping(value = "/")
@RestController
public class PointInfoController {

	Logger log = LoggerFactory.getLogger(PointInfoController.class);
	
	@Autowired
	PointInfoService pointInfoService;

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String testApp() throws Exception{
	    return "pointinfo index";
	}
	
	@RequestMapping(value = "/point/add", method = RequestMethod.PUT)
	public ResponseEntity<Void> addPoint(@RequestBody Point point) {

		log.info("Adding new point to the list: " + point.toString());
		
		pointInfoService.addPoint(point);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/point/getall", method = RequestMethod.GET)
	public ResponseEntity<Map<Integer, Point>> getAllPoints() {
		Map<Integer, Point> allPoints = pointInfoService.getAllPoints();
		return new ResponseEntity<Map<Integer, Point>>(allPoints, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/point/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<Integer, Point>> deletePoint(@PathVariable("id") int id) {
		
		log.info("Removing point from the list: " + id);
		
		pointInfoService.removePoint(id);
		return new ResponseEntity<Map<Integer, Point>>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/point/getpath", method = RequestMethod.GET)
	public ResponseEntity<List<Point>> getShortestPath() {
		return null;
	}
	
}
