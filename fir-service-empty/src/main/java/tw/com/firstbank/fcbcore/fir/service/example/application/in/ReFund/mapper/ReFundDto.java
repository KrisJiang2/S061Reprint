package tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper;

import lombok.Getter;
import lombok.Setter;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

import java.math.BigDecimal;

@Setter
@Getter
public class ReFundDto {

	private int seqNo;
	private String advBranch;
	private String depositBank;
	private String sw54d1;
    private String version;
    private String currency;
    private BigDecimal irAmt;
    private String spotBoughFxrate;
    private String commTotal;
    private String spotSettledNt;
    private BigDecimal reAmt;
    private String returnReason;
}
