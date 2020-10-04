package com.bookworld.bookapp.DTO;

import java.util.List;

import com.google.api.services.books.model.Volume.VolumeInfo.ImageLinks;

public class BookDTO {

	public BookDTO() {}
	
	public BookDTO(String title) {
		this.title = title;
	}
	
	public BookDTO(String title, ImageLinks imageLinks, List<String> authors) {
		super();
		this.title = title;
		this.imageLinks = imageLinks;
		this.mediumImageLink = imageLinks.getThumbnail();
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMediumImageLink() {
		return mediumImageLink;
	}

	public void setMediumImageLink(String mediumImageLink) {
		this.mediumImageLink = mediumImageLink;
	}

	public ImageLinks getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(ImageLinks imageLinks) {
		this.imageLinks = imageLinks;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	private String title;
	
	private String mediumImageLink;
	
	private ImageLinks imageLinks;
	
	private List<String> authors;
}
