package shop.itbook.itbookdelivery.delivery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.itbook.itbookdelivery.common.response.CommonResponseBody;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryNoResponseDto;
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
     * Save delivery response entity.
     *
     * @param deliveryRequestDto the delivery request dto
     * @return the response entity
     * @author 정재원 *
     */
    @PostMapping
    public ResponseEntity<CommonResponseBody<DeliveryNoResponseDto>> saveDelivery(
        DeliveryRequestDto deliveryRequestDto) {

        DeliveryNoResponseDto deliveryNoResponseDto =
            new DeliveryNoResponseDto(deliveryService.saveDelivery(deliveryRequestDto));

        CommonResponseBody<DeliveryNoResponseDto> commonResponseBody = new CommonResponseBody<>(
            new CommonResponseBody.CommonHeader(true, HttpStatus.CREATED.value(),
                "등록 성공"), deliveryNoResponseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponseBody);
    }
}
