package shop.itbook.itbookdelivery.delivery.transfer;

import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryResponseDto;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;

/**
 * 배송 엔티티와 Dto 간의 변환을 위한 클래스입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public class DeliveryTransfer {

    private DeliveryTransfer() {
    }

    /**
     * 배송 엔티티를 응답 Dto 로 변환합니다.
     *
     * @param delivery 배송 엔티티
     * @return 배송 응답 Dto 입니다.
     * @author 정재원 *
     */
    public static DeliveryResponseDto entityToDto(Delivery delivery) {
        return DeliveryResponseDto.builder()
            .deliveryNo(delivery.getDeliveryNo())
            .orderNo(delivery.getOrderNo())
            .receiverName(delivery.getReceiverName())
            .receiverAddress(delivery.getReceiverAddress())
            .receiverDetailAddress(delivery.getReceiverDetailAddress())
            .receiverPhoneNumber(delivery.getReceiverPhoneNumber())
            .trackingNo(delivery.getTrackingNo())
            .build();
    }

    /**
     * 배송 요청 Dto 를 엔티티로 변환합니다.
     *
     * @param deliveryRequestDto 배송 요청 정보가 담긴 Dto
     * @return 배송 엔티티 객체
     * @author 정재원 *
     */
    public static Delivery dtoToEntity(DeliveryRequestDto deliveryRequestDto) {
        return Delivery.builder()
            .orderNo(deliveryRequestDto.getOrderNo())
            .receiverName(deliveryRequestDto.getReceiverName())
            .receiverAddress(deliveryRequestDto.getReceiverAddress())
            .receiverDetailAddress(deliveryRequestDto.getReceiverDetailAddress())
            .receiverPhoneNumber(deliveryRequestDto.getReceiverPhoneNumber())
            .build();
    }
}
