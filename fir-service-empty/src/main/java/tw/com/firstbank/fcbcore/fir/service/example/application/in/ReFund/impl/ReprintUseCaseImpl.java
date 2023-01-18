package tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.impl;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fcbframework.core.application.in.QueryHandler;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.ReFundService;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.api.GetReFundUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper.ReFundUseCaseMapper;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.print.PrintOuterRequest;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.print.PrintOuterResponse;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

/**
 * The type Get reFund.
 */
@Service
@AllArgsConstructor
public class ReprintUseCaseImpl extends GetReFundUseCaseApi implements QueryHandler {

	private final ReFundService reFundService;

	private static final ReFundUseCaseMapper mapper = Mappers.getMapper(ReFundUseCaseMapper.class);

	/**
	 * 1.取得退匯資料放到outerRequest
	 * 2.判斷退匯資料內的劃帳行去取得劃帳行資料放到outerRequest
	 * 3.將outerRequest丟給printService取得outerResponse
	 * 4.將outerResponse轉換成ResponseCommand
	 *
	 * GetReFundOuterRequestCommand 裡面有所有要丟給printService的欄位
	 * GetReFundOuterResponseCommand 裡面有String 電文,String ReturnCode,String ReturnMessage
	 * GetReFundResponseCommand 裡面有String 電文,String ReturnCode,String ReturnMessage
	 *
	 * @param requestCommand
	 * @return
	 */
	@Override
	public GetReFundResponseCommand execute(GetReFundRequestCommand requestCommand) {
		PrintOuterRequest printOuterRequestCommand = new PrintOuterRequest();
		PrintOuterResponse printOuterResponseCommand = new PrintOuterResponse();
		GetReFundResponseCommand responseCommand = new GetReFundResponseCommand();
		//1 getReFund
		try {
			ReFund reFund = reFundService.getReFund(requestCommand.getSeqNo(), requestCommand.getAdvBranch()).getReFund();

			if(reFund.getDepositBank().isBlank()){

				responseCommand.setReFund(reFund);
			}else {
				if(!reFund.getSw54d1().equals(reFund.getDepositBank())){

				}else {

				}
			}

		} catch (Exception e) {
			responseCommand.setReturnCode("SYSTEM-999");
			responseCommand.setReturnMsg("call s061service getReFund fail");
			return responseCommand;
		}

		//2 and call print service

		//3 set refundstring into gerrefundresponsecommand

		responseCommand.setReturnCode("SYSTEM-000");
		responseCommand.setReturnMsg("success");
		return responseCommand;
	}
}
