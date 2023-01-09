package shop.itbook.itbookdelivery.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;

/**
 * 배송 엔티티의 Repository 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
