package shop.itbook.itbookdelivery.deliverystatushistory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.itbook.itbookdelivery.common.response.CommonResponseBody;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.request.DeliveryStatusHistoryRequestDto;
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
@RequestMapping("/api/delivery-status-history")
public class DeliveryStatusHistoryController {

    private final DeliveryStatusHistoryService deliveryStatusHistoryService;

    /**
     * 배송 상태 이력 정보 등록 요청을 받아 처리 합니다.
     *
     * @param deliveryStatusHistoryRequestDto the delivery status history request dto
     * @return the response entity
     * @author 정재원 *
     */
    @PostMapping
    public ResponseEntity<CommonResponseBody<DeliveryStatusHistoryResponseDto>> deliveryStatusHistoryAdd(
        DeliveryStatusHistoryRequestDto deliveryStatusHistoryRequestDto) {

        DeliveryStatusHistoryResponseDto deliveryStatusHistoryResponseDto =
            deliveryStatusHistoryService.findDeliveryStatusHistory(deliveryStatusHistoryRequestDto);

        CommonResponseBody<DeliveryStatusHistoryResponseDto> commonResponseBody =
            new CommonResponseBody<>(
                new CommonResponseBody.CommonHeader(true, HttpStatus.CREATED.value(),
                    ResultMessageEnum.DELIVERY_STATUS_HISTORY_ADD_SUCCESS_MESSAGE.getSuccessMessage()),
                deliveryStatusHistoryResponseDto
            );

        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponseBody);
    }

    /**
     * 배송 상태 이력 조회 요청을 받아 처리합니다.
     *
     * @param deliveryStatusHistoryNo the delivery status history no
     * @return the response entity
     * @author 정재원 *
     */
    @GetMapping
    public ResponseEntity<CommonResponseBody<Long>> deliveryStatusHistoryAdd(
        @PathVariable Long deliveryStatusHistoryNo) {

        DeliveryStatusHistoryResponseDto deliveryStatusHistoryResponseDto =
            deliveryStatusHistoryService.findDeliveryStatusHistory(deliveryStatusHistoryNo);

        CommonResponseBody<Long> commonResponseBody =
            new CommonResponseBody<>(
                new CommonResponseBody.CommonHeader(true, HttpStatus.CREATED.value(),
                    ResultMessageEnum.DELIVERY_STATUS_HISTORY_ADD_SUCCESS_MESSAGE.getSuccessMessage()),
                deliveryStatusHistoryResponseDto.getDeliveryStatusHistoryNo()
            );

        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponseBody);
    }
}
