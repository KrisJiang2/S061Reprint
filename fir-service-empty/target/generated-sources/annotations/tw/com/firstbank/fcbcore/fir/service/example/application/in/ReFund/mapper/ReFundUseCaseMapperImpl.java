package tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-16T15:15:47+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ReFundUseCaseMapperImpl implements ReFundUseCaseMapper {

    @Override
    public ReFundDto toReFundDto(int seqNo, String advBranch) {
        if ( advBranch == null ) {
            return null;
        }

        ReFundDto reFundDto = new ReFundDto();

        reFundDto.setSeqNo( seqNo );
        reFundDto.setAdvBranch( advBranch );

        return reFundDto;
    }
}
