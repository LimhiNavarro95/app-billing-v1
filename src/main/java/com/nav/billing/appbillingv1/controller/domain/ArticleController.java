package com.nav.billing.appbillingv1.controller.domain;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.service.domain.article.ArticleService;
import com.nav.billing.appbillingv1.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.nav.billing.appbillingv1.commons.GlobalConstants.ARTICLE_API;
import static java.util.Objects.isNull;

@RestController
@Slf4j
@RequestMapping(ARTICLE_API)  // uri -> /v1/article
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
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

  @GetMapping("/by-description")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity<?> findByLikeObject(@RequestParam String description){

    try {
      Article article = new Article();
      article.setDescription(description);
      List<Article> articles = articleService.findByLikeDescription(article);
      if (articles.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(articles);
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @GetMapping("/all-articles")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity<?> findAllArticlesPaged(@RequestParam Integer page, @RequestParam Integer size){

    try {

      Pageable pageable = PageRequest.of(page -1, size);

      //-> Este objeto tiene toda la info para saber cuantas paginas tengo y cuantos registros en total se obtienen
      //   para armar toda la info que necesite
      Page<Article> articles = articleService.findAllArticlesPaging(pageable);

      if (articles.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(articles.getContent());

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @GetMapping("/by-trademark")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity<?> findByLikeTrademarkPaged(@RequestParam String trademark,
                                                    @RequestParam Integer page, /*No. de pagina, ej: Pag.1, 2, ...5 */
                                                    @RequestParam Integer size /*De cuanto en cuanto, ej: 10,20,50 */){
    try {

      Pageable pageable = PageRequest.of(page -1, size);
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

  @PostMapping
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity<?> registerArticle(@RequestBody @Validated Article article, BindingResult bindingResult){

    //el objeto binding result apoya para comprobar que el objeto tenga los atributos correctos
    if (bindingResult.hasErrors()){
      return WebUtil.getErrors(bindingResult);
    }

    try {
      Article articleRst = articleService.save(article);
      if (isNull(articleRst)){
        return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(articleRst);
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @PutMapping("/{articleId}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity<?> updateArticle(@PathVariable Long articleId, @RequestBody Article article, BindingResult bindingResult){

    //el objeto binding result apoya para comprobar que el objeto tenga los atributos correctos
    if (bindingResult.hasErrors()){
      return WebUtil.getErrors(bindingResult);
    }

    try {
      // se asigna el ID al article ya que el objeto de la peticion no lo tiene
      article.setArticleId(articleId);
      Article articleUpdated = articleService.update(article);

      if (isNull(articleUpdated)){
        return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

  @DeleteMapping("/{articleId}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity<?> deleteArticle(@PathVariable Long articleId){

    try {

      Article article = new Article();
      article.setArticleId(articleId);

      if (articleService.delete(article)){
        return ResponseEntity.status(HttpStatus.OK).build();
      } else {
        return ResponseEntity.badRequest().build();
      }

    } catch (Exception e) {
      log.error(e.getMessage(),e);
      return ResponseEntity.internalServerError().build();
    }

  }

}
