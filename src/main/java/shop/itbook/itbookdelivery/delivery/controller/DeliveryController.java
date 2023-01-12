package shop.itbook.itbookdelivery.delivery.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.itbook.itbookdelivery.common.response.CommonResponseBody;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.dto.response.TrackingNoResponseDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryResponseDto;
import shop.itbook.itbookdelivery.delivery.resultmessageenum.ResultMessageEnum;
import shop.itbook.itbookdelivery.delivery.service.DeliveryService;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;

/**
 * 배송 등록, 조회, 수정, 삭제를 요청 받는 컨트롤러 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DeliveryStatusHistoryService deliveryStatusHistoryService;

    private final static Boolean SUCCEEDED = true;

    /**
     * 요청받은 배송 정보로 배송 엔티티를 만들고 DB 에 등록한 뒤 성공하면 Pk 인 배송 번호를 반환한다.
     *
     * @param deliveryRequestDto the delivery request dto
     * @return the response entity
     * @author 정재원 *
     */
    @PostMapping
    public ResponseEntity<CommonResponseBody<TrackingNoResponseDto>> deliveryAdd(
        @Valid @RequestBody DeliveryRequestDto deliveryRequestDto) {

        TrackingNoResponseDto trackingNoResponseDto =
            new TrackingNoResponseDto(deliveryService.addDelivery(deliveryRequestDto));

        CommonResponseBody<TrackingNoResponseDto> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(SUCCEEDED, HttpStatus.CREATED.value(),
                ResultMessageEnum.DELIVERY_ADD_SUCCESS_MESSAGE.getSuccessMessage()),
            trackingNoResponseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponseBody);
    }

    /**
     * 배송 정보 조회 요청 시 운송장 번호를 받아 처리합니다.
     *
     * @param trackingNo 배송 정보 조회를 위해 요청으로 들어온 해당 주문의 운송장 번호
     * @return 요청 성공 했다는 헤더와 요청한 배송 엔티티 정보.
     * @author 정재원 *
     */
    @GetMapping("/{trackingNo}")
    public ResponseEntity<CommonResponseBody<DeliveryResponseDto>> deliveryFind(
        @PathVariable String trackingNo) {

        CommonResponseBody<DeliveryResponseDto> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(SUCCEEDED, HttpStatus.OK.value(),
                ResultMessageEnum.DELIVERY_FIND_SUCCESS_MESSAGE.getSuccessMessage()),
            deliveryService.findDeliveryByTrackingNo(trackingNo));

        return ResponseEntity.ok().body(commonResponseBody);
    }

    /**
     * 배송 정보 수정 요청 시 운송장 번호를 받아 처리합니다.
     *
     * @param trackingNo         배송 정보 수정을 위해 요청으로 들어온 해당 주문의 운송장 번호
     * @param deliveryRequestDto 수정할 값을 가지고 있는 요청 Dto
     * @return 수정 성공 시 200 상태 값을 반환.
     * @author 정재원 *
     */
    @PutMapping("/{trackingNo}")
    public ResponseEntity<CommonResponseBody<Void>> deliveryModify(
        @PathVariable String trackingNo,
        @Valid @RequestBody DeliveryRequestDto deliveryRequestDto) {

        deliveryService.modifyDeliveryByTrackingNo(trackingNo, deliveryRequestDto);

        CommonResponseBody<Void> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.OK.value(),
                ResultMessageEnum.DELIVERY_MODIFY_SUCCESS_MESSAGE.getSuccessMessage()),
            null);

        return ResponseEntity.ok().body(commonResponseBody);
    }

    /**
     * 배송 정보 삭제 요청 시 운송장 번호를 받아 처리합니다.
     *
     * @param trackingNo 배송 정보 삭제를 위해 요청으로 들어온 해당 주문의 운송장 번호
     * @return 삭제 성공 시 200 상태 값을 반환.
     * @author 정재원 *
     */
    @DeleteMapping("/{trackingNo}")
    public ResponseEntity<CommonResponseBody<Void>> deliveryRemove(
        @PathVariable String trackingNo) {

        deliveryService.removeDeliveryByTrackingNo(trackingNo);

        CommonResponseBody<Void> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.NO_CONTENT.value(),
                ResultMessageEnum.DELIVERY_REMOVE_SUCCESS_MESSAGE.getSuccessMessage()),
            null);

        return ResponseEntity.ok().body(commonResponseBody);
    }
}
