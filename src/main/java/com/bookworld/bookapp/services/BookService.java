package com.bookworld.bookapp.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bookworld.bookapp.DTO.BookDTO;
import com.bookworld.bookapp.googlebooks.GoogleBooksUtil;
import com.bookworld.util.BooksUtil;
import com.google.api.services.books.Books;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

@Service
public class BookService {

	public java.util.List<BookDTO> getBooksByQuery(String query) {
		java.util.List<BookDTO> bookResults = new ArrayList<BookDTO>();
		Books books;
		try {
			books = GoogleBooksUtil.getBooksClient();

			// Set query string and filter only Google eBooks.
			System.out.println("Query: [" + query + "]");
			List volumesList = books.volumes().list(query);

			// volumesList.setFilter("ebooks");

			Volumes volumes = volumesList.execute();
			if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
				System.out.println("No matches found.");
				return bookResults;
			}

			// Output results.
			for (Volume volume : volumes.getItems()) {
				bookResults.add(BooksUtil.convertVolumeToBook(volume));
			}
		} catch (Exception e) {
			System.out.println("Exception during query "+e.getMessage());
		}

		return bookResults;
	}

}
