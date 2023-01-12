package shop.itbook.itbookdelivery.deliverystatushistory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.itbook.itbookdelivery.common.response.CommonResponseBody;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.response.DeliveryStatusHistoryResponseDto;
import shop.itbook.itbookdelivery.deliverystatushistory.resultmessageenum.ResultMessageEnum;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;

/**
 * The type Delivery status history controller.
 *
 * @author 정재원
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery-status-histories")
public class DeliveryStatusHistoryController {

    private final DeliveryStatusHistoryService deliveryStatusHistoryService;

    /**
     * 운송장 번호로 해당 배송의 최신 상태 이력을 조회합니다.
     *
     * @param trackingNo 조회를 요청받은 운송장 번호.
     * @return the response entity
     * @author 정재원 *
     */
    @GetMapping("/{trackingNo}")
    public ResponseEntity<CommonResponseBody<DeliveryStatusHistoryResponseDto>> deliveryStatusHistoryAdd(
        @PathVariable String trackingNo) {

        DeliveryStatusHistoryResponseDto deliveryStatusHistoryResponseDto =
            deliveryStatusHistoryService.findAndUpdateDeliveryStatusHistory(trackingNo);

        CommonResponseBody<DeliveryStatusHistoryResponseDto> commonResponseBody =
            new CommonResponseBody<>(
                new CommonResponseBody.CommonHeader(true, HttpStatus.CREATED.value(),
                    ResultMessageEnum.DELIVERY_STATUS_HISTORY_ADD_SUCCESS_MESSAGE.getSuccessMessage()),
                deliveryStatusHistoryResponseDto
            );

        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponseBody);
    }
}
