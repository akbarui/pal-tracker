package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Integer, TimeEntry> timeEntries = new HashMap<Integer, TimeEntry>();
    int idCounter = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(idCounter);
        timeEntries.put((int) timeEntry.getId(),timeEntry);
        idCounter++;
        return timeEntry;
    }

    @Override
    public TimeEntry update(Long timeEntryId, TimeEntry timeEntry) {
        if(find(timeEntryId) == null) {
            return null;
        }
        Integer key = Math.toIntExact(timeEntryId);
        timeEntry.setId(key);
        timeEntries.replace(key,timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(Long timeEntryId) {
        Integer key = Math.toIntExact(timeEntryId);
        return timeEntries.get(key);
    }

    @Override
    public List<TimeEntry> list(){

        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public void delete(Long timeEntryId) {
        Integer key = Math.toIntExact(timeEntryId);
        timeEntries.remove(key);

    }
}
