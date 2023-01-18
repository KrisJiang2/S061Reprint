package tw.com.firstbank.fcbcore.fir.service.example.application.out.print;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class PrintOuterResponse {
    private String lkRtnCod;
    private String lkFormTypeCode;
    private String lkProcessBrn;
    private String lkTernId;
    private String lkIrReportProcMode;
    private String lkIrReportTime;
    private String lkIrReportDate;
    private String lkIrReportVersion;
    private String lkIrReportOperId;
    private String lkIrReportOperName;
}
