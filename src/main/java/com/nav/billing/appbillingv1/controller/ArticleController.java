package com.nav.billing.appbillingv1.controller;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.service.domain.article.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/by-trademark")
  public ResponseEntity<?> findByLikeTrademarkPaged(@RequestParam String trademark,
                                                    @RequestParam Integer page, /*No. de pagina, ej: Pag.1, 2, ...5 */
                                                    @RequestParam Integer size /*De cuanto en cuanto, ej: 10,20,50 */){
    try {

      Pageable pageable = PageRequest.of(page -1 , size);

      Page<Article> articles = articleService.findByLikeTrademarkPaging(trademark, pageable);

      if (articles.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(articles.getContent());

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }
  }

}
