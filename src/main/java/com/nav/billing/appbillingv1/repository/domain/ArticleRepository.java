package com.nav.billing.appbillingv1.repository.domain;

import com.nav.billing.appbillingv1.entities.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

  @Query("select art from Article art where art.articleId = :articleId and art.status = '1'")
  Optional<Article> findArticleById(@Param("articleId") Long articleId);

  @Query("select art from Article art where upper(art.trademark) like upper(:trademark) and art.status = '1'")
  List<Article> findByLikeTrademark(@Param("trademark") String trademark);

  // Obtiene articulos por marca con paginacion
  @Query("select art from Article art where upper(art.trademark) like upper(:trademark) and art.status = '1'")
  Page<Article> findByLikeTrademarkPaging(@Param("trademark") String trademark, Pageable pageable);

}
