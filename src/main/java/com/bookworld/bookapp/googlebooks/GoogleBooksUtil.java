package com.bookworld.bookapp.googlebooks;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.bookworld.bookapp.APICredentials;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;

public class GoogleBooksUtil {
	
	public static Books getBooksClient() throws GeneralSecurityException, IOException {
		return new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(),
				JacksonFactory.getDefaultInstance(), null)       
        .setGoogleClientRequestInitializer(new BooksRequestInitializer(APICredentials.API_KEY))
        .build();
	}

}
