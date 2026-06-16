package com.shoplith.customers.events;

public record CustomerProfileCreateEvent(String userId, String name, String email) {
}
