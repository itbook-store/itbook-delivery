package shop.itbook.itbookdelivery.delivery.service.impl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.delivery.repository.DeliveryRepository;
import shop.itbook.itbookdelivery.delivery.service.DeliveryService;
import shop.itbook.itbookdelivery.deliverystatus.entity.deliverystatusenum.DeliveryStatusEnum;
import shop.itbook.itbookdelivery.deliverystatus.repository.DeliveryStatusRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.repository.DeliveryStatusHistoryRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;
import shop.itbook.itbookdelivery.deliverystatushistory.service.impl.DeliveryStatusHistoryServiceImpl;

/**
 * @author 정재원
 * @since 1.0
 */
@ExtendWith(SpringExtension.class)
@Import({DeliveryServiceImpl.class, DeliveryStatusHistoryServiceImpl.class})
class DeliveryServiceTest {

    @Autowired
    DeliveryService deliveryService;

    @MockBean
    DeliveryStatusHistoryService deliveryStatusHistoryService;

    @MockBean
    DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("배송 정보 등록 성공")
    void addDelivery() {
    }

    @Test
    void findDeliveryByTrackingNo() {
    }

    @Test
    void modifyDeliveryByTrackingNo() {
    }

    @Test
    void removeDeliveryByTrackingNo() {
    }
}