package com.bns.model;

import java.io.Serializable;

public class ColorMaster implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	private String colorId;
	private String colorCode;
	private String colorName;
	private String status;
	
	public ColorMaster() {
	}

	public ColorMaster(String colorId, String colorCode, String colorName, String status) {
		super();
		this.colorId = colorId;
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.status = status;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ColorMaster [colorId=" + colorId + ", colorCode=" + colorCode + ", colorName=" + colorName + ", status="
				+ status + "]";
	}
	
}
