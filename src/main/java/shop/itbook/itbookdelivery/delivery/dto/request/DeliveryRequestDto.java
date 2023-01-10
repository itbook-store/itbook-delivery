package shop.itbook.itbookdelivery.delivery.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

/**
 * 배송 정보 등록, 수정시 요청할 정보를 담은 Dto 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@Getter
public class DeliveryRequestDto {

    @Min(value = 1, message = "주문 번호는 1 이상이여야 합니다.")
    private Long orderNo;
    @NotBlank(message = "수령인 이름은 공백일 수 없습니다.")
    private String receiverName;
    @NotBlank(message = "수령지 주소는 공백일 수 없습니다.")
    private String receiverAddress;
    @NotBlank(message = "수령지 상세 주소는 공백일 수 없습니다.")
    private String receiverDetailAddress;
    @NotBlank(message = "수령인의 핸드폰 번호는 공백일 수 없습니다.")
    private String receiverPhoneNumber;
    
}
