package tw.com.firstbank.fcbcore.fir.service.example.adapter.out.event.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.out.event.remitBank.GetRemitBankRequest;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.remitBank.GetRemitBankOuterRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RemitBankMapper {

	GetRemitBankRequest toGetRemitBankRequest(GetRemitBankOuterRequest source);

	GetRemitBankOuterRequest toGetRemitBankOuterResponse(GetRemitBankRequest source);

}
