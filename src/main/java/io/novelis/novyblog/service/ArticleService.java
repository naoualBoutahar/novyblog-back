package io.novelis.novyblog.service;

import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.service.dto.ArticleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    ArticleDTO save(Article Article);
    ArticleDTO update(Article Article);
    List<ArticleDTO> findAll();
    Optional<Article> findOne(Long id);
    void delete(Long id);
}
