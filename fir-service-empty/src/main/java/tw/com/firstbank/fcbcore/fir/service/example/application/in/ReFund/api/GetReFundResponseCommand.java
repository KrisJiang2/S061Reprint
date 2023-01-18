package tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fcbframework.core.application.in.ResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

@ToString
@Getter
@Setter
public class GetReFundResponseCommand implements ResponseCommand {

    private String returnCode;
    private String returnMsg;
    private ReFund reFund;
}
