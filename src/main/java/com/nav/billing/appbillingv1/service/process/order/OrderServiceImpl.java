package com.nav.billing.appbillingv1.service.process.order;

import com.nav.billing.appbillingv1.entities.domain.Article;
import com.nav.billing.appbillingv1.entities.process.Order;
import com.nav.billing.appbillingv1.repository.domain.ArticleRepository;
import com.nav.billing.appbillingv1.repository.process.OrderRepository;
import com.nav.billing.appbillingv1.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

  private final OrderRepository orderRepository;
  private final ArticleRepository articleRepository;

  public OrderServiceImpl(OrderRepository orderRepository, ArticleRepository articleRepository){
    this.orderRepository = orderRepository;
    this.articleRepository = articleRepository;
  }

  @Override
  public List<Order> findByLikeObject(Order order) throws ServiceException {
    return null;
  }

  @Override
  public Optional<Order> findById(Long id) throws ServiceException {
    try {
      return orderRepository.findById(id);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  @Transactional
  @Override
  public Order save(Order order) throws ServiceException {

    try {
      // Prepara el detalle
      order.getItems().forEach(item -> {
        item.setOrder(order); // En el "item" del pedido se guarda toda la orden

        // Buscando el producto
        Optional<Article> optionalArticle = articleRepository.findById(item.getArticle().getArticleId());

        if (optionalArticle.isPresent()) {
          Article article = optionalArticle.get();
          item.setPrice(article.getPrice());
          item.calculateSubTotal();

          articleRepository.updateSubstractStock(article.getArticleId(), item.getQuantity());
        }
      });

      order.calculateTotal();

      return orderRepository.save(order);

    } catch (Exception e) {
      throw new ServiceException(e);
    }

  }

  @Override
  public Order update(Order order) throws ServiceException {
    return null;
  }

  @Override
  public Boolean delete(Order order) throws ServiceException {
    return null;
  }

}
