package com.cdac.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Passenger;
import com.cdac.entity.Passenger.Gender;
import com.cdac.entity.Passenger.Status;
import com.cdac.entity.Pnr;
 //Assume: we are working for irctc / indian railways
//@RestController
@Controller
public class PnrController {
	
	@RequestMapping("/pnrData")
	public String pnrData() {
		return "pnr";
	}
	
	
	@GetMapping("/pnr-status")
	public String ckeckStatus(@RequestParam int pnrNo, Map map) {
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(1452);
		pnr.setTravelDate(LocalDateTime.now());
		
		Passenger p1= new Passenger();
		 p1.setName("Tushar");
		 p1.setGender(Gender.MALE);
		 p1.setStatus(Status.RAC);
		 Passenger p2= new Passenger();
		 p2.setName("Miraj");
		 p2.setGender(Gender.MALE);
		 p2.setStatus(Status.RAC);
		 
		// List list = new ArrayList();
		 
		 List<Passenger> passengers = new ArrayList<Passenger>();
		 passengers.add(p1);
		 passengers.add(p2);
		pnr.setPassenger(passengers);
		map.put("pnrData", pnr);
		map.put("passData", p1);
		map.put("passData2", p2);
		
		
		return "trainStatus";
		
	}

}
