package tw.com.firstbank.fcbcore.fir.service.example.adapter.out.event.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.out.event.remitBank.GetRemitBankRequest;
import tw.com.firstbank.fcbcore.fir.service.example.application.out.repository.remitBank.GetRemitBankOuterRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-13T15:31:47+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class RemitBankMapperImpl implements RemitBankMapper {

    @Override
    public GetRemitBankRequest toGetRemitBankRequest(GetRemitBankOuterRequest source) {
        if ( source == null ) {
            return null;
        }

        GetRemitBankRequest getRemitBankRequest = new GetRemitBankRequest();

        getRemitBankRequest.setDepositBank( source.getDepositBank() );

        return getRemitBankRequest;
    }

    @Override
    public GetRemitBankOuterRequest toGetRemitBankOuterResponse(GetRemitBankRequest source) {
        if ( source == null ) {
            return null;
        }

        GetRemitBankOuterRequest getRemitBankOuterRequest = new GetRemitBankOuterRequest();

        getRemitBankOuterRequest.setDepositBank( source.getDepositBank() );

        return getRemitBankOuterRequest;
    }
}
