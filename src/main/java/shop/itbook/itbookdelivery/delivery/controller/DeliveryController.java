package shop.itbook.itbookdelivery.delivery.controller;

import javax.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.DB2Dialect;
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
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryNoResponseDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryResponseDto;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.delivery.resultmessageenum.ResultMessageEnum;
import shop.itbook.itbookdelivery.delivery.service.DeliveryService;

/**
 * 배송 관련 요청을 받고 처리하는 컨트롤러입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@RestController
@RequestMapping("api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    /**
     * 요청받은 배송 정보로 배송 엔티티를 만들고 DB 에 등록한 뒤 성공하면 Pk 인 배송 번호를 반환한다.
     *
     * @param deliveryRequestDto the delivery request dto
     * @return the response entity
     * @author 정재원 *
     */
    @PostMapping
    public ResponseEntity<CommonResponseBody<DeliveryNoResponseDto>> deliveryAdd(
        @Valid @RequestBody DeliveryRequestDto deliveryRequestDto) {

        DeliveryNoResponseDto deliveryNoResponseDto =
            new DeliveryNoResponseDto(deliveryService.addDelivery(deliveryRequestDto));

        CommonResponseBody<DeliveryNoResponseDto> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.CREATED.value(),
                ResultMessageEnum.DELIVERY_ADD_SUCCESS_MESSAGE.getSuccessMessage()),
            deliveryNoResponseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponseBody);
    }

    /**
     * 배송 테이블에서 요청한 배송번호로 정보를 조회하여 배송 관련 정보를 모두 포함하는 Dto 를 반환하는 메서드입니다.
     *
     * @param deliveryNo the delivery no
     * @return 요청 성공 했다는 헤더와 요청한 배송 엔티티 정보.
     * @author 정재원 *
     */
    @GetMapping
    public ResponseEntity<CommonResponseBody<DeliveryResponseDto>> deliveryFind(
        @PathVariable Long deliveryNo) {

        CommonResponseBody<DeliveryResponseDto> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.OK.value(),
                ResultMessageEnum.DELIVERY_FIND_SUCCESS_MESSAGE.getSuccessMessage()),
            deliveryService.findDeliveryEntity(deliveryNo));

        return ResponseEntity.ok().body(commonResponseBody);
    }

    /**
     * Delivery modify response entity.
     *
     * @param deliveryNo         the delivery no
     * @param deliveryRequestDto the delivery request dto
     * @return the response entity
     * @author 정재원 *
     */
    @PutMapping
    public ResponseEntity<CommonResponseBody<Void>> deliveryModify(
        @PathVariable Long deliveryNo,
        @Valid @RequestBody DeliveryRequestDto deliveryRequestDto) {

        deliveryService.modifyDelivery(deliveryNo, deliveryRequestDto);

        CommonResponseBody<Void> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.OK.value(),
                ResultMessageEnum.DELIVERY_MODIFY_SUCCESS_MESSAGE.getSuccessMessage()),
            null);

        return ResponseEntity.ok().body(commonResponseBody);
    }

    /**
     * Pk 인 deliveryNo(배송번호) 를 받아서 해당 배송 정보를 삭제합니다.
     *
     * @param deliveryNo the delivery no
     * @return the response entity
     * @author 정재원 *
     */
    @DeleteMapping
    public ResponseEntity<CommonResponseBody<Void>> deliveryDelete(
        @PathVariable Long deliveryNo) {

        deliveryService.deleteDelivery(deliveryNo);

        CommonResponseBody<Void> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.NO_CONTENT.value(),
                ResultMessageEnum.DELIVERY_DELETE_SUCCESS_MESSAGE.getSuccessMessage()),
            null);

        return ResponseEntity.ok().body(commonResponseBody);
    }
}
