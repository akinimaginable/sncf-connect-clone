package org.etrange.sncfconnect.database.config

import org.etrange.sncfconnect.database.repositories.AccountRepository
import org.etrange.sncfconnect.database.repositories.OfferRepository
import org.etrange.sncfconnect.database.repositories.TripRepository
import org.etrange.sncfconnect.database.stubbedAccounts
import org.etrange.sncfconnect.database.stubbedOffers
import org.etrange.sncfconnect.database.stubbedTrips
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializerConfig {
    @Bean
    fun dataInitializer(
        accountRepository: AccountRepository,
        offerRepository: OfferRepository,
        tripRepository: TripRepository
    ): ApplicationRunner {
        return ApplicationRunner { _: ApplicationArguments ->
            if (accountRepository.count() == 0L) {
                accountRepository.saveAll(stubbedAccounts)
                println("Sample account data initialized.")
            }

            if (offerRepository.count() == 0L) {
                offerRepository.saveAll(stubbedOffers)
                println("Sample offer data initialized.")
            }

            if (tripRepository.count() == 0L) {
                tripRepository.saveAll(stubbedTrips)
                println("Sample trip data initialized.")
            }
        }
    }
}
