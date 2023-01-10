package shop.itbook.itbookdelivery.deliverystatus.resultmessageenum;

/**
 * 배송 상태 관련 서비스 성공 시 사용 할 메세지 입니다.
 *
 * @author 정재원
 * @since 1.0
 */
public enum ResultMessageEnum {

    DELIVERY_STATUS_ADD_SUCCESS_MESSAGE("배송 상태 등록 성공했습니다."),
    DELIVERY_STATUS_FIND_SUCCESS_MESSAGE("배송 상태 조회 성공했습니다."),
    DELIVERY_STATUS_MODIFY_SUCCESS_MESSAGE("배송 상태 수정 성공했습니다."),
    DELIVERY_STATUS_DELETE_SUCCESS_MESSAGE("배송 상태 삭제 성공했습니다.");

    private final String successMessage;

    ResultMessageEnum(String successMessage) {
        this.successMessage = successMessage;
    }
}
