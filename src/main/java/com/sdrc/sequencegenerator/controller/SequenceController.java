package com.sdrc.sequencegenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdrc.sequencegenerator.service.SequenceGenerator;

/**
 * @author Biswabhusan Pradhan
 */
@RestController
public class SequenceController {
	
	@Autowired
	private SequenceGenerator sequenceGenerator;
	@GetMapping("getSequence")
	public String getSequence(@RequestParam("anyKey") String anyKey) {
		return sequenceGenerator.getSequence(anyKey);
	}
}
