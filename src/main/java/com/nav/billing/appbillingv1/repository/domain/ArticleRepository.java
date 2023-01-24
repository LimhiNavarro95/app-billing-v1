package com.nav.billing.appbillingv1.repository.domain;

import com.nav.billing.appbillingv1.entities.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

  // -- Simple querys

  @Query("select art from Article art where art.articleId = :articleId and art.status = '1'")
  Optional<Article> findArticleById(@Param("articleId") Long articleId);

  @Query("select art from Article art where upper(art.trademark) like upper(:trademark) and art.status = '1'")
  List<Article> findByLikeTrademark(@Param("trademark") String trademark);

  // -- SERVICIOS CON PAGINACION

  @Query("select art from Article art where art.status = '1' order by art.articleId")
  Page<Article> findAllArticles(Pageable pageable);

  // Obtiene articulos por marca con paginacion
  @Query("select art from Article art where upper(art.trademark) like upper(:trademark) and art.status = '1'")
  Page<Article> findByLikeTrademarkPaging(@Param("trademark") String trademark, Pageable pageable);

  @Modifying
  @Query(nativeQuery = true, value = "UPDATE ARTICLE SET status = '0' WHERE ID_ARTICLE = :id")
  void delete(@Param("id") Long id);

}
