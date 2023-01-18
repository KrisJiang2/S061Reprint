package tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReFundUseCaseMapper {

	ReFundDto toReFundDto(int seqNo, String advBranch);

	ReFundDto toReFundDto(ReFund reFund);
}
