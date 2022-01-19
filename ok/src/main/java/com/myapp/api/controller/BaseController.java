package com.myapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.api.model.ProductModel;
import com.myapp.api.service.BaseService;

@RestController
@RequestMapping("/api")
public class BaseController {
	
	@Autowired
	BaseService baseService;
	
	/**
	 * This API saves data in both databases
	 * @param infoModel
	 * @return
	 */
	@PostMapping("/users")
	public ResponseEntity<ProductModel> createUser(@RequestBody ProductModel infoModel) {
		return new ResponseEntity<ProductModel>(baseService.createUser(infoModel),HttpStatus.CREATED);
	}
	
	/**
	 * This API reads data from both databases
	 * @return
	 */
	@GetMapping("/users")
	public ResponseEntity<List<ProductModel>> getUsers() {
		List<ProductModel> userInfoModels = baseService.getUsersList();
		if(CollectionUtils.isEmpty(userInfoModels)) {
			return new ResponseEntity<List<ProductModel>>(baseService.getUsersList(),HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ProductModel>>(baseService.getUsersList(),HttpStatus.OK);
		}
	}
	
	

}
