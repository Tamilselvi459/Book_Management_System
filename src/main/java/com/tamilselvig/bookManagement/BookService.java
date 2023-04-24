package com.tamilselvig.bookManagement;

import java.util.Optional;

public class BookService {
    BookRepositry bookr = new BookRepositry();

    public boolean addBook(Book book) {
        Optional<Book> bookopt = bookr.getbyId(book.getBookId());
        if(bookopt.isPresent())
        {
            throw new BookAlreadyExistsException(book.getBookId());
        }
        return bookr.addBooks(book);
    }
    public Book findbook(int id){
        Optional<Book> bookopt = bookr.getbyId(id);
        if(bookopt.isEmpty()){
            throw new BookNotFoundException(id);
        }
        return bookopt.get();
    }

    public String updatebook(int id, String title, String author, int pages) {
     Book book ;
     try{
         book = findbook(id);
         book.setTitle(title);
         book.setPages(pages);
         book.setAuthor(author);
         bookr.addBooks(book);
         return "Book updated";
     }catch(BookNotFoundException ex){
         book = new Book(id,title,author,pages);
         bookr.addBooks(book);
       return "Book created";
     }

    }
    public boolean deletebooks (int id){
        Optional<Book> bookopt = bookr.getbyId(id);
        if(bookopt.isEmpty())
        {
            throw new BookNotFoundException(id);
        }
        bookr.deletebook(id);
        return true;
    }
}
