package shop.itbook.itbookdelivery.deliverystatusenum;

import lombok.Getter;

/**
 * 배송 상태 테이블 Enum 입니다.
 *
 * @author 강명관
 * @since 1.0
 */
@Getter
public enum DeliveryStatusEnum {

    WAITING("배송대기"),
    COMPLETED("배송완료");

    private final String deliveryStatus;
    
    DeliveryStatusEnum(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
