package io.novelis.novyblog.web.rest;

import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.exception.ArticleNotFoundException;
import io.novelis.novyblog.service.ArticleService;
import io.novelis.novyblog.service.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ArticleRessource {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<ArticleDTO> getAllArticles() {
        return articleService.findAll();
    }

    @PostMapping("/articles")
    ArticleDTO createArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    // Single item
    @GetMapping("/articles/{id}")
    Article findArticle(@PathVariable Long id) {
        return articleService.findOne(id)
                .orElseThrow(()->new ArticleNotFoundException(id));
    }


    @PutMapping("/articles/{id}")
    ArticleDTO replaceArticle(@RequestBody Article newArticle, @PathVariable Long id) {
        return articleService.findOne(id)
                .map(article -> {
                    article.setContent(newArticle.getContent());
                    article.setPublishDate(newArticle.getPublishDate());

                    return articleService.save(article);
                })
                .orElseGet(() -> {
                    newArticle.setId(id);
                    return articleService.save(newArticle);
                });
    }

    @DeleteMapping("/articles/{id}")
    void deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
    }

}


