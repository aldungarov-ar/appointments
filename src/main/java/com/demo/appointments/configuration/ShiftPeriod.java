package com.demo.appointments.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ShiftPeriod {

    public static final String MORNING = "MORNING";
    public static final String EVENING = "EVENING";
    public static final String NIGHT = "NIGHT";
    public static final String ALL_DAY = "ALL_DAY";

    @Value("${shifts.morning.starts}")
    private String morningShiftStarts;
    @Value("${shifts.morning.ends}")
    private String morningShiftEnds;
    @Value("${shifts.evening.starts}")
    private String eveningShiftStarts;
    @Value("${shifts.evening.ends}")
    private String eveningShiftEnds;
    @Value("${shifts.night.starts}")
    private String nightShiftStarts;
    @Value("${shifts.night.ends}")
    private String nightShiftEnds;


    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

    public LocalTime getShiftStartTime(String period) {
        return switch (period.toUpperCase(Locale.ROOT)) {
            case MORNING, ALL_DAY -> getTimeFromString(morningShiftStarts);
            case EVENING -> getTimeFromString(eveningShiftStarts);
            case NIGHT -> getTimeFromString(nightShiftStarts);
            default -> null;
        };
    }

    public LocalTime getShiftEndTime(String period) {
        return switch (period.toUpperCase(Locale.ROOT)) {
            case MORNING -> getTimeFromString(morningShiftEnds);
            case EVENING, ALL_DAY -> getTimeFromString(eveningShiftEnds);
            case NIGHT -> getTimeFromString(nightShiftEnds);
            default -> null;
        };
    }

    private LocalTime getTimeFromString(String timeShiftStarts) {
        if (timeShiftStarts == null || timeShiftStarts.isEmpty()) {
            return null;
        }

        LocalTime result;
        result = LocalTime.parse(timeShiftStarts);

        return result;
    }

    public String getPeriodIfPossible(LocalTime shiftTimeStart,
                                      LocalTime shiftTimeEnd) {

        if (shiftTimeStart == null || shiftTimeEnd == null) {
            return null;
        }

        if (shiftTimeStart.isAfter(getShiftStartTime(MORNING)) &&
                shiftTimeEnd.isBefore(getShiftEndTime(MORNING))) {
            return MORNING;
        }
        if (shiftTimeStart.isAfter(getShiftStartTime(EVENING)) &&
                shiftTimeEnd.isBefore(getShiftEndTime(EVENING))) {
            return EVENING;
        }
        if (shiftTimeStart.isAfter(getShiftStartTime(NIGHT)) &&
                shiftTimeEnd.isBefore(getShiftEndTime(NIGHT))) {
            return NIGHT;
        }

        return null;
    }
}
