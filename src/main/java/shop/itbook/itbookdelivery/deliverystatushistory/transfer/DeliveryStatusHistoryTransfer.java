package shop.itbook.itbookdelivery.deliverystatushistory.transfer;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import shop.itbook.itbookdelivery.deliverystatus.entity.DeliveryStatus;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.request.DeliveryStatusHistoryRequestDto;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.response.DeliveryStatusHistoryResponseDto;
import shop.itbook.itbookdelivery.deliverystatushistory.entity.DeliveryStatusHistory;

/**
 * 배송 상태 이력의 엔티티와 Dto 간의 변환을 도와주는 클래스 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public class DeliveryStatusHistoryTransfer {

    private DeliveryStatusHistoryTransfer() {
    }

    /**
     * 배송 상태 이력 테이블 엔티티를 반환을 위한 Dto 로 만들어 주는 기능입니다.
     *
     * @param deliveryStatusHistory the delivery status history
     * @return the delivery status history response dto
     * @author 정재원 *
     */
    public static DeliveryStatusHistoryResponseDto entityToDto(
        DeliveryStatusHistory deliveryStatusHistory) {

        return DeliveryStatusHistoryResponseDto.builder()
            .deliveryStatusHistoryNo(deliveryStatusHistory.getDeliveryStatusHistoryNo())
            .deliveryNo(deliveryStatusHistory.getDelivery().getDeliveryNo())
            .deliveryStatusEnum(deliveryStatusHistory.getDeliveryStatus().getDeliveryStatusEnum()
                .getDeliveryStatus())
            .statusChangedCreatedAt(deliveryStatusHistory.getStatusChangedCreatedAt())
            .location(deliveryStatusHistory.getLocation())
            .build();
    }

    /**
     * 요청 받은 Dto 정보를 바탕으로 배송 정보 이력 엔티티를 만들어주는 기능입니다.
     *
     * @param deliveryStatusHistoryRequestDto the delivery status history request dto
     * @return the delivery status history
     * @author 정재원 *
     */
    public static DeliveryStatusHistory dtoToEntity(
        DeliveryStatusHistoryRequestDto deliveryStatusHistoryRequestDto) {

        return new DeliveryStatusHistory(deliveryStatusHistoryRequestDto.getLocation());
    }
}
