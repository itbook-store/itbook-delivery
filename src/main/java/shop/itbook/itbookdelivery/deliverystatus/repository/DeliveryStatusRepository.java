package shop.itbook.itbookdelivery.deliverystatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.itbook.itbookdelivery.deliverystatus.entity.DeliveryStatus;

/**
 * 배송 상태 관련 정보 관련 Repository 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Integer> {
}
