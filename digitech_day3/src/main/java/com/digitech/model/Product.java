//package com.digitech.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.web.multipart.MultipartFile;
//
//@Entity														//id name supplier id catID price quantity stock										
//public class Product {
//	
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int proID;
//	
//	@Column
//	private String proName;
//	@Column
//	private int supplierID;
//	@Column
//	private int categoryID;
//	@Column
//	private int quantity;
//	@Column
//	private int stock;
//	@Column
//	private int price;
//	
//	
//	
//	@Column
//	String description;
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	MultipartFile proImage;
//	public int getProID() {
//		return proID;
//	}
//	public void setProID(int proID) {
//		this.proID = proID;
//	}
//	public String getProName() {
//		return proName;
//	}
//	public void setProName(String proName) {
//		this.proName = proName;
//	}
//	public int getSupplierID() {
//		return supplierID;
//	}
//	public void setSupplierID(int supplierID) {
//		this.supplierID = supplierID;
//	}
//	public int getCategoryID() {
//		return categoryID;
//	}
//	public void setCategoryID(int categoryID) {
//		this.categoryID = categoryID;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public int getStock() {
//		return stock;
//	}
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public MultipartFile getProImage() {
//		return proImage;
//	}
//	public void setProImage(MultipartFile proImage) {
//		this.proImage = proImage;
//	}
//	
//	
//
//}
