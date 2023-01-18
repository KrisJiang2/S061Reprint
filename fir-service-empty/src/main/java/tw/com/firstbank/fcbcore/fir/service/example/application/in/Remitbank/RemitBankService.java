package tw.com.firstbank.fcbcore.fir.service.example.application.in.Remitbank;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fcbframework.core.application.exception.BusinessException;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.GetRemitBankOuterRequest;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.GetRemitBankOuterResponse;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.RemitBankServiceApi;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.repository.RefundRepository;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemitBankService {

    private final RemitBankServiceApi remitBankService;
    private final RefundRepository s061Repository;

    /**
     *
     * @param outerRequest
     * @return
     */
    public GetRemitBankOuterResponse getRemitBank(GetRemitBankOuterRequest outerRequest){

        GetRemitBankOuterResponse outerResponse = null;
        try {
            outerResponse = remitBankService.getRemitBank(outerRequest);
            if(!outerResponse.getReturnCode().equals("0000")) {
                outerResponse.setDpName("*");
                outerResponse.setSwiftTid("");
                outerResponse.setNameAddr1("*");
                outerResponse.setNameAddr2("*");
            }
        } catch (Exception e) {
            throw new BusinessException("9999", "查詢失敗");
        }
        return outerResponse;
    }
}
