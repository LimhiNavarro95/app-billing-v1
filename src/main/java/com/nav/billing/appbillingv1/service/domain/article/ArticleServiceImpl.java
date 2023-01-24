package com.nav.billing.appbillingv1.service.domain.article;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.repository.domain.ArticleRepository;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import com.nav.billing.appbillingv1.util.BDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

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
      return articleRepository.findArticleById(id);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public Article save(Article article) throws ServiceException {
    try {
      return articleRepository.save(article);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public Article update(Article article) throws ServiceException {
    try {
      //-Se obtiene por medio del Id del cliente a modifiar la info actual en BD
      Article currentArticleData = this.findById(article.getArticleId()).orElse(null);
      if (!isNull(currentArticleData)){
        BeanUtils.copyProperties(article, currentArticleData);
        return articleRepository.save(currentArticleData);
      }
      return null;
    } catch (Exception e){
      throw new ServiceException(e);
    }
  }

  @Transactional
  @Override
  public Boolean delete(Article article) throws ServiceException {
    try {
      articleRepository.delete(article.getArticleId());
      return true;
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public Page<Article> findAllArticlesPaging(Pageable pageable) throws ServiceException {
    try {
      return articleRepository.findAllArticles(pageable);
    } catch (Exception e){
      throw new ServiceException(e);
    }
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
