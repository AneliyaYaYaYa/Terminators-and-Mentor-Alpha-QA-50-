package com.company.oop.agency.commands.listing;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ListingHelpers;

import java.util.List;

public class ListVehiclesCommand implements Command {

    private final List<Vehicle> vehicles;

    public ListVehiclesCommand(AgencyRepository agencyRepository) {
        vehicles = agencyRepository.getVehicles();
    }

    public String execute(List<String> parameters) {
        if (vehicles.isEmpty()) {
            return "There are no registered vehicles.";
        }

        return ListingHelpers.vehiclesToString(vehicles);
    }

}