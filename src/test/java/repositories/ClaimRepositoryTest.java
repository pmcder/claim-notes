package repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.Claim;

class ClaimRepositoryTest {

	@Test
	void test() {
		
		ClaimRepository claimRepository = new ClaimRepository();

		Claim testClaim = claimRepository.findById(1);
		
		assertEquals(1, testClaim.getClaimId());
		assertEquals(1, testClaim.getRepId());
		
	}

}
