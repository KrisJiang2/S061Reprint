package tw.com.firstbank.fcbcore.fir.service.example.application.in;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tw.com.firstbank.fcbcore.fcbframework.core.application.exception.BusinessException;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.ReFundService;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper.ReFundDto;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.Remitbank.RemitBankService;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.RemitBankServiceApi;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.repository.RefundRepository;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class RefundServiceTest {

    @Mock
    private RefundRepository s061Repository;

    @Mock
    private RemitBankServiceApi remitBankService;

    private ReFundService reFundService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        reFundService = new ReFundService(remitBankService,s061Repository);
    }

    @Test
    void 假如我要取得退匯交易檔資料_取得退匯交易檔_成功() throws Exception {

        // Arrange
        GetReFundRequestCommand requestCommand = new GetReFundRequestCommand();
        requestCommand.setSeqNo(1234567);
        requestCommand.setAdvBranch("091");

        ReFundDto reFundDto = new ReFundDto();
        reFundDto.setSeqNo(1234567);
        reFundDto.setAdvBranch("091");

        Optional<ReFund> reFund = Optional.of(new ReFund(reFundDto));

        when(s061Repository.getReFund(requestCommand.getSeqNo(),requestCommand.getAdvBranch())).thenReturn(reFund);

        // Act
        GetReFundResponseCommand getReFundOutput = reFundService.getReFund(requestCommand.getSeqNo(), requestCommand.getAdvBranch());

        // Assert
        verify(s061Repository).getReFund(any(), any());
        assertEquals("0000",getReFundOutput.getReturnCode());
    }

    @Test
    void 假如我要取得退匯交易檔資料_取得退匯交易檔_失敗() throws Exception {

        // Arrange
        doThrow(BusinessException.class).when(s061Repository).getReFund(any(), any());

        // Act
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            reFundService.getReFund(any(), any());
        });

        // Assert
        verify(s061Repository).getReFund(any(), any());
        assertEquals("查詢失敗",exception.getMessage());
    }

 @Test
void 假如我要取得退匯交易檔資料_取得退匯交易檔_無資料() throws Exception {

        // Arrange
        GetReFundRequestCommand requestCommand = new GetReFundRequestCommand();
        requestCommand.setSeqNo(1234568);
        requestCommand.setAdvBranch("091");

        when(s061Repository.getReFund(requestCommand.getSeqNo(),requestCommand.getAdvBranch())).thenReturn(Optional.empty());

        // Act
        GetReFundResponseCommand getReFundOutput = reFundService.getReFund(requestCommand.getSeqNo(), requestCommand.getAdvBranch());

        // Assert
        verify(s061Repository).getReFund(any(), any());
        assertEquals("9998",getReFundOutput.getReturnCode());
    }
}

