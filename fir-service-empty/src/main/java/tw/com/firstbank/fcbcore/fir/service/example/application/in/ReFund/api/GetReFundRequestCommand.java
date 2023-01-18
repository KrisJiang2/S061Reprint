package tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetReFundRequestCommand {
    private Integer seqNo;
    private String advBranch;
}
