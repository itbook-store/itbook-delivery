package shop.itbook.itbookdelivery.delivery.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.itbook.itbookdelivery.deliverystatushistory.entity.DeliveryStatusHistory;

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

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.REMOVE)
    List<DeliveryStatusHistory> deliveryStatusHistory;

    /**
     * 배송 엔티티에 대한 생성자 입니다.
     *
     * @param orderNo               요청으로 들어온 해당 쇼핑몰의 주문의 번호입니다.
     * @param receiverName          요청으로 들어온 수령인의 이름입니다.
     * @param receiverAddress       요청으로 들어온 수령 주소입니다.
     * @param receiverDetailAddress 요청으로 들어온 수령 상세 주소입니다.
     * @param receiverPhoneNumber   요청으로 들어온 수령인의 전화번호입니다.
     * @author 강명관
     * @author 정재원
     */
    @Builder
    public Delivery(Long orderNo, String receiverName, String receiverAddress,
                    String receiverDetailAddress, String receiverPhoneNumber) {
        this.orderNo = orderNo;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverDetailAddress = receiverDetailAddress;
        this.receiverPhoneNumber = receiverPhoneNumber;
    }
}
