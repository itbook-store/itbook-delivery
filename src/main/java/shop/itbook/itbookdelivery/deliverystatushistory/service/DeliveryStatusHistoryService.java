package shop.itbook.itbookdelivery.deliverystatushistory.service;

import shop.itbook.itbookdelivery.deliverystatushistory.dto.request.DeliveryStatusHistoryRequestDto;
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
     * @param deliveryStatusHistoryRequestDto the delivery status history request dto
     * @return the delivery status history response dto
     * @author 정재원 *
     */
    DeliveryStatusHistoryResponseDto findDeliveryStatusHistory(
        String trackingNo, DeliveryStatusHistoryRequestDto deliveryStatusHistoryRequestDto);


    /**
     * 배송상태 이력을 Id 값을 이용해 조회합니다.
     *
     * @param deliveryStatusHistoryNo the delivery status history no
     * @return the delivery status history response dto
     * @author 정재원 *
     */
    DeliveryStatusHistoryResponseDto findDeliveryStatusHistory(Long deliveryStatusHistoryNo);
}
