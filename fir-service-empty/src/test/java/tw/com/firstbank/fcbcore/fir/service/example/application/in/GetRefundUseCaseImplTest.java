package tw.com.firstbank.fcbcore.fir.service.example.application.in;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.ReFundService;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.impl.ReprintUseCaseImpl;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper.ReFundDto;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.repository.RefundRepository;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.GetRemitBankOuterRequest;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.GetRemitBankOuterResponse;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetRefundUseCaseImplTest {

    @Mock
    private ReFundService reFundService;

    @Mock
    private RefundRepository refundRepository;

    private ReprintUseCaseImpl getReFund;
    @BeforeEach
    public void setup() {
        openMocks(this);
        getReFund = new ReprintUseCaseImpl(reFundService);
    }

    @Test
    void getRefundExecute_WillReturn_ReFund() throws Exception {
        //arrange
        GetReFundRequestCommand requestCommand = new GetReFundRequestCommand();
        requestCommand.setSeqNo(1234567);
        requestCommand.setAdvBranch("091");

        ReFundDto dto = new ReFundDto();
        dto.setVersion("");
        dto.setAdvBranch("");
        dto.setCurrency("");
        dto.setIrAmt(BigDecimal.valueOf(10));
        dto.setSpotBoughFxrate("");
        dto.setCommTotal("");
        dto.setSpotSettledNt("");
        dto.setReAmt(BigDecimal.valueOf(10));
        dto.setReturnReason("");
        dto.setSw54d1("");
        dto.setDepositBank("");
        ReFund reFund = new ReFund(dto);

        GetRemitBankOuterRequest getRemitBankOuterRequest = new GetRemitBankOuterRequest();
        getRemitBankOuterRequest.setDepositBank("ABC");

        GetRemitBankOuterResponse getRemitBankOuterResponse = new GetRemitBankOuterResponse();
        getRemitBankOuterResponse.setReturnCode("0000");
        getRemitBankOuterResponse.setDpName("三重分行");
        getRemitBankOuterResponse.setSwiftTid("BKTWTWTP042");
        getRemitBankOuterResponse.setNameAddr1("新北市");
        getRemitBankOuterResponse.setNameAddr2("三重");

        when(reFundService.getRemitBank(getRemitBankOuterRequest)).thenReturn(getRemitBankOuterResponse);

        //getReFund
        when(refundRepository.getReFund(requestCommand.getSeqNo(),requestCommand.getAdvBranch())).thenReturn(Optional.of(reFund));

        //act
        GetReFundResponseCommand output = getReFund.execute(requestCommand);

        //then validate
        verify(reFundService).getReFund(any(),any());
        verify(reFundService).getRemitBank(any());

    }
}
