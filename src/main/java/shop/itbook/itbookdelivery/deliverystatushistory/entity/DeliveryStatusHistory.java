package shop.itbook.itbookdelivery.deliverystatushistory.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.deliverystatus.entity.DeliveryStatus;

/**
 * 배송 상태 이력 테이블에 대한 엔티티 입니다.
 *
 * @author 강명관
 * @since 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_status_history")
public class DeliveryStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_status_history_no")
    private Long deliveryStatusHistoryNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_no", nullable = false)
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_status_no", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "status_changed_created_at", nullable = false, columnDefinition = "default now()")
    private LocalDateTime statusChangedCreatedAt;

    @Column(name = "location", nullable = false, columnDefinition = "varchar(255)")
    private String location;

    /**
     * 배송 상태 이력을 생성 하기 위한 생성자입니다.
     *
     * @param delivery               the delivery
     * @param deliveryStatus         the delivery status
     * @param statusChangedCreatedAt the status changed created at
     * @param location               the location
     */
    @Builder
    public DeliveryStatusHistory(Delivery delivery, DeliveryStatus deliveryStatus,
                                 LocalDateTime statusChangedCreatedAt, String location) {
        this.delivery = delivery;
        this.deliveryStatus = deliveryStatus;
        this.statusChangedCreatedAt = LocalDateTime.now();
        this.location = location;
    }
}
