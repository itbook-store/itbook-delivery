package shop.itbook.itbookdelivery.delivery.exception;

/**
 * 배송 엔티티가 존재하지 않을 경우 발생할 예외 클래스 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public class DeliveryNotFoundException extends RuntimeException {

    public DeliveryNotFoundException(Long deliveryNo) {
        super("해당 번호를 가진 배송 정보가 존재하지 않습니다. 번호: " + deliveryNo);
    }
}
