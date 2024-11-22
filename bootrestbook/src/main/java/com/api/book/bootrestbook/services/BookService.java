package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Java Complete Reference","xyz"));
    //     list.add(new Book(36,"Head first to java","Abc"));
    //     list.add(new Book(12963,"Thing in java","lmn"));

    // }
    //get all book 
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list ;
    }
    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        //book = list.stream().filter(e->e.getId()==id).findFirst().get();
        book =this.bookRepository.findById(id);
        return book;

    }

    //adding the book
    public Book addBook(Book b){
        //list.add(b);
        Book result = bookRepository.save(b);
        return result;
    }

    //delete book
    public void deleteBook(int bid){
        // list = list.stream()
        //        .filter(book -> book.getId() != bid)
        //        .collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    //update book
    public Book updateBook(Book book ,int bookId){
        // list.stream().map(b->{
        //     if(b.getId()==bookId){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
                
        //     }
        //     return b;
 
        // }).collect(Collectors.toList());    
        book.setId(bookId);
        bookRepository.save(book);
        return book;
    }

}
