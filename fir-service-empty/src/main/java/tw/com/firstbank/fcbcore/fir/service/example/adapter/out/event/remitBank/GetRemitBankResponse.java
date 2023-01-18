package tw.com.firstbank.fcbcore.fir.service.example.adapter.out.event.remitBank;

import lombok.Getter;
import lombok.Setter;
import tw.com.firstbank.fcbcore.fcbframework.core.application.out.OuterResponse;

@Getter
@Setter
public class GetRemitBankResponse {
    private String returnCode;
    private String dpName;
    private String swiftTid;
    private String nameAddr1;
    private String nameAddr2;

}
