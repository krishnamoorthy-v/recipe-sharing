package com.saec.web.model;

public class RecipeModel {
	
	private int rid;
	private String title;
	private String description;
	private String image;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int id) {
		this.rid = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "RecipeModel [ id= "+rid+ " title=" + title + ", description=" + description + ", image=" + image + "]";
	}
	
	
}
