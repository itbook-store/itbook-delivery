package shop.itbook.itbookdelivery.deliverystatushistory.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 * 배송 상태 이력 관련 등록, 수정, 삭제 시 요청할 정보를 담은 Dto 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@Getter
public class DeliveryStatusHistoryRequestDto {

    @NotNull(message = "배송 번호는 Null 일 수 없습니다.")
    @Min(value = 1, message = "배송 번호는 1부터 시작합니다.")
    private Long deliveryNo;
    @NotNull(message = "배송 상태 번호는 Null 일 수 없습니다.")
    @Min(value = 1, message = "배송 상태 번호는 1부터 시작합니다.")
    private Integer deliveryStatusNo;
    @NotBlank(message = "위치 정보는 Null 이거나 빈 칸일 수 없습니다.")
    private String location;
}
