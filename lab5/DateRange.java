package lab5;

import java.time.LocalDate;
import java.util.Calendar;

public final class DateRange {

	private LocalDate startDate;
	private LocalDate endDate;

	public DateRange(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "[startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public boolean isInRange(LocalDate date) {
		return date.isAfter(this.getStartDate()) && date.isBefore(this.getEndDate());
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
