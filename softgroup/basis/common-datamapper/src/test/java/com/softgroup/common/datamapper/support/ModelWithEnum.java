package com.softgroup.common.datamapper.support;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author odin
 * @since 15.02.17.
 */
public class ModelWithEnum {

	private String name;

	private ModelType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModelType getType() {
		return type;
	}

	public void setType(ModelType type) {
		this.type = type;
	}

	public enum ModelType{
		MODEL_X(1),
		MODEL_Y(2);

		private final int code;


		ModelType(int code) {
			this.code = code;
		}

		@JsonValue
		public int getCode() {
			return code;
		}

		@JsonCreator
		public static ModelType forValue(int code) {
			for(ModelType v : values()){
				if( v.getCode() == code){
					return v;
				}
			}
			return null;
		}


	}

}
