package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(Long timeEntryId);

    TimeEntry update(Long timeEntryId, TimeEntry timeEntry);

    List<TimeEntry> list();

    void delete(Long timeEntryId);
}
