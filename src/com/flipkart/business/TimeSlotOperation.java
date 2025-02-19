package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.TimeSlot;
import com.flipkart.dao.TimeSlotDAOImplementation;


public class TimeSlotOperation implements TimeSlotInterface {

	private static TimeSlotInterface timeSlotServiceObj = null;

	public static synchronized TimeSlotInterface getInstance() {
		if (timeSlotServiceObj == null)
			timeSlotServiceObj = new TimeSlotOperation();

		return timeSlotServiceObj;
	}
	@Override
	public TimeSlot findSlotByID(int slotID) {
		// TODO Auto-generated method stub
		TimeSlot availableSlot = TimeSlotDAOImplementation.getInstance().getSlotByID(slotID);
		if(availableSlot.getAvailableSeats() > 0) return availableSlot;
		return null;
	}
	
	@Override
	public TimeSlot findSlot(int slotHour, int gymID) {
		// TODO Auto-generated method stub
		TimeSlot availableSlot = TimeSlotDAOImplementation.getInstance().findSlot(slotHour, gymID);
		if(availableSlot!=null && availableSlot.getAvailableSeats() > 0) return availableSlot;
		return null;
	}

	@Override
	public boolean addSlot(TimeSlot slot) {
		// TODO Auto-generated method stub
		slot.setDay(java.time.LocalDate.now());
		boolean isAdded = TimeSlotDAOImplementation.getInstance().insertSlot(slot);
		return isAdded;
	}

	@Override
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats) {
		// TODO Auto-generated method stub
		boolean isUpdated = TimeSlotDAOImplementation.getInstance().updateSlot(slotHour, gymID, changeInSeats);
		return isUpdated;
	}

	@Override
	public ArrayList<TimeSlot> getAllAvailableSlots() {
		// TODO Auto-generated method stub
		return TimeSlotDAOImplementation.getInstance().getAllAvailableSlots();
	}
	


}
