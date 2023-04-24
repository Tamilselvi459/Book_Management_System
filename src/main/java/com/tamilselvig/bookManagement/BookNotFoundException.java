package com.tamilselvig.bookManagement;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book not found for this id");
    }
}
