package shop.itbook.itbookdelivery.deliverystatus.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.itbook.itbookdelivery.deliverystatus.entity.DeliveryStatus;
import shop.itbook.itbookdelivery.deliverystatus.entity.deliverystatusenum.DeliveryStatusEnum;

/**
 * @author 정재원
 * @since 1.0
 */
@DataJpaTest
class DeliveryStatusRepositoryTest {

    @Autowired
    DeliveryStatusRepository deliveryStatusRepository;

    @Test
    @DisplayName("배송 엔티티 상태 데이터베이스 insert 성공")
    void save_success_test() {
        DeliveryStatus deliveryStatus = new DeliveryStatus();
        deliveryStatus.setDeliveryStatusEnum(DeliveryStatusEnum.DELIVERY_IN_PROGRESS);

        DeliveryStatus savedDeliveryStatus = deliveryStatusRepository.save(deliveryStatus);

        assertThat(savedDeliveryStatus.getDeliveryStatusEnum()).isEqualTo(
            DeliveryStatusEnum.DELIVERY_IN_PROGRESS);
    }

    @Test
    @DisplayName("배송 엔티티 상태 데이터베이스에서 select 성공")
    void find_success_test() {
        DeliveryStatus deliveryStatus = new DeliveryStatus();
        deliveryStatus.setDeliveryStatusEnum(DeliveryStatusEnum.DELIVERY_COMPLETED);

        deliveryStatusRepository.save(deliveryStatus);

        DeliveryStatus foundDeliveryStatus =
            deliveryStatusRepository.findById(deliveryStatus.getDeliveryStatusNo())
                .orElseThrow();

        assertThat(foundDeliveryStatus.getDeliveryStatusEnum()).isEqualTo(
            deliveryStatus.getDeliveryStatusEnum());
    }
}