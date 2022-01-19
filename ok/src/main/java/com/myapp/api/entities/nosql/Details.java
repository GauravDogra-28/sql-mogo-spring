package com.myapp.api.entities.nosql;
import org.springframework.data.annotation.Id;

/**
 * 
 * MongoDB Entity
 *
 */
public class Details {
                                                            
    @Id
    private String id;
    private int userId;

    private String data;
    
    public Details() {}

	public Details(String id, String technologyName,int userId) {
		super();
		this.id = id;
		this.userId = userId;
		this.data = technologyName;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getdata() {
		return data;
	}

	public void setdata(String technologyName) {
		this.data = technologyName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}