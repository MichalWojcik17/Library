package com.MichalWojcik.Library.repository;

import org.springframework.data.repository.CrudRepository;
import com.MichalWojcik.Library.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{
}
