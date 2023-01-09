package shop.itbook.itbookdelivery.deliverystatushistory.service.impl;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.delivery.exception.DeliveryNotFoundException;
import shop.itbook.itbookdelivery.delivery.repository.DeliveryRepository;
import shop.itbook.itbookdelivery.deliverystatus.entity.DeliveryStatus;
import shop.itbook.itbookdelivery.deliverystatus.exception.DeliveryStatusNotFoundException;
import shop.itbook.itbookdelivery.deliverystatus.repository.DeliveryStatusRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.request.DeliveryStatusHistoryRequestDto;
import shop.itbook.itbookdelivery.deliverystatushistory.dto.response.DeliveryStatusHistoryResponseDto;
import shop.itbook.itbookdelivery.deliverystatushistory.entity.DeliveryStatusHistory;
import shop.itbook.itbookdelivery.deliverystatushistory.exception.DeliveryStatusHistoryNotFoundException;
import shop.itbook.itbookdelivery.deliverystatushistory.repository.DeliveryStatusHistoryRepository;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;
import shop.itbook.itbookdelivery.deliverystatushistory.transfer.DeliveryStatusHistoryTransfer;

/**
 * DeliveryStatusHistoryService 인터페이스의 기본 구현체 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
@RequiredArgsConstructor
@Service
public class DeliveryStatusHistoryServiceImpl implements DeliveryStatusHistoryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryStatusRepository deliveryStatusRepository;
    private final DeliveryStatusHistoryRepository deliveryStatusHistoryRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DeliveryStatusHistoryResponseDto findDeliveryStatusHistory(
        DeliveryStatusHistoryRequestDto deliveryStatusHistoryRequestDto) {

        Delivery delivery =
            deliveryRepository.findById(deliveryStatusHistoryRequestDto.getDeliveryNo())
                .orElseThrow(() ->
                    new DeliveryNotFoundException(deliveryStatusHistoryRequestDto.getDeliveryNo()));

        DeliveryStatus deliveryStatus =
            deliveryStatusRepository.findById(deliveryStatusHistoryRequestDto.getDeliveryStatusNo())
                .orElseThrow(() -> new DeliveryStatusNotFoundException(
                    deliveryStatusHistoryRequestDto.getDeliveryStatusNo()));

        DeliveryStatusHistory deliveryStatusHistory =
            DeliveryStatusHistoryTransfer.dtoToEntity(deliveryStatusHistoryRequestDto);

        deliveryStatusHistory.setDelivery(delivery);
        deliveryStatusHistory.setDeliveryStatus(deliveryStatus);

        deliveryStatusHistoryRepository.save(deliveryStatusHistory);

        return DeliveryStatusHistoryTransfer.entityToDto(deliveryStatusHistory);
    }

    @Override
    public DeliveryStatusHistoryResponseDto findDeliveryStatusHistory(
        Long deliveryStatusHistoryNo) {

        DeliveryStatusHistory deliveryStatusHistory =
            deliveryStatusHistoryRepository.findById(deliveryStatusHistoryNo)
                .orElseThrow(
                    () -> new DeliveryStatusHistoryNotFoundException(deliveryStatusHistoryNo));

        return DeliveryStatusHistoryTransfer.entityToDto(deliveryStatusHistory);
    }
}
