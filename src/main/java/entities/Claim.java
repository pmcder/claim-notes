package entities;

import java.util.List;

public class Claim {
	
	private long claimId;
	
	private long repId;
	
	private List<ClaimNote> claimNotes;

	public Claim(long claimId, long repId) {
		this.claimId = claimId;
		this.repId = repId;
	}

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public long getRepId() {
		return repId;
	}

	public void setRepId(long repId) {
		this.repId = repId;
	}

	public List<ClaimNote> getClaimNotes() {
		return claimNotes;
	}

	public void setClaimNotes(List<ClaimNote> claimNotes) {
		this.claimNotes = claimNotes;
	}
	
}
