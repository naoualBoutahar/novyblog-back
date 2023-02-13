package io.novelis.novyblog.service.Impl;

import io.novelis.novyblog.dao.ArticleDao;
import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.service.ArticleService;
import io.novelis.novyblog.service.dto.ArticleDTO;
import io.novelis.novyblog.service.mapper.ArticleMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleDTO save(Article article) {
        return articleMapper.articleToArticleDto(articleDao.save(article));
    }

    @Override
    public ArticleDTO update(Article article) {
        return articleMapper.articleToArticleDto(articleDao.save(article));
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleDao
                .findAll()
                .stream()
                .map(articleMapper::articleToArticleDto).collect(toList());
    }


    @Override
    public Optional<Article> findOne(Long id) {
        return articleDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        articleDao.deleteById(id);
    }
}
