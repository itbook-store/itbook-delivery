package shop.itbook.itbookdelivery.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
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
    public Long saveDelivery(DeliveryRequestDto deliveryRequestDto) {
        Delivery delivery = DeliveryTransfer.dtoToEntity(deliveryRequestDto);
        return deliveryRepository.save(delivery).getDeliveryNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delivery findDeliveryEntity(Long deliveryNo) {
        return deliveryRepository.findById(deliveryNo).orElseThrow(DeliveryNotFoundException::new);
    }
}
