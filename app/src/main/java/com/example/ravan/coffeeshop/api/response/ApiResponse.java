package com.example.ravan.coffeeshop.api.response;

import java.util.List;
import javax.annotation.Generated;

import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ApiResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private List<CoffeeEntity> message;

	public int getCode(){
		return code;
	}

	public List<CoffeeEntity> getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ApiResponse{" + 
			"code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}