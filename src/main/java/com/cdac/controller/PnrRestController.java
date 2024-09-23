package com.cdac.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Passenger;
import com.cdac.entity.Passenger.Gender;
import com.cdac.entity.Passenger.Status;
import com.cdac.entity.Pnr;

@RestController
@CrossOrigin
public class PnrRestController {

	@GetMapping("/pnr_stat")
	public Pnr pnrStatus(@RequestParam int pnrNo) {

		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(4563);
		pnr.setTravelDate(LocalDateTime.now());

		Passenger p1 = new Passenger();
		p1.setName("Ritika");
		p1.setGender(Gender.FEMALE);
		p1.setStatus(Status.CONFIRMED);
		Passenger p2 = new Passenger();
		p1.setName("Resma");
		p1.setGender(Gender.FEMALE);
		p1.setStatus(Status.RAC);

		List<Passenger> list = new ArrayList<Passenger>();
		list.add(p1);
		list.add(p2);
		//System.out.println(p1.getName());
		for( Passenger item : list ) {
			/*StringBuilder sb = new StringBuilder();
			sb.append(item.getName());
			sb.append(item.getGender());
			sb.append(item.getStatus());
			String result = sb.toString();
			System.out.println(result);*/
			String result = item.toString();
			System.out.println(result);
		}
		//System.out.println(list);

		pnr.setPassenger(list);

		return pnr;
	}

}
