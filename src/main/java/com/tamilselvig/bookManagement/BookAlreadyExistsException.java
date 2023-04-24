package com.tamilselvig.bookManagement;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(int bookId) {

        super("book for id : "+ bookId+" alreaady exists");
    }
}
