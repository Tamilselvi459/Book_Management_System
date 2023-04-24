package com.tamilselvig.bookManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController{

      BookService books = new BookService();

    @PostMapping("/add-book")
    public ResponseEntity addbook(@RequestBody Book book){
      try{
          Boolean flag =  books.addBook(book);
          return new ResponseEntity("book added sucessfully" , HttpStatus.CREATED);
      }catch (BookAlreadyExistsException ex)
        {
        return new ResponseEntity("unable to add book , book already exsits" , HttpStatusCode.valueOf(400));
        }
//        hm.put(book.getBookId(), book);
//        return ResponseEntity("Added succes";
    }
    @GetMapping("/find-book")
    public ResponseEntity findbook(@RequestParam int id){
       try{
         Book book =   books.findbook(id);
         return new ResponseEntity(book ,HttpStatus.OK);
       }catch(BookNotFoundException ex){
           return new ResponseEntity(ex.getMessage() , HttpStatus.valueOf(500));
       }
    }
//
//    @GetMapping("/find-book/{id}")
//    public Book findbookbyparam(@PathVariable int id){
//     return hm.get(id);
//    }
//
   @PutMapping("/update-book")
   public String updatebooks(@RequestParam int id , @RequestParam String title, @RequestParam String author ,@RequestParam int pages){

       String ans =  books.updatebook(id,title,author,pages);
       return ans;
//        Book book = hm.get(id);
////        book.setBookId(id);
//        if(Objects.nonNull(title))
//        book.setTitle(title);
//        book.setAuthor(author);
//        book.setPages(pages);
//        hm.put(id,book);
//        return "book updated ";
  }
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
       try{
           boolean delete =  books.deletebooks(id);
           return new ResponseEntity("book deleted successfully" , HttpStatus.OK);
       }catch(BookNotFoundException ex){
           return new ResponseEntity(ex.getMessage() , HttpStatus.NOT_FOUND);
       }
  }
}