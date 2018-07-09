package br.com.uaijug.demomongo.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.uaijug.demomongo.model.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
