# SMART HOME

## Authors 
Oľga Ostashchuk, Michal Pechník, Tereza Lodrová 

## DESIGN PATTERNS: 

Observer - package cz.cvut.fel.omo.observers
Visitor - package cz.cvut.fel.omo.visitors
Builder - package cz.cvut.fel.omo.builders
Simple factory - package cz.cvut.fel.omo.factory
Chain of responsibility - package cz.cvut.fel.omo.handlers
Lazy loading - package cz.cvut.fel.omo.model.devices.Device, getManual
State machine - package cz.cvut.fel.omo.deviceStates
Facade - cz.cvut.fel.omo.facade

## UML

https://gitlab.fel.cvut.cz/ostasolg/b201_b6b36omo-semestral-work/-/blob/master/uml_diagrams/omo_class_diagram_v2.png 

## USE CASE 

https://gitlab.fel.cvut.cz/ostasolg/b201_b6b36omo-semestral-work/-/blob/master/uml_diagrams/omo_use_case_diagram_v2.png 


## FUNKČNÍ POŽADAVKY

F1- Splněno, cz.cvut.fel.omo.model 

F2- Splněno, každé zařízení se může zapnout, vypnout, dát do nečinného stavu, rozbít a opravit. Jednotlivá zařízení v domu mají API na ovládání - model.devices.DeviceOperationsApi, stavy zariadení sú implementované v deviceStates.

F3- Splněno, při změně stavu se spočítá spotřeba v aktuálním stavu. - cz.cvut.fel.omo.model.details.Consumption

F4- Splněno, visitors.Waterconsumptionvisitor, visitors.Electricityconsumptionvisitor

F5- Splněno, Osoba může používat zařízení, najíst se (pokud bude hladová), dále může krmit děti nebo zvířata (pokud budou hladoví), může jít na kolo nebo vzít auto (pokud v něm bude ještě volné místo) a jít lyžovat, osoba může také opravit zařízení nebo přemístit se z místnosti a čekat. package controllers

F6- Splněno package controllers

F7- Splněno package controllers + handlers

F8- Splněno, package report, package visitors.FinancialReportVisitor, visitors.StartReportVisitor, + logování do souborů 

F9- Splněno, handlers.BrokenDeviceHandler, deviceStates.OffState - getFixed , manual je přístupný v model.details.Manual

F10- Splněno, controllers.HouseController


## NEFUNKČNÍ POŽADAVKY

Není požadována autentizace ani autorizace.

Aplikace může běžet pouze v jedné JVM.

Reporty jsou ve složce reports.

Konfigurace jsou v cz.cvut.fel.omo.runningConfig.

Javadoc.

