package com.nav.billing.appbillingv1.controller;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.service.domain.article.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.nav.billing.appbillingv1.commons.GlobalConstants.ARTICLE_API;

@RestController
@Slf4j
@RequestMapping(ARTICLE_API)
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id){

    try {
      Optional<Article> optionalArticle = articleService.findById(id);
      if (optionalArticle.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(optionalArticle.get());
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

}
