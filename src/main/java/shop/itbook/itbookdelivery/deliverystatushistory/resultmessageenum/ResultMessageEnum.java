package shop.itbook.itbookdelivery.deliverystatushistory.resultmessageenum;

import lombok.Getter;

/**
 * @author 정재원
 * @since 1.0
 */
@Getter
public enum ResultMessageEnum {

    DELIVERY_STATUS_HISTORY_ADD_SUCCESS_MESSAGE("배송 상태 정보 등록 성공했습니다."),
    DELIVERY_STATUS_HISTORY_FIND_SUCCESS_MESSAGE("배송 상태 정보 조회 성공했습니다."),
    DELIVERY_STATUS_HISTORY_MODIFY_SUCCESS_MESSAGE("배송 상태 정보 수정 성공했습니다."),
    DELIVERY_STATUS_HISTORY_REMOVE_SUCCESS_MESSAGE("배송 상태 정보 삭제 성공했습니다.");

    private final String successMessage;

    ResultMessageEnum(String successMessage) {
        this.successMessage = successMessage;
    }
}
