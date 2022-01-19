package com.myapp.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myapp.api.entities.nosql.Details;
import com.myapp.api.entities.sql.Product;
import com.myapp.api.mappers.EntityToModel;
import com.myapp.api.mappers.ModelToEntity;
import com.myapp.api.model.DetailsModel;
import com.myapp.api.model.ProductModel;
import com.myapp.api.repository.nosql.TechnologyRepository;
import com.myapp.api.repository.sql.IUserRepository;

@Service
public class BaseService {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	/**
	 * This methods saves data processing the Model
	 * @param infoModel
	 * @return
	 */
	public ProductModel createUser(ProductModel infoModel) {
		// User save logic in MySQL Db
		Product product = new Product();
		product.setofc_code(infoModel.getofc_code());
		product.setsku_code(infoModel.getsku_code());
		product = userRepository.save(product);
		infoModel.setstore_sku_id(product.getId());
		if(!CollectionUtils.isEmpty(infoModel.getdetails())) {
		 infoModel.setdetails(insertDetails(infoModel.getdetails(), infoModel.getstore_sku_id()));	
		}
		return infoModel;
	}
	private List<DetailsModel> insertDetails(List<DetailsModel> objects, Integer id) {
		List<DetailsModel> detailModels = new ArrayList<>();
		List<Details> details = ModelToEntity.convertTechnologyModelsToTechnologies(objects,id);
		details = technologyRepository.saveAll(details);
		detailModels = EntityToModel.convertTechnologiesToTechnologyModels(details);
		return detailModels;
	}

	
	/**
	 * This methods reads data processing the entities
	 * @param infoModel
	 */
	public List<ProductModel> getUsersList(){
		List<ProductModel> userInfoModels = new ArrayList<ProductModel>();
		// Retrieving List of Users from MySQL Database
		List<Product> users = userRepository.findAll();
		if(!CollectionUtils.isEmpty(users)) {
			users.stream().forEach(item->{
				ProductModel uModel = new ProductModel();
				uModel.setstore_sku_id(item.getId());
				uModel.setsku_code(item.getsku_code());
				uModel.setofc_code(item.getofc_code());
				// Retrieving List of Technologies from MongoDB Database
				List<Details> technologies = technologyRepository.findByUserId(item.getId());
				if(!CollectionUtils.isEmpty(technologies)) {
					uModel.setdetails(EntityToModel.convertTechnologiesToTechnologyModels(technologies));
				}
				userInfoModels.add(uModel);
			});
		}
		return userInfoModels;
	}

}
