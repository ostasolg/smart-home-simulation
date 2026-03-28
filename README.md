# Smart Home Simulation

A Java application for virtual smart home simulation. The project models a household environment with people, animals, devices, sensors, vehicles, rooms, and weather conditions, and simulates their behavior, activities, state changes, events, and resource consumption.

## Overview

The application simulates the operation of an intelligent home, including device usage, household activities, weather changes, generated events, and reporting. Devices can change states, consume resources such as electricity, gas, and water, and may break and require repair. People and animals perform activities that affect the home environment and interact with devices and other entities. 

## Tech Stack

- Java
- Maven
- SLF4J
- Logback
- UML diagrams

## Main Concepts

- Smart home simulation
- Object-oriented design
- Design patterns
- Logging
- Report generation

## Implemented Design Patterns

- Observer
- Visitor
- Builder
- Simple Factory
- Chain of Responsibility
- Lazy Loading
- State
- Facade

## Reports

The application generates reports covering house configuration, activity and device usage, consumption, and events.

- `HouseConfigReport.txt`
- `ActivityAndUsageReport.txt`
- `ConsumptionReport.txt`
- `DeviceEventReport.txt`
- `WeatherEventReport.txt`

Reports are stored in the `reports` folder.

## Configuration

Configuration is located in:

- `cz.cvut.fel.omo.runningConfig`

## How to Run

Run the application from the `SmartHome` main class.

### Run with Maven

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="cz.cvut.fel.omo.SmartHome"
```
