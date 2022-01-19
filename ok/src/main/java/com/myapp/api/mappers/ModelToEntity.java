package com.myapp.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.myapp.api.entities.nosql.Details;
import com.myapp.api.model.DetailsModel;

/**
 * 
 * ModelToEntity converts Models to Entities
 *
 */
public class ModelToEntity {
	
	public static List<Details> convertTechnologyModelsToTechnologies
	(List<DetailsModel> objects,int userId) {
		List<Details> details = new ArrayList<>();
		objects.stream().forEach(item->{
			Details detail = new Details();
			detail.setUserId(item.getstore_sku_id());
			detail.setdata(item.getprice());
			details.add(detail);
		});
		return details;
	}
}
