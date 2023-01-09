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

    public static Delivery dtoToEntity(DeliveryRequestDto deliveryRequestDto) {
        return Delivery.builder()
            .orderNo(deliveryRequestDto.getOrderNo())
            .receiverName(deliveryRequestDto.getReceiverName())
            .receiverAddress(deliveryRequestDto.getReceiverAddress())
            .receiverDetailAddress(deliveryRequestDto.getReceiverDetailAddress())
            .receiverPhoneNumber(deliveryRequestDto.getReceiverPhoneNumber())
            .trackingNo(deliveryRequestDto.getTrackingNo())
            .build();
    }
}
