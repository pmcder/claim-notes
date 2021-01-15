package entities;

import java.time.LocalDateTime;

public class ClaimNote {
	
	private long noteId;
	
	private long claimId;
	
	private long repId;
	
	private long categoryId;
	
	private LocalDateTime createdAt;
	
	private String content;
	
	private boolean isEditable ;
	
	

	public ClaimNote(long noteId, long claimId, long repId, long categoryId, LocalDateTime createdAt, String content, boolean isEditable) {
		this.noteId = noteId;
		this.claimId = claimId;
		this.repId = repId;
		this.categoryId = categoryId;
		this.createdAt = createdAt;
		this.content = content;
		this.isEditable = isEditable;
	}

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	
}
