package br.com.ramonsantos.workshopmongo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonsantos.workshopmongo.domain.Post;
import br.com.ramonsantos.workshopmongo.repository.PostRepository;
import br.com.ramonsantos.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				String.format("O post com o id %s não foi encontrado no sistema.", id)));

		return post;
	}

	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
