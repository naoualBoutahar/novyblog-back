package io.novelis.novyblog.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(Long id) {
        super("Could not find comment " + id);
    }

}
