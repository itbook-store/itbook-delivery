package shop.itbook.itbookdelivery.deliverystatushistory.service;

import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.response.DeliveryStatusHistoryResponseDto;

/**
 * The interface Delivery status history service.
 *
 * @author 정재원
 * @since 1.0
 */
public interface DeliveryStatusHistoryService {

    /**
     * Dto 정보를 바탕으로 배송 정보 이력을 추가합니다.
     *
     * @param delivery 이력에 저장될 매개변수입니다.
     * @author 정재원 *
     */
    void addDeliveryStatusHistory(Delivery delivery);

    /**
     * 배송 상태 이력을 운송장 번호를 통해 조회합니다.
     *
     * @param trackingNo 배송 상태 이력을 조죄할 운송장 번호
     * @return 해당 운송장 번호의 최신 배송 상태 이력
     * @author 정재원 *
     */
    DeliveryStatusHistoryResponseDto findAndUpdateDeliveryStatusHistory(String trackingNo);
}
