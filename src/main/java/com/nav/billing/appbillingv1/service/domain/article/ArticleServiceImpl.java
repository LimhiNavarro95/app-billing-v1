package com.nav.billing.appbillingv1.service.domain.article;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.repository.domain.ArticleRepository;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.util.BDUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

  private final ArticleRepository articleRepository;

  public ArticleServiceImpl(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;
  }

  @Override
  public List<Article> findByLikeObject(Article article) throws ServiceException {
    try {
      return articleRepository.findByLikeTrademark(BDUtil.getLike(article.getTrademark()));
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public Optional<Article> findById(Long id) throws ServiceException {
    try{
      return articleRepository.findById(id);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public Article save(Article article) throws ServiceException {
    return null;
  }

  @Override
  public Article update(Article article) throws ServiceException {
    return null;
  }

  @Override
  public Boolean delete(Article article) throws ServiceException {
    return null;
  }

  @Override
  public Page<Article> findByLikeTrademarkPaging(String trademark, Pageable pageable) throws ServiceException {
    try{
      return articleRepository.findByLikeTrademarkPaging(trademark, pageable);
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

}
