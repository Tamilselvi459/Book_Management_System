package com.tamilselvig.bookManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepositry {

    Map<Integer,Book> hm = new HashMap<>();

    public boolean addBooks(Book book) {
     hm.put(book.getBookId(),book);
     return true;
    }

    public Optional<Book> getbyId(int id) {
        if(hm.containsKey(id)){
            return Optional.of(hm.get(id));
        }
        return Optional.empty();
    }

    public void deletebook(int id){
      hm.remove(id);
    }
}
