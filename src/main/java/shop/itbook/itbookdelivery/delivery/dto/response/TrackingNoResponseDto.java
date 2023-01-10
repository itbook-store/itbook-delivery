package shop.itbook.itbookdelivery.delivery.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 운송장 버호만을 반환하는 Dto 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@AllArgsConstructor
@Getter
public class TrackingNoResponseDto {

    private String trackingNo;
}
