package shop.itbook.itbookdelivery.deliverystatushistory.service.impl;

import java.nio.Buffer;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.delivery.exception.DeliveryNotFoundException;
import shop.itbook.itbookdelivery.delivery.repository.DeliveryRepository;
import shop.itbook.itbookdelivery.deliverystatus.entity.DeliveryStatus;
import shop.itbook.itbookdelivery.deliverystatus.entity.deliverystatusenum.DeliveryStatusEnum;
import shop.itbook.itbookdelivery.deliverystatus.exception.DeliveryStatusNotFoundException;
import shop.itbook.itbookdelivery.deliverystatus.repository.DeliveryStatusRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.response.DeliveryStatusHistoryResponseDto;
import shop.itbook.itbookdelivery.deliverystatushistory.entity.DeliveryStatusHistory;
import shop.itbook.itbookdelivery.deliverystatushistory.repository.DeliveryStatusHistoryRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;
import shop.itbook.itbookdelivery.deliverystatushistory.transfer.DeliveryStatusHistoryTransfer;

/**
 * DeliveryStatusHistoryService 인터페이스의 기본 구현체 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryStatusHistoryServiceImpl implements DeliveryStatusHistoryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryStatusRepository deliveryStatusRepository;
    private final DeliveryStatusHistoryRepository deliveryStatusHistoryRepository;
    private static final StringBuffer stringBuffer = new StringBuffer();

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addDeliveryStatusHistory(Delivery delivery) {

        DeliveryStatus deliveryStatus =
            deliveryStatusRepository.findDeliveryStatusByDeliveryStatusEnum(
                    DeliveryStatusEnum.DELIVERY_IN_PROGRESS)
                .orElseThrow(DeliveryStatusNotFoundException::new);

        DeliveryStatusHistory deliveryStatusHistory =
            new DeliveryStatusHistory(stringBuffer.append(delivery.getReceiverAddress())
                .append(" ")
                .append(delivery.getReceiverDetailAddress()).toString());

        deliveryStatusHistory.setDelivery(delivery);
        deliveryStatusHistory.setDeliveryStatus(deliveryStatus);

        deliveryStatusHistoryRepository.save(deliveryStatusHistory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DeliveryStatusHistoryResponseDto findAndUpdateDeliveryStatusHistory(String trackingNo) {

        Delivery delivery = deliveryRepository.findDeliveryByTrackingNo(trackingNo)
            .orElseThrow(() -> new DeliveryNotFoundException(trackingNo));

        DeliveryStatus deliveryStatus =
            deliveryStatusRepository.findDeliveryStatusByDeliveryStatusEnum(
                    DeliveryStatusEnum.DELIVERY_COMPLETED)
                .orElseThrow(DeliveryStatusNotFoundException::new);

        DeliveryStatusHistory deliveryStatusHistory = new DeliveryStatusHistory(
            stringBuffer.append(delivery.getReceiverAddress())
                .append(" ")
                .append(delivery.getReceiverDetailAddress()).toString());


        deliveryStatusHistory.setDelivery(delivery);
        deliveryStatusHistory.setDeliveryStatus(deliveryStatus);

        deliveryStatusHistoryRepository.save(deliveryStatusHistory);

        return DeliveryStatusHistoryTransfer.entityToDto(deliveryStatusHistory);
    }
}
