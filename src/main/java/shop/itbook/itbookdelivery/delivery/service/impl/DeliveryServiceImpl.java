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

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Long addDelivery(DeliveryRequestDto deliveryRequestDto) {
        Delivery delivery = DeliveryTransfer.dtoToEntity(deliveryRequestDto);
        return deliveryRepository.save(delivery).getDeliveryNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryResponseDto findDeliveryEntity(Long deliveryNo) {
        return DeliveryTransfer.entityToDto(
            deliveryRepository.findById(deliveryNo)
                .orElseThrow(() -> new DeliveryNotFoundException(deliveryNo)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyDelivery(Long deliveryNo, DeliveryRequestDto deliveryRequestDto) {
        Delivery delivery =
            deliveryRepository.findById(deliveryNo)
                .orElseThrow(() -> new DeliveryNotFoundException(deliveryNo));

        updateDelivery(deliveryRequestDto, delivery);

        deliveryRepository.save(delivery);
    }


    private static void updateDelivery(DeliveryRequestDto deliveryRequestDto, Delivery delivery) {
        delivery.setOrderNo(deliveryRequestDto.getOrderNo());
        delivery.setReceiverName(deliveryRequestDto.getReceiverName());
        delivery.setReceiverAddress(deliveryRequestDto.getReceiverAddress());
        delivery.setReceiverDetailAddress(deliveryRequestDto.getReceiverDetailAddress());
        delivery.setReceiverPhoneNumber(deliveryRequestDto.getReceiverPhoneNumber());
        delivery.setTrackingNo(deliveryRequestDto.getTrackingNo());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteDelivery(Long deliveryNo) {
        Delivery delivery =
            deliveryRepository.findById(deliveryNo)
                .orElseThrow(() -> new DeliveryNotFoundException(deliveryNo));

        deliveryRepository.delete(delivery);
    }
}
