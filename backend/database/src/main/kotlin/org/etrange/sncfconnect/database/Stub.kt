package org.etrange.sncfconnect.database

import org.etrange.sncfconnect.database.entities.AccountEntity
import org.etrange.sncfconnect.database.entities.OfferEntity
import org.etrange.sncfconnect.database.entities.TripEntity

val stubbedAccounts = listOf(
    AccountEntity(
        id = null, firstName = "John", lastName = "Doe", email = "john.doe@example.com"
    ), AccountEntity(
        id = null, firstName = "Jane", lastName = "Doe", email = "jane.doe@example.com"
    ), AccountEntity(
        id = null, firstName = "Robert", lastName = "Johnson", email = "robert.johnson@example.com"
    ), AccountEntity(
        id = null, firstName = "Emily", lastName = "Wilson", email = "emily.wilson@example.com"
    ), AccountEntity(
        id = null, firstName = "Michael", lastName = "Brown", email = "michael.brown@example.com"
    )
)

val stubbedOffers: List<OfferEntity> = listOf(
    OfferEntity(
        name = "Carte Avantage Jeune TGV INOUI",
        altText = "12 - 27 years old",
        illustration = "https://example.com/offer1.jpg",
        price = 49,
        discount = null
    ), OfferEntity(
        name = "Carte Avantage Adulte TGV INOUI",
        altText = "27 - 59 years old",
        illustration = "https://example.com/offer2.jpg",
        price = 49,
        discount = null
    ), OfferEntity(
        name = "Carte Avantage Senior TGV INOUI",
        altText = "60+ years old",
        illustration = "https://example.com/offer2.jpg",
        price = 49,
        discount = null
    ), OfferEntity(
        name = "Carte Liberté",
        altText = "€299 with the Pro Contrat",
        illustration = "https://example.com/offer2.jpg",
        price = 49,
        discount = 349
    ), OfferEntity(
        name = "MAX JEUNE for 79/month",
        altText = "age 60 and up",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "MAX SENIOR for 79/month",
        altText = "27 - 59 years old",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "MAX ACTIF",
        altText = "Up to 250 bookings at €0.",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "PASS Weekly or Monthly (TGV INOUI)",
        altText = "2nd class",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "PASS Weekly or Monthly (TGV INOUI)",
        altText = "1st class",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "Forfait Weekly or Monthly (TER and INTERCITÉS)",
        altText = "2nd class",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "Weekly or Monthly Forfait (TER and INTERCITÉS)",
        altText = "1st class",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "Interrail Pass",
        altText = "Embark on a rail trip though 33 European countries",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    ), OfferEntity(
        name = "PASS Rail",
        altText = "The offer has ended 31/08/2024",
        illustration = "https://example.com/offer2.jpg",
        price = 49,
        discount = null
    ), OfferEntity(
        name = "MAX Actif +",
        altText = "Up to 250 bookings at €0.",
        illustration = "https://example.com/offer2.jpg",
        price = null,
        discount = null
    )
)

