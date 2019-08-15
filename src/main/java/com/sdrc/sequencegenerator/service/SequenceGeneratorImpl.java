package com.sdrc.sequencegenerator.service;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * @author Biswabhusan Pradhan
 */
@Service
public class SequenceGeneratorImpl implements SequenceGenerator {

	private Integer seq=0;
	@Override
	public String getSequence(String anyKey) {
		String finalSequence="";
		// increment the value of seq for each new requests
		if(seq!=0) {
			seq++;
			finalSequence=generateSequence(anyKey, seq);
		}
		/*
		 * when the application get restarted, 
		check db for last inserted sequence, 
		if exists then return it else create new one
		*/
		else {
			/*let's last sequence value from db is this -> 1565851773824-014405860048139596-biswa-14*/			
			String lstInsertedSequence="1565851773824-014405860048139596-biswa-14";
			
			/*when database has no record*/
			if(lstInsertedSequence.equals(null)) {
				seq++;
				finalSequence=generateSequence(anyKey, seq);
			}else {
				seq=Integer.parseInt(lstInsertedSequence.split("-")[3]); 
				finalSequence=generateSequence(anyKey, seq);
			}
		}
		return finalSequence;
	}
	
	private String generateSequence(String anyKey,Integer seq) {
		String sequence="";
		sequence=new Date().getTime()+"-"+Math.random()+"-"+anyKey+"-"+seq;
		sequence=sequence.replace(".", "");
		return sequence;
	}

}
