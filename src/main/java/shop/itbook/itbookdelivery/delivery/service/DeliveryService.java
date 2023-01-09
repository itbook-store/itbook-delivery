package shop.itbook.itbookdelivery.delivery.service;

import javax.transaction.Transactional;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;

/**
 * 배송 엔티티와 관련된 로직을 담당하는 클래스입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public interface DeliveryService {

    /**
     * 요청을 받아 Delivery 엔티티를 생성하고 데이터베이스에 저장하는 함수입니다.
     *
     * @param deliveryRequestDto the delivery request dto
     * @return the delivery
     */
    Long saveDelivery(DeliveryRequestDto deliveryRequestDto);

    /**
     * Pk 값으로 Delivery 엔티티를 가져오는 함수입니다.
     *
     * @param deliveryNo the delivery no, Pk.
     * @return the delivery
     */
    Delivery findDeliveryEntity(Long deliveryNo);
}
