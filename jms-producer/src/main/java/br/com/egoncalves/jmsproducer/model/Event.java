package br.com.egoncalves.jmsproducer.model;

import java.time.LocalDate;
import java.util.Objects;

public class Event {

    private String name;
    private String description;
    private String company;
    private LocalDate dateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name) &&
                Objects.equals(description, event.description) &&
                Objects.equals(company, event.company) &&
                Objects.equals(dateTime, event.dateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, company, dateTime);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
