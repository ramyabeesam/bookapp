package com.bookworld.util;

import com.bookworld.bookapp.DTO.BookDTO;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volume.VolumeInfo;

public class BooksUtil {

	public static BookDTO convertVolumeToBook(Volume volume){
		VolumeInfo info = volume.getVolumeInfo(); 
		return new BookDTO(info.getTitle(), info.getImageLinks(), info.getAuthors());
	}
}
