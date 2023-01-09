package shop.itbook.itbookdelivery.deliverystatus.exception;

/**
 * 유효하지 않은 배송 상태 정보를 참조할려 할 시 발생하는 에러입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public class DeliveryStatusNotFoundException extends RuntimeException {
    public DeliveryStatusNotFoundException(Integer deliveryStatusNo) {
        super("해당 번호를 가진 배송 상태가 존재하지 않습니다. 번호: " + deliveryStatusNo);
    }
}
