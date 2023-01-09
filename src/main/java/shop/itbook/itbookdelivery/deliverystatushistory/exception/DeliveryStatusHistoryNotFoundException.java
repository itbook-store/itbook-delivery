package shop.itbook.itbookdelivery.deliverystatushistory.exception;

/**
 * 요청한 배송 조회 상태 이력 관련 정보가 없을 경우 발생할 예외 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public class DeliveryStatusHistoryNotFoundException extends RuntimeException {
    public DeliveryStatusHistoryNotFoundException(Long deliveryStatusHistoryNo) {
        super("해당 번호를 가진 배송 상태 이력이 존재하지 않습니다. 번호: " + deliveryStatusHistoryNo);
    }
}
