package io.novelis.novyblog.service.mapper;

import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.service.dto.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    @Mapping(source="id", target="articleId")
    ArticleDTO articleToArticleDto(Article article);
}
