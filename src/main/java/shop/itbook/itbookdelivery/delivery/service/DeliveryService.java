package shop.itbook.itbookdelivery.delivery.service;

import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryResponseDto;
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
     * @author 정재원 *
     */
    Long addDelivery(DeliveryRequestDto deliveryRequestDto);

    /**
     * Pk 값으로 Delivery 엔티티를 가져오는 함수입니다.
     *
     * @param deliveryNo the delivery no, Pk.
     * @return the delivery
     * @author 정재원 *
     */
    DeliveryResponseDto findDeliveryEntity(Long deliveryNo);


    /**
     * 요청으로 받은 deliveryRequestDto 값으로 Delivery 엔티티를 생성하여 배송 정보를 변경합니다.
     *
     * @param deliveryNo         the delivery no
     * @param deliveryRequestDto the delivery request dto
     * @author 정재원 *
     */
    void modifyDelivery(Long deliveryNo, DeliveryRequestDto deliveryRequestDto);


    /**
     * 요청으로 Pk 인 배송 번호를 받아 배송 정보를 삭제 합니다.
     *
     * @param deliveryNo the delivery no
     * @author 정재원 *
     */
    void deleteDelivery(Long deliveryNo);
}
