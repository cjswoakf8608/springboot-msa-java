package com.demo.project.apps.infrastructure.integration.payments.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
public class PaymentConfirmResponse {

    @Schema(description = "응답 버전", example = "v1.2", required = true)
    private String version;

    @Schema(description = "결제 키", example = "k7Z3y47BMw6", required = true, maxLength = 200)
    private String paymentKey;

    @Schema(description = "결제 타입", example = "NORMAL", allowableValues = {"NORMAL", "BILLING", "BRANDPAY"}, required = true)
    private String type;

    @Schema(description = "주문 번호", example = "ORDER123456", required = true, minLength = 6, maxLength = 64)
    private String orderId;

    @Schema(description = "구매 상품", example = "생수 외 1건", maxLength = 100)
    private String orderName;

    @Schema(description = "상점 ID", example = "MID123456", required = true, maxLength = 14)
    private String mId;

    @Schema(description = "결제 통화", example = "KRW", required = true)
    private String currency;

    @Schema(description = "결제 수단", example = "CARD", allowableValues = {"카드", "가상계좌", "간편결제", "휴대폰", "계좌이체", "문화상품권", "도서문화상품권", "게임문화상품권"})
    private String method;

    @Schema(description = "총 결제 금액", example = "10000", required = true)
    private Integer totalAmount;

    @Schema(description = "취소할 수 있는 금액(잔고)", example = "5000")
    private Integer balanceAmount;

    @Schema(description = "결제 처리 상태", example = "DONE", allowableValues = {"READY", "IN_PROGRESS", "WAITING_FOR_DEPOSIT", "DONE", "CANCELED", "PARTIAL_CANCELED", "ABORTED", "EXPIRED"}, required = true)
    private String status;

    @Schema(description = "결제가 요청된 시간", example = "2022-01-01T00:00:00+09:00", required = true)
    private String requestedAt;

    @Schema(description = "결제 승인이 발생한 시간", example = "2022-01-01T01:00:00+09:00")
    private String approvedAt;

    @Schema(description = "에스크로 사용 여부", example = "false")
    private Boolean useEscrow;

    @Schema(description = "마지막 거래의 키 값", example = "Tx123456", maxLength = 64)
    private String lastTransactionKey;

    @Schema(description = "공급가액", example = "9090")
    private Integer suppliedAmount;

    @Schema(description = "부가세", example = "909")
    private Integer vat;

    @Schema(description = "문화비 지출 여부", example = "false")
    private Boolean cultureExpense;

    @Schema(description = "면세 금액", example = "0")
    private Integer taxFreeAmount;

    @Schema(description = "과세 제외 금액", example = "0")
    private Integer taxExemptionAmount;

    @Schema(description = "결제 취소 내역")
    private List<Cancel> cancels;

    @Schema(description = "환불 가능한 잔액", example = "5000")
    private Integer refundableAmount;

    @Schema(description = "결제 상태가 바뀔 수 있는 시간", example = "2022-01-01T02:00:00+09:00")
    private String canceledAt;

    @Schema(description = "취소된 금액", example = "5000")
    private Integer cancelAmount;

    @Schema(description = "간편결제 할인 금액", example = "1000")
    private Integer easyPayDiscountAmount;

    @Schema(description = "카드 관련 정보")
    private Card card;

    @Schema(description = "가상계좌 관련 정보")
    private VirtualAccount virtualAccount;

    @Schema(description = "현금영수증 관련 정보")
    private CashReceipt cashReceipt;

    @Schema(description = "기타 메타데이터 정보")
    private Object metadata;

    @Schema(description = "간편결제 정보")
    private EasyPay easyPay;

    @Schema(description = "실패 정보")
    private Failure failure;

    // 내포된 클래스 정의 (취소 이력, 카드, 가상계좌, 현금영수증, 간편결제, 실패)
    @Getter
    @Setter
    @Schema(description = "취소 내역")
    public static class Cancel {
        @Schema(description = "취소된 금액", example = "5000")
        private Integer cancelAmount;

        @Schema(description = "취소 이유", example = "상품 결함", maxLength = 200)
        private String cancelReason;

        @Schema(description = "취소된 면세 금액", example = "0")
        private Integer taxFreeAmount;

        @Schema(description = "취소된 과세 제외 금액", example = "0")
        private Integer taxExemptionAmount;

        @Schema(description = "환불 가능한 잔액", example = "5000")
        private Integer refundableAmount;

        @Schema(description = "취소된 날짜", example = "2022-01-01T02:00:00+09:00")
        private String canceledAt;

        @Schema(description = "취소 거래의 키 값", example = "Tx123456", maxLength = 64)
        private String transactionKey;
    }

    @Getter
    @Setter
    @Schema(description = "카드 정보")
    public static class Card {
        @Schema(description = "카드번호", example = "1234-****-****-5678", maxLength = 20)
        private String number;

        @Schema(description = "카드 승인 번호", example = "A12345", maxLength = 8)
        private String approveNo;

        @Schema(description = "할부 개월 수", example = "0")
        private Integer installmentPlanMonths;

        @Schema(description = "무이자 할부 여부", example = "false")
        private Boolean isInterestFree;

        @Schema(description = "카드 종류", example = "신용", allowableValues = {"신용", "체크", "기프트", "미확인"})
        private String cardType;

        @Schema(description = "카드 소유자 타입", example = "개인", allowableValues = {"개인", "법인", "미확인"})
        private String ownerType;

        @Schema(description = "매입 상태", example = "COMPLETED", allowableValues = {"READY", "REQUESTED", "COMPLETED", "CANCEL_REQUESTED", "CANCELED"})
        private String acquireStatus;
    }

    @Getter
    @Setter
    @Schema(description = "가상계좌 정보")
    public static class VirtualAccount {
        @Schema(description = "가상계좌 번호", example = "1234567890123456", maxLength = 20)
        private String accountNumber;

        @Schema(description = "은행 코드", example = "020", maxLength = 3)
        private String bankCode;

        @Schema(description = "입금 기한", example = "2022-01-01T00:00:00+09:00")
        private String dueDate;
    }

    @Getter
    @Setter
    @Schema(description = "현금영수증 정보")
    public static class CashReceipt {
        @Schema(description = "현금영수증 발급 번호", example = "123456789", maxLength = 9)
        private String issueNumber;

        @Schema(description = "발행된 영수증 URL", example = "http://example.com/receipt")
        private String receiptUrl;
    }

    @Getter
    @Setter
    @Schema(description = "간편결제 정보")
    public static class EasyPay {
        @Schema(description = "간편결제 금액", example = "10000")
        private Integer amount;

        @Schema(description = "간편결제 할인 금액", example = "1000")
        private Integer discountAmount;
    }

    @Getter
    @Setter
    @Schema(description = "실패 정보")
    public static class Failure {
        @Schema(description = "에러 코드", example = "ERR001")
        private String code;

        @Schema(description = "에러 메시지", example = "승인 실패", maxLength = 510)
        private String message;
    }

    // 비어있는 지 검증
    public boolean isEmpty() {
        return (this.paymentKey == null && this.orderId == null);
    }

}
