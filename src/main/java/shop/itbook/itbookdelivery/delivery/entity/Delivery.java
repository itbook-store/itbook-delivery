package shop.itbook.itbookdelivery.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 배송 테이블에 대한 엔티티 입니다.
 *
 * @author 강명관
 * @author 정재원
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_no")
    private Long deliveryNo;

    @Column(name = "order_no", nullable = false)
    private Long orderNo;

    @Column(name = "receiver_name", nullable = false, columnDefinition = "varchar(20)")
    private String receiverName;

    @Column(name = "receiver_address", nullable = false, columnDefinition = "varchar(255)")
    private String receiverAddress;

    @Column(name = "receiver_detail_address", nullable = false, columnDefinition = "varchar(255)")
    private String receiverDetailAddress;

    @Column(name = "receiver_phone_number", nullable = false, columnDefinition = "varchar(14)")
    private String receiverPhoneNumber;

    @Column(name = "tracking_no", nullable = false, columnDefinition = "varchar(255)")
    private String trackingNo;

    /**
     * 배송 엔티티에 대한 생성자 입니다.
     *
     * @param orderNo               the order no
     * @param receiverName          the receiver name
     * @param receiverAddress       the receiver address
     * @param receiverDetailAddress the receiver detail address
     * @param receiverPhoneNumber   the receiver phone number
     * @param trackingNo            the delivery tracking no
     * @author 강명관
     * @author 정재원
     */
    @Builder
    public Delivery(Long orderNo, String receiverName, String receiverAddress,
                    String receiverDetailAddress, String receiverPhoneNumber, String trackingNo) {
        this.orderNo = orderNo;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverDetailAddress = receiverDetailAddress;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.trackingNo = trackingNo;
    }
}
