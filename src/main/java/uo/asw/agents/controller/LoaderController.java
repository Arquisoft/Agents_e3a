package uo.asw.agents.controller;

import org.springframework.http.ResponseEntity;

import uo.asw.agents.util.LoaderMin;

import java.util.Map;


public interface LoaderController {

	public ResponseEntity<LoaderMin> getLoader(Map<String, Object> payload);
}
