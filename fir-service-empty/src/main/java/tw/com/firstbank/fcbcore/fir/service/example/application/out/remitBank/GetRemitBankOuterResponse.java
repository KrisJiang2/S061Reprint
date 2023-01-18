package tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fcbframework.core.application.out.OuterResponse;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class GetRemitBankOuterResponse implements OuterResponse {
    private String returnCode;
    private String dpName;
    private String swiftTid;
    private String nameAddr1;
    private String nameAddr2;

}
