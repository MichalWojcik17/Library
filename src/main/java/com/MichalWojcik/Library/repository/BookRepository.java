package com.MichalWojcik.Library.repository;

import org.springframework.data.repository.CrudRepository;
import com.MichalWojcik.Library.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
