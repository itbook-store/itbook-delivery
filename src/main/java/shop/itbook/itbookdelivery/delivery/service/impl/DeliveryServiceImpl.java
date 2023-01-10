package shop.itbook.itbookdelivery.delivery.service.impl;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.dto.response.DeliveryResponseDto;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.delivery.exception.DeliveryNotFoundException;
import shop.itbook.itbookdelivery.delivery.repository.DeliveryRepository;
import shop.itbook.itbookdelivery.delivery.service.DeliveryService;
import shop.itbook.itbookdelivery.delivery.transfer.DeliveryTransfer;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;

/**
 * DeliveryService 인터페이스를 구현한 클래스입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@RequiredArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryStatusHistoryService deliveryStatusHistoryService;

    private static final Long TRACKING_SEQUENCE_NUMBER = 1L;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public String addDelivery(DeliveryRequestDto deliveryRequestDto) {
        Delivery delivery = DeliveryTransfer.dtoToEntity(deliveryRequestDto);

        // TODO 멀티쓰레드 고려. 유니크 아이디.
        delivery.setTrackingNo(
            String.valueOf(deliveryRepository.count() + TRACKING_SEQUENCE_NUMBER));

        deliveryRepository.save(delivery);
        deliveryStatusHistoryService.addDeliveryStatusHistory(delivery);

        return delivery.getTrackingNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryResponseDto findDeliveryByTrackingNo(String trackingNo) {
        return DeliveryTransfer.entityToDto(
            deliveryRepository.findDeliveryByTrackingNo(trackingNo)
                .orElseThrow(() -> new DeliveryNotFoundException(trackingNo)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void modifyDeliveryByTrackingNo(String trackingNo,
                                           DeliveryRequestDto deliveryRequestDto) {
        Delivery delivery =
            deliveryRepository.findDeliveryByTrackingNo(trackingNo)
                .orElseThrow(() -> new DeliveryNotFoundException(trackingNo));

        updateDelivery(deliveryRequestDto, delivery);

        deliveryRepository.save(delivery);
    }

    private static void updateDelivery(DeliveryRequestDto deliveryRequestDto, Delivery delivery) {
        delivery.setOrderNo(deliveryRequestDto.getOrderNo());
        delivery.setReceiverName(deliveryRequestDto.getReceiverName());
        delivery.setReceiverAddress(deliveryRequestDto.getReceiverAddress());
        delivery.setReceiverDetailAddress(deliveryRequestDto.getReceiverDetailAddress());
        delivery.setReceiverPhoneNumber(deliveryRequestDto.getReceiverPhoneNumber());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void removeDeliveryByTrackingNo(String trackingNo) {
        Delivery delivery =
            deliveryRepository.findDeliveryByTrackingNo(trackingNo)
                .orElseThrow(() -> new DeliveryNotFoundException(trackingNo));

        deliveryRepository.delete(delivery);
    }
}
