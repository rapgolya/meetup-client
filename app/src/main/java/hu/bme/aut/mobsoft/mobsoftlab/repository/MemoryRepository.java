package hu.bme.aut.mobsoft.mobsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.mobsoftlab.model.Event;
import hu.bme.aut.mobsoft.mobsoftlab.model.EventComments;
import hu.bme.aut.mobsoft.mobsoftlab.model.Todo;

public class MemoryRepository implements Repository {

	private static final long MINUTE = 60 * 1000;

	public static List<Event> events;
	public static List<Category> categories;
	public static List<EventComments> comments;

	@Override
	public void open(Context context) {
		if (events == null) {
			events = new ArrayList<>();
			events.add(new Event(1L, 1L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
			events.add(new Event(2L, 2L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
			events.add(new Event(3L, 2L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
			events.add(new Event(4L, 2L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
			events.add(new Event(5L, 3L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
			events.add(new Event(6L, 4L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
			events.add(new Event(7L, 1L, 20, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus massa nisi, auctor nec libero vitae, suscipit gravida erat. Morbi vitae enim eu quam imperdiet interdum. Vivamus dictum, est non vehicula varius, eros enim facilisis sapien, lobortis efficitur libero libero a metus. Donec ullamcorper mi bibendum, sagittis velit a, vulputate metus. Vestibulum et euismod augue, ac eleifend augue. Sed sodales enim sit amet nibh interdum tincidunt. Sed id elementum enim. Praesent et massa vitae mauris fringilla volutpat quis facilisis dui. Sed consequat tortor dui, sed tempor tortor efficitur in. Aenean vitae egestas leo. Duis lacus mi, dapibus nec varius eget, ultricies id lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus.", "20.05.2017 4:30 PM", "BME", "free", "Test Event", "20.05.2017 4:30 PM", "Budapest Park", 200));
		}
		if (categories == null){
			categories = new ArrayList<>();
			categories.add(new Category(1L, "Informatika", "IT"));
			categories.add(new Category(2L, "Gasztronómia", "IT"));
			categories.add(new Category(3L, "Tánc", "IT"));
			categories.add(new Category(4L, "Kutya", "IT"));
		}
	}

	@Override
	public void close() {

	}

	@Override
	public List<Category> getCategories(){
		return this.categories;
	}

	@Override
	public Event getEventById(Long eventId) {
		for(Event event : this.events) {
			if(event.getId().equals(eventId)) {
				return event;
			}
		}
		return null;
	}

	@Override
	public List<Event> getEventsByCategoryId(Long categoryId) {
		List<Event> events = new ArrayList<>();
		for(Event event : this.events) {
			if(event.getCategoryId().equals(categoryId)) {
				 events.add(event);
			}
		}
		return events;
	}

    @Override
    public Event setAttending(Long eventId, boolean attending) {
        Event event = getEventById(eventId);
        event.setYesRsvpCount(event.getYesRsvpCount() + (attending ? +1: -1 ));
        return event;
    }


    @Override
	public boolean isInDB(Event event) {
		return true;
	}



}

