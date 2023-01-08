package shop.itbook.itbookdelivery.delivery.dto.request;

import lombok.Getter;

/**
 * 배송 정보 등록, 수정시 요청할 정보를 담은 Dto 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@Getter
public class DeliveryRequestDto {
    private Long deliveryNo;
    private Long orderNo;
    private String receiverName;
    private String receiverAddress;
    private String receiverDetailAddress;
    private String receiverPhoneNumber;
    private String trackingNo;
    
}
