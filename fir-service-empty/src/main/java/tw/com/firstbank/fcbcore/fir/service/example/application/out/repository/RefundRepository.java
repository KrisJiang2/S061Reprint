package tw.com.firstbank.fcbcore.fir.service.example.application.out.repository;

import tw.com.firstbank.fcbcore.fir.service.example.domain.reFund.ReFund;

import java.util.Optional;

public interface RefundRepository {
     Optional<ReFund> getReFund(Integer seqNo, String advBranch);
}
