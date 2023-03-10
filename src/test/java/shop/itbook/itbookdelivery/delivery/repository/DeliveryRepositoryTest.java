package shop.itbook.itbookdelivery.delivery.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;

/**
 * 배송 엔티티의 Repository 의 테스트 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@DataJpaTest
class DeliveryRepositoryTest {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("insert 성공 케이스")
    void insertTest() {
        Delivery delivery = Delivery.builder()
            .orderNo(1L)
            .receiverName("테스트 수령인이름")
            .receiverAddress("테스트 주소")
            .receiverDetailAddress("테스트 상세주소")
            .receiverPhoneNumber("테스트 전화번호")
            .build();

        delivery.setTrackingNo("1");

        Delivery savedDelivery = deliveryRepository.save(delivery);

        assertThat(savedDelivery.getOrderNo()).isEqualTo(1L);
        assertThat(savedDelivery.getReceiverName()).isEqualTo("테스트 수령인이름");
        assertThat(savedDelivery.getReceiverDetailAddress()).isEqualTo("테스트 상세주소");
        assertThat(savedDelivery.getReceiverPhoneNumber()).isEqualTo("테스트 전화번호");
    }
}