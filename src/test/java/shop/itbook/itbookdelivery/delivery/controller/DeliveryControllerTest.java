package shop.itbook.itbookdelivery.delivery.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import shop.itbook.itbookdelivery.delivery.dto.request.DeliveryRequestDto;
import shop.itbook.itbookdelivery.delivery.entity.Delivery;
import shop.itbook.itbookdelivery.delivery.service.DeliveryService;
import shop.itbook.itbookdelivery.delivery.transfer.DeliveryTransfer;
import shop.itbook.itbookdelivery.deliverystatushistory.service.DeliveryStatusHistoryService;

/**
 * @author 정재원
 * @since 1.0
 */
@WebMvcTest(DeliveryController.class)
class DeliveryControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    DeliveryController deliveryController;
    @MockBean
    DeliveryService deliveryService;
    @MockBean
    DeliveryStatusHistoryService deliveryStatusHistoryService;
    @Autowired
    ObjectMapper objectMapper;

    @Disabled
    @Test
    @DisplayName("배송 정보 저장 요청 성공")
    void addDelivery_success_test() throws Exception {

        //given
        DeliveryRequestDto deliveryRequestDto = new DeliveryRequestDto();
        ReflectionTestUtils.setField(deliveryRequestDto, "orderNo", 1L);
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverName", "수령인이름");
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverAddress", "수령주소");
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverDetailAddress", "수령상세주소");
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverPhoneNumber", "수령핸드폰번호");

        given(deliveryService.addDelivery(any(DeliveryRequestDto.class))).willReturn(
            DeliveryTransfer.entityToDto(DeliveryTransfer.dtoToEntity(deliveryRequestDto))
        );

        doNothing().when(deliveryStatusHistoryService)
            .addDeliveryStatusHistory(any(Delivery.class));

        //when
        mockMvc.perform(post("/api/deliveries")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(deliveryRequestDto)))
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.result.receiverPhoneNumber", equalTo("수령핸드폰번호")));
    }

    @Disabled
    @Test
    @DisplayName("배송 정보 저장 요청 실패 - 필수 정보가 없을 경우")
    void addDelivery_fail_test() throws Exception {

        //given
        DeliveryRequestDto deliveryRequestDto = new DeliveryRequestDto();
        ReflectionTestUtils.setField(deliveryRequestDto, "orderNo", 1L);
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverAddress", "수령주소");
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverDetailAddress", "수령상세주소");
        ReflectionTestUtils.setField(deliveryRequestDto, "receiverPhoneNumber", "수령핸드폰번호");

        doNothing().when(deliveryStatusHistoryService)
            .addDeliveryStatusHistory(any(Delivery.class));

        mockMvc.perform(post("/api/deliveries")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(deliveryRequestDto)))
            .andExpect(status().isBadRequest());
    }
}