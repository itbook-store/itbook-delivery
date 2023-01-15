package shop.itbook.itbookdelivery.deliverystatus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.itbook.itbookdelivery.deliverystatus.entity.deliverystatusenum.DeliveryStatusEnum;

/**
 * 배송 상태 테이블에 대한 엔티티 입니다.
 *
 * @author 강명관
 * @author 정재원
 * @since 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "delivery_status")
public class DeliveryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_status_no")
    private Integer deliveryStatusNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status_name", nullable = false, columnDefinition = "varchar(20)", unique = true)
    private DeliveryStatusEnum deliveryStatusEnum;
}
