package shop.itbook.itbookdelivery.delivery.service;

import java.util.List;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryResponseDto;

/**
 * 배송 엔티티와 관련된 로직을 담당하는 클래스입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public interface DeliveryService {

    /**
     * 개별 배송 정보 등록 요청을 받아 처리합니다.
     * 다른 서버의 요청에 응답합니다.
     *
     * @param deliveryRequestDto 배송 정보를 등록할 주문과 주문 수령인의 정보를 포함한 Dto 입니다.
     * @return 저장에 성공 했을 경우 등록한 배송 정보를 반환합니다.
     * @author 정재원
     */
    DeliveryResponseDto addDelivery(DeliveryRequestDto deliveryRequestDto);

    /**
     * 배송 정보 리스트를 요청으로 받아 처리합니다.
     * 다른 서버의 요청에 응답합니다.
     *
     * @param deliveryRequestDtoList the delivery request dto list
     * @return 저장에 성공 했을 경우 등록한 배송 정보를 리스트로 반환합니다.
     * @author 정재원
     */
    List<DeliveryResponseDto> addDeliveryList(List<DeliveryRequestDto> deliveryRequestDtoList);

    /**
     * 운송장번호를 통해 배송 정보를 조회합니다.
     *
     * @param trackingNo 조회를 위해 요청으로 들어온 주문의 운송장 번호.
     * @return 조회성공한 배송 정보를 Dto 에 담아 반환합니다.
     * @author 정재원
     */
    DeliveryResponseDto findDeliveryByTrackingNo(String trackingNo);


    /**
     * 요청으로 받은 Dto 값으로 운송장번호를 통해 배송 정보를 수정합니다.
     *
     * @param trackingNo         수정을 위해 요청으로 들어온 주문의 운송장 번호.
     * @param deliveryRequestDto 이 변수에 포함되어 있는 값으로 배송 정보를 수정합니다.
     * @author 정재원
     */
    void modifyDeliveryByTrackingNo(String trackingNo, DeliveryRequestDto deliveryRequestDto);


    /**
     * 운송장번호를 통해 배송 정보를 삭제합니다.
     *
     * @param trackingNo 삭제를 위해 요청으로 들어온 주문의 운송장 번호.
     * @author 정재원
     */
    void removeDeliveryByTrackingNo(String trackingNo);
}
