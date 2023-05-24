package com.company.oop.agency.tests.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTests {

    private Journey testJourney;

    @BeforeEach
    public void before() {
        testJourney = JourneyTests.initializeJourney();
    }

    @Test
    public void constructor_Should_ThrowException_When_CostsNegative() {
        //Arrange, Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class,
                () -> new TicketImpl(
                        1,
                        testJourney,
                        -1.2));
    }

    @Test
    public void should_CalculatePrice_Ticket_When_ValidValuesArePassed() {
        // Arrange
        Ticket ticket = new TicketImpl(
                1,
                testJourney,
                1.2
        );
        double calculatedPrice = ticket.getAdministrativeCosts() * testJourney.calculateTravelCosts();

        // Act, Assert
        assertEquals(calculatedPrice, ticket.calculatePrice());
    }

    @Test
    public void should_Create_Ticket_When_ValidValuesArePassed() {
        // Arrange
        Ticket ticket = new TicketImpl(
                1,
                testJourney,
                1.2
        );

        // Act, Assert
        assertAll(
                () -> assertEquals(1, ticket.getId()),
                () -> assertSame(testJourney, ticket.getJourney()),
                () -> assertEquals(1.2, ticket.getAdministrativeCosts())
        );
    }

}
