Architecture Overview

The system is designed using object-oriented principles and follows a layered architecture:

* Models represent core domain entities such as Vehicle, ParkingSpot, Floor, Ticket, and ParkingLot.
* Services orchestrate business workflows such as parking and unparking vehicles.
* Strategies encapsulate interchangeable algorithms for spot allocation and fee calculation.
* Factories handle object creation and hide construction details from clients.
* Gates act as entry points for vehicles entering and exiting the parking lot.

⸻

Core Entities

ParkingLot

Represents the parking lot and acts as the root aggregate of the system.

Floor

Represents a parking floor containing multiple parking spots.

ParkingSpot

Represents an individual parking spot and manages parking operations.

Vehicle

Abstract representation of a vehicle.

Supported vehicle types:

* Car
* Bike
* Truck

Ticket

Generated when a vehicle enters the parking lot and used during exit for fee calculation.

⸻

Design Patterns Used

Factory Pattern

Used to encapsulate vehicle creation.

Strategy Pattern

Parking Allocation Strategy

Enables different parking spot allocation algorithms without changing business logic.

Current implementation:

* DefaultParkingStrategy

Possible future implementations:

* NearestParkingStrategy
* RandomParkingStrategy
* VIPParkingStrategy

Pricing Strategy

Enables different fee calculation algorithms.

Current implementation:

* HourlyPricingStrategy

Possible future implementations:

* FlatRatePricingStrategy
* WeekendPricingStrategy
* DynamicPricingStrategy

⸻

Concurrency Considerations

Parking and unparking operations are protected using a shared lock to prevent race conditions during spot allocation and ticket management.

Future optimizations may include:

* Spot-level locking
* Read-write locks
* O(1) spot allocation using available spot queues

⸻

Future Enhancements

* Multiple entry and exit gates
* EV charging spots
* Reservation system
* Display boards
* Nearest spot allocation
* Dynamic pricing
* Spot-level concurrency control