val stubbedTrips: List<TripEntity> = listOf(
    TripEntity(
        departureDate = "2023-10-01T10:00:00Z",
        arrivalDate = "2023-10-01T12:00:00Z",
        departureStation = "Paris",
        arrivalStation = "Lyon",
        trainNumber = "TGV123",
        duration = "2h",
        price = 50,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "12A",
        co2Emission = 5.0,
        reference = "ABC123",
        purpose = "Business"
    ), TripEntity(
        departureDate = "2023-10-02T14:00:00Z",
        arrivalDate = "2023-10-02T16:00:00Z",
        departureStation = "Lyon",
        arrivalStation = "Marseille",
        trainNumber = "TGV456",
        duration = "2h",
        price = 60,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "2nd",
        seat = "15B",
        co2Emission = 6.0,
        reference = "DEF456"
    ), TripEntity(
        departureDate = "2023-10-03T08:00:00Z",
        arrivalDate = "2023-10-03T10:00:00Z",
        departureStation = "Marseille",
        arrivalStation = "Nice",
        trainNumber = "TGV789",
        duration = "2h",
        price = 40,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "5C",
        co2Emission = 4.0,
        reference = "GHI789",
        purpose = "Business"
    ), TripEntity(
        departureDate = "2023-10-04T09:00:00Z",
        arrivalDate = "2023-10-04T11:00:00Z",
        departureStation = "Nice",
        arrivalStation = "Bordeaux",
        trainNumber = "TGV101",
        duration = "2h",
        price = 70,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "2nd",
        seat = "20D",
        co2Emission = 7.0,
        reference = "JKL101"
    ), TripEntity(
        departureDate = "2023-10-05T11:00:00Z",
        arrivalDate = "2023-10-05T13:00:00Z",
        departureStation = "Bordeaux",
        arrivalStation = "Paris",
        trainNumber = "TGV112",
        duration = "2h",
        price = 55,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "8A",
        co2Emission = 5.5,
        reference = "MNO112",
        purpose = "Business"
    ), TripEntity(
        departureDate = "2023-10-06T15:00:00Z",
        arrivalDate = "2023-10-06T17:00:00Z",
        departureStation = "Paris",
        arrivalStation = "Lyon",
        trainNumber = "TGV131",
        duration = "2h",
        price = 65,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "2nd",
        seat = "18B",
        co2Emission = 6.5,
        reference = "PQR131"
    ), TripEntity(
        departureDate = "2023-10-07T12:00:00Z",
        arrivalDate = "2023-10-07T14:00:00Z",
        departureStation = "Lyon",
        arrivalStation = "Marseille",
        trainNumber = "TGV415",
        duration = "2h",
        price = 45,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "10C",
        co2Emission = 4.5,
        reference = "STU415",
        purpose = "Business"
    ), TripEntity(
        departureDate = "2023-10-08T09:00:00Z",
        arrivalDate = "2023-10-08T11:00:00Z",
        departureStation = "Marseille",
        arrivalStation = "Nice",
        trainNumber = "TGV161",
        duration = "2h",
        price = 50,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "2nd",
        seat = "22D",
        co2Emission = 5.0,
        reference = "VWX161"
    ), TripEntity(
        departureDate = "2023-10-09T14:00:00Z",
        arrivalDate = "2023-10-09T16:00:00Z",
        departureStation = "Nice",
        arrivalStation = "Bordeaux",
        trainNumber = "TGV718",
        duration = "2h",
        price = 75,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "6A",
        co2Emission = 7.5,
        reference = "YZA718",
        purpose = "Business"
    ), TripEntity(
        departureDate = "2023-10-10T11:00:00Z",
        arrivalDate = "2023-10-10T13:00:00Z",
        departureStation = "Bordeaux",
        arrivalStation = "Paris",
        trainNumber = "TGV919",
        duration = "2h",
        price = 60,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "2nd",
        seat = "14B",
        co2Emission = 6.0,
        reference = "BCD919"
    ), TripEntity(
        departureDate = "2023-10-11T15:00:00Z",
        arrivalDate = "2023-10-11T17:00:00Z",
        departureStation = "Paris",
        arrivalStation = "Lyon",
        trainNumber = "TGV202",
        duration = "2h",
        price = 55,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "9C",
        co2Emission = 5.5,
        reference = "EFG202",
        purpose = "Business"
    ), TripEntity(
        departureDate = "2023-10-12T12:00:00Z",
        arrivalDate = "2023-10-12T14:00:00Z",
        departureStation = "Lyon",
        arrivalStation = "Marseille",
        trainNumber = "TGV303",
        duration = "2h",
        price = 65,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "2nd",
        seat = "17D",
        co2Emission = 6.5,
        reference = "HIJ303"
    ), TripEntity(
        departureDate = "2023-10-13T09:00:00Z",
        arrivalDate = "2023-10-13T11:00:00Z",
        departureStation = "Marseille",
        arrivalStation = "Nice",
        trainNumber = "TGV404",
        duration = "2h",
        price = 40,
        currency = "EUR",
        type = "TGV",
        passenger = null,
        coach = "1st",
        seat = "4A",
        co2Emission = 4.0,
        reference = "KLM404",
    )
)
