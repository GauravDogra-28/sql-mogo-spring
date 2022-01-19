package com.myapp.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.myapp.api.entities.nosql.Details;
import com.myapp.api.model.DetailsModel;

/**
 * 
 * EntityToModel converts Entities to Models
 *
 */
public class EntityToModel {
	
	public static List<DetailsModel> convertTechnologiesToTechnologyModels(List<Details> details) {
		List<DetailsModel> detailsmodels = new ArrayList<DetailsModel>();
		details.forEach(item->{
			DetailsModel detailsmodel = new DetailsModel();
			detailsmodel.setstore_sku_id(item.getUserId());
			detailsmodel.setprice(item.getdata());
			detailsmodels.add(detailsmodel);
		});
		return detailsmodels;
	}

}
