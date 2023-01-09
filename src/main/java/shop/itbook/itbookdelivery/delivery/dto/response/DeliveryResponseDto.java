package shop.itbook.itbookdelivery.delivery.dto.response;

import lombok.Builder;
import lombok.Getter;

/**
 * 배송 엔티티의 모든 필드값을 포함하고 있는 Dto 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@Getter
@Builder
public class DeliveryResponseDto {

    private Long deliveryNo;
    private Long orderNo;
    private String receiverName;
    private String receiverAddress;
    private String receiverDetailAddress;
    private String receiverPhoneNumber;
    private String trackingNo;
}
