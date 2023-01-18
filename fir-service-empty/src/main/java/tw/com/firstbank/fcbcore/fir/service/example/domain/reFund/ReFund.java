package tw.com.firstbank.fcbcore.fir.service.example.domain.reFund;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import tw.com.firstbank.fcbcore.fcbframework.core.domain.BaseAggregate;
import tw.com.firstbank.fcbcore.fcbframework.core.spring.config.SensitiveData;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.ReFund.mapper.ReFundDto;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * The type Account.
 */

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "reFund")
@SensitiveData
public class ReFund extends BaseAggregate<ReFund, UUID> implements Serializable {

	@Serial
	private static final long serialVersionUID = -2574050251059257361L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reFund_id_seq")
	@SequenceGenerator(name = "reFund_id_seq", sequenceName = "ISEQ$$_225875", allocationSize = 2)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "uuid", nullable = false, updatable = false)
	@Type(type = "uuid-char")
	private UUID uuid;

	@Column(name = "seqNo")
	private Integer seqNo;

	@Column(name = "advBranch", nullable = false)
	private String advBranch;

	@Column(name = "depositBank")
	private String depositBank;

	@Column(name = "sw54d1", nullable = false)
	private String sw54d1;

	public ReFund(ReFundDto dto) {

		// the fields of collection type

		// the fields of self-generated values
		this.uuid = UUID.randomUUID();

		// the field values comes from dto data
		this.seqNo = dto.getSeqNo();

        this.advBranch = dto.getAdvBranch();

		this.sw54d1 = dto.getSw54d1();

		this.depositBank =dto.getDepositBank();
	}

	@Override
	public String getAggregateId() {
		return getUuid().toString();
	}
}
