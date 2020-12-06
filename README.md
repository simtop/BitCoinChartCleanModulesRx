
BitCoinApp

The architecture that I used for this application is MVVM for the presentation,
but having only one Sealed Class State for each View and for the Model part of MVVM I used
Clean Architecture.

The App is divided in 5 modules:

-BuildSrc for the Kotlin DSL and dependency management.
-App is our presentation module, where we have our fragments and custom views and the DI, and is
 where we have our UI tests and the unit test of our viewmodel
-Domain is where we control our business logic using the usecase and where we have our business models
 and the interface that connects the Domain with the Data Module, we unit test our usecase
-Data is our exterior module, where we consume our api and map. We test our mapper, remote source and the
 repository
-Test utils module is used as module for the shared test utilities




