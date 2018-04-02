package com.MichalWojcik.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.MichalWojcik.Library.model.Book;
import com.MichalWojcik.Library.repository.AuthorRepository;
import com.MichalWojcik.Library.repository.BookRepository;


@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/books/add")
    public String add(ModelMap modelMap){
        modelMap.addAttribute("book",new Book());
        modelMap.addAttribute("authors",authorRepository.findAll());
        return "books/add";
    }

    @PostMapping("/books")
    public String save(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("books",bookRepository.findAll());
        return "books/index";
    }
    @GetMapping("books/{id}/edit")
    public String edit(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("book",bookRepository.findById(id).get());
        modelMap.addAttribute("authors",authorRepository.findAll());

        return "books/add";
    }

    @GetMapping("books/{id}/delete")
    public String delete(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
    @GetMapping("/books/{id}")
    public String details(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("book", bookRepository.findById(id).get());
        return "books/details";
    }

}



