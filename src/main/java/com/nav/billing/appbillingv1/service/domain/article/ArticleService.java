package com.nav.billing.appbillingv1.service.domain.article;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.service.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService extends GenericService<Article> {

  Page<Article> findAllArticlesPaging(Pageable pageable) throws ServiceException;

  Page<Article> findByLikeTrademarkPaging(String trademark, Pageable pageable) throws ServiceException;

  List<Article> findByLikeDescription(Article article) throws ServiceException;

}
