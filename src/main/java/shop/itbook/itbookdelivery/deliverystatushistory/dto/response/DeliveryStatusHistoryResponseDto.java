package shop.itbook.itbookdelivery.deliverystatushistory.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

/**
 * 배송 상태 이력 엔티티의 모든 정보를 담고 있는 반환 Dto 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@Getter
@Builder
public class DeliveryStatusHistoryResponseDto {

    private Long deliveryStatusHistoryNo;
    private Long deliveryNo;
    private String deliveryStatusEnum;
    private LocalDateTime statusChangedCreatedAt;
    private String location;
}
