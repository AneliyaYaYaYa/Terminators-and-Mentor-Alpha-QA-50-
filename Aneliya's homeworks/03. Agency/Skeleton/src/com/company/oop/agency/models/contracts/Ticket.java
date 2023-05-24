package com.company.oop.agency.models.contracts;

public interface Ticket extends Identifiable, Printable {

    Journey getJourney();

    double calculatePrice();

    double getAdministrativeCosts();

}