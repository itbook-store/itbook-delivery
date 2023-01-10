package shop.itbook.itbookdelivery.deliverystatushistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.entity.DeliveryStatusHistory;

/**
 * 배송 상태 이력 엔티티의 로직을 담당하는 Repository 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public interface DeliveryStatusHistoryRepository
    extends JpaRepository<DeliveryStatusHistory, Long> {
}